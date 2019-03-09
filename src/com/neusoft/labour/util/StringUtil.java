package com.neusoft.labour.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 字符串工具类
 * @author 
 *
 */
public class StringUtil {

	/**
	 * 判断是否是空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim()) || "null".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断是否不是空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if((str!=null)&&!"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 格式化模糊查询
	 * @param str
	 * @return
	 */
	public static String formatLike(String str){
		if(isNotEmpty(str)){
			return "%"+str+"%";
		}else{
			return null;
		}
	}
	
	/**
	 * 过滤掉集合里的空格
	 * @param list
	 * @return
	 */
	public static List<String> filterWhite(List<String> list){
		List<String> resultList=new ArrayList<String>();
		for(String l:list){
			if(isNotEmpty(l)){
				resultList.add(l);
			}
		}
		return resultList;
	}
	
	/**
	 * 
	* @Description: 获取对象的toString()
	* @author  deng-jx
	* @param obj
	* @return
	* @date 2016-12-12 上午11:43:23
	 */
	public static String getString(Object obj){
		if(obj == null || obj == "null"){
			return "";
		}
		else{
			return obj.toString().equals("null")?"":obj.toString();
		}
	}
	
	
	/**
	   * 随机创建一个6位订单防伪码
	   * @return
	   */
	  public static String getOrderValidCode()
	  {
	    Random rad = new Random();
	    
	    String result = rad.nextInt(10000000)+"";
	    if (result.length() != 6) {
	      return getOrderValidCode();
	    }
	    return result;
	  }

	  /**
		 * 
		 * @Description 主键UUID获取
		 * @return
		 * @return_type String
		 * @author  deng-jx
		 * @date   2017-9-26
		 */
		public static String getUUID(){
			//因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
			String uuid = UUID.randomUUID().toString();
			String regist_id = uuid.replaceAll("-", "");
			return regist_id;
		}
		
}
