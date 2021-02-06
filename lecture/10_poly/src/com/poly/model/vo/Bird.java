package com.poly.model.vo;

public class Bird extends Animal{
	public Bird() {
		// TODO Auto-generated constructor stub
	}
	
	public Bird(String category, String name, int age, int legs) {
		super(category, name, age, legs);
	}
	
	public String birdBark() {
		return "»õ´Â Â±Â±";
	}
	
	@Override
	public String bark() {
		return "";
	}
	
}
