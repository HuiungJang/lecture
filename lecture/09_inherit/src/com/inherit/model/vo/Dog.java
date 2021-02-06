package com.inherit.model.vo;

public class Dog extends Animal{
	
	public Dog(String name, int age, String category) {
		super(name, age, category);
	}
	
	@Override
	public String bark() {
		return "울음소리 멍!";
	}
}
