package com.obj.main;

import java.util.Scanner;

import com.obj.controller.Member;
import com.obj.controller.Practice;

public class PracticeRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Practice pr = new Practice();
//		String result = pr.strChain("여러분", "할수있다!");
//		System.out.println(result);
//		// 문자열 결합하고 리턴.
//		
//		int sum = pr.numSum(6,5);
//		System.out.println(sum);
//		// 숫자 두개 입력받고 첫번째 수부터 두번째 수까지 합 출력.
//		
//		boolean verifyEng = pr.verifyEng('1');
//		System.out.println(verifyEng);
//		if(pr.verifyEng('1')) {
//			System.out.println("영문자 맞네요");
//		}else
//			System.out.println("영문자아니네요");
//		// 영문자인지 확인.
//		
		Scanner sc = new Scanner(System.in);
//		System.out.println("문자입력 : ");
//		String str1 = sc.nextLine();
//		
//		System.out.println("문자입력 : ");
//		String str2 = sc.nextLine();
//		
//		System.out.println( pr.strEqual(str1, str2)? "같다" : "아니다");
		// 문자열이 같은지 확인.
		
		// 로그인 처리 메소드 구현하기.
		// id와 pw가 일치하면 로그인 성공 아니면 실패 
		System.out.println("id입력 : ");
		String id = sc.nextLine();
		
		System.out.println("pw입력 : ");
		String pw = sc.nextLine();	
		
		System.out.println( pr.login(id, pw)? "로그인 성공" : "로그인 실패");
		
//		Member member = new Member();
//		member.inserMember();
	}

}
