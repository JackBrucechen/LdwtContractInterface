package com.neusoft.labour.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class QuerysocialcodeDao extends BaseDao{
	private static Logger logger =Logger.getLogger(QuerysocialcodeDao.class);
	/**
	 *  serviceid-- 80300001
	 * @Description 查询单位统一信用代码是否存在
	 * @return 0或1
	 * @author  chen-tao
	 * @date   2018-9-7
	 */
	public boolean querystatus(String unitcode){
		List<Map<String, Object>> unitcodelist = new ArrayList<Map<String, Object>>();
		List<String> bindArgs = new ArrayList<>(Arrays.asList(unitcode));
		String sql = "select * from company where ORGANIZATION_CODE= ?";
		//执行查询
		try {
			unitcodelist = this.executeQuery(sql, bindArgs);
		} catch (Exception e) {
			logger.info("查询社会统一信用代码-异常!");
			unitcodelist = null;
		}
        if (unitcodelist.isEmpty()){
        	logger.info("查询不到对应的社会统一信用代码记录");
        	return false;
        }else {
        	return true;	
		}
	}
}
