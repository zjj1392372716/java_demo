package db.dao.test;

import java.util.List;

import db.dao.IStudentDao;
import db.dao.impl.StudentDaoImpl;
import db.domain.Student;

public class StudentTest {
	
	public static void main(String[] args) {
		save();
	}
	
	static void save() {
		Student stu = new Student();
		stu.setName("码字");
		stu.setAge(10);
		
		IStudentDao dao = new StudentDaoImpl();
		dao.save(stu);
	}
	
	public static void delete() {
		IStudentDao dao = new StudentDaoImpl();
		dao.delete(3);
	}


	public static void update() {
		IStudentDao dao = new StudentDaoImpl();
		Student stu = new Student();
		stu.setName("张美美");
		stu.setAge(2);	
		dao.update(2, stu);
		
	}

	public static void get(){
		IStudentDao dao = new StudentDaoImpl();
		 Student stu = dao.findOne(2);
		 System.out.println(stu);
	}


	public static void getAll(){
		IStudentDao dao = new StudentDaoImpl();
		List<Student> allStu = dao.findAll();
		System.out.println(allStu);
	}
	
}
