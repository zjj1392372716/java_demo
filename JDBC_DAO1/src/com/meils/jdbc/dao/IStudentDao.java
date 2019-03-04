package com.meils.jdbc.dao;

import java.util.List;

import com.meils.jdbc.domain.Student;

/**
 * DAO 接口层
 * @author apple
 *
 */
public interface IStudentDao {
	
	/**
	 * 存储学生
	 * @param stu
	 */
	void save(Student stu);
	
	/**
	 * 删除学生
	 * @param id
	 * @return 是否成功
	 */
	void delete(int id);
	
	/***
	 * 更新学生信息
	 * @param stu
	 * @return
	 */
	void update(int id, Student stu);
	
	/**
	 * 查找某一个学生
	 * @param id
	 * @return
	 */
	Student findOne(int id);
	
	/**
	 * 查找所有学生
	 * @return
	 */
	List <Student> findAll();
}
