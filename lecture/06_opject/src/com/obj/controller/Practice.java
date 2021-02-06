package com.obj.controller;

import java.util.Scanner;

public class Practice {
// 기능제공클래스는 default 생성자를 반드시 만들필요는 없다.	
	
	
	public Practice() {
		// TODO Auto-generated constructor stub
	}
	
	public String strChain(String str, String str2) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("문자열 입력 : ");
//		String str1 = sc.nextLine();
//		
//		System.out.println("문자열 입력 : ");
//		String str2 = sc.nextLine();	
		
		
		
//		String result = str + str2;
//		return result;
		
		return str + str2;
		// 따로 체크할것이 없으면 이렇게 해도된다.
	}
	
	public int numSum(int num1, int num2) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 입력 : ");
//		int num1 = sc.nextInt();
//		
//		System.out.println("정수 입력 : ");
//		int num2 = sc.nextInt();
		
		int result =0;
		for(int i= num1; i< num2; i++) {
//			if(num1<num2) {
//				result = num1  + num2;	
//			}else {
//				System.out.println("계산할 수 없습니다.");
//				result = 0;
//			}

			result+=i;
			}
		
		if(num1> num2) {
			System.out.println("계산할수없습니다.");
			result = 0;
		}
	
		return result;
	}
	
	
	
	public boolean verifyEng(char munja) {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("글자가 영문자인지 확인하기 \n문자 하나 입력 : ");
//		char munja = sc.next().charAt(0);
//		if( (munja>='A' && munja<= 'Z') || (munja>= 'a'&& munja<='z') )
		if( (munja>=65 && munja<= 90) || (munja>= 97&& munja<=122) ) {
			return true;
		}else 
			return false;
		
	}
	
	public boolean strEqual(String str1, String str2) {
		return str1.equals(str2);
		//이렇게 해도 됨.
		
//		if(str1.equals(str2)) {
//			return true;
//		}else
//			return false;
//		
	}
	
//	final String id = "abcd";
//	final String pw = "a1234";
	
	public boolean login(String id, String pw) {
	// return this.id.equals(id) && this.pw.equals(pw);
		
		if(id.length()<4 || pw.length()<4) {
			return false; 	
			// return 나오면 그 순간 메소드가 종료됨
			// return은 메소드에 1개만 있을 수 있지만 조건에 들어가면 가능함.

		}
		System.out.println("이것도 실행되니? "); // 위 if문이 실행되면 여기부터는 실행안됨.
		return id.equals("admin") && pw.equals("1234");
	}
	
	public void returnTest(int su) {
		if(su <10) {
			return; 
			// 메소드를 멈추고 싶을때 retrun; 사용하면됨
		}
		
		System.out.println("void에서 retrun은?");
	}
	
}
