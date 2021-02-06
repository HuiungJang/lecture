package com.inter.model.vo;

import com.inter.common.MakeBugger;

public class King extends Bugger implements MakeBugger{
	// 인터페이스 MakeBugger이 implements 되었으니 
	// 거기에 있는 추상메소드를 반드시
	// Override해야함.
	// 특정기능이 필요할때 인터페이스를 써서
	// 강제시킴.
	
	public King(String name, int price, int size) {
		super(name, price, size);
	}
	
	public void makeKingBugger() {
		System.out.println("버거킹 : " +super.getName()+"는 "+
				super.getPrice()+"입니다.");	}
	
	@Override
	public void makeBugger() {
		makeKingBugger();
	}
	
	@Override
	public void infoBugger() {
		
	}
}
