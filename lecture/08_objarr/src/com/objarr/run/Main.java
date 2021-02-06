package com.objarr.run;

import java.util.Scanner;

import com.objarr.model.vo.Car;
import com.objarr.model.vo.Person;

public class Main {
	public static void main(String[] args) {
		// 
		
//		Car c; 
//		Car c2;
//		Car c3; -> 
		
		Car[] cas; 
		cas = new Car[4]; 
		cas[0] = new Car();
		cas[1] = new Car("","",100,"",4);
		cas[2] = new Car("","",1,"",4);
		cas[3] = new Car("","",1,"",4);
		
		System.out.println(cas[1]);
		
		System.out.println(cas[1].getModelName());
	
		
		System.out.println(cas[2].getModelName());
		System.out.println(cas[3].getModelName());
		// NullPointerException
		
		cas[0].setModelName("");
		
		
		for(int i = 0; i<cas.length; i++) {
			System.out.println( cas[i].getModelName() );
		}
		
		
		Person[] arr = new Person[5];
		Scanner sc = new Scanner(System.in);
		
		
		
//		for(int i = 0; i<arr.length; i++) {
//			
//			arr[i].setName( sc.nextLine() );
//			arr[i].setAge( sc.nextInt() );
//			sc.nextLine();
//			arr[i].setGender( sc.nextLine() );
//			arr[i].setNumber( sc.nextLine() );
//			
//		}
//		
		arr[0] = new Person("유병승", 19, "남", "01023010211");
		arr[1] = new Person("김상현", 12, "남", "01020302022");
		arr[2] = new Person("김태희", 23, "남", "01010202030");
		arr[3] = new Person("김예진", 12, "여", "01010202010");
		arr[4] = new Person("", 0, "", "");

		for(int i = 0; i<arr.length; i++) {
			// arr[i] = new Person(); 객체배열 할당.
			System.out.println("====="+(i+1)+"번째 사람의 정보를 입력해주세요.=====");
			System.out.print("이름을 입력해주세요 : ");
			arr[i].setName( sc.nextLine() );
			
			System.out.print("나이를 입력해주세요 : ");
			arr[i].setAge( sc.nextInt() );
			sc.nextLine();
			
			System.out.print("성별을 입력해주세요 : ");
			arr[i].setGender( sc.nextLine() );
			
			System.out.print("전화번호를 입력해주세요 : ");
			arr[i].setNumber( sc.nextLine() );
			
		}
		
		//전체를 출력해보세요
//		for(int i =0; i<arr.length; i++) {
//			System.out.print(arr[i].getName());
//			System.out.print(arr[i].getAge());
//			System.out.print(arr[i].getGender());
//			System.out.print(arr[i].getNumber()+"\n");
//			
//		}
		
		
		for(int i = 0; i<arr.length; i++) {
//			System.out.println( arr[i].getName() );
//			System.out.print(arr[i].getAge());
//			System.out.print(arr[i].getGender());
//			System.out.print(arr[i].getNumber()+"\n");
			
			System.out.println(arr[i]);
		}		
		
	}
}
