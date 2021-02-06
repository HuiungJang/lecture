package com.poly.model.vo;

public class Dog extends Animal{
 
	
	public Dog(String name, String category, int age, int leg) {
		super(name, category, age, leg);
		// TODO Auto-generated constructor stub
	}
	
	public void dogBark(Object obj) {
		System.out.println("°­¾ÆÁö´Â ¿Ð¿Ð¿Ð");
		System.out.println("ÀÌ¸§: "+getName()+" Á¾ : "+getCategory()
		+" ³ªÀÌ: "+getAge()+ " ´Ù¸®°³¼ö : "+getLeg());
	}

	public String dogB() {
		return " °­¾ÆÁö´Â ¾ß¿Ë¾ß¿Ë ";	
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
