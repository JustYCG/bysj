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
	/*	Session session = HibernateSessionFactory.getSession();//获得Session对象
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();//关闭Session对象
		return student;
	*/
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		/*Student student = (Student) session.get(Student.class, studentID);*/
		Query query = session.createQuery("from Student as stu where stu.studentID = ?");
		query.setString(0, studentID);
		List list =query.list();//结果保存到list中
		HibernateSessionFactory.closeSession();//关闭Session对象
		if(list.size()==0){
			return null;
		}else{
			return (Student)list.get(0);
		}
	}

	public void updateStudent(Student student) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.update(student);//更新学生信息
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}
	
	public void deleteStudent(String studentID) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Student student = (Student) session.get(Student.class, studentID);
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.delete(student);
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}

	public List<Student> findByStudentName(String studentName) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Student as stu where stu.studentName = ?");
		query.setString(0, studentName);
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();		//关闭Session对象
		return list;
	}

	public List<Student> findByStudentClass(String sclass) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Student as stu where stu.sclass = ?");
		query.setString(0, sclass);
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();		//关闭Session对象
		return list;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.save(student);//保存学生信息
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}


	public List<Student> findStudentByPage(Page page) {	
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Student");
		query.setMaxResults(page.getEveryPage());//设置查询记录数
		query.setFirstResult(page.getBeginIndex());//设置查询记录起始位置
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();//关闭Session对象
		return list;
	}


	public int findStudentCount() {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Student");
		List list = query.list();					//查询结果保存到list中
		int count = list.size();
		HibernateSessionFactory.closeSession();//关闭Session对象
		return count;
	}

	public Student findStudentByID(String studentID) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();		//关闭Session对象
		return student;
	}
}
