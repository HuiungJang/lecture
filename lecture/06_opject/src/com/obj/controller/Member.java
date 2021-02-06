package com.obj.controller;

import java.util.Scanner;

public class Member {
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public void inserMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("id : ");
		String id = sc.next();
		
		System.out.println("pw : ");
		String pw = sc.next();
		
		System.out.println("name : ");
		String name = sc.next();
		
		System.out.println("email : ");
		String email = sc.next();
		
		System.out.println("address : ");
		String address = sc.next();
		
		System.out.println("id : "+id +" pw : "+pw +" name : "+name +
						" email : "+email+ " address : "+address );
	}
}
