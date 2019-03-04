package com.meils.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC  工具类
 * @author apple
 *
 */
public class JdbcUtil {
	// 配置信息
	public static String driverName = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/mytest";
	public static String userName = "root";
	public static String password = "zjj19970517";
	
	static {
		try {
			// 加载驱动，因为是在static块中，所以只会加载一次
			Class.forName(JdbcUtil.driverName);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 连接数据库
	 * @return 返回连接对象
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(JdbcUtil.url, JdbcUtil.userName, JdbcUtil.password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭连接，并释放资源
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void close(Connection conn, Statement st, ResultSet rs) {
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(st!=null) {
			try {
				st.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(rs!=null) {
			try {
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
