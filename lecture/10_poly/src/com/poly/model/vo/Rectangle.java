package com.poly.model.vo;

public class Rectangle extends Shape {
	private int width;
	private int height;
	
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	public String draw(int width, int height) {
		
		String rectangle = "가로 : "+ width + 
				" 세로 : "+height +
				" 넓이 : "+ width * height;
		
		
		return rectangle;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
