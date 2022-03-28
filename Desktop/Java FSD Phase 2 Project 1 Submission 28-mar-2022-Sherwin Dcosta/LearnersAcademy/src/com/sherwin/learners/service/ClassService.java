package com.sherwin.learners.service;

import java.util.List;

import com.sherwin.learners.bean.ClassBean;
import com.sherwin.learners.dao.ClassDao;;

public class ClassService {
	ClassDao dao = new ClassDao();
	public List<ClassBean> getClassList(){
		return dao.getClassList();
	}
	
	public boolean addClass(String className) {
		return dao.addClass(className);
	}
	
	public boolean deleteClass(int id) {
		
		return dao.deleteClass(id);
	}
}
