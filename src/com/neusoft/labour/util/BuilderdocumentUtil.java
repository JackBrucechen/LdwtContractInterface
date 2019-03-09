package com.neusoft.labour.util;

import java.util.UUID;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class BuilderdocumentUtil {
	
	public Document builderdocument(Document document,String companyId){
		String applyId=UUID.randomUUID().toString().replace("-", "");
		Element rootElement = document.getRootElement();
		if(rootElement.getName()=="data"){
		Element applyIdElement = DocumentHelper.createElement("applyId");
		Element companyIdElement = DocumentHelper.createElement("companyId");
		applyIdElement.setText(applyId);
		companyIdElement.setText(companyId);
	    rootElement.add(applyIdElement);
	    rootElement.add(companyIdElement);
		}
		return document;
	}
	
}
