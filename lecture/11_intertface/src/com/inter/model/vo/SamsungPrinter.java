package com.inter.model.vo;

import com.inter.common.PrintDriver;

public class SamsungPrinter implements PrintDriver{
	public void samPrint() {
		System.out.println("�Ｚ����Ʈ �μ���!");
	}
	
	@Override
	public void print() {
		samPrint();
	}
	
	@Override
	public void scan() {
		
	}

	@Override
	public void makeBugger() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void infoBugger() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
