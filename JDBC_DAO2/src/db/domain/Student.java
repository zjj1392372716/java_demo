package db.domain;

/**
 * 学生表
 * domain类
 * @author apple
 *
 */
public class Student {

	public Integer pid; // id
	public String name; // 姓名
	public Integer age; // 年龄
	
	@Override
	public String toString() {
		return "Student [pid=" + pid + ", name=" + name + ", age=" + age + "]";
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
