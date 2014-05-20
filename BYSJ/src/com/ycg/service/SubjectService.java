package com.ycg.service;

import java.util.List;

import com.ycg.po.Subject;
import com.ycg.util.Page;
import com.ycg.util.PageResult;

public interface SubjectService {
	// ������⣬�����жϸ���������Ƿ��Ѿ����ڣ�����Ѿ��������
	public boolean saveSubject(Subject subject);
	// ����ҳ��Ϣ��ѯ����
	public PageResult querySubjectByPage(Page page);
	// �鿴������ϸ��Ϣ
	public Subject showSubjectParticular(int subjectID);
	// ����������Ϣ
	public void updateSubject(Subject subject);
	// ɾ��������Ϣ
	public void deleteSubject(int subjectID);
	//ģ����ѯ������Ϣ
	public PageResult likeQueryBySubjectTitle(String subjectTitle,Page page);
	//�����ѯ�����¼
	public List<Subject> randomFindSubject(int number);
	//����ѧ���÷�
	public int accountResult(List<Integer> subjectIDs,List<String> studentAnswers);
}
