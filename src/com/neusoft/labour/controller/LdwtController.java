package com.neusoft.labour.controller;

import javax.jws.WebService;
import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.neusoft.labour.service.InsurancePortService;
import com.neusoft.labour.util.CommonConstantUtil;
import cn.gov.ynhrss.psp.YnhrssPSPPortType;
import cn.gov.ynhrss.psp.Pspenv;
/**
 * 
 * <p>Title: 云南省云南人社公共服务平台劳动合同备案接口</p>
 * <p>Description: 接入平台和劳动备案网厅交互的webservice实现类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 东软集团股份有限公司</p>
 * <p>Department: 西南大区(昆明)-云南研发与交付中心二</p>
 * @author  chen-tao
 * @version 1.0
 */
@WebService(name= "YnhrssPSPPortType",serviceName="YnhrssPSPService",endpointInterface = "cn.gov.ynhrss.psp.YnhrssPSPPortType", targetNamespace =  "http://www.ynhrss.gov.cn/psp", portName = "YnhrssPSPPortType")
public class LdwtController implements YnhrssPSPPortType {
	private static Logger logger = Logger.getLogger(LdwtController.class);
	InsurancePortService insurancePortService =new InsurancePortService();
	/**
	 * 业务核心逻辑处理类  service
	 */
	public void ynhrssPSPOP(Holder<Pspenv> parameters) {
		// TODO Auto-generated method stub

		String strServiceID = parameters.value.getPsppilot().getServiceid();
		if (true) {
			// APP已接入到云南人社公共服务平劳动合同备案接口
			logger.info("LdwtController------Loadin...OK");
			try {
				// 查询二代金融社保卡制卡进度
				if ("8030999999".equals(strServiceID)) {
					insurancePortService.transfrompspenv(parameters);
				}
				// 劳动合同备案
				else if ("8030010001".equals(strServiceID)) {
				insurancePortService.ldhtba(parameters);
				}
				// 劳动合同备案结果查询
				else if ("8030010002".equals(strServiceID)) {
				insurancePortService.querylthtba(parameters);
				}
				else {
					logger.info("云南人社公共服务平劳动合同备案接口---业务代码不存在!");
					parameters.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSFAIL);
					parameters.value.getPsppilot().setStatusmessage(CommonConstantUtil.NOBUSINESS);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("云南人社公共服务平劳动合同备案接口---系统异常1!");
				parameters.value.getPsppilot().setStatuscode(CommonConstantUtil.STATUSFAIL);
				parameters.value.getPsppilot().setStatusmessage(CommonConstantUtil.SYSEXCEPTION);
			}
		}
	
		
	}


	
	
	

}