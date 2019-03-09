package com.neusoft.labour.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	//外部调用
	public static String PORTURL = null;
	//卡管测试库地址
	public static String TESTTARGET=null;
	//卡管正式库地址	
	public static String TARGET=null;
	//平台数据库
	public static String DATASOURCE = null;
	//劳动合同备案网厅地址
	public static String LDHTBAWTTEST=null;
	//作为接入系统证书id
	public static String INFOSYSCODE = null;
	public static String INFOSYSCERTID = null;
	//密钥证书地址|密码
	public static String PRIVATEKEY_FILE_PATH = null;
	public static String PRIVATEKEY_PWD = null; 
	public static String PUBKEY_FILE_PATH = null;  
	public void init() {
		try {
			InputStream stream = null;
			Properties props = new Properties();
			stream = getClass().getClassLoader().getResourceAsStream("/config.properties");
			props.load(stream);
			
			// 数据库
			DATASOURCE = props.getProperty("DATASOURCE");
			// 外部调用
			PORTURL = props.getProperty("PORTURL");
			//卡管测试库地址
			 TESTTARGET=props.getProperty("TESTTARGET");
			//卡管正式库地址	
			TARGET=props.getProperty("TARGET");
			//接入系统代码
			INFOSYSCODE = props.getProperty("INFOSYSCODE");
			//劳动合同备案网厅地址
			LDHTBAWTTEST=props.getProperty("LDHTBAWTTEST");
			//接入系统证书ID
			INFOSYSCERTID = props.getProperty("INFOSYSCERTID");
			//密钥
			PRIVATEKEY_FILE_PATH = props.getProperty("PRIVATEKEY_FILE_PATH");
			PRIVATEKEY_PWD = props.getProperty("PRIVATEKEY_PWD");
			PUBKEY_FILE_PATH = props.getProperty("PUBKEY_FILE_PATH");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
