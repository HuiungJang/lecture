package com.poly.model.vo;

public class Dog extends Animal{
 
	
	public Dog(String name, String category, int age, int leg) {
		super(name, category, age, leg);
		// TODO Auto-generated constructor stub
	}
	
	public void dogBark(Object obj) {
		System.out.println("�������� �пп�");
		System.out.println("�̸�: "+getName()+" �� : "+getCategory()
		+" ����: "+getAge()+ " �ٸ����� : "+getLeg());
	}

	public String dogB() {
		return " �������� �߿˾߿� ";	
	}
	
	@Override
	public String bark() {
		return dogB();
	}

	@Override
	public String toString() {
		return "Dog [getName()=" + getName() + ", getCategory()=" + getCategory() + ", getAge()=" + getAge()
				+ ", getLeg()=" + getLeg() + "]";
	}
	
	
}
