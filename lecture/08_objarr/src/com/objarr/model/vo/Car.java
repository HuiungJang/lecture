package com.objarr.model.vo;

public class Car {
	private String modelName;
	private String brand;
	private int price;
	private String color;
	private int door;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Car(String modelName, String brand, int price, String color, int door) {
		
		this.modelName = modelName;
		this.brand = brand;
		this.price = price;
		this.color = color;
		this.door = door;
	}


	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName= modelName;
	}
	// 외부에서 값을 받아올때는 매개변수를 사용한다.
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	
}
