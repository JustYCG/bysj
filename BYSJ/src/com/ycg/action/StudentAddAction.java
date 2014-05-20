package com.ycg.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ycg.po.Student;
import com.ycg.service.StudentService;
import com.ycg.service.StudentServiceImpl;

//��Action��������ѧ��������������ҵ���߼����studenttService������������
public class StudentAddAction extends ActionSupport{
	private String studentID;
	private String password;
	private String studentName;
	private Integer result;
	private String sclass;

	private StudentService studentService = new StudentServiceImpl();
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	
	public String execute() throws Exception {
		Student student=new Student();
		student.setStudentID(studentID);
		student.setPassword(password);
		student.setStudentName(studentName);
		student.setResult(result);
		student.setSclass(sclass);
		if(studentService.saveStudent(student)) {
			return SUCCESS;
		}else {
			this.addActionError("���д�ѧ����Ϣ����ȷ�ϣ�");
			return INPUT;
		}
	}
}

