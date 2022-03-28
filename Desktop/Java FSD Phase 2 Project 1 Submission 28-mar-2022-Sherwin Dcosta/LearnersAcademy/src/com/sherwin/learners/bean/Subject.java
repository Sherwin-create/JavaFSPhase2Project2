package com.sherwin.learners.bean;

public class Subject {
	private String name;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject () {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + "]";
	}
}
