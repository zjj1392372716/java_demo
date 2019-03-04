
package com.meils.jdbc.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * JDBC  工具类
 * @author apple
 *
 */
public class DBCPUtils1 {
	// 配置信息
	public static DataSource d = null;
	
	/**
	 * 静态块只是在类加载的时候加载一次，创建一个连接池
	 */
	static {
		try {
			Properties p = new Properties();
			FileInputStream in;
			in = new FileInputStream("resource/db.properties");
			p.load(in);
			d = BasicDataSourceFactory.createDataSource(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 连接数据库
	 * @return 返回连接对象
	 */
	public static Connection getConnection() {
		try {
			// 获取连接对象
			return d.getConnection();
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
