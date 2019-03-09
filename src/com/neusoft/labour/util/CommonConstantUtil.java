package com.neusoft.labour.util;

public class CommonConstantUtil {
	//本系统操作员id
	public static final String sysOperatorId = com.neusoft.rsa.utils.PropertiesUtil.getConfigValue("rsapkg_privatekey_CertId");
	//分页查询的每页显示条数
	public static final int pageSize = 10; 
	/**
	 * 平台返回结果状态代码
	 */
	public static final String STATUSSUCCESS = "900000";  		 //查询成功
	public static final String STATUSFAIL = "980080";	   		 //查询失败，执行查询失败
	public static final String DATAXMLNULL = "<data></data>";    //查询失败，返回给前端的空boby
	public static final String ZGSHOUXU = "招工手续不能为空!";
	public static final String NOTOOPEN = "非全日制和其他敬请期待!";
	public static final String RSBMBA = "请等待人设部门备案确认!";
	public static final String POSTSENDSUCE = "已提交劳动网厅处理";
	public static final String POSTSENDFLAG = "劳动网厅服务异常或申报数据校验失败";
	public static final String SCNOTEXITES = "单位统一社会信用代码无效";
	public static final String NOBUSINESS = "业务交易服务号不存在!";
	public static final String SYSEXCEPTION = "劳动网厅服务平台异常!";
	public static final String QUERYBRANDSUCC = "查询成功!";
	
	public static final String QUERYSCODESUCC = "劳动合同备案申报成功!";
	
	
	
	
	
	
	
	
	
	
	

	
}
