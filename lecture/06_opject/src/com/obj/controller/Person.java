package com.obj.controller;

public class Person {
	private String name;
	private int age;
	private String address;
	private double ki;
	private double mommuge;
	
	{
		name ="";
		age=0;
		address="";
		ki=0.0;
		mommuge=0.0;	
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveInfo(String name,int age, String address, double ki
						,double mommuge) {
		
		this.name = name;
		this.age = age;
		this.address = address;
		this.ki =ki ;
		this.mommuge =mommuge;
		
	}
	
	public void printInfo() {
	
		System.out.println( name + age + address + ki + mommuge);
	}
	
	public void setAge(int age) {
		// 조건문을 통해서 필터
		if(age<0) {
			System.out.println("나이는 음수가 될 수 없습니다.");
		}else
			this.age =age;
		
	} // age에 값을 저장
	public int getAge() {
		return this.age;
	} // age 값을 가져올 수 있음.

	
	public void setName(String name) {
		this.name =name;
	}
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address =address;
	}
	public String getAddress() {
		return address;
	}
	
	
	public void setKi(double ki) {
		this.ki =ki;
	}
	public double getKi() {
		return ki;
	}
	
	
	public void setMommuge(double mommuge) {
		this.mommuge = mommuge;
	}
	public double getMommuge() {
		return mommuge;
	}
	
}
