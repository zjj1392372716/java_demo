package com.meils.jdbc.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Conn();
		delete();
	}

	// 测试连接
	public static void Conn() {
		MysqlDB m = new MysqlDB();
	}

	// 测试查询
	public static void queryTest() {
		MysqlDB m = new MysqlDB();
		String sql = "select * from student";
		ResultSet result = m.query(sql);
		System.out.println(result);
		try {
			while (result.next()) {
				System.out.println(result.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			m.close();
		}
	}
	// 更新
	public static void update() {
		MysqlDB m = new MysqlDB();
		String sql = "update student set name = ? where id = ?";
		String [] args = {"梅子111", "7"};
		
		m.update(sql, args);
	}
	
	// 删除
	public static void delete() {
		MysqlDB m = new MysqlDB();
		String sql = "delete from student  where id = 8";
		System.out.println(m.delete(sql));
	}
	
	
	

}
