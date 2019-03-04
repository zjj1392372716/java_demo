package com.meils.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.meils.jdbc.dao.IStudentDao;
import com.meils.jdbc.domain.Student;
import com.meils.jdbc.utils.DBCPUtils;
import com.meils.jdbc.utils.DBCPUtils1;
import com.meils.jdbc.utils.JdbcUtil;

/**
 * 实现DAO接口的类
 * @author apple
 *
 */
public class StudentDaoImpl implements IStudentDao{

	@Override
	/**
	 * 存储学生
	 * @param stu
	 */
	public void save(Student stu) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 连接数据库
//			conn = JdbcUtil.getConnection();
			conn = DBCPUtils1.getConnection(); // 测试使用DBCPUtils，使用哪个utils都行的
			
			String sql = "insert into student (name, age) values (? , ?)";
			
			// 创建预编译
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			
			// 执行更新
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			JdbcUtil.close(conn, ps, null);
			DBCPUtils1.close(conn, ps, null);
		}
	}

	@Override
	public void delete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 连接数据库
			conn = JdbcUtil.getConnection();
			
			String sql = "delete from student where id = ?";
			
			// 创建预编译
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			// 执行更新
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, null);
		}
	}

	@Override
	public void update(int id, Student stu) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {

			conn = JdbcUtil.getConnection();
			
			String sql = "update student set name=?, age=? where id = ? ";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setInt(3, id);
			// 执行
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, null);
		}
		
	
	}

	@Override
	public Student findOne(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			conn = JdbcUtil.getConnection();
			// sql语句
			String sql = "select * from student where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			// 执行
			rs = ps.executeQuery();
			
			if (rs.next()) {
				// 保存数据
				Student stu = new Student();
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setId(rs.getInt("id"));
				return stu;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 销毁
			JdbcUtil.close(conn, ps, rs);

		}
		
		return null;
	}

	@Override
	public List<Student> findAll() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			
			
			conn = JdbcUtil.getConnection();
			
			
			st = conn.createStatement();
			String sql = "select * from student ";
			
			rs = st.executeQuery(sql);
			
			List<Student> list = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setId(rs.getInt("id"));
				list.add(stu);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, st, rs);
		}
		return null;
	}
	
}
