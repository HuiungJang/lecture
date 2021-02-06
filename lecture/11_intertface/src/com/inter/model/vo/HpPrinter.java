package com.inter.model.vo;

import com.inter.common.PrintDriver;

public class HpPrinter implements PrintDriver{
	
	public void printHp() {
		System.out.println("HP프린터 인쇄중!");
	}
	
	@Override
	public void print() {
		printHp();
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
