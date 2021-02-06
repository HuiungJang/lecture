package com.exception.common;

import java.io.Serializable;

public class MyException extends RuntimeException implements Serializable{
	// 예외처리 객체로 만들어보자
	// Exception객체를 상속받으면 Exception객체가 됨
	// 어느 것이든 상관없이 Exception을 상속받은 객체를 상속받으면 됨.
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4119272505420334756L;

	public MyException(String name) {
		super(name);
	}

}
