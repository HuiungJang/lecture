package com.inter.model.vo;

import com.inter.common.PrintDriver;

public class SamsungPrinter implements PrintDriver{
	public void samPrint() {
		System.out.println("ªÔº∫«¡∏∞∆Æ ¿Œº‚¡ﬂ!");
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
