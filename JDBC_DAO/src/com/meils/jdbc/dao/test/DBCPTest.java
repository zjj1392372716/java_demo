package com.meils.jdbc.dao.test;

import java.util.List;

import org.junit.Test;

import com.meils.jdbc.dao.IStudentDao;
import com.meils.jdbc.dao.impl.StudentDaoImpl;
import com.meils.jdbc.domain.Student;

public class DBCPTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ssss");
	}
	
	@Test
	public void save() {
		Student stu = new Student();
		String name = "张伟";
		stu.setName(name);
		stu.setAge(2100);
		
		IStudentDao dao = new StudentDaoImpl();
		dao.save(stu);
	}
	
	@Test
	public void delete() {
		IStudentDao dao = new StudentDaoImpl();
		dao.delete(4);
	}

	@Test
	public void update () {
		Student stu = new Student();
		stu.setName("mmmmm");
		stu.setAge(16);
		
		IStudentDao dao = new StudentDaoImpl();
		dao.update(5, stu);
	}
	
	@Test
	public void findOne() {
		IStudentDao dao = new StudentDaoImpl();
		Student stu = dao.findOne(5);
		System.out.println(stu);
	}
	
	
	@Test
	public void findAll() {
		IStudentDao dao = new StudentDaoImpl();
		List<Student> allStu = dao.findAll();
		System.out.println(allStu);
	}
}
