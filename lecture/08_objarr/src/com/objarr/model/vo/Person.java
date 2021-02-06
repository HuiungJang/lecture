package com.objarr.model.vo;

public class Person {
	private String name;
	private int age;
	private String gender;
	private String number;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, int age, String gender
						,String number) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.number = number;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name =name;
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

	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	public String toString() {
		return name+" "+age+" "+gender+" "+ number;
	}
	
	
	
}
