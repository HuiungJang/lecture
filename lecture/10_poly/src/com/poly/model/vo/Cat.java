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
		System.out.println("����̴� �߿˾߿�");
		System.out.println("�̸�: "+getName()+" �� : "+getCategory()
							+" ����: "+getAge()+ " �ٸ����� : "+getLeg());
	}
	
	public String catB() {
		return " ����̴� �߿˾߿� ";
	}
	
	@Override
	public String bark() {
		return catB();
	}
}
