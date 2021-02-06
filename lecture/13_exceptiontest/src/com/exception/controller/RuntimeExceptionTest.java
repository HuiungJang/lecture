package com.exception.controller;

import java.util.Scanner;

import com.exception.common.MyException;

public class RuntimeExceptionTest {
	public static void main(String[] args) {
		// ArithmeticException : 수학적으로 계산이 불가능한 경우에 발생
		Scanner sc =new Scanner(System.in);
		
		System.out.println("수 : ");
		int su = sc.nextInt();
		
		System.out.println("수 : ");
		int su1 = sc.nextInt();
		
		try{
		System.out.println(su/su1);
		}catch(ArithmeticException e) {
			// Exception 나면 e에 저장.
			System.out.println(e.getMessage());
			// Exception에 대한 메세지.
			e.printStackTrace();
			// 메소드가 실행된 순서.
			// 모든 Exception 발생지점을 확인할수있는 출력구문.
			
			System.out.println("숫자에 0이 있습니다. ");
		}
		// 0으로 나누면 발생 
		
		// NegativeArraySizeExcption : 배열길이 음수
		// int[] arrInt = new int [-10];
		// ArrayIndexOutOfBounds : 접근한 인덱스가 배열의 길이를 초과했을때.
		String[] names = new String[2];
		try {
			names[3] = "11";
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위를 초과했습니다.");
			String[] tmp = new String[names.length+10];
			System.arraycopy(names, 0, tmp, 0, names.length);
			names = tmp;
			names[3] = "11";
		}
		System.out.println("??");
		System.out.println(names[3]);
		
		// ClassCasException 클래스 형변환시 에러
		Object obj = new String("hi");
		//Scanner s2 = (Scanner)obj;
		
		// chcekedException : 반드시 예외처리 해야하는 것
		// FileReader fr = new FileReader("test.txt");
		
//		new ExceptionHandle().testException();
		new ExceptionHandle().tryCatchTest();
		new ExceptionHandle().fileLoad();
		
		try {
			new ExceptionHandle().myExceptionUse();
		}catch(MyException e) {
			e.printStackTrace();
		}
		
	}
}
