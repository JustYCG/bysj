package com.ycg.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ycg.po.Student;
import com.ycg.po.Subject;
import com.ycg.service.StudentService;
import com.ycg.service.StudentServiceImpl;
import com.ycg.util.Page;
import com.ycg.util.PageResult;

public class StudentDeleteAction extends ActionSupport {
	private String studentID;
	private int currentPage;		//当前页
	private StudentService studentService = new StudentServiceImpl();
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	
	public String execute() throws Exception {
		studentService.deleteStudent(studentID);
		Page page = new Page();
		page.setEveryPage(10);//每页显示10条记录
		page.setCurrentPage(currentPage);//设置当前页
		PageResult pageResult = studentService.queryStudentByPage(page);
		List<Student> students = pageResult.getList();//获得试题记录
		page = pageResult.getPage();//获得分页信息
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("students", students);
		request.setAttribute("page", page);
		return SUCCESS;
	}

}
