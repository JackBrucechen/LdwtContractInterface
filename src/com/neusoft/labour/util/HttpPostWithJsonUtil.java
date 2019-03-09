package com.neusoft.labour.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

public class HttpPostWithJsonUtil {
	private static Logger logger = Logger
            .getLogger(HttpPostWithJsonUtil.class); // 日志记录

	public static String httpPost(String url, JSONObject jsonParam) {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
       String content=null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpPost.setConfig(requestConfig);
        try {
            if (null != jsonParam) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(),
                        "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            //请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            	logger.info("状态码为200");
                try {
                	BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity()  
                            .getContent()));  
                    StringBuffer sb = new StringBuffer("");  
                    String line = "";  
                    String NL = System.getProperty("line.separator");  
                    while ((line = in.readLine()) != null) {  
                        sb.append(line + NL);  
                    }  
                    in.close();  
                    content = sb.toString();
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }else{
            	logger.info("状态码非200");
            	try {
                	BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity()  
                            .getContent()));  
                    StringBuffer sb = new StringBuffer("");  
                    String line = "";  
                    String NL = System.getProperty("line.separator");  
                    while ((line = in.readLine()) != null) {  
                        sb.append(line + NL);  
                    }  
                    in.close();  
                    content = sb.toString();
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        } finally {
            httpPost.releaseConnection();
        }
        return content;
    }
}
