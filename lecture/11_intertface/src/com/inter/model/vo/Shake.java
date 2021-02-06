package com.inter.model.vo;

public class Shake extends Bugger {
	
	public Shake(String name, int price, int size) {
		super(name, price, size);
	}
	
	public void makeShake() {
		System.out.println("½§½§¹ö°Å : " +super.getName()+"Àº "+
				super.getPrice()+"ÀÔ´Ï´Ù.");
	}
	
}
