package com.inter.controller;

import com.inter.common.PrintDriver;

public class PrinterController {

//	private HpPrinter print = new HpPrinter();
//	private LgPrinter print = new LgPrinter();
//	private SamsungPrinter print = new SamsungPrinter();
	
	private PrintDriver print;
	
	public PrinterController(PrintDriver print) {
		this.print = print;
	}
	
	public void print() {
		// 연결된 프린터기를 이용한 인쇄하는 기능
		//print.printHp();
		//print.lgPrint();
		print.print();
		print.test();
	}
	
}
