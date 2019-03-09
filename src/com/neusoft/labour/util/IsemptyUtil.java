package com.neusoft.labour.util;

import java.util.Map;

public class IsemptyUtil {
 public boolean isempty(String s){
	 if(s.trim()==" "||s==null||s.length()<=0||s.equals(" ")){
		 return false;
	 }else{
	 return true;
	 }
 }
 public boolean ismaphaskey(Map<String, Object>resuletmap,String title,String status,String detail){
	 if(resuletmap.containsKey(title)||resuletmap.containsKey(status)||resuletmap.containsKey(detail)){
		 return false;
	 }else{
		 return true; 
	 }
	
	 
 }
}
