package com.ycg.service;

import java.util.List;

import com.ycg.dao.StudentDAO;
import com.ycg.dao.StudentDAOImpl;
import com.ycg.po.Student;
import com.ycg.po.Subject;
import com.ycg.util.Page;
import com.ycg.util.PageResult;
import com.ycg.util.PageUtil;

public class StudentServiceImpl implements StudentService{
	private StudentDAO studentDAO = new StudentDAOImpl();
	
	public boolean allowLogin(String studentID, String password) {
		
		Student student = studentDAO.findByStudentID(studentID);
		if(student == null) {//�ж��Ƿ���ڸ�ID��ѧ��
			return false;
		}else {
			if(password.equals(student.getPassword())) {//�ж������Ƿ���ͬ
				return true;
			}else{
				return false;
			}
			
		}
	}

	public Student getStudentInfo(String studentID) {
		return studentDAO.findByStudentID(studentID);
	}

	public void setStudentResult(String studentID, int result) {
		Student student = studentDAO.findByStudentID(studentID);//����ID���ҵ���ѧ��
		student.setResult(result);//������ɼ�
		studentDAO.updateStudent(student);//����ѧ����Ϣ
	}

	public List<Student> getStudentByName(String studentName) {
		return studentDAO.findByStudentName(studentName);
	}

	public List<Student> getStudentByClass(String sclass) {
		return studentDAO.findByStudentClass(sclass);
	}


	public boolean saveStudent(Student student) {
		String studentID =student.getStudentID();
		if(studentDAO.findByStudentID(studentID)==null){ //�����������ⲻ���ڣ��������
			studentDAO.addStudent(student);
			return true;
		}else {
			return false;
		}
	}

	public PageResult queryStudentByPage(Page page) {
		// TODO Auto-generated method stub
		page = PageUtil.createPage(page.getEveryPage(),
				studentDAO.findStudentCount(),page.getCurrentPage());//�����ܼ�¼��������ҳ��Ϣ
		List<Student> list = studentDAO.findStudentByPage(page);//ͨ����ҳ��Ϣȡ������
		PageResult result = new PageResult(page,list);//��װ��ҳ��Ϣ�ͼ�¼��Ϣ�����ظ����ô�
		return result;
	}

	public void deleteStudent(String studentID) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(studentID);
	}

	public Student showStudentParticular(String studentID) {
		// TODO Auto-generated method stub
		return studentDAO.findStudentByID(studentID);
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentDAO.updateStudent(student);
	}
}
