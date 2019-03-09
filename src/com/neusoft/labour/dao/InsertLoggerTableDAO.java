package com.neusoft.labour.dao;

import java.util.Map;

import org.apache.log4j.Logger;

public class InsertLoggerTableDAO extends BaseDao {
	/**
	 * @Description 存储接收报文信息日志至数据库
	 * @author  chen-tao
	 * @date   2018-9-10
	 */
	private static String tablename="APPLY_INTERFACE_LOG";
	private static Logger logger =Logger.getLogger(InsertLoggerTableDAO.class);
 public void insertlogger(Map<String, Object> valueMap){
	 try {
		this.insert(tablename,valueMap);
		logger.info("向数据库插入日志记录成功 ");
	} catch (Exception e) {
		e.printStackTrace();
		logger.info("向数据库插入日志记录失败 ");
	}
 }
}
