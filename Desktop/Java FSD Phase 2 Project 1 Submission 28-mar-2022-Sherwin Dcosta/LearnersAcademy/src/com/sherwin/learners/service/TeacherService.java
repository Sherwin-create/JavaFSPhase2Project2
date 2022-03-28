package com.sherwin.learners.service;

import java.util.List;

import com.sherwin.learners.bean.Teacher;
import com.sherwin.learners.dao.TeacherDao;

public class TeacherService {
	TeacherDao dao = new TeacherDao();
	public List<Teacher> getTeacherList(){
		return dao.getTeacherList();
	}
	
	public boolean addTeacher(String firstName,String lastName) {
		return dao.addTeacher(firstName, lastName);
	}
	
	public boolean deleteTeacher(int id) {
		return dao.deleteTeacher(id);
	}
}
