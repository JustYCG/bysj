package com.ycg.dao;

import java.util.List;

import com.ycg.po.Student;
import com.ycg.po.Subject;
import com.ycg.util.Page;

public interface StudentDAO { 
	public void addStudent(Student student);//�������ѧ����Ϣ
	public List<Student> findStudentByPage(Page page);//��ҳ��ѯ����
	public int findStudentCount();//��ѯ��������
	public Student findByStudentID(String studentID);//��ѯ����������ѧ��ID��ѯ
	public void updateStudent(Student student);//����ѧ����Ϣ
	public void deleteStudent(String studentID);//ɾ��ѧ����Ϣ
	public List<Student> findByStudentName(String studentName);//����ѧ����������ѧ��
	public List<Student> findByStudentClass(String sclass);//���ݰ༶����ѧ��
	public Student findStudentByID(String studentID);//����ID����ѧ��
}
