package com.exception.controller;

import java.io.FileNotFoundException;

public class SubException extends ExceptionHandle{
	
	@Override
	public void fileLoad2() throws FileNotFoundException{
		System.out.println("오버라이드 ! ");
	}
	// 상속 받아 오버라이드 할 때 부모클래스 Exception의 범위보다
	// 크게 하면 안된다.
	// 자식클래스를 사용하거나 같게한다. 단 여러가는 상관없다.
}
