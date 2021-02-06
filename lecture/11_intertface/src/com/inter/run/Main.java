package com.inter.run;

import com.inter.common.MakeBugger;
import com.inter.common.PrintDriver;
import com.inter.common.PrintDriverObj;
import com.inter.controller.PrinterController;
import com.inter.model.vo.Bugger;
import com.inter.model.vo.CannonPrinter;
import com.inter.model.vo.King;
import com.inter.model.vo.Mac;
import com.inter.model.vo.Shake;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bugger[] bugger = new Bugger[4];
		
		bugger[0] = new Shake("�ӽ������",8000,1);
		bugger[1] = new Mac("���",7000,1);
		bugger[2] = new King("����",8500,3);
		
		// �������̽��� Ÿ������ ��밡��.
		// �������ε�.
		// MakeBugger���� makerBugger()�̶��
		// �߻�޼ҵ带 ������� 
		// King Ŭ�������� makeBugger�� Override������
		// �θ�ü�� �ڽİ�ü �޼ҵ� ������ϴ� �Ͱ� ����.
		
		MakeBugger maker = new King("����",8500,3);
		maker.makeBugger();
		// �������̽��� ������ �ִ� �޼ҵ常 ��밡���ϰ�
		// �ٸ� �޼ҵ�� �Ұ���.
		
		MakeBugger[] makerArr = new King[3];
		// new MakeBuger() <-> new MakerBugger[3];
		// ���ڴ� ��ü�� �����ϴ°�
		// ���ڴ� ���� �������ִ� ������ 3�� �����ϴ°�.
		// �������̽��� implements�� �͸� ����.
		
		
//		
//		makerArr[0] = new King("����1",8500,3);
//		makerArr[1] = new Mac("���2",8500,3);
//		makerArr[2] = new King("����3",8500,3);
		
		
		
		// �����ͱ�
		new PrinterController(new CannonPrinter()).print();
		
		MakeBugger maker1  =new CannonPrinter();
		PrintDriver pd = new CannonPrinter();
		PrintDriverObj po = new CannonPrinter();
		// CannonPrinter�� ��� 1�� implements 2�� �س��� ����.
		
		
	}

}
