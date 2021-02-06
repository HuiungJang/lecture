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
		
		bugger[0] = new Shake("머쉬룸버거",8000,1);
		bugger[1] = new Mac("빅맥",7000,1);
		bugger[2] = new King("와퍼",8500,3);
		
		// 인터페이스도 타입으로 사용가능.
		// 동적바인딩.
		// MakeBugger에서 makerBugger()이라는
		// 추상메소드를 만들었고 
		// King 클래스에서 makeBugger을 Override했으니
		// 부모객체가 자식객체 메소드 실행못하는 것과 같다.
		
		MakeBugger maker = new King("와퍼",8500,3);
		maker.makeBugger();
		// 인터페이스가 가지고 있는 메소드만 사용가능하고
		// 다른 메소드는 불가능.
		
		MakeBugger[] makerArr = new King[3];
		// new MakeBuger() <-> new MakerBugger[3];
		// 전자는 객체를 생성하는거
		// 후자는 저걸 담을수있는 변수를 3개 생성하는거.
		// 인터페이스를 implements한 것만 가능.
		
		
//		
//		makerArr[0] = new King("와퍼1",8500,3);
//		makerArr[1] = new Mac("빅맥2",8500,3);
//		makerArr[2] = new King("와퍼3",8500,3);
		
		
		
		// 프린터기
		new PrinterController(new CannonPrinter()).print();
		
		MakeBugger maker1  =new CannonPrinter();
		PrintDriver pd = new CannonPrinter();
		PrintDriverObj po = new CannonPrinter();
		// CannonPrinter에 상속 1개 implements 2개 해놔서 가능.
		
		
	}

}
