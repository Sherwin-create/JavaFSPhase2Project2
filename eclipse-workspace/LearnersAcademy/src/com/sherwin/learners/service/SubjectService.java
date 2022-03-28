package com.sherwin.learners.service;

import java.util.List;

import com.sherwin.learners.bean.Subject;
import com.sherwin.learners.dao.SubjectDao;

public class SubjectService {
	SubjectDao dao = new SubjectDao();
	public List<Subject> getSubjectList() {
		return dao.getSubjectList();
	}
	
	public boolean addSubject(String subjectName) {
		return dao.addSubjects(subjectName);

	}
	
	public boolean deleteSubject(int id) {
		return dao.deleteSubject(id);
	}
}
