package com.obj.controller;

public class FieldTest {
	
	// 필드 선언하기
	// 접근제한자(public , protected, private, (default) )자료형 변수명;
	String name; // 접근제한자 안쓰면 기본값 default -> 같은 패키지에서만 사용가능. 
	public int age; // public-> 어디서나 사용가능.
	private String email; // private -> 이 클래스에서만 사용가능.
	
	
	// static 필드(멤버변수) 선언하기
	public static String nickName;
	private static double height;
	
	
	// final예약어 상수. 한개만 입력받고 유지.
	public final char ch ;
	
	// 필드(멤버변수) 초기화 블록, 생성자를 이용해서 초기화를 할 수 있음.
	{ // 초기화 블록.
		ch ='C';
	}
	
	
	
	public void test() {
		System.out.println(email);
		System.out.println(name);
		System.out.println(age);
	}
}
