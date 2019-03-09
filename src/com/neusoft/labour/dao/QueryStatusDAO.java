package com.neusoft.labour.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class QueryStatusDAO extends BaseDao {
	/**
	 * serviceid-- 80300002
	 * @Description 查询备案审批结果
	 * @author  chen-tao
	 * @date   2018-9-12
	 */
	private static Logger logger =Logger.getLogger(QueryStatusDAO.class);
	public List<Map<String, Object>> querystatus(String applicant_idnumber,String applicant_name,String represent_number,String apply_type){
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		String sql = "select applicant_idnumber,applicant_name,apply_type,review_comment,review_status,SUBMIT_DATE from view_result_to_interface where applicant_idnumber = ? and applicant_name = ? and represent_number = ?  and apply_type =? ";
		//执行查询
		try {
			List<String> bindArgs = new ArrayList<>(Arrays.asList(applicant_idnumber,applicant_name,represent_number,apply_type));
			resultList = this.executeQuery(sql, bindArgs);
		} catch (Exception e) {
			logger.info("劳动备案审批---备案结果查询--查询-异常!");
			resultList = null;
		}
		return resultList;
		
	}
	
	

}
