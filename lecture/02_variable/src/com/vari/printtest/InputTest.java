package com.vari.printtest;

import java.util.Scanner;


public class InputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 키보드에서 입력한 값 가져오기.
		// 키보드에 입력한 값을 RAM에 저장하기.
		// 자바에서 제공하는 Scanner 클래스를 이용한다.
		// java.util 패키지에 속해있음.
		// 1. java.util.Scanner를 import한다.
		// 2. 클래스를 사용하려면 반드시 '생성'해야한다. 'new' 연산자를 사용.
		// 생성 : new 클래스명(); ex)new Scanner(); 		
		Scanner sc = new Scanner(System.in);
		
		// 3. Scanner가 제공하는 기능(메소드)을 이용해서 키보드의 입력값을 가져온다.
		// nextInt(), nextDouble(), nextLine(), next(), nextFloat()
		// nextInt(); -> int Type의 값을 가져옴.
		// nextDouble(); -> double Type의 값을 가져옴.
		// next(); : 문자열을 가져오는 기능. 띄어쓰기 기준으로 가져옴.(띄어쓰기 앞까지 가져옴)
		// nextLine(); : 문자열을 가져오는 기능. (개행(줄바꿈)앞의 문자열을 가져옴)
//		System.out.print("당신의 나이는 ? ");
//		int age = sc.nextInt();// 정수 입력 받을 때.
//		System.out.print("당신의 키는?");
//		double height = sc.nextDouble();// 실수 입력 받을 때.
//		System.out.println("나이 : " + age);
//		System.out.println("키 : " + height);
		
		
		//문자열 입력받기.
		//System.out.print("당신의 이름은? ");
		//String name = sc.next();
//		System.out.print("당신의 주소는? ");
//		String name = sc.next();
//		sc.nextLine();
//		System.out.println("next() : " + name);
//		System.out.println("당신의 주소 ? : ");
//		name= sc.nextLine();
		//String adress = sc.nextLine();
		//System.out.println("입력받은 이름은 : " + name);
		//System.out.println("입력받은 주소는 : " + adress);
//		System.out.println("nextLine() :"+ name);
		
		// 정수, 실수, 문자(next())를 입력받고 nextLine()을 입력받을 경우.
		// 반드시 buffer를 비워줘야함.
		System.out.println("age?");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("adress?");
		String address = sc.nextLine(); 
		//-> nextInt 나 next등을 사용하고 nextLine 사용하면 그냥 넘어가버림.
		// 그래서 반드시 버퍼를 비워야함 
		// 비우는 방법 sc.nextLine(); 한번 적기.
		//String address = sc.next();
		System.out.println("age: " + age + "\nadress : " + address);
		
		sc.close();
		
	}

}
