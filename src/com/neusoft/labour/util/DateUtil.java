package com.neusoft.labour.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public static String formatDate(Date date,String format){
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	}
	
	
	public static Date formatString(String str,String format) throws Exception{
		if(StringUtil.isEmpty(str)){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.parse(str);
	}
	
	public static String getCurrentDateStr(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static String getCurrentDateTimeStr(){
		Date timedate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(timedate);
	}
	
	
	public static Date getCurrentDate(){
		Date date=new Date();
		return date;
	}
	
	
	public static Date getCurrentDateFormate() throws Exception{
		Date timedate = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(sdf.format(timedate));
	}
	
	
	
	
	
	/**
	 * 获得当天的日期
	 */
	 public static String lastDay(){
	     String dateString=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	     return dateString;
	  }

	 /**
	  * 获得一周前的日期
	  */
	 public static String lastWeek(){
	     Date date = new Date();
	   
	     int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
	     int month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
	     int day = Integer.parseInt(new SimpleDateFormat("dd").format(date))-6;
	   
	     if(day < 1){
	    	 month -= 1;
	    	 if(month==0){
	    		 year -= 1;month = 12;
	    	 }
	      	 if(month==4||month==6||month==9||month==11){
	      		 day = 30 + day;
	      	 }else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
	      	 {
	      		 day = 31 + day;
	      	 }else if(month==2){
	      		 if(year % 400 == 0||(year %4 == 0 && year %100 != 0))day = 29 + day;
	      		 else day = 28 + day;
	      	 }    
	     }
	     String y = year+"";String m ="";String d ="";
	     if(month<10) m = "0"+month;
	     else m=month+"";
	     if(day<10) d = "0"+day;
	     else d = day+"";
	   
	     return y+"-"+m+"-"+d + " 00:00:00";
	  }
	 
	 /**
	  * 获得一月前的日期
	  */
	 public static String lastMonth(){
	    Date date = new Date();
	   
	    int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
	    int month = Integer.parseInt(new SimpleDateFormat("MM").format(date))-1;
	    int day=Integer.parseInt(new SimpleDateFormat("dd").format(date));

	    //月份小于1，则年份减1
	    if(month < 1){
	    	 year -= 1;
	    	 if(month==0){
	    		  month = 12;
	    	 }
	    	 else{
	    		 month += 12;
	    	 }
	    }
	    else if(day>28){
	    	if(month==2){
	    		if(year % 400 == 0||(year %4 == 0 && year %100 != 0)){
	    			day=29;
	    		}else day=28;
	    	}else if((month==4||month==6||month==9||month==11)&&day==31)
	    	{
	    		day=30;
	    	}
	    }
	    String y = year+"";String m ="";String d ="";
	    if(month<10) m = "0"+month;
	    else m=month+"";
	    if(day<10) d = "0"+day;
	    else d = day+"";
	  
	    return y+"-"+m+"-"+d + " 00:00:00";
	 }
	 
	 
	/**
	 * 最近N个月第一天 
	 */ 
	public static String getLastNMonthStart(int monthCount) {  
	        Calendar calendar = new GregorianCalendar();  
	        calendar.add(Calendar.MONTH, monthCount);  
	        calendar.set(Calendar.DAY_OF_MONTH, 1);  
	        String str = DateFormat.getDateInstance(DateFormat.MEDIUM).format(  
	                (Date) calendar.getTime().clone());  
	        return str +  " 00:00:00";  
    }
	
	
	/**
	 * 获得一周前的日期，前几天日期
	 */
	public static String getDateAfter(int day) {  
		Date date = new Date();
        Calendar now = Calendar.getInstance();  
        now.setTime(date);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
	    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
	}
	
	
	
	
	 /**
	  * 获得一周前的日期
	  */
	 public static String headWeek(){
		 Date date = new Date();
	        Calendar now = Calendar.getInstance();  
	        now.setTime(date);  
	        now.set(Calendar.DATE, now.get(Calendar.DATE) + 6);  
		    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
	  }
	 
	 
	 /**
	  * 获得当前日期后的第几天的日期
	  */
	 public static String headWeek2(int day){
		 Date date = new Date();
	        Calendar now = Calendar.getInstance();  
	        now.setTime(date);  
	        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
		    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
	  }
	 
	 
	 /**
	  * 
	  * @Description 获取当前日期后第几日凌晨零点
	  * @return
	  * @return_type String
	  * @author  deng-jx
	  * @date   Jul 6, 2017
	  */
	 public static String getTimeTomorrowZero(int day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
	 }
	 
	 /**
	  * 
	  * @Description 获取当前日期后第几日凌晨零点
	  * @return
	  * @return_type String
	  * @author  deng-jx
	  * @date   Jul 6, 2017
	  */
	 public static Date getDateTomorrowZero(int day) throws Exception{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_MONTH, day);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(sdf.format(cal.getTime()));
	 }
	 
	 
	 /**
	  * 
	  * @Description 获取当前日期后第几年的日期
	  * @param year
	  * @return
	  * @return_type String
	  * @author  deng-jx
	  * @date   Jul 10, 2017
	  */
	 public static String getTimeAfterYear(int year){
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(new Date());
		 cal.set(Calendar.HOUR_OF_DAY, 23);
		 cal.set(Calendar.MINUTE, 59);
		 cal.set(Calendar.SECOND, 59);
		 cal.add(Calendar.YEAR, year);
		 return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
	 }
	 
	 /**
	  * 
	  * @Description 获取当前日期后第几年的日期
	  * @param year
	  * @return
	  * @return_type String
	  * @author  deng-jx
	  * @date   Jul 10, 2017
	  */
	 public static Date getDateAfterYear(int year) throws Exception{
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(new Date());
		 cal.set(Calendar.HOUR_OF_DAY, 23);
		 cal.set(Calendar.MINUTE, 59);
		 cal.set(Calendar.SECOND, 59);
		 cal.add(Calendar.YEAR, year);
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 return sdf.parse(sdf.format(cal.getTime()));
	 }

}
