package com.inherit.model.vo;

// public final class Person { 
//final �ۼ��� ����� �Ұ�����.
public class Person {

	private String name;
	private int age;
	private String gender;
	protected String email;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// �θ� �޼ҵ� ���� -> ��ü������ ����ϴ� �޼ҵ�
	public void print() {
		System.out.println(name +" "+age+" "+ gender+" "+email);
	}
	
	
}
