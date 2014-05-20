package com.ycg.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ycg.hibernate.HibernateSessionFactory;
import com.ycg.po.Student;
import com.ycg.po.Subject;
import com.ycg.util.Page;

public class StudentDAOImpl implements StudentDAO{
	public Student findByStudentID(String studentID) {
	/*	Session session = HibernateSessionFactory.getSession();//���Session����
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();//�ر�Session����
		return student;
	*/
		Session session = HibernateSessionFactory.getSession();//���Session����
		/*Student student = (Student) session.get(Student.class, studentID);*/
		Query query = session.createQuery("from Student as stu where stu.studentID = ?");
		query.setString(0, studentID);
		List list =query.list();//������浽list��
		HibernateSessionFactory.closeSession();//�ر�Session����
		if(list.size()==0){
			return null;
		}else{
			return (Student)list.get(0);
		}
	}

	public void updateStudent(Student student) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.update(student);//����ѧ����Ϣ
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}
	
	public void deleteStudent(String studentID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Student student = (Student) session.get(Student.class, studentID);
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.delete(student);
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}

	public List<Student> findByStudentName(String studentName) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Student as stu where stu.studentName = ?");
		query.setString(0, studentName);
		List list = query.list();					//��ѯ������浽list��
		HibernateSessionFactory.closeSession();		//�ر�Session����
		return list;
	}

	public List<Student> findByStudentClass(String sclass) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Student as stu where stu.sclass = ?");
		query.setString(0, sclass);
		List list = query.list();					//��ѯ������浽list��
		HibernateSessionFactory.closeSession();		//�ر�Session����
		return list;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.save(student);//����ѧ����Ϣ
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}


	public List<Student> findStudentByPage(Page page) {	
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Student");
		query.setMaxResults(page.getEveryPage());//���ò�ѯ��¼��
		query.setFirstResult(page.getBeginIndex());//���ò�ѯ��¼��ʼλ��
		List list = query.list();					//��ѯ������浽list��
		HibernateSessionFactory.closeSession();//�ر�Session����
		return list;
	}


	public int findStudentCount() {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Student");
		List list = query.list();					//��ѯ������浽list��
		int count = list.size();
		HibernateSessionFactory.closeSession();//�ر�Session����
		return count;
	}

	public Student findStudentByID(String studentID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();		//�ر�Session����
		return student;
	}
}
