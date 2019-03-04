package com.meils.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDB {
	Connection conn = null; // 创建连接对象
	Statement st = null; // 创建编译语句对象
	PreparedStatement ps = null; // 创建预编译语句对象
	ResultSet rs1 = null;  // 结果集

	// 配置信息
	// 驱动名称
	private static final String driverName = "com.mysql.jdbc.Driver";
	// 数据库的地址
	private static final String URL = "jdbc:mysql://localhost:3306/mytest";
	// 数据库登录用户名
	private static final String userName = "root";
	// 数据库登录密码
	private static final String pwd = "zjj19970517";
	
	/**
	 * 连接数据库
	 * @return
	 */
	public Connection getConnection() {
		try {
			Class.forName(driverName);
			
			this.conn = DriverManager.getConnection(URL, userName, pwd);
			System.out.println("连接成功");
			
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 构造函数
	public MysqlDB() {
		this.getConnection();
	}
	
	/**
	 * 查询
	 * @param sql sql语句，完整的语句，查询一般比较安全
	 * @return
	 */
	public ResultSet query(String sql) {
		try {
			this.st = this.conn.createStatement();
			this.rs1 = this.st.executeQuery(sql);
			return rs1;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	/**
	 * 更新
	 * @param sql  // 预编译sql语句
	 * @param args // 参数数组
	 */
	public void update(String sql, String [] args) {
		try {
			this.ps = this.conn.prepareStatement(sql);
			for (int i = 0 ; i < args.length ; i++) {
				this.ps.setString(i+1, args[i]);
			}
			
			this.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close();
		}
		
	}
	
	/**
	 * 删除
	 * @param sql
	 * @return
	 */
	public int delete(String sql){
        try {
            this.st = this.conn.createStatement();
            int num = this.st.executeUpdate(sql);
            return num;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  finally {
			this.close();
		}
        return 0;
    }
	
	/**
	 * 释放资源
	 */
	public void close () {
		try {
            if(rs1!=null) {
                rs1.close();
            }
            if(st!=null) {
                st.close();
            }
            if(ps!=null) {
                ps.close();
            }
            if(conn!=null) {
                conn.close();
            }

        } catch (SQLException e) {
            // TODO: handle exception
        	e.printStackTrace();
        }
	}

}
