package com.neusoft.labour.util;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Util {
	 private static C3p0Util instance = null;
     /**
      * 数据源map
      */
	 private static Map<String, ComboPooledDataSource> dataSourceMap=new HashMap<String, ComboPooledDataSource>();
	 
	 synchronized public static C3p0Util getInstance() {
	  if (instance == null) {
	   instance = new C3p0Util();
	  }
	  return instance;
	 }
	 public Connection getConnection(String dsName) throws SQLException {
		 ComboPooledDataSource ds=dataSourceMap.get(dsName);
		 	if(ds==null)
			 {
				 ds=new ComboPooledDataSource(dsName);
				 dataSourceMap.put(dsName, ds);
			 }
		 return ds.getConnection();
	 }
	 
	 public static void release(String dsName) {
	  ComboPooledDataSource ds=dataSourceMap.get(dsName);
	  try {
	   if (ds != null) {
	    ds.close();
	   }
	  } catch (Exception ex) {
	   ex.printStackTrace();
	  }
	 }
	 
	 public static void closeResource(Connection conn, Statement stmt, ResultSet rs) {
			
			try {
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(stmt!=null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if(conn!=null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
}


