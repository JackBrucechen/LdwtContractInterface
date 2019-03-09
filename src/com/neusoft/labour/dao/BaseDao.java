package com.neusoft.labour.dao;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.neusoft.labour.util.C3p0Util;
import com.neusoft.labour.util.PropertiesUtil;
import com.neusoft.labour.util.StringUtil;

import oracle.sql.BLOB;

public class BaseDao {
	/**
	 * 可以执行新增，修改，删除
	 * 
	 * @param sql
	 *            sql语句
	 * @param bindArgs
	 *            绑定参数
	 * @return 影响的行数
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public int executeUpdate(String sql, Object[] bindArgs)
			throws Exception {
		/** 影响的行数 **/
		int affectRowCount = -1;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			/** 从数据库连接池中获取数据库连接 **/
			connection = C3p0Util.getInstance().getConnection(PropertiesUtil.DATASOURCE);
			/** 执行SQL预编译 **/
			preparedStatement = connection.prepareStatement(sql.toString());
			/** 设置不自动提交，以便于在出现异常的时候数据库回滚 **/
			connection.setAutoCommit(false);
			if (bindArgs != null) {
				/** 绑定参数设置sql占位符中的值 **/
				for (int i = 0; i < bindArgs.length; i++) {
					preparedStatement.setObject(i + 1, bindArgs[i]);
				}
			}
//			LogUtil.writeLog(sql);
			/** 执行sql **/
			affectRowCount = preparedStatement.executeUpdate();
			connection.commit();
			String operate;
			if (sql.toUpperCase().indexOf("DELETE FROM") != -1) {
				operate = "删除";
			} else if (sql.toUpperCase().indexOf("INSERT INTO") != -1) {
				operate = "新增";
			} else {
				operate = "修改";
			}
		} catch (Exception e) {
			if (connection != null) {
				connection.rollback();
			}
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return affectRowCount;
	}

	/**
	 * 执行查询
	 * 
	 * @param sql
	 *            要执行的sql语句
	 * @param bindArgs
	 *            绑定的参数
	 * @return List<Map<String, Object>>结果集对象
	 * @throws Exception
	 */
	public List<Map<String, Object>> executeQuery(String sql,List<String> bindArgs ) throws Exception {
		List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			/** 获取数据库连接池中的连接 **/
			connection = C3p0Util.getInstance().getConnection(PropertiesUtil.DATASOURCE);
			preparedStatement = connection.prepareStatement(sql);
			if (bindArgs != null) {
				/** 设置sql占位符中的值 **/
				for (int i = 0; i < bindArgs.size(); i++) {
					preparedStatement.setString(i + 1, bindArgs.get(i));
				}
			}
//			LogUtil.writeLog(sql);
			/** 执行sql语句，获取结果集 **/
			resultSet = preparedStatement.executeQuery();
			datas = getDatas(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return datas;
	}

	/**
	 * 执行数据库插入操作
	 * 
	 * @param valueMap
	 *            插入数据表中key为列名和value为列对应的值的Map对象
	 * @param tableName
	 *            要插入的数据库的表名
	 * @return 影响的行数
	 * @throws Exception
	 */
	public int insert(String tableName, Map<String, Object> valueMap) throws Exception {

		/** 获取数据库插入的Map的键值对的值 **/
		Set<String> keySet = valueMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		/** 要插入的字段sql，其实就是用key拼起来的 **/
		StringBuilder columnSql = new StringBuilder();
		/** 要插入的字段值，其实就是？ **/
		StringBuilder unknownMarkSql = new StringBuilder();
		Object[] bindArgs = new Object[valueMap.size()];
		int i = 0;
		while (iterator.hasNext()) {
			String key = iterator.next();
			columnSql.append(i == 0 ? "" : ",");
			columnSql.append(key);

			unknownMarkSql.append(i == 0 ? "" : ",");
			unknownMarkSql.append("?");
			bindArgs[i] = valueMap.get(key);
			i++;
		}
		/** 开始拼插入的sql语句 **/
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append(tableName);
		sql.append(" (");
		sql.append(columnSql);
		sql.append(" )  VALUES (");
		sql.append(unknownMarkSql);
		sql.append(" )");
		return executeUpdate(sql.toString(), bindArgs);
	}

	/**
	 * 执行更新操作
	 * 
	 * @param tableName
	 *            表名
	 * @param valueMap
	 *            要更改的值
	 * @param whereMap
	 *            条件
	 * @return 影响的行数
	 * @throws Exception
	 */
	public int update(String tableName, Map<String, Object> valueMap,
			Map<String, Object> whereMap) throws Exception {
		/** 获取数据库插入的Map的键值对的值 **/
		Set<String> keySet = valueMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		/** 开始拼插入的sql语句 **/
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ");
		sql.append(tableName);
		sql.append(" SET ");

		/** 要更改的的字段sql，其实就是用key拼起来的 **/
		StringBuilder columnSql = new StringBuilder();
		int i = 0;
		List<Object> objects = new ArrayList<Object>();
		while (iterator.hasNext()) {
			String key = iterator.next();
			columnSql.append(i == 0 ? "" : ",");
			columnSql.append(key + " = ? ");
			objects.add(valueMap.get(key));
			i++;
		}
		sql.append(columnSql);

		/** 更新的条件:要更改的的字段sql，其实就是用key拼起来的 **/
		StringBuilder whereSql = new StringBuilder();
		int j = 0;
		if (whereMap != null && whereMap.size() > 0) {
			whereSql.append(" WHERE ");
			iterator = whereMap.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				whereSql.append(j == 0 ? "" : " AND ");
				whereSql.append(key + " = ? ");
				objects.add(whereMap.get(key));
				j++;
			}
			sql.append(whereSql);
		}
		return executeUpdate(sql.toString(), objects.toArray());
	}

	/**
	 * 执行删除操作
	 * 
	 * @param tableName
	 *            要删除的表名
	 * @param whereMap
	 *            删除的条件
	 * @return 影响的行数
	 * @throws Exception
	 */
	public int delete(String tableName, Map<String, Object> whereMap) throws Exception {
		/** 准备删除的sql语句 **/
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ");
		sql.append(tableName);

		/** 更新的条件:要更改的的字段sql，其实就是用key拼起来的 **/
		StringBuilder whereSql = new StringBuilder();
		Object[] bindArgs = null;
		if (whereMap != null && whereMap.size() > 0) {
			bindArgs = new Object[whereMap.size()];
			whereSql.append(" WHERE ");
			/** 获取数据库插入的Map的键值对的值 **/
			Set<String> keySet = whereMap.keySet();
			Iterator<String> iterator = keySet.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				String key = iterator.next();
				whereSql.append(i == 0 ? "" : " AND ");
				whereSql.append(key + " = ? ");
				bindArgs[i] = whereMap.get(key);
				i++;
			}
			sql.append(whereSql);
		}
		return executeUpdate(sql.toString(), bindArgs);
	}

	/**
	 * 组装返回值
	 * 
	 * @param 【ResultSet】 rs 查询结果
	 * @return 【List<Map<String,Object>>】
	 * @throws SQLException
	 */
	private List<Map<String, Object>> getDatas(ResultSet rs)
			throws SQLException {
		List<Map<String, Object>> lm = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			ResultSetMetaData rsm = rs.getMetaData();
			int columnnum = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= columnnum; i++) {
				map.put(rsm.getColumnName(i), rs.getObject(i));
			}
			lm.add(map);
		}
		return lm;
	}
	
	
	
	
	/**
	 * 执行查询
	 * 
	 * @param sql
	 *            要执行的sql语句
	 * @param bindArgs
	 *            绑定的参数
	 * @return List<Map<String, Object>>结果集对象
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public int executeUpdateBlob(String sql,String keyid,String blobColumn,String content) throws Exception {
		int result = -1;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			/** 获取数据库连接池中的连接 **/
			connection = C3p0Util.getInstance().getConnection(PropertiesUtil.DATASOURCE);
			/** 设置不自动提交，以便于在出现异常的时候数据库回滚 **/
			connection.setAutoCommit(false);
			/** 执行SQL预编译 **/
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1, keyid); //条件就一个，记录主键id
			/** 执行sql语句，获取结果集 **/
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				/* 获取此CLOB对象 */
				BLOB blob = (BLOB) resultSet.getBlob(blobColumn);
				
				OutputStream blobWriter = blob.getBinaryOutputStream();
				byte[] b = content.getBytes();
				blobWriter.write(b,0,b.length);
				blobWriter.flush();
				blobWriter.close();
				
			}
			result = 1;
			connection.commit();
			
		} catch (Exception e) {
			result = -1;
			/* 出错回滚 */
			connection.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return result;
	}
	
	
	/**
	 * 通过secquence获取一个主键
	 * 
	 * @Description:
	 * @author david
	 * @param seqName
	 * @return
	 * @date 2016-12-5 下午03:30:44
	 */
	public String getSequenceId(String seqName) {
		String seq = "";
		try {
			List<Map<String, Object>> list = this.executeQuery("select " + seqName + ".nextval SEQ from dual", null);
			if(list != null && list.size() > 0){
				seq = StringUtil.getString(list.get(0).get("SEQ"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			seq = "-1";
		}
		return seq;
	}
}
