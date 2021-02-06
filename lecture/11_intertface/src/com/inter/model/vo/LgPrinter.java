package com.inter.model.vo;

import com.inter.common.PrintDriver;

public class LgPrinter implements PrintDriver{
	public void lgPrint() {
		System.out.println("LG프린터 인쇄중!");
	}
	
	@Override
	public void print() {
		lgPrint();
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
