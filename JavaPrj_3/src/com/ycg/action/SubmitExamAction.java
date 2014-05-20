package com.ycg.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ycg.po.Student;
import com.ycg.service.StudentService;
import com.ycg.service.StudentServiceImpl;
import com.ycg.service.SubjectService;
import com.ycg.service.SubjectServiceImpl;

/*
 * �ύ�Ծ��������
 */
public class SubmitExamAction extends ActionSupport{
	private List<Integer> subjectID;//ѧ�����Ե���Ŀ
	private SubjectService subjectService = new SubjectServiceImpl();
	private StudentService studentService = new StudentServiceImpl();
	public List<Integer> getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(List<Integer> subjectID) {
		this.subjectID = subjectID;
	}
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String> studentAnswers = new ArrayList<String>();
		for(int i = 0; i < 20; i++) {
			String answer = request.getParameter("subjectAnswer"+i);
			studentAnswers.add(answer);
		}
		int GeneralPoint = subjectService.accountResult(subjectID, studentAnswers);
		
		//���óɼ���ѧ����Ϣ��
		Map session = ActionContext.getContext().getSession();
		Student student = (Student)session.get("studentInfo");
		String studentID = student.getStudentID();
		studentService.setStudentResult(studentID, GeneralPoint);
		request.setAttribute("studentName", student.getStudentName());//����ѧ���������ܷ���
		request.setAttribute("GeneralPoint", GeneralPoint);
		session.put("subjectIDs", subjectID);//��������Ŀ���浽session�����������ʾ��ʹ��
		return SUCCESS;
	}
}