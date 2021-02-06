package com.inter.model.vo;

import com.inter.common.MakeBugger;

public class Mac extends Bugger implements MakeBugger{
	
	public Mac(String name, int price, int size) {
		super(name, price, size);
	}
	
	@Override
	public void makeBugger() {
		System.out.println("맥도날드버거 : " +super.getName()+"은 "+
				super.getPrice()+"입니다.");	}
	
	@Override
	public void infoBugger() {
		
	}
}
