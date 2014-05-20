package com.ycg.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ycg.po.Student;
import com.ycg.service.StudentService;
import com.ycg.service.StudentServiceImpl;
import com.ycg.util.Page;
import com.ycg.util.PageResult;

public class QueryStudentAction extends ActionSupport{
	private int currentPage;
	private StudentService studentService =new StudentServiceImpl();
	
	public void setCurrentPage(int currentPage){
		this.currentPage=currentPage;
	}
	
	public int getCurrentPage(){
		return currentPage;
	}

	public String execute() throws Exception{
		System.out.println(1);
		Page page=new Page();
		page.setEveryPage(10);//ÿҳ��ʾ10����¼
		page.setCurrentPage(currentPage);//���õ�ǰҳ
		PageResult pageResult =  studentService.queryStudentByPage(page);
		List<Student> students = pageResult.getList();//��������¼
		System.out.println(students.size());
		page = pageResult.getPage();//��÷�ҳ��Ϣ
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("students", students);	
		request.setAttribute("page", page);
		return SUCCESS;
	}
}
