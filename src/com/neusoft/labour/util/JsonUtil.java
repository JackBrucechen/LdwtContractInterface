package com.neusoft.labour.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("rawtypes")
public class JsonUtil {

	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 将对象转换成json字符串。
	 * <p>
	 * Title: pojoToJson
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param data
	 * @return
	 */
	public static String objectToJson(Object data) {
		try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	

	/**
	 * 将json结果集转化为对象
	 * 
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            对象中的object类型
	 * @return
	 */
	public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
		try {
			T t = MAPPER.readValue(jsonData, beanType);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json数据转换成pojo对象list
	 * <p>
	 * Title: jsonToList
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param jsonData
	 * @param beanType
	 * @return
	 */
	public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			List<T> list = MAPPER.readValue(jsonData, javaType);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	/** 
    * 将json格式的字符串解析成Map对象 <li> 
    * json格式：{"name":"admin","retries":"3fff","testname" 
    * :"ddd","testretries":"fffffffff"} 
    */  
public static Map<String, Object> json2HashMap(Object object)  
   {  
       HashMap<String, Object> data = new HashMap<String, Object>();  
       // 将json字符串转换成jsonObject  
       JSONObject jsonObject = JSONObject.fromObject(object);  
       Iterator it = jsonObject.keys();  
       // 遍历jsonObject数据，添加到Map对象  
       while (it.hasNext())  
       {  
           String key = String.valueOf(it.next());  
           Object obj=jsonObject.get(key);
           Object value="";
           if(!(obj instanceof JSONObject))
           {
        	   value=obj;
           }
           data.put(key, value);  
       }  
       return data;  
   }  
	   
	   
   public static JSONObject getHashMapToJSON(HashMap<String,Object> dataMap){
		JSONObject dataJson = new JSONObject();
		 for(Entry<String,Object> entry:dataMap.entrySet()){
			 String key = entry.getKey();
			 String value = entry.getValue()==null?"":entry.getValue().toString();
			 dataJson.put(key, value);
		 }
		 return dataJson;
	}
}
