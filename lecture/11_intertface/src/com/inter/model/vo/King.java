package com.inter.model.vo;

import com.inter.common.MakeBugger;

public class King extends Bugger implements MakeBugger{
	// �������̽� MakeBugger�� implements �Ǿ����� 
	// �ű⿡ �ִ� �߻�޼ҵ带 �ݵ��
	// Override�ؾ���.
	// Ư������� �ʿ��Ҷ� �������̽��� �Ἥ
	// ������Ŵ.
	
	public King(String name, int price, int size) {
		super(name, price, size);
	}
	
	public void makeKingBugger() {
		System.out.println("����ŷ : " +super.getName()+"�� "+
				super.getPrice()+"�Դϴ�.");	}
	
	@Override
	public void makeBugger() {
		makeKingBugger();
	}
	
	@Override
	public void infoBugger() {
		
	}
}
