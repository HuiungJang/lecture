package com.poly.model.vo;

public class Monkey extends Animal {

	public Monkey(String name, String category, int age, int leg) {
		super(name, category, age, leg);
		// TODO Auto-generated constructor stub
	}
	
	public void monkeyBark(Object obj) {
		System.out.println("¿ø¼þÀÌ´Â Å°Å°Å±");
		System.out.println("ÀÌ¸§: "+getName()+" Á¾ : "+getCategory()
		+" ³ªÀÌ: "+getAge()+ " ´Ù¸®°³¼ö : "+getLeg());
	}
	
	@Override
	public String bark() {
		return "ŸH³¢³¢³¢³¢³£";
	}
	
}
