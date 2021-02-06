package com.objparam.model.vo;

public class Lunch {
	
	private String name;
	private int price;
	private int capacity;
	private String category;
	
	
	public Lunch() {
		// TODO Auto-generated constructor stub
	}
	
	public Lunch(String category, String name, int price, int capacity) {
		this.capacity = capacity;
		this.category = category;
		this.name = name;
		this.price = price;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
