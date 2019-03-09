package com.neusoft.labour.util;

import java.util.Calendar;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * 
 * <p>Title: 云南省医保移动化健康保险平台</p>
 * <p>Module: 健康保险</p>
 * <p>Description: 根据身份证获取性别、出生日期、年龄，支持15、18位身份证 </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 东软集团股份有限公司</p>
 * <p>Department: 西南大区(昆明)-云南研发与交付中心二</p>
 * @author  deng-jx
 * @date   Jun 30, 2017
 * @version 1.0
 */
public class IDCardUtil {
	private static Logger logger = Logger.getLogger(IDCardUtil.class);
	
	
	/**
	 * 
	 * @Description 校验身份证号是否规范
	 * @param certificateNo
	 * @return
	 * @return_type boolean
	 * @author  deng-jx
	 * @date   Jun 30, 2017
	 */
	public static boolean validIDCard(String certificateNo){
		String myRegExpIDCardNo = "^\\d{6}(((19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])\\d{3}([0-9]|x|X))|(\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])\\d{3}))$";  
        boolean valid=Pattern.matches(myRegExpIDCardNo,certificateNo)||(certificateNo.length() == 17 && Pattern.matches(myRegExpIDCardNo,certificateNo.substring(0,15)));  
        return valid; 
	}
	
	
	/**
	 * 
	 * @Description 获取出生日期
	 * @param certificateNo
	 * @return
	 * @return_type String
	 * @author  deng-jx
	 * @date   Jun 30, 2017
	 */
	public static String getBirthDay(String certificateNo){
		if(!validIDCard(certificateNo)){
			logger.error("身份证号不规范!");
			return "";
		}
        int birthYearSpan = 4;  
        //如果是15位的证件号码  
        if(certificateNo.length() == 15) {  
            birthYearSpan = 2;  
        }  
        String year = (birthYearSpan == 2 ? "19" : "") + certificateNo.substring(6, 6 + birthYearSpan);  
        String month = certificateNo.substring(6 + birthYearSpan, 6 + birthYearSpan + 2);  
        String day = certificateNo.substring(8 + birthYearSpan, 8 + birthYearSpan + 2);  
        String birthday = year + '-' + month + '-' + day;  
        
        return birthday;
	}
	
	/**
	 * 
	 * @Description 获取性别
	 *  1 男
	 *	2 女
	 *	9 未说明性别
	 * @return
	 * @return_type String
	 * @author  deng-jx
	 * @date   Jun 30, 2017
	 */
	public static String getGender(String certificateNo){
		if(!validIDCard(certificateNo)){
			logger.error("身份证号不规范!");
			return "";
		}
		int idxSexStart = 16;  
        //如果是15位的证件号码  
        if(certificateNo.length() == 15) {  
            idxSexStart = 14;  
        }  
		//性别  
        String idxSexStr = certificateNo.substring(idxSexStart, idxSexStart + 1);  
        int idxSex = Integer.parseInt(idxSexStr) % 2;  
        String sex = (idxSex == 1) ? "1" : "2";  
        return sex;
	}
	
	
	/**
	 * 
	 * @Description 获取年龄
	 * @return
	 * @return_type String
	 * @author  deng-jx
	 * @date   Jun 30, 2017
	 */
	@SuppressWarnings("static-access")
	public static int getAge(String certificateNo){
		if(!validIDCard(certificateNo)){
			logger.error("身份证号不规范!");
			return 0;
		}
        int birthYearSpan = 4;  
        //如果是15位的证件号码  
        if(certificateNo.length() == 15) {  
            birthYearSpan = 2;  
        }  
        String year = (birthYearSpan == 2 ? "19" : "") + certificateNo.substring(6, 6 + birthYearSpan);  
        String month = certificateNo.substring(6 + birthYearSpan, 6 + birthYearSpan + 2);  
        String day = certificateNo.substring(8 + birthYearSpan, 8 + birthYearSpan + 2);  
        
        //年龄  
        Calendar certificateCal = Calendar.getInstance();  
        Calendar currentTimeCal = Calendar.getInstance();  
        certificateCal.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));  
        int yearAge = (currentTimeCal.get(currentTimeCal.YEAR)) - (certificateCal.get(certificateCal.YEAR));  
        certificateCal.set(currentTimeCal.get(Calendar.YEAR), Integer.parseInt(month)-1, Integer.parseInt(day));  
        int monthFloor = (currentTimeCal.before(certificateCal) ? 1 : 0);  
        return yearAge - monthFloor;
	}
}
