package com.neusoft.labour.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.xml.ws.Endpoint;

import org.apache.log4j.Logger;

import com.neusoft.labour.controller.LdwtController;
import com.neusoft.labour.util.PropertiesUtil;
import com.neusoft.labour.util.StringUtil;
public class InsurancePortServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(InsurancePortServlet.class);

	@SuppressWarnings("static-access")
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		propertiesUtil.init();
		logger.info("初始化配置文件完成");
		String DeployHolderPort = config.getInitParameter("DeployHolderPortLdwt");
		logger.info(DeployHolderPort);
		if (StringUtil.isEmpty(DeployHolderPort)) {
			//
			DeployHolderPort = propertiesUtil.PORTURL; 
			logger.info("DeployHolderLdwt======" + DeployHolderPort);
		}
		Endpoint.publish(DeployHolderPort, new LdwtController());
		logger.info("----------------LabourLdwtServlet.init--------------");
			  
	}
}
