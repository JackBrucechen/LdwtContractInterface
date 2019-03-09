package com.neusoft.labour.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.neusoft.labour.dao.InsertLoggerTableDAO;
import com.neusoft.labour.dao.QueryStatusDAO;
import com.neusoft.labour.dao.QuerycompanycodeDao;
import com.neusoft.labour.dao.UpdateapplyeventDAO;
import com.neusoft.labour.dto.ContractApplyDTO;
import com.neusoft.labour.util.CommonConstantUtil;
import com.neusoft.labour.util.HttpPostWithJsonUtil;
import com.neusoft.labour.util.IsemptyUtil;
import com.neusoft.labour.util.JsonUtil;
import com.neusoft.labour.util.PropertiesUtil;
import com.neusoft.labour.util.StringUtil;
import com.neusoft.labour.util.XmlUtil;
import cn.gov.ynhrss.psp.Pspenv;
import cn.gov.ynhrss.baseinfo.BizPortType;
import cn.gov.ynhrss.baseinfo.BizService;
import cn.gov.ynhrss.baseinfo.Bizenv;
import cn.gov.ynhrss.baseinfo.Bizhead;
import cn.gov.ynhrss.baseinfo.ObjectFactory;
import net.sf.json.JSONObject;

/**
 * @Description 具体业务实现
 * @return
 * @type Overriding Methods
 * @author chen-tao
 */
// 转化两种报文具体实现
public class InsurancePortService {
	private static Logger logger = Logger.getLogger(InsurancePortService.class);
	PropertiesUtil propertiesUtil = new PropertiesUtil();

	// 转化两种报文格式针对卡管结口
	public void transfrompspenv(Holder<Pspenv> pspenv) {
		@SuppressWarnings("static-access")
		String target = propertiesUtil.TARGET;
		String bodyStr = pspenv.value.getPspbody();
		logger.info("查询二代金融社保卡制卡进度:" + bodyStr);
		// 把串转为Document对象
		Document document = XmlUtil.transXMLStrToDocument(bodyStr);
		Element rootElement = document.getRootElement();
		String aac003 = XmlUtil.eleString(rootElement.element("aac003"));// 姓名
		String aac058 = XmlUtil.eleString(rootElement.element("aac058"));// 证件类型
		String aac147 = XmlUtil.eleString(rootElement.element("aac147"));// 证件号码
		/**
		 * 2.把参数转化为卡管系统接口规范发请求传递过去
		 */
		BizService service = new BizService();
		BizPortType stub = service.getBizPortType();
		BindingProvider provider = (BindingProvider) stub;
		provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, target);
		ObjectFactory of = new ObjectFactory();
		Bizenv env = of.createBizenv();
		Bizhead header = of.createBizhead();
		// 设置报文请求头
		header.setVersion("V1.0");
		header.setSrcmsgid("530000013"+System.currentTimeMillis()+"");
		header.setSrcsysid("530000015");
		header.setSrcsystoken("123");
		header.setOperid("53000001501");
		header.setOpertoken("123");
		header.setServiceid("1019");// 制卡查询
		// 设置body把参数传入

		Element dataElement = DocumentHelper.createElement("data");
		Element aac058Element = DocumentHelper.createElement("aac058");
		Element aac003Element = DocumentHelper.createElement("aac003");
		Element aac147Element = DocumentHelper.createElement("aac147");

		aac058Element.setText(aac058);
		aac003Element.setText(aac003);
		aac147Element.setText(aac147);

		dataElement.add(aac058Element);
		dataElement.add(aac003Element);
		dataElement.add(aac147Element);

		System.out.println("Test:" + dataElement.asXML());
		env.setBizbody(dataElement.asXML());
		env.setBizhead(header);
		Holder<Bizenv> parameter = new Holder<Bizenv>();
		parameter.value = env;
		try {
			stub.bizOP(parameter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("卡管信息发送失败");
			pspenv.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSFAIL);
			pspenv.value.getPsppilot().setStatusmessage("卡管系统消息发送失败");
		}// 发送消息
		/**
		 * 3.接收卡管结口系统回复
		 */
		if(parameter.value.getBizbody().isEmpty()){
			logger.info("卡管系统无回复");
			pspenv.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSFAIL);
			pspenv.value.getPsppilot().setStatusmessage("卡管系统无回复");
			pspenv.value.setPspbody(CommonConstantUtil.DATAXMLNULL);
		}else{
			pspenv.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSSUCCESS);
			pspenv.value.setPspbody(parameter.value.getBizbody());
		}

	}
   //	劳动合同备案
	@SuppressWarnings("static-access")
	public void ldhtba(Holder<Pspenv> pspenv){
		UpdateapplyeventDAO updateapplyeventDAO=new UpdateapplyeventDAO();
		IsemptyUtil isemptyUtil =new IsemptyUtil();
		HttpPostWithJsonUtil httpPostWithJsonUtil=new HttpPostWithJsonUtil();
		InsertLoggerTableDAO insertLoggerTableDAO=new InsertLoggerTableDAO();//数据库存储日志
		ContractApplyDTO contractApplyDTO =new ContractApplyDTO();
		QuerycompanycodeDao querycompanycodeDao =new QuerycompanycodeDao();
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		JsonUtil jsonUtil=new JsonUtil();
        Map<String, Object> valueMap=new HashMap<String, Object>();
		//获取交易时间
		Date day=new Date(); 
		SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddHHmmss");//可以精确到时分秒
		long nowdate = Long.parseLong(df2.format(day)); //更新表需要字段
		Map<String, Object> valueMap2 =new HashMap<String, Object>();
		Map<String, Object> whereMap =new HashMap<String, Object>();
		
		//设置更新参数
		valueMap2.put("issue", Long.parseLong(new SimpleDateFormat("yyyyMM").format(day)));
		valueMap2.put("submit_date", nowdate);
		valueMap2.put("submit_status", "1");
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Map<String, Object>resuletmap=new HashMap<String, Object>();//获取response信息
 		/**
		 * 1.获取参数
		 */
		// 获取body
		String bodyStr = pspenv.value.getPspbody();
		logger.info("劳动合同备案:" + bodyStr);
		// 把串转为Document对象
		Document document = XmlUtil.transXMLStrToDocument(bodyStr);
		//加入交易时间字段
		valueMap.put("calltime", df.format(day));
		//提取参数
		Element rootElement = document.getRootElement();
		//根据传入的社会统一信用代码查询单位编号
		String unitcode=XmlUtil.eleString(rootElement.element("unitcode"));
		List<Map<String,Object>> companynumber = querycompanycodeDao.querycompany(unitcode);
		//向数据库中增加日志
		valueMap.put("orderid", XmlUtil.eleString(rootElement.element("orderid")));//交易号
		valueMap.put("unitname", XmlUtil.eleString(rootElement.element("unitname")));//单位名称
		valueMap.put("unitcode", XmlUtil.eleString(rootElement.element("unitcode")));//社会统一信用代码
		valueMap.put("operatorid", XmlUtil.eleString(rootElement.element("operatorid")));
		valueMap.put("operatorname", XmlUtil.eleString(rootElement.element("operatorname")));
		valueMap.put("operatorphon", XmlUtil.eleString(rootElement.element("operatorphon")));
		valueMap.put("type", XmlUtil.eleString(rootElement.element("type")));
		valueMap.put("aac003", XmlUtil.eleString(rootElement.element("aac003")));
		valueMap.put("aac143", XmlUtil.eleString(rootElement.element("aac143")));
		valueMap.put("aae018", XmlUtil.eleString(rootElement.element("aae018")));
		valueMap.put("aac002", XmlUtil.eleString(rootElement.element("aac002")));
		valueMap.put("aac004", XmlUtil.eleString(rootElement.element("aac004")));
		valueMap.put("aac006", Long.parseLong(XmlUtil.eleString(rootElement.element("aac006"))));
		valueMap.put("acb501", XmlUtil.eleString(rootElement.element("acb501")));
		//包装参数类
		contractApplyDTO.setcompanyId((String)companynumber.get(0).get("COMPANY_NUMBER"));
		contractApplyDTO.setCompanyNumer((String)companynumber.get(0).get("COMPANY_NUMBER"));
		contractApplyDTO.setName(XmlUtil.eleString(rootElement.element("aac003")));
		contractApplyDTO.setIdCountry(XmlUtil.eleString(rootElement.element("aac143")));
		contractApplyDTO.setIdType(XmlUtil.eleString(rootElement.element("aae018")));
		contractApplyDTO.setIdNumber(XmlUtil.eleString(rootElement.element("aac002")));
		contractApplyDTO.setSex(XmlUtil.eleString(rootElement.element("aac004")));
		//判断为不为空
		if(isemptyUtil.isempty(XmlUtil.eleString(rootElement.element("aac006")))){
			contractApplyDTO.setBirthday(Long.parseLong(XmlUtil.eleString(rootElement.element("aac006"))));
		}
		contractApplyDTO.setEducationLevel(XmlUtil.eleString(rootElement.element("aac011")));
		contractApplyDTO.setNation(XmlUtil.eleString(rootElement.element("aac005")));
		contractApplyDTO.setHouseholdType(XmlUtil.eleString(rootElement.element("aac009")));
		contractApplyDTO.setHouseholdState(XmlUtil.eleString(rootElement.element("aab301")));
		contractApplyDTO.setMigrantWorkers(XmlUtil.eleString(rootElement.element("aac028")));
		if(isemptyUtil.isempty(XmlUtil.eleString(rootElement.element("aac142")))){
		contractApplyDTO.setWorkDate(Long.parseLong(XmlUtil.eleString(rootElement.element("aac142"))));
		}
		contractApplyDTO.setPolicitalStatus(XmlUtil.eleString(rootElement.element("aac024")));
		contractApplyDTO.setMobile(XmlUtil.eleString(rootElement.element("acb501")));
//		contractApplyDTO.setContractid(XmlUtil.eleString(rootElement.element("unitcode")));
		//限制非全日制办理
		if(XmlUtil.eleString(rootElement.element("aec007")).equals("1")){
			contractApplyDTO.setAec007(XmlUtil.eleString(rootElement.element("aec007")));
		}else{
			logger.info("非全日制不办理");
			pspenv.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSFAIL);
			pspenv.value.getPsppilot().setStatusmessage(CommonConstantUtil.NOTOOPEN);
			return ;
		}
		contractApplyDTO.setAec102(XmlUtil.eleString(rootElement.element("aec102")));
		contractApplyDTO.setAec003(XmlUtil.eleString(rootElement.element("aec003")));
		contractApplyDTO.setAca111(XmlUtil.eleString(rootElement.element("aca111")));
		contractApplyDTO.setAca112(XmlUtil.eleString(rootElement.element("aca112")));
		//工资格式转化
		if(isemptyUtil.isempty(XmlUtil.eleString(rootElement.element("wages")))){
		BigDecimal bd=new BigDecimal(XmlUtil.eleString(rootElement.element("wages")));
		contractApplyDTO.setWages(bd);
		}//正式工资
		if(isemptyUtil.isempty(XmlUtil.eleString(rootElement.element("probationarywages")))){
		BigDecimal bs=new BigDecimal(XmlUtil.eleString(rootElement.element("probationarywages")));//试用期工资
		contractApplyDTO.setProbationaryWages(bs);
		}
		contractApplyDTO.setWorkplace(XmlUtil.eleString(rootElement.element("workplace")));
		if(isemptyUtil.isempty(XmlUtil.eleString(rootElement.element("aae030")))){
		contractApplyDTO.setAae030(Long.parseLong(XmlUtil.eleString(rootElement.element("aae030"))));
		}
		if(isemptyUtil.isempty(XmlUtil.eleString(rootElement.element("aae031")))){
		contractApplyDTO.setAae031(Long.parseLong(XmlUtil.eleString(rootElement.element("aae031"))));
		}
		if(isemptyUtil.isempty(XmlUtil.eleString(rootElement.element("aec103")))){
		contractApplyDTO.setAec103(Long.parseLong(XmlUtil.eleString(rootElement.element("aec103"))));
		}
		if(isemptyUtil.isempty(XmlUtil.eleString(rootElement.element("aec104")))){
		contractApplyDTO.setAec104(Long.parseLong(XmlUtil.eleString(rootElement.element("aec104"))));
		}
		contractApplyDTO.setWeekhours(XmlUtil.eleString(rootElement.element("weekhours")));
		contractApplyDTO.setTarget(XmlUtil.eleString(rootElement.element("target")));
		contractApplyDTO.setDispatchOrgId(XmlUtil.eleString(rootElement.element("dispatchorgid")));
		contractApplyDTO.setDispatchOrgName(XmlUtil.eleString(rootElement.element("dispatchorgname")));
		contractApplyDTO.setSchoolName(XmlUtil.eleString(rootElement.element("schoolname")));
		contractApplyDTO.setWorkingHoursSystem(XmlUtil.eleString(rootElement.element("workinghourssystem")));
		contractApplyDTO.setAddress(XmlUtil.eleString(rootElement.element("aac026")));
		contractApplyDTO.setIsSign(XmlUtil.eleString(rootElement.element("issign")));
		contractApplyDTO.setEverydayHours(XmlUtil.eleString(rootElement.element("everydayhours")));
		contractApplyDTO.setDispatchOrgRegtype(XmlUtil.eleString(rootElement.element("dispatchorgregtype")));
		if(isemptyUtil.isempty(XmlUtil.eleString(rootElement.element("dispatchbegindate")))){
		contractApplyDTO.setDispatchBeginDate(Long.parseLong(XmlUtil.eleString(rootElement.element("dispatchbegindate"))));
		}
		if(isemptyUtil.isempty(XmlUtil.eleString(rootElement.element("dispatchbegindate")))){
		contractApplyDTO.setDispatchEndDate(Long.parseLong(XmlUtil.eleString(rootElement.element("dispatchenddate"))));
		}
		if(isemptyUtil.isempty(XmlUtil.eleString(rootElement.element("issignemployee")))){
		contractApplyDTO.setIsSignEmployee(XmlUtil.eleString(rootElement.element("issignemployee")));
		}else{
			logger.info("是否办理招工手续为空");
			pspenv.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSFAIL);
			pspenv.value.getPsppilot().setStatusmessage(CommonConstantUtil.ZGSHOUXU);
			return;
		}
		/**
		 * 2.查询数据库中有无此单位统一信用代码
		 */
		//信用代码存在进行下一步操作，不存在return
		if(companynumber.isEmpty()){
			logger.info("单位统一社会信用代码无效");
			pspenv.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSFAIL);
			pspenv.value.getPsppilot().setStatusmessage(CommonConstantUtil.SCNOTEXITES);
			return;
		}else{
			//发送post请求
			String flag=" ";
			String message=" ";
			String responserusult=" ";
			JSONObject jsonStu = JSONObject.fromObject(contractApplyDTO);
			responserusult=httpPostWithJsonUtil.httpPost(propertiesUtil.LDHTBAWTTEST,jsonStu);//接收到反馈json串
			//反馈为空判断
			if(!responserusult.isEmpty()){
			resuletmap=jsonUtil.json2HashMap(responserusult);
			}
			//反馈节点判断是否存在
			if(isemptyUtil.ismaphaskey(resuletmap, "title", "status", "detail")){
				logger.info("处理成功");
				pspenv.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSSUCCESS);
				pspenv.value.getPsppilot().setStatusmessage(CommonConstantUtil.POSTSENDSUCE);
				flag="0";
				message="合同申报已成功";
				valueMap.put("flag", flag);
				valueMap.put("message",message);
				//设置where条件
				whereMap.put("applicant_idnumber", XmlUtil.eleString(rootElement.element("aac002")));
				whereMap.put("applicant_name", XmlUtil.eleString(rootElement.element("aac003")));
				whereMap.put("represent_number", (String)companynumber.get(0).get("COMPANY_NUMBER"));
				whereMap.put("submit_status", "0");
//				whereMap.put("create_date", Long.parseLong(XmlUtil.eleString(rootElement.element("dispatchbegindate"))));
				//执行更新表操作
				updateapplyeventDAO.updateapplyevent(valueMap2, whereMap);
			}else{
				logger.info("post请求发送失败或处理失败");
				pspenv.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSFAIL);
				pspenv.value.getPsppilot().setStatusmessage(CommonConstantUtil.POSTSENDFLAG);
				flag="1";
				valueMap.put("flag", flag);
				message=resuletmap.get("detail").toString();
				valueMap.put("message",message);
				valueMap.put("blief", resuletmap.get("title"));
				
			}

			//数据库记录日志
			insertLoggerTableDAO.insertlogger(valueMap);
			//组装返回报文xml
			Element dataElement = DocumentHelper.createElement("data");
			Element flagElement = DocumentHelper.createElement("flag");
			Element messageElement = DocumentHelper.createElement("message");
		    flagElement.setText(flag);
		    messageElement.setText(message);
		    dataElement.add(flagElement);
		    dataElement.add(messageElement);
			pspenv.value.setPspbody(dataElement.asXML());
		}	
	}
	
	// 劳动合同备案结果查询
	@SuppressWarnings("static-access")
	public void querylthtba(Holder<Pspenv> pspenv){
		IsemptyUtil isemptyUtil =new IsemptyUtil();
		CommonConstantUtil commonConstantUtil =new CommonConstantUtil();
		QuerycompanycodeDao querycompanycodeDao=new QuerycompanycodeDao();
		QueryStatusDAO queryStatusDAO=new QueryStatusDAO();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		/**
		 * 1.获取参数
		 */
		// 获取body
		String bodyStr = pspenv.value.getPspbody();
		logger.info("劳动网厅合同备案申请---合同申请备案结果查询:" + bodyStr);
		// 把串转为Document对象
		Document document = XmlUtil.transXMLStrToDocument(bodyStr);
		Element rootElement = document.getRootElement();
		//获取参数
		String applicant_idnumber=XmlUtil.eleString(rootElement.element("aac002"));
		String applicant_name=XmlUtil.eleString(rootElement.element("aac003"));
		//根据传入的社会统一信用代码查询单位编号
		String unitcode=XmlUtil.eleString(rootElement.element("unitcode"));
		List<Map<String,Object>> companynumber = querycompanycodeDao.querycompany(unitcode);
		String apply_type=XmlUtil.eleString(rootElement.element("type"));
		//执行查询返回结果
		if(companynumber.isEmpty()){
			logger.info("单位统一社会信用代码无效");
			pspenv.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSFAIL);
			pspenv.value.getPsppilot().setStatusmessage(CommonConstantUtil.SCNOTEXITES);
		}else{
			resultList=queryStatusDAO.querystatus(applicant_idnumber, applicant_name, (String)companynumber.get(0).get("COMPANY_NUMBER"), apply_type);
		}
		//组装放回报文
		if(resultList.isEmpty()){
			pspenv.value.getPsppilot().setStatuscode(commonConstantUtil.STATUSFAIL);
			pspenv.value.getPsppilot().setStatusmessage(commonConstantUtil.SYSEXCEPTION);
			pspenv.value.setPspbody(commonConstantUtil.DATAXMLNULL);
		}else{
			Element data = DocumentHelper.createElement("data");
			for (int i = 0; i <resultList.size(); i++) {
				Map<String, Object> map = resultList.get(i);
				Element rowElement = DocumentHelper.createElement("row");
				XmlUtil.appendMutiEleRows(data,rowElement, "aac003", StringUtil.getString(map.get("APPLICANT_NAME")));
				XmlUtil.appendMutiEleRows(data,rowElement, "aac002", StringUtil.getString(map.get("APPLICANT_IDNUMBER")));
				XmlUtil.appendMutiEleRows(data,rowElement, "type", StringUtil.getString(map.get("APPLY_TYPE")));
				XmlUtil.appendMutiEleRows(data,rowElement, "createtime", StringUtil.getString(map.get("SUBMIT_DATE")));
				if(isemptyUtil.isempty(StringUtil.getString(map.get("REVIEW_COMMENT")))||isemptyUtil.isempty(StringUtil.getString(map.get("REVIEW_STATUS")))){
					XmlUtil.appendMutiEleRows(data,rowElement, "message", StringUtil.getString(map.get("REVIEW_COMMENT")));
				}else{
					XmlUtil.appendMutiEleRows(data,rowElement, "message",commonConstantUtil.RSBMBA );
				}
			}
			/**
			 * 3.返回
			 */
			pspenv.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSSUCCESS);
			pspenv.value.getPsppilot().setStatusmessage(CommonConstantUtil.QUERYBRANDSUCC);
			pspenv.value.setPspbody(data.asXML());
		}
	}

}
