package com.neusoft.labour.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

@SuppressWarnings({"unchecked","unused","rawtypes"})
public class MapUtils {
	private static Logger logger = Logger.getLogger(MapUtils.class);

    /**
     * 将bean转换到map
     * @param bean
     * @return
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
	public static final Map<String, Object> toMap(Object bean)
			throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName().toLowerCase();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}
    /**
     * 将map填充到bean
     * @param type
     * @param map
     * @return
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
	public static final Object toBean(Class<?> type,
			Map<String, ? extends Object> map) throws IntrospectionException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {
		map = keyReplace(map,"_");
		BeanInfo beanInfo = Introspector.getBeanInfo(type);
		Object obj = type.newInstance();
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			String propertyName = null;
			try {
				PropertyDescriptor descriptor = propertyDescriptors[i];
			    propertyName = descriptor.getName().toLowerCase();
				if (map.containsKey(propertyName)) {
					Object value = map.get(propertyName);
					Object[] args = new Object[1];
					//判断类型
					if(descriptor.getPropertyType().getName().equals("java.lang.Double")){
						args[0] = (value==null)?0:Double.parseDouble(value.toString());
					}
					else if(descriptor.getPropertyType().getName().equals("java.util.Date")){
						SimpleDateFormat formate = null;
						try {
							formate = new SimpleDateFormat("yyyy-MM-dd");
							args[0] = (value==null)?null:formate.parse(value.toString());
						} catch (Exception e) {
							//异常是因格式不匹配
							formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							args[0] = (value==null)?null:formate.parse(value.toString());
						}
					}
					else{
						args[0] = value;
					}
					descriptor.getWriteMethod().invoke(obj, args);
				
				}
			} catch (Exception e) {
				logger.error("propertyName = " + propertyName);
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	private static Map keyReplace(Map map,String rgx)
	{
		Map rspMap=new HashMap();
		Set set= map.entrySet();
		Iterator<Entry<String, String>>  iterator=set.iterator();
		while(iterator.hasNext())
		{
			Entry<String, String> en = iterator.next();
			rspMap.put(en.getKey().replace(rgx, "").toLowerCase(), en.getValue());
		}
		return rspMap;
	}
	/**
	 * 将Map中的数据转换成按照Key的ascii码排序后的key1=value1&key2=value2的形式 不包含签名域signature
	 * 
	 * @param data
	 *            待拼接的Map数据
	 * @return 拼接好后的字符串
	 */
	public static String coverMap2String(Map<String, String> data) {
		TreeMap<String, String> tree = new TreeMap<String, String>();
		Iterator<Entry<String, String>> it = data.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> en = it.next();
			tree.put(en.getKey(), en.getValue());
		}
		it = tree.entrySet().iterator();
		StringBuffer sf = new StringBuffer();
		while (it.hasNext()) {
			Entry<String, String> en = it.next();
			sf.append(en.getKey() + "=" + en.getValue()
					+ "&");
		}
		return sf.substring(0, sf.length() - 1);
	}
	/**
	 * 将map中值为null的转换为""
	 * @param map
	 * @return
	 */
	public static Map coverMapNull2empty(Map map)
	{
		Set keyset= map.entrySet();
		Iterator<Entry> it = map.entrySet().iterator();
		while(it.hasNext())
		{
			Entry en=it.next();
			if(en.getValue()==null)
			{
				map.put(en.getKey(), "");
			}
		}
		return map;
	}
	/**
	 * 将map中的值赋值给bean
	 * @param bean 要赋值的bean
	 * @param map 
	 * @return bean
	 */
	public static Object putValue2Bean(Object bean,Map map)
	{
		Set keyset= map.entrySet();
		Iterator<Entry> it = map.entrySet().iterator();
		while(it.hasNext())
		{
			Entry en=it.next();
			if(en.getValue()==null)
			{
				map.put(en.getKey().toString().toLowerCase(), "");
			}
			bean=beanValueSet(bean,en.getKey().toString().toLowerCase(),en.getValue());
		}
		return bean;
	}
	/**
	 * 为bean的某个属性赋值
	 * @param bean
	 * @param properName
	 * @return
	 */
	private static Object beanValueSet(Object bean,String properName,Object value)
	{
		try
		{
		 BeanInfo beanInfo=Introspector.getBeanInfo(bean.getClass());
		 PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		 for (int i = 0; i < propertyDescriptors.length; i++) 
		 {
			 PropertyDescriptor descriptor = propertyDescriptors[i];
			 String propertyName = descriptor.getName().toLowerCase();
			 if(propertyName.equals(properName))
			 {
				 descriptor.getWriteMethod().invoke(bean, value);
				 break;
			 }
		 }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bean;
	}
	
	
}
