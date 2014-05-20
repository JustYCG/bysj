package com.ycg.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ycg.po.Student;
import com.ycg.service.StudentService;
import com.ycg.service.StudentServiceImpl;

public class StudentUpdateBefore extends ActionSupport {
	private String studentID;
	private StudentService studentService = new StudentServiceImpl();
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String execute() throws Exception {
		Student student = studentService.showStudentParticular(studentID);
		ServletActionContext.getRequest().setAttribute("student", student);
		return SUCCESS;
	}
}
