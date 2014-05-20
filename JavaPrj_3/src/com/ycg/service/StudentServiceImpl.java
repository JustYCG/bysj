package com.ycg.service;

import java.util.List;

import com.ycg.dao.StudentDAO;
import com.ycg.dao.StudentDAOImpl;
import com.ycg.po.Student;
import com.ycg.po.Subject;
import com.ycg.util.Page;
import com.ycg.util.PageResult;
import com.ycg.util.PageUtil;

public class StudentServiceImpl implements StudentService{
	private StudentDAO studentDAO = new StudentDAOImpl();
	
	public boolean allowLogin(String studentID, String password) {
		
		Student student = studentDAO.findByStudentID(studentID);
		if(student == null) {//判断是否存在该ID的学生
			return false;
		}else {
			if(password.equals(student.getPassword())) {//判断密码是否相同
				return true;
			}else{
				return false;
			}
			
		}
	}

	public Student getStudentInfo(String studentID) {
		return studentDAO.findByStudentID(studentID);
	}

	public void setStudentResult(String studentID, int result) {
		Student student = studentDAO.findByStudentID(studentID);//根据ID查找到该学生
		student.setResult(result);//设置其成绩
		studentDAO.updateStudent(student);//更新学生信息
	}

	public List<Student> getStudentByName(String studentName) {
		return studentDAO.findByStudentName(studentName);
	}

	public List<Student> getStudentByClass(String sclass) {
		return studentDAO.findByStudentClass(sclass);
	}


	public boolean saveStudent(Student student) {
		String studentID =student.getStudentID();
		if(studentDAO.findByStudentID(studentID)==null){ //如果该试题标题不存在，允许添加
			studentDAO.addStudent(student);
			return true;
		}else {
			return false;
		}
	}

	public PageResult queryStudentByPage(Page page) {
		// TODO Auto-generated method stub
		page = PageUtil.createPage(page.getEveryPage(),
				studentDAO.findStudentCount(),page.getCurrentPage());//根据总记录数创建分页信息
		List<Student> list = studentDAO.findStudentByPage(page);//通过分页信息取得试题
		PageResult result = new PageResult(page,list);//封装分页信息和记录信息，返回给调用处
		return result;
	}

	public void deleteStudent(String studentID) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(studentID);
	}

	public Student showStudentParticular(String studentID) {
		// TODO Auto-generated method stub
		return studentDAO.findStudentByID(studentID);
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentDAO.updateStudent(student);
	}
}
