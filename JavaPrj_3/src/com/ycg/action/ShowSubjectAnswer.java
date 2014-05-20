package com.ycg.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ycg.po.Subject;
import com.ycg.service.SubjectService;
import com.ycg.service.SubjectServiceImpl;

/*
 * ��ʾ�����
 */
public class ShowSubjectAnswer extends ActionSupport{
	private SubjectService subjectService = new SubjectServiceImpl();
	public String execute() throws Exception {
		List<Subject> subjects = new ArrayList<Subject>();//����ѧ����������Ŀ
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		List<Integer> subjectIDs = (List<Integer>) session.get("subjectIDs");
		for(Integer subjectID : subjectIDs) {
			Subject subject = subjectService.showSubjectParticular(subjectID);//ͨ�������Ų�������
			subjects.add(subject);
		}
		request.setAttribute("subjects", subjects);
		return SUCCESS;
	}
}
