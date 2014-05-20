package com.ycg.service;

import java.util.List;

import com.ycg.po.Student;
import com.ycg.po.Subject;
import com.ycg.util.Page;
import com.ycg.util.PageResult;

public interface StudentService {
	//���ѧ����Ϣ�������ж�ѧ����¼�Ƿ����
	public boolean saveStudent(Student student);
	//�ж��Ƿ�Ϊ�Ϸ�ѧ�����Ӷ������Ƿ������¼
	public boolean allowLogin(String studentID,String password);
	//���ѧ����Ϣ
	public Student getStudentInfo(String studentID);
	//����ѧ���ɼ�
	public void setStudentResult(String studentID,int result);
	//����ѧ����������ѧ��
	public List<Student> getStudentByName(String studentName);
	//���ݰ༶����ѧ��
	public List<Student> getStudentByClass(String sclass);
	//����ҳ������ѧ����Ϣ
	public PageResult queryStudentByPage(Page page);
	// �鿴ѧ����ϸ��Ϣ
	public Student showStudentParticular(String studentID);
	// ����ѧ����Ϣ
	public void updateStudent(Student student);
	// ɾ��ѧ����Ϣ
	public void deleteStudent(String studentID);
}
