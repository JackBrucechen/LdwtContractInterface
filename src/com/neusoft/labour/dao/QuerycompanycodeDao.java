package com.neusoft.labour.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class QuerycompanycodeDao extends BaseDao{
	private static Logger logger =Logger.getLogger(QuerysocialcodeDao.class);
	/**
	 *  serviceid-- 80300001
	 * @Description 根据社会统一信用代码查询companyId,
	 * @return companyId
	 * @author  chen-tao
	 * @date   2018-9-7
	 */
	public List<Map<String, Object>> querycompany(String unitcode){
		List<Map<String, Object>> companynumber = new ArrayList<Map<String, Object>>();
		List<String> bindArgs = new ArrayList<>(Arrays.asList(unitcode));
		String sql = "select COMPANY_NUMBER from company where ORGANIZATION_CODE= ?";
		//执行查询
		try {
			companynumber = this.executeQuery(sql, bindArgs);
		} catch (Exception e) {
			logger.info("查询公司编号--查询-异常!");
			companynumber = null;
		}
		return companynumber;
	}
	
}
