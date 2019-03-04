package com.meils.jdbc.dao.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.meils.jdbc.domain.Student;
import com.meils.jdbc.utils.JdbcUtil;

public class ProductTest {

	public static void main(String[] args) {
		CallableStatement cstmt = null;
		try {
			//1.连接
			Connection conn = JdbcUtil.getConnection();
			//2.
			CallableStatement cs = conn.prepareCall("{ call getStu(?)}");
			//3.设置参数
			cs.setString(1, "张锦杰");
			//4.执行
			ResultSet rs = cs.executeQuery();
			if(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				System.out.println(stu);
			}
			
			
			
//			//1.创建连接
//			Connection conn = JdbcUtil.getConnection();
//			//2.创建预编译语句
//			CallableStatement cs = conn.prepareCall("{ call getName(?,?)}");
//			//3.设置参数
//			cs.setInt(1, 1);
//			//4.设置输出参数
//			cs.registerOutParameter(2, Types.VARCHAR);
//			//5.执行
//			cs.execute();
//			
//			//6.获取到输出的参数
//			String name = cs.getString(2);
//			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
