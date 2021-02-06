package com.poly.model.vo;

public class Cat extends Animal {
	
	public Cat(String name, String category, int age, int leg) {
		super(name, category, age, leg);
		// TODO Auto-generated constructor stub
	}
	public Cat() {
		// TODO Auto-generated constructor stub
	}
		
	public void catBark(Object obj) {
		System.out.println("고양이는 야옹야옹");
		System.out.println("이름: "+getName()+" 종 : "+getCategory()
							+" 나이: "+getAge()+ " 다리개수 : "+getLeg());
	}
	
	public String catB() {
		return " 고양이는 야옹야옹 ";
	}
	
	@Override
	public String bark() {
		return catB();
	}
}
