package com.neusoft.labour.dao;

import java.util.Map;

import org.apache.log4j.Logger;

public class UpdateapplyeventDAO extends BaseDao {
	/**
	 * @Description 数据校验通过后更新数据库表字段
	 * @author  chen-tao
	 * @date   2018-9-12
	 */
	private static String tablename="apply_event";
	private static Logger logger =Logger.getLogger(UpdateapplyeventDAO.class);
	public void updateapplyevent(Map<String, Object> valueMap,Map<String, Object> whereMap){
		try {
			this.update(tablename, valueMap, whereMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("更新apply_event表字段失败");
		}
	}

}
