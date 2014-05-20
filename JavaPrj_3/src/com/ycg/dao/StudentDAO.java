package com.ycg.dao;

import java.util.List;

import com.ycg.po.Student;
import com.ycg.po.Subject;
import com.ycg.util.Page;

public interface StudentDAO { 
	public void addStudent(Student student);//用来添加学生信息
	public List<Student> findStudentByPage(Page page);//分页查询试题
	public int findStudentCount();//查询试题总量
	public Student findByStudentID(String studentID);//查询方法，根据学生ID查询
	public void updateStudent(Student student);//更新学生信息
	public void deleteStudent(String studentID);//删除学生信息
	public List<Student> findByStudentName(String studentName);//根据学生姓名查找学生
	public List<Student> findByStudentClass(String sclass);//根据班级查找学生
	public Student findStudentByID(String studentID);//根据ID查找学生
}
