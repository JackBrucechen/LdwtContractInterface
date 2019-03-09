package com.neusoft.labour.util;

import java.io.BufferedInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Encoder;
/**
 * 基础工具类
 * @author xu-wq
 *
 */
public class BaseUtil {	
	/**
	 * 获取请求中的所有参数
	 * @param request
	 * @return
	 */
	public static Map<String, String> getAllRequestParam(final HttpServletRequest request) {
		Map<String, String> res = new HashMap<String, String>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				res.put(en, value);
				//在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
				if (null == res.get(en) || "".equals(res.get(en))) {
					res.remove(en);
				}
			}
		}
		return res;
	}
	/**
	 * 判断字符串是否为NULL或空
	 * 
	 * @param s
	 *            待判断的字符串数据
	 * @return 判断结果 true-是 false-否
	 */
	public static boolean isEmpty(String s) {
		return null == s || "".equals(s.trim());
	}
	/**
	 * 将Map中的数据转换成按照Key的ascii码排序后的key1=value1&key2=value2的形式 并排除指定值
	 * 
	 * @param data
	 *            待拼接的Map数据
	 * @param lparam_signatures 需要被过滤的值
	 * @return 拼接好后的字符串
	 */
	public static String coverMap2String(Map<String, String> data,List<String> lparam_signatures) {
		TreeMap<String, String> tree = new TreeMap<String, String>();
		Iterator<Entry<String, String>> it = data.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> en = it.next();
			if(lparam_signatures.contains(en.getKey().trim()))
			{
				continue;
			}
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
	 * 将key1=value1&key2=value2形式的string转换为Map
	 * 
	 * @param data
	 *            待拼接的string数据
	 * @return 拼接好后Map
	 */
	public static Map<String, String> coverString2Map(String data) {
		String[] s=data.split("&");
		Map<String,String> map=new HashMap<String, String>();
		for(int i=0;i<s.length;i++)
		{
			String temp=s[i];
			String[] temps=temp.split("=",2);
			if(temps.length>1){
				map.put(temps[0], temps[1]);
			}else{
				map.put(temps[0], "");
			}
		}
		return map;
	}
	/**
	 * 过滤请求报文中的空字符串或者空字符串
	 * @param contentData
	 * @return
	 */
	public static Map<String, String> filterBlank(Map<String, String> contentData){
//		LogUtil.writeLog("打印报文域 :");
		Map<String, String> submitFromData = new HashMap<String, String>();
		Set<String> keyset = contentData.keySet();
		
		for(String key:keyset){
			String value = contentData.get(key);
			if (StringUtils.isNotBlank(value)) {
				// 对value值进行去除前后空处理
				submitFromData.put(key, value.trim());
//				LogUtil.writeLog(key + "-->" + String.valueOf(value));
			}
		}
		return submitFromData;
	}
	 /**
     * 生成6位数验证码
     * @return
     */
    public static String createValidCode()
    {
    	StringBuilder validCode=new StringBuilder();
    	for(int i=0;i<6;i++)
    	{
    		Random r=new Random();
    		validCode.append(r.nextInt(9));
    	}
    	return validCode.toString();
    }
    /**
     * 获取UUID
     * @return
     */
    public static String getUUid()
    {
    	return UUID.randomUUID().toString().replace("-", "");
    }
    /**
     * 将Blob转为byte[]
     * @param blob
     * @return
     * @throws Exception
     */
    public static byte[] blob2ByteArr(Blob blob) throws Exception {
             BufferedInputStream is = null;
            byte[] bytes = null;
            try {
                is = new BufferedInputStream(blob.getBinaryStream());
                bytes = new byte[(int) blob.length()];
                int len = bytes.length;
                int offset = 0;
                int read = 0;
     
                while (offset < len
                        && (read = is.read(bytes, offset, len - offset)) >= 0) {
                    offset += read;
                }
     
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bytes;
    }
    /**
     * 用指定字符替换string里面指定长度的字符
     * @param source 要替换的字符串
     * @param rplStr 要使用的替换字符
     * @param start 开始位置
     * @param length 替换长度
     * @return
     */
    public static String rplStr(String source,char rplStr,int start,int length)
    {
        String headStr=source.substring(0, start);
        String footStr=source.substring(start+length,source.length());
        StringBuilder body=new StringBuilder();
        for(int i=0;i<length;i++)
        {
        	body.append(rplStr);
        }
    	return headStr+body.toString()+footStr;
    }
    /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException  
     */
    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
}
