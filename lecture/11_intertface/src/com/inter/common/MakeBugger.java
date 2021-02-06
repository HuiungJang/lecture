package com.inter.common;

public interface MakeBugger {
	
	// 버거 생성하는 기능을 강제하는 인터페이스.
	// 인터페이스는 멤버변수 선언이 불가능함.
//	private int count; // 불가능.
	
	public static final int COUNT  = 100;
	// 상수만 가능하다.
	String TITLE = "버거만들기";
	// String 앞에 public static final이 생략되어있음
	// 인터페이스는 생성이 불가능함.
	
	
	// 인터페이스 내부에는 추상메소드만 선언이 가능함. 
//	public void makeBugger() {
//		System.out.println("버거만들기 ");
//	}
	public abstract void makeBugger();
	
	void infoBugger();
	// public abstract 접근제한자 예약어가 반드시 포함되어있고
	// 자동으로 앞에 붙여줌.
}
