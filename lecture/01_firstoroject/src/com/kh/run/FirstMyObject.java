package com.kh.run;

import java.util.ArrayList;
// 외부에(다른 패키지에) 있는 클래스를 가져와 사용할 때 쓰는 것. -> import
import java.util.Date; // 날짜를 표시해주는 클래스 

public class FirstMyObject {
	// 자바프로젝트가 실행이 되려면
	// 반드시 한개의 public static void main(String[] args) 메소드가 존재해야함
			
	public static void main(String[] args) {
		//프로젝트 실행시키면 main() 메소드를 찾아서 실행한다.
		System.out.println("안녕 Rclass 자바 화이팅!");
		
		//외부 클래스 이용해서 날짜 출력하기
		System.out.println(new Date());
	}

}
/*

드래그 cmd+/ =>드래그한 부분 전체 주석

import > 외부에 있는 클래스를 불러와서 사용한다.

*/