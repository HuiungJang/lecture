package com.obj.controller;

public class Student { //Student Class 생성.
		
	public String name;
	public int age;
	public int grade;
	public int group;
	public String address;
	public double height;
	// 이름 중복 안됨.
	
	
//	{
//		name = "장희웅";
//		age = 27;
//		grade = 4;
//		group = 5;
//		address = "서울시 종로구";
//		height = 168.0;
//	}
	
	// 생성자 추가하기.
	// 접근제한자 클래스명() { 로직(필드를 초기화) }
	// public을 보통 사용

	public Student() {
		// 필드 초기화함.
		// 제일 마지막에 적용됨.
		name = "박유현";
		age = 27;
		grade = 1;
		group = 10;
		address = "이천";
		height = 200.2;
		
		System.out.println("기본 생성자 실행. ");
	} // 기본 생성자. -> default 값으로 설정됨.
	
	// 매개변수가 있는 생성자
	public Student(String name, int age, int grade, int group, String address
					,double height) { // 외부에서 받아오는 값.-> 생성하는 객체마다 값을 다르게 할 수 있음.
//		name = name; // 위 필드에도 매개변수에도 name가 있어서 중복됨. 생성자 안에 있는 것이 우선됨.		
		this.name = name; // this -> 생성되는 객체에 있는. (주소를 새로배정받음)
//		age = age1; // 통상적으로 이름을 필드와 매개변수를 같게 함.
		this.age = age;
		this.grade = grade;
		this.group = group;
		this.address = address;
		this.height = height;
		
	}
	
	
	public Student(String name, int age, String address, double height) {
		// 위와 ()에 들어있는 생성자와 이름은 같지만 매개변수가 다르기 때문에 다른 생성자.
		// 메소드형 코드에서 이름이 같은것을 오버로딩(overloading)이라고함.
		// 장점 . 같은 이름으로 여러개 사용가능함.
		// 모든 변수의 이름을 다 외우지 않아도 됨.
		// 다른 생성자 호출
		//this(); // default 생성자 호출.
		this("신충현",24 ,13 ,4 , "안산" ,132.3); // 나를 제외한 나머지를 호출해야함.

		this.name = name;
		this.age = age;
		this.address =address;
		this.height = height;
	}
	
}