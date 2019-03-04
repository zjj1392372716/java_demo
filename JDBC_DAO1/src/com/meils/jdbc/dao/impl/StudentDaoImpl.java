package com.meils.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.meils.jdbc.dao.IStudentDao;
import com.meils.jdbc.domain.Student;
import com.meils.jdbc.handle.IResultSetHandle;
import com.meils.jdbc.utils.CRUDTemplate;

import db.utils.JDBCUtils;

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
		String sql = "insert into student (name, age) values (? , ?)";
		CRUDTemplate._executeUpdate(sql, stu.getName(), stu.getAge());
	}

	@Override
	public void delete(int id) {
		String sql = "delete from student where id = ?";
		CRUDTemplate._executeUpdate(sql, id);
	}

	@Override
	public void update(int id, Student stu) {	
		String sql = "update student set name=?, age=? where id = ? ";
		CRUDTemplate._executeUpdate(sql, stu.getName(), stu.getAge(), id);
	}

	@Override
	public Student findOne(int id) {
		
		String sql = "select * from student where id = ?";
		IResultSetHandle <List<Student>> result = new StuResultSetHandle();
		List<Student> list = CRUDTemplate._executeQuery(sql,result,id);
		return list.size() == 1 ? list.get(0) : null;
	}

	@Override
	public List<Student> findAll() {
		String sql = "select * from student ";
		return CRUDTemplate._executeQuery(sql,new StuResultSetHandle());
	}
}

/**
 * 结果集处理 实现类
 * @author apple
 *
 */
class StuResultSetHandle implements IResultSetHandle <List<Student>>{

	@Override
	public List<Student> handle(ResultSet rs) {
		List<Student> list = new ArrayList<Student>();
		try {
			while (rs.next()) {
				Student stu = new Student();
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setId(rs.getInt("id"));
				list.add(stu);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
