package com.obj.main;

import com.obj.controller.Person;

public class Run3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person ps = new Person();
		
		Person ps1 = new Person();
		ps1.saveInfo("유병승", 19, "경기도 시흥", 180.5, 65.5);
		ps.printInfo();
		
		
		// private으로 선언된 필드(멤버변수)에 접근 할 수 있게 메소드를 추가.
		// setter() -> 값을 필드에 넣어주는 메소드, getter() -> 값을 가져오는 메소드.
		ps.setAge(12);
		System.out.println( ps.getAge() );
		
		// ps 객체에 age 값을 넣기.
		// p.age = 20;
		ps.setAge(-29);
		System.out.println( ps.getAge() );
		
		// 생성되어있는  Person ps를 반장으로~
		ps.setName("김상현");
		ps.setAge(19);
		ps.setAddress("서울 구로");
		ps.setKi(192.3);
		ps.setMommuge(63.1);
		
		System.out.println(ps.getAddress()+ ps.getAge()+ ps.getKi()+ ps.getMommuge()+ ps.getName());
	}

}
