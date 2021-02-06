package com.obj.main;

import com.obj.controller.FunctionalTest;

public class Run2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		double result = new FunctionalTest().cal1(); 
		/*
		1. FunctionaalTest 클래스의 cal1메소드 호출.
		2. new FunctionalTest().cal1() 이 문장은 cal1에 있는 값이랑 같은 결과임.	
		3. cal1()의 결과를 double result에 저장.		
		 */
		
//		System.out.println(result);
		
//		System.out.println( new FunctionalTest().cal1() );
		// cal1() 메소드를 새롭게 호출해서 출력해라.
		// cal1()의 값이 나오면 그거를 출력.
		
//		double result = new FunctionalTest().cal1()+300;
		// return 값에 +연산한것이기 때문에 가능.
		// return은 계산한 결과이기때문에.
		
		
		FunctionalTest ft = new FunctionalTest();
//		ft.cal2(3, 4, '/');
		// 매개변수가 있는 메소드를 호출할때는
		// 반드시 선언된 매개변수값을 모두 전달해야함.
		
		// 반환형이 없고 매개변수가 없는 메소드.
//		ft.cal3();
		
		// 반환형이 있고 매개변수도 있는 메소드.
		double result = ft.cal4(4, 4, '*');
		System.out.println("result : "+result);
		
		System.out.println("병승이가 계산한 결과 : "+ft.cal4(20, 20, '/'));
	}

}
