package com.neusoft.labour.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.gov.ynhrss.psp.Pspenv;
import cn.gov.ynhrss.psp.Pspheader;
import cn.gov.ynhrss.psp.Psppilot;

/**
 * 
 * <p>Description: XML工具类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 东软集团股份有限公司</p>
 * <p>Department: 西南大区(昆明)-云南研发与交付中心二</p>
 * @author  chen-tao
 * @version 1.0
 */
public class XmlUtil {
	private static Logger logger = Logger.getLogger(XmlUtil.class);
	
//	把xml转化为文档对象模型
	public static Document transXMLStrToDocument(String XMLStr) {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
					XMLStr.getBytes("UTF-8"));
			document = saxReader.read(byteArrayInputStream, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return document;
	}

	
	/**
	 * 
	 * @Description:初始化 pspenv
	 * @author david
	 * @return
	 * @date 2016-12-7 上午10:47:29
	 */
	public static Pspenv initPspenv() {
		Pspenv pspenv = new Pspenv();
		Psppilot psppilot = new Psppilot();
		Pspheader pspheader = new Pspheader();
		pspenv.setPsppilot(psppilot);
		pspenv.setPspheader(pspheader);
		return pspenv;
	}
	
	
	/**
	 * 获取xml元素数据,避免没有数据时直接getText()报错
	 * deng-jx
	 * 2016-12-09
	 * @param element
	 * @return
	 */
	public static String eleString(Element element){
		if(element == null){
			return "";
		}
		else{
			if(element.isTextOnly()){ //元素
				return StringUtil.getString(element.getText());
			}
			else{ //element
				return element.asXML();
			}
		}
	}
	
	
	
	
	public static String getStrFromXMLStr(String XMLStr, String param) {
		Document document = XmlUtil.transXMLStrToDocument(XMLStr);
		Element rootElement = document.getRootElement();
		return XmlUtil.eleString(rootElement.element(param));
	}

	/**
	 * 删除data标签
	 * 
	 * @Description:
	 * @author david
	 * @param XMLStr
	 * @return
	 * @date 2016-12-6 下午03:56:29
	 */
	public static String removeDateTag(String XMLStr) {
		return XMLStr.replaceFirst("<data>", "").replaceFirst("</data>", "");
	}

	/**
	 * 添加data标签
	 * 
	 * @Description:
	 * @author david
	 * @param XMLStr
	 * @return
	 * @date 2016-12-6 下午03:56:16
	 */
	public static String addDateTag(String XMLStr) {
		return "<data>" + XMLStr + "</data>";
	}

	
	/**
	 * 
	 * @Description: 只有一个子节点的情况，在data里面添加子节点
	 * @author david
	 * @param dataElement
	 *            报文的data节点
	 * @param subElementName
	 *            需要添加的子节点的名称
	 * @param value
	 *            需要添加的子节点的值
	 * @return
	 * @date 2016-12-2 下午02:32:13
	 */
	public static Element appendElement(Element dataElement,
			String subElementName, String value) {
		if (StringUtil.isNotEmpty(subElementName)) {
			Element subElement = DocumentHelper.createElement(subElementName);
			subElement.setText(value);
			dataElement.add(subElement);
		}
		return dataElement;
	}
	
	
	
	/**
	 * 
	 * @Description: 有多个子节点的情况，在data里面添加子节点 ---app
	 * @author david
	 * @param dataElement
	 *            报文的data节点
	 * @rowElement 参数需要被添加的row节点
	 * @param subElementName
	 *            需要添加的子节点的名称
	 * @param value
	 *            需要添加的子节点的值
	 * @return
	 * @date 2016-12-2 下午02:32:13
	 */
	public static Element appendMutiElesNoRownum(Element dataElement,
			Element rowElement, String subElementName, String value) {
		// 获取rownum节点
	/*	Element rowNumElement = dataElement.element("rownum");
		if (rowNumElement == null) {
			// 节点不存在创建一个节点，初始为1
			rowNumElement = DocumentHelper.createElement("rownum");
			rowNumElement.setText(0 + "");
			dataElement.add(rowNumElement);
		}*/
		if (!rowElement.nodeIterator().hasNext()) {
			// 节点为新创建的节点
			dataElement.add(rowElement);
//			rowNumElement.setText(String.valueOf((Integer.parseInt(rowNumElement.getText()) + 1)));
		}
		// 向row节点插入数据
		if (StringUtil.isNotEmpty(subElementName)) {
			// 有多行的情况
			Element subElement = DocumentHelper.createElement(subElementName);
			// 当值不为空的情况
			if (StringUtil.isNotEmpty(value)) {
				subElement.setText(value);
			}
			rowElement.add(subElement);
		}
		return dataElement;
	}
	
	
	
	

	/**
	 * 
	 * @Description: 有多个子节点的情况，在data里面添加子节点 ---app
	 * @author david
	 * @param dataElement
	 *            报文的data节点
	 * @rowElement 参数需要被添加的row节点
	 * @param subElementName
	 *            需要添加的子节点的名称
	 * @param value
	 *            需要添加的子节点的值
	 * @return
	 * @date 2016-12-2 下午02:32:13
	 */
	public static Element appendMutiElements(Element dataElement,
			Element rowElement, String subElementName, String value) {
		// 获取rownum节点
		Element rowNumElement = dataElement.element("rownum");
		if (rowNumElement == null) {
			// 节点不存在创建一个节点，初始为1
			rowNumElement = DocumentHelper.createElement("rownum");
			rowNumElement.setText(0 + "");
			dataElement.add(rowNumElement);
		}
//		// 获取rows节点
//		Element rowsElement = dataElement.element("rows");
//		if (rowsElement == null) {
//			// 节点不存在创建一个rows节点
//			rowsElement = DocumentHelper.createElement("rows");
//			dataElement.add(rowsElement);
//		}
		if (!rowElement.nodeIterator().hasNext()) {
			// 节点为新创建的节点
			dataElement.add(rowElement);
			rowNumElement.setText(String.valueOf((Integer.parseInt(rowNumElement.getText()) + 1)));
		}
		// 向row节点插入数据
		if (StringUtil.isNotEmpty(subElementName)) {
			// 有多行的情况
			Element subElement = DocumentHelper.createElement(subElementName);
			// 当值不为空的情况
			if (StringUtil.isNotEmpty(value)) {
				subElement.setText(value);
			}
			rowElement.add(subElement);
		}
		return dataElement;
	}
	
	
	
	
	/**
	 * 
	 * @Description: 有多个子节点的情况，在data里面添加子节点---临时使用把实际元素变为rows
	 * @param dataElement
	 *            报文的data节点
	 * @rowElement 参数需要被添加的row节点
	 * @param subElementName
	 *            需要添加的子节点的名称
	 * @param value
	 *            需要添加的子节点的值
	 * @return
	 */
	public static Element appendMutiEleRows(Element dataElement,
			Element rowElement, String subElementName, String value) {
		// 获取rownum节点
		Element rowNumElement = dataElement.element("rownum");
		if (rowNumElement == null) {
			// 节点不存在创建一个节点，初始为1
			rowNumElement = DocumentHelper.createElement("rownum");
			rowNumElement.setText(0 + "");
			dataElement.add(rowNumElement);
		}
		// 获取rows节点
		Element rowsElement = dataElement.element("rows");
		if (rowsElement == null) {
			// 节点不存在创建一个rows节点
			rowsElement = DocumentHelper.createElement("rows");
			dataElement.add(rowsElement);
		}
		if (!rowElement.nodeIterator().hasNext()) {
			// 节点为新创建的节点
			rowsElement.add(rowElement);
			rowNumElement.setText(String.valueOf((Integer.parseInt(rowNumElement.getText()) + 1)));
		}
		// 向row节点插入数据
		if (StringUtil.isNotEmpty(subElementName)) {
			// 有多行的情况
			Element subElement = DocumentHelper.createElement(subElementName);
			// 当值不为空的情况
			if (StringUtil.isNotEmpty(value)) {
				subElement.setText(value);
			}
			rowElement.add(subElement);
		}
		return dataElement;
	}
	
	
	
	
	/**
     * 将xml填充到bean
     * @param type
     * @param map
     * @return
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
	public static final Object toBean(Class<?> type,
			Element element) throws IntrospectionException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(type);
		Object obj = type.newInstance();
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			String propertyName = null;
			try {
				PropertyDescriptor descriptor = propertyDescriptors[i];
			    propertyName = descriptor.getName().toLowerCase();
			    if("class".equals(propertyName)){
			    	continue;
			    }
				//元素值
				Object value = eleString(element.element(propertyName));
				Object[] args = new Object[1];
				args[0] = value;
				descriptor.getWriteMethod().invoke(obj, args);
			} catch (Exception e) {
				logger.error("propertyName = " + propertyName);
				e.printStackTrace();
			}
		}
		return obj;
	}
	
}
