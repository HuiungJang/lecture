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
		arr[0] = new Person("������", 19, "��", "01023010211");
		arr[1] = new Person("�����", 12, "��", "01020302022");
		arr[2] = new Person("������", 23, "��", "01010202030");
		arr[3] = new Person("�迹��", 12, "��", "01010202010");
		arr[4] = new Person("", 0, "", "");

		for(int i = 0; i<arr.length; i++) {
			// arr[i] = new Person(); ��ü�迭 �Ҵ�.
			System.out.println("====="+(i+1)+"��° ����� ������ �Է����ּ���.=====");
			System.out.print("�̸��� �Է����ּ��� : ");
			arr[i].setName( sc.nextLine() );
			
			System.out.print("���̸� �Է����ּ��� : ");
			arr[i].setAge( sc.nextInt() );
			sc.nextLine();
			
			System.out.print("������ �Է����ּ��� : ");
			arr[i].setGender( sc.nextLine() );
			
			System.out.print("��ȭ��ȣ�� �Է����ּ��� : ");
			arr[i].setNumber( sc.nextLine() );
			
		}
		
		//��ü�� ����غ�����
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
