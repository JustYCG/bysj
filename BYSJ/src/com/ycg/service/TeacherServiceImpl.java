package com.ycg.service;

import com.ycg.dao.TeacherDAO;
import com.ycg.dao.TeacherDAOImpl;
import com.ycg.po.Teacher;

public class TeacherServiceImpl implements TeacherService{
	private TeacherDAO teacherDAO = new TeacherDAOImpl();
	
	public boolean allowLogin(String teacherID, String password) {
		Teacher teacher = teacherDAO.findByTeacherID(teacherID);
		if(teacher == null) {//�ж��Ƿ���ڸ�ID�Ľ�ʦ
			return false;
		}else {
			if(password.equals(teacher.getPassword())) {//�ж������Ƿ���ͬ
				return true;
			}else{
				return false;
			}
		}
	}
}
