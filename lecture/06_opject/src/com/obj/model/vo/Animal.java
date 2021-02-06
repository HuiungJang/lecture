package com.obj.model.vo;

public class Animal {
	private String jong;
	private String name;
	private int age;
	private int leg;
	private static int tmp; // static 변수
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
	public void dong(String jong, String name, int age, int leg) {
		this.jong = jong;
		this.name = name;
		this.age = age;
		this.leg = leg;
	}
	
	public void printDong() {
		System.out.println(jong + name + age + leg);
	}
	
	
	public void setJong(String jong) {
		this.jong = jong;
	}
	public String getJong() {
		return jong;
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

	
	
	public int getLeg() {
		return leg;
	}
	public void setLeg(int leg) {
		this.leg = leg;
	}
	
	public static int getTmp() {
		return tmp;
	}
	public static void setTmp(int tmp) {
	//	this.tmp = tmp; // staic 은 this로 접근안함.
		Animal.tmp = tmp;
	}
	
}
