package com.sherwin.learners.service;

import java.util.List;

import com.sherwin.learners.bean.Student;
import com.sherwin.learners.dao.StudentsDao;


public class StudentService {
	StudentsDao student = new StudentsDao();
	
	public List<Student> StudentList() {
		return student.getStudentList();
	}
	
	public boolean deleteStudent(int id) {
		return student.deleteStudent(id);
	}
	
	public boolean addStudent( String firstName, String lastName) {
		return student.addStudent(firstName, lastName);
	}
}
