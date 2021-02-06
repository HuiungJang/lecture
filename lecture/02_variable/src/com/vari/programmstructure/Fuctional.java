package com.vari.programmstructure;
//기능 제공형 클래스 -> 기능을 가지고 있음.
import java.util.Scanner;
public class Fuctional {

	public void inputData(){
		System.out.println("====회원정보====");
		Scanner sc = new Scanner(System.in);
		System.out.print("회원아이디 : ");
		String userId = sc.nextLine();
		
		System.out.print("회원 패스워드 : ");
		String password = sc.nextLine();
		
		System.out.print("회원나이 : ");
		int age =sc.nextInt();
		
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		
		System.out.print(userId + password + age + gender);
		
	}
}
