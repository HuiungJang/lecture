package com.poly.model.vo;

public class Monkey extends Animal {

	public Monkey(String name, String category, int age, int leg) {
		super(name, category, age, leg);
		// TODO Auto-generated constructor stub
	}
	
	public void monkeyBark(Object obj) {
		System.out.println("원숭이는 키키킥");
		System.out.println("이름: "+getName()+" 종 : "+getCategory()
		+" 나이: "+getAge()+ " 다리개수 : "+getLeg());
	}
	
	@Override
	public String bark() {
		return "욲끼끼끼끼끽";
	}
	
}
