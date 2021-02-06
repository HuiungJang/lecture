package com.vari.casting;

public class CastingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자동 형변환 알아보기.
		//byte bnum = 200;
		byte bnum = 100; // 자동 형변환.
		System.out.println(bnum);
		
		long lnum = 10000;
		
		System.out.println(3.14+100);
		
		String msg = "dnd" + 19 + "year";
		
		double weight = 65.5; // 8byte
		int weightInt; // 4byte
		
		// 강제적 형변환 방법
		// 변수, 리터럴 앞(왼쪽)에 (변환할 자료형)변수형| 리터럴 
		weightInt = (int)weight;
		weightInt = (int)65.5; // 위 코드와 같다.
		// (double)weight = weight; <- 불가 변수는 형변환 불가능.
		System.out.println("변환한 값: " + weightInt);
		System.out.println("원본값 : " + weight);
		
		//데이터 손실상황
		int num = 290;
		bnum = (byte) num;
		System.out.println("원본값 : "+num);
		System.out.println("형변환값 : "+bnum);
		
		// 자동형변환 (정수형)의 특이점.
		// 기본적인 산술연산에 대한 값은 int형으로 처리가 됨.
		byte bnum1 = 100;
		byte bnum2 = 10;
		// byte result = bnum1+bnum2; 
		// byte , short 는 연산시 int로 처리함.
		byte result = (byte)(bnum1+bnum2);//강제 형변환.
		
		int num1 = 100;
		double dnum = 180.5;
		// int result1 = num1+dnum; 
		// -> double로 자동형변환되어 타입에러.
		int result1 = (int)(num1 + dnum);
		result1 = num1 + (int)dnum;
		
		//chat type에 대한 자료형 변환.
		// 유니코드 -> 숫자와 문자를 매핑시킨 코드.
		char ch = 'A'; 
		int alpha = ch; // 내부적으로 양수를 저장.
		System.out.println(alpha);
		System.out.println((char)alpha);
		char ch2 = (char)(ch+1); //66, char형은 산술연산이 가능.
		System.out.println(ch2); //B
	}

}