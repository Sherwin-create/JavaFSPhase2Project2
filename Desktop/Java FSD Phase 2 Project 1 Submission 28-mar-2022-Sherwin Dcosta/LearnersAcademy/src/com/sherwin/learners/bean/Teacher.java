package com.sherwin.learners.bean;

public class Teacher {
	private String firstName;
	private String lastName;
	private int id;
	private String className;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher() {}
	
	@Override
	public String toString() {
		return "Teacher [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className){
		this.className = className;
	}

}
