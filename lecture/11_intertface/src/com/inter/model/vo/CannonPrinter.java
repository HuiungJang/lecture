package com.inter.model.vo;

import com.inter.common.MakeBugger;
import com.inter.common.PrintDriver;
import com.inter.common.PrintDriverObj;

public class CannonPrinter  extends PrintDriverObj implements PrintDriver,MakeBugger{
//implements PrintDriver{
	
	@Override
	public void print() {
		System.out.println("ĳ������Ʈ �μ���");
	}

	@Override
	public void scan() {
		
	}
	
	@Override
	public void makeBugger() {
		
	}
	@Override
	public void infoBugger() {
		
	}
}
