package com.inter.model.vo;

import com.inter.common.MakeBugger;

public class Mac extends Bugger implements MakeBugger{
	
	public Mac(String name, int price, int size) {
		super(name, price, size);
	}
	
	@Override
	public void makeBugger() {
		System.out.println("�Ƶ�������� : " +super.getName()+"�� "+
				super.getPrice()+"�Դϴ�.");	}
	
	@Override
	public void infoBugger() {
		
	}
}
