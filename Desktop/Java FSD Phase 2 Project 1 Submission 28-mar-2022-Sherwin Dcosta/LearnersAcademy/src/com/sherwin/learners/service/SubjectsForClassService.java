package com.sherwin.learners.service;

import java.util.List;

import com.sherwin.learners.bean.SubjectClassBean;
import com.sherwin.learners.dao.AllocateSubjectsForClassDao;

public class SubjectsForClassService {
	AllocateSubjectsForClassDao dao = new AllocateSubjectsForClassDao();
	public List<SubjectClassBean> getDetails(String className){
		return dao.getDetails(className);
	}
	
	public boolean addSubjects(SubjectClassBean beanFromUser) {
		return dao.addSubjects(beanFromUser);
	}
}
