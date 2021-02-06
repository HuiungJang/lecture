package com.inherit.model.vo;

public class Cat extends Animal{
	
	public Cat(String name, int age, String category) {
		super(name, age, category);

	}
	
	@Override
	public String bark() {
		return "匡澜家府 具克!";
	}
}
