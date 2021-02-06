package com.inherit.model.vo;

public class Animal {
	private String name;
	private int age;
	private String category;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String name, int age, String category) {
		super();
		this.name = name;
		this.age = age;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String bark() {
		return "울음소리 왘!";
	}
	
	
}
