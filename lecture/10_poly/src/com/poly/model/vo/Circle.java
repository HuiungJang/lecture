package com.poly.model.vo;

public class Circle extends Shape {
	public double PI = Math.PI;
	private int radius;
	
	public Circle() {
		// TODO Auto-generated constructor stub
	}

	public Circle( int radius) {
		this.radius = radius;
	}
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String draw(int radius) {
		
		String circle = "������ : "+ radius+ 
				" ���� : "+(radius*radius*PI)+
				" �ѷ� : "+ (2*PI*radius);
		
		return circle;
	}
	
}
