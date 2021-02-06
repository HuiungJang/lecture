package com.vari.dataover;

public class DataOverflow {
	public static void main(String args[]) {
		//데이터 오버플로우 확인하기.
		byte bnum = 125;
		//int bnum = 125;
		//bnum++; -> bnum 변수의 값을 1 증가시키는 연산자.
		System.out.println(++bnum); //126
		System.out.println(++bnum); //127
		System.out.println(++bnum); //128 -> -128
		System.out.println(++bnum); //129 -> -127
		//byte -> 127 넘는값은 표현 불가. maximum 127
		
		for(int i = 0; i<150; i++) {
			System.out.println(++bnum);
		}
	}
}
