package db.dao;

import java.util.List;

import db.domain.Student;



// DAO层

/**
 * Student 接口
 * @author apple
 *
 */
public interface IStudentDao {
	/**
	 * 存储学生
	 * @param stu
	 * @return 返回行数
	 */
	int save(Student stu);
	
	/**
	 * 删除学生
	 * @param id
	 * @return 行数
	 */
	int delete(int id);
	
	/***
	 * 更新学生信息
	 * @param stu
	 * @return 行数
	 */
	int update(int id, Student stu);
	
	/**
	 * 查找某一个学生
	 * @param id
	 * @return 学生对象
	 */
	Student findOne(int id);
	
	/**
	 * 查找所有学生
	 * @return 返回集合
	 */
	List <Student> findAll();
}
