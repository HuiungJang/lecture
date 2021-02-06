package com.obj.controller;

import java.util.Scanner;

public class FunctionalTest {
	// 기능제공용 클래스.
	// 메소드만 가지고 있는 클래스.
	
	public FunctionalTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	// 계산기 기능을 추가.
	// 수 두개, 연산자, 결과.
	// 1.반환형(return)있고 매개변수 없는 메소드.
	// 반환형을 선언하면 필드에 반환값이 있어야함 중괄호안에
	// return <<<< 반드시 필요 
	// 반환형은 무조건 한개만 가능.
	// 같은 타입의 값을 여러개 리턴받아야한다면 배열사용 
	// 다른 타입의 값을 여러개 리턴받아야하면 class(객체) 사용
	
	public double cal1() {
		Scanner sc = new Scanner(System.in);
		// cmd + 쉬프트 + o 하면 필요한 패키지 알아서 import해줌.
		// 스캐너 클래스를 이용해서 객체sc 생성.
		// 매개변수 System.in 사용해서 Scanner 생성.
		
		System.out.print("정수입력 : ");
		// System 객체에 직접접근자 .을 이용해서
		// public static 멤버변수 out에 접근
		// printStream에 .을 이용해서 접근
		// print(); <- 메소드 실행
		
		int su = sc.nextInt();
		// sc객체의 멤버변수 nextInt()로 접근.
		// int su에 저장.
		System.out.print("정수입력 : ");
		int su2 = sc.nextInt();
		
		System.out.print("연산자 : ");
		char op = sc.next().charAt(0);
		
		double result = 0.0;
		// 지역변수는 메소드 안에서 반드시 초기화해야함.
		
		switch(op) {
			case '+' :
				result = su + su2;
				break;
				
			case '-' :
				result = su - su2;
				break;
				
			case '*' :
				result = su * su2;
				break;
				
			case '/' :
				result = (double)su / su2;
				break;
			
		}
		
		return result;
		// 자신을 호출한 곳으로 (return 값)을 보내주는놈.
	}
	
	// static 변수를 쓰면 
	// 멤버변수라고 안하고 static변수 혹은 class변수라고 한다.
	
	// 매개변수가 있고 반환형이 없는 메소드 구현하기.
	// 숫자 두개, 연산자, 계산결과
	public void  cal2(int su,int su2, char op) {
		// 이 메소드를 호출 할 때는 매개변수 형식에 맞춰서 호출해야함.
		// 외부에서 값을 입력받기때문에 따로 입력받는 기능을 구현할 필요가 없음.
		
		double result = 0.0;
		// 지역변수는 메소드 안에서 반드시 초기화해야함.
		switch(op) {
			case '+' :
				result = su + su2;
				break;
				
			case '-' :
				result = su - su2;
				break;
				
			case '*' :
				result = su * su2;
				break;
				
			case '/' :
				result = (double)su / su2;
				break;
			
		}
		
		System.out.println(result);
		// 반환형이 없기 때문에 반환형이 있는 코드와 다르게
		// 결과값을 같이 가짐.
	}
	
	public void cal3() {
		// 반환형이 없고 매개변수가 없는 메소드.
		Scanner sc = new Scanner(System.in);
		System.out.println("수 : ");
		int su = sc.nextInt();
		
		System.out.println("수 : ");
		int su2 =sc.nextInt();
		
		System.out.println("연산자 : ");
		char op = sc.next().charAt(0);
		// Scanner 클래스의 객체 sc가 next메소드를 호출해서 반환받고 
		// charAt 메소드 실행. 
		
		double result = 0.0;
		
		switch(op) {
		case '+' :
			result = su + su2;
			break;
			
		case '-' :
			result = su - su2;
			break;
			
		case '*' :
			result = su * su2;
			break;
			
		case '/' :
			result = (double)su / su2;
			break;
		
		}
		System.out.println(result);
	}
	public double cal4(int su, int su2, char op) {
		double result = 0.0;
		
		switch(op) {
			case '+' :
				result = su + su2;
				break;
				
			case '-' :
				result = su - su2;
				break;
				
			case '*' :
				result = su * su2;
				break;
				
			case '/' :
				result = (double)su / su2;
				break;
		}
		
		return result;
		
	}
}
