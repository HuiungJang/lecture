package com.obj.controller;

public class BasicObjTest { // 클래스 선언부 public -> 접근제한자. 
	// 1.필드 (멤버변수) -> 데이터 저장. 생략가능.
	// 2.생성자 -> 클래스를 인스턴스화 시킬때 실행하는것, 객체로 생성할때 사용.'생략불가능'
	//	   	       -> 자동생성됨 꼭필요하니까.
	// 3.메소드 -> 기능을 구현해놓음. 생략가능.
	
	
//	DefaultTest d = new DefaultTest(); // default접근제한자를 사용한 클래스는 같은 패키지에서만 사용가능한 클래스다.
	public void fieldTest() {
		FieldTest fieldTest = new FieldTest();
		System.out.println(fieldTest.name); // default 접근제한자 사용 -> 같은 패키지 내에서는 사용가능.
		System.out.println(fieldTest.age); // public 접근제한자 사용 -> 어디서나 사용가능.
//		System.out.println(fieldTest.email); // private 접근제한자 사용 -> 같은 클래스내에서만 사용가능.
	}
}
