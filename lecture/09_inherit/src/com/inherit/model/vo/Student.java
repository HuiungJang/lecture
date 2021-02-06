package com.inherit.model.vo;

import java.util.Objects;

public class Student extends Person{

//	private String name;
//	private int age;
//	private String gender;
	private int grade;
	private int group;
	private int number;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int age, String gender,
					int grade, int group, int number) {
		
		// 자식생성자에서 부모생성자를 호출 할 수 있다.
		// 생성된부모클래스를 지칭하는 예약어 -> super();
		// this()
		//super(); // 부모의 디폴트 생성자를 호출.
		super(name, age, gender);
//		this.name =name;
//		this.age =age;
//		this.gender =gender;
		
		this.grade = grade;
		this.group = group;
		this.number =number;
	}
	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() { // Object에서 가져온 Override
		//	객체의 정보를 출력할때 사용 
		return getName()+grade + " " + group +" "+ number+" "+email;
		// 상속을 받았어도 부모클래스에서 private로 접근제한자로 제한한 멤버변수는 직접접근x.
		// getter, setter 사용해서 수정해야한다.
		// 부모클래스와 중복되는 메소드명이 아닐때 가능.
		// email은 protected라서 private와 다르게
		// 후손클래스에서 직접접근이 가능하다.
	}
	
	// 객체의 정보를 출력하는 메소드 재정의하기.
	// Person.print(); 메소드 다시 정의해보자.
	
	@Override // 반드시 표기 
	public void print() { // 선언부는 부모메소드와 동일하게 작성함.
		System.out.println(super.getName()+ " "+super.getAge()
				+" "+super.getGender()+" "+grade+" "+group+" "+number);
		// super 사용한 이유는 부모클래스에서 가져온것이라는 것을 확실히 보여주기위해서
		// 없어도 상관은 없음.
	
	}
	
	// 객체의 동일성 비교하기 위해서는 
	// Object의 equals를 오버라이딩해서 구현한다.
	@Override
	public boolean equals(Object obj) {
		// 내가 만든 객체니까 -> 어떤 내용을 동일하다고 판단할지 결정
		if(obj instanceof Student) {
			// 객체 instanceof 클래스
			// 객체가 클래스로 형변환이 가능한지 확인하는 메소드 
			// 가능하면 true 불가능하면 false  반환함
			// 주로 부모객체인지 자식객체인지 확인하는데 사용한다.
			
			Student s =(Student)obj;
			if(super.getName().equals(s.getName()) ) {
				// 부모클래스에서 name을 가져오고
				// 비교할 객체의 name을 가져와서 
				// 같으면 true를 반환.
				return true;
			}
			
//			if(super.getName().equals(s.getName()) &&
//					grade == s.grade) {
//				// 부모클래스에서 name과 grade를 가져오고 
//				// 비교할 객체의 name과 grade를 가져와서 
//				// 같으면 true를 반환.
//				return true;
//			}
			
		}	
		return false;
	}
	
	
	
	
}
