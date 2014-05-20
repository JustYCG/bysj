package com.ycg.dao;

import java.util.List;

import com.ycg.po.Subject;
import com.ycg.util.Page;

public interface SubjectDAO {
	public void addSubject(Subject subject);//���淽����������������
	public Subject findSubjectByTitle(String subjectTitle);//������������������
	public List<Subject> findSubjectByPage(Page page);//��ҳ��ѯ����
	public int findSubjectCount();//��ѯ��������
	public Subject findSubjectByID(int subjectID);//��������ID��������
	public void updateSubject(Subject subject);//���·�����������������
	public void deleteSubject(int subjectID);//��������IDɾ������
	public List<Subject> likeQueryByTitle(String subjectTitle,Page page);//�����������ģ����ѯ����
	public int findLinkQueryCount(String subjectTitle);//��ѯģ����¼��
	public List<Subject> randomFindSubject(int number);//��ʱȡ����¼
}
