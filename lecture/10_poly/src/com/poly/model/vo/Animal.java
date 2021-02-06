package com.poly.model.vo;

public abstract class Animal {
	private String name;
	private String category;
	private int age;
	private int leg;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
	public Animal(String name, String category, int age, int leg) {
		super();
		this.name = name;
		this.category = category;
		this.age = age;
		this.leg = leg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLeg() {
		return leg;
	}

	public void setLeg(int leg) {
		this.leg = leg;
	}
	
	
	// 자식객체에서 구현해서 써야하는 메소드. -> 추상메소드
	// 상속 받는 즉시 구현해야함.
//	public String bark() {
//		return "동물 울음소리";
//	}
	public abstract String bark();
	// 추상메소드 선언
	
	
	public String toString() {
		return name+" "+category+" "+age+" "+leg;
	}
	
}
