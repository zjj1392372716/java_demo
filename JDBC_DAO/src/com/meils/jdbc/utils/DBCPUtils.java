package com.meils.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * JDBC  工具类
 * @author apple
 *
 */
public class DBCPUtils {
	// 配置信息
	public static String driverName = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/mytest";
	public static String userName = "root";
	public static String password = "zjj19970517";
	public static BasicDataSource d = null;
	/**
	 * 连接数据库
	 * @return 返回连接对象
	 */
	public static Connection getConnection() {
		try {
			// 创建连接池
			DataSource db = DBCPUtils.getDataSource();
			// 获取连接对象
			return db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取连接池
	 * @return
	 */
	public static DataSource getDataSource() {
		d = new BasicDataSource();
		d.setDriverClassName(driverName);
		d.setUrl(url);
		d.setUsername(userName);
		d.setPassword(password);
		return d;
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
