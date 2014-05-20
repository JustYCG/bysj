package com.ycg.service;

import java.util.List;

import com.ycg.po.Student;
import com.ycg.po.Subject;
import com.ycg.util.Page;
import com.ycg.util.PageResult;

public interface StudentService {
	//添加学生信息，首先判断学生记录是否存在
	public boolean saveStudent(Student student);
	//判断是否为合法学生，从而决定是否允许登录
	public boolean allowLogin(String studentID,String password);
	//获得学生信息
	public Student getStudentInfo(String studentID);
	//设置学生成绩
	public void setStudentResult(String studentID,int result);
	//根据学生姓名查找学生
	public List<Student> getStudentByName(String studentName);
	//根据班级查找学生
	public List<Student> getStudentByClass(String sclass);
	//根据页数查找学生信息
	public PageResult queryStudentByPage(Page page);
	// 查看学生详细信息
	public Student showStudentParticular(String studentID);
	// 更新学生信息
	public void updateStudent(Student student);
	// 删除学生信息
	public void deleteStudent(String studentID);
}
