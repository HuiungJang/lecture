package com.poly.model.vo;

public class Monkey extends Animal {

	public Monkey(String name, String category, int age, int leg) {
		super(name, category, age, leg);
		// TODO Auto-generated constructor stub
	}
	
	public void monkeyBark(Object obj) {
		System.out.println("�����̴� ŰŰű");
		System.out.println("�̸�: "+getName()+" �� : "+getCategory()
		+" ����: "+getAge()+ " �ٸ����� : "+getLeg());
	}
	
	@Override
	public String bark() {
		return "�H����������";
	}
	
}
