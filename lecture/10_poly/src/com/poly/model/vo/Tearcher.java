package com.poly.model.vo;

public class Tearcher extends Person{
	private String subject;
	private String major;
	
	public Tearcher() {
		// TODO Auto-generated constructor stub
	}
	
	public Tearcher(String subject, String major) {
		// TODO Auto-generated constructor stub
	}
	
	public Tearcher(String name, int age, String address, String subject, String major) {
//		super(name, age, address);
		this.subject = subject;
		this.major = major;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	
}
