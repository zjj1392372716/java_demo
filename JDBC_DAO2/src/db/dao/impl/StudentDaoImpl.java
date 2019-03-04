package db.dao.impl;

import java.util.List;

import db.dao.IStudentDao;
import db.domain.Student;
import db.handle.BeanHandler;
import db.handle.BeanListHandler;
import db.utils.CRUDTemplate;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public int save(Student stu) {
		String sql = "insert into student (name, age) values (? , ?)";
		return CRUDTemplate._executeUpdate(sql, stu.getName(), stu.getAge());
	}

	@Override
	public int delete(int id) {
		String sql = "delete from student where pid = ?";
		return CRUDTemplate._executeUpdate(sql, id);
	}

	@Override
	public int update(int id, Student stu) {
		String sql = "update student set name=?, age=? where pid =? ";
		return CRUDTemplate._executeUpdate(sql, stu.getName(), stu.getAge(), id);
	}

	@Override
	public Student findOne(int id) {
		String sql = "select * from student where pid = ?";
		return	CRUDTemplate._executeQuery(sql, new BeanHandler<Student>(Student.class), id);
	}

	@Override
	public List<Student> findAll() {
		String sql = "select * from student ";
		return CRUDTemplate._executeQuery(sql,new BeanListHandler<Student>(Student.class));
	}

}
