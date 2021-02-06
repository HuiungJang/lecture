package com.obj.controller;

public class InitBlockTest {
	
	public String name;
	public int age;
	public double height;
	public final String email;
	// 이 위는 heap영역(필드)에 생성.
	
	public static String data;
	// static 영역에 String data 생성.
	
	
	// 초기화 블록 사용하기.
	// 객체를 생성할때마다 실행됨.
	{
		// 필드(멤버변수, heap영역에 생성.)의 초기값을 세팅;
		// 연산자 사용이 가능.
		System.out.println("초기화 블록실행");
		name = "rclass 수강생.";
		age = 19;
		height = 190.1;
		email = "jhw1345@gmail.com";
		
		// static 변수를 초기화 할 수 있나? -> 가능하다.
		// 어디서든 접근 가능하게 만든 영역(static)에 생성된 것이기 때문에.
		data = "aa";
		
	}
	
	// static 초기화 블록
	// static으로 선언된 변수를 초기화할 때 사용.
	static { // -> static 영역에서 찾는다.
		System.out.println("static 초기화블록"); // 프로그램 시작시 최초 1번실행.
		// name = "김상현"; // name -> heap영역에 생성된 인스턴스(필드에 생성됨).
		// static 필드만 가능.
		data = "코로나 없어져라.";
	
	
	}
	

	

}
