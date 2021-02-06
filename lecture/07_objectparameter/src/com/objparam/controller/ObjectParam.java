package com.objparam.controller;

import com.objparam.model.vo.Lunch;

public class ObjectParam {
	
	private String check;
	
	
	// 1. 기본자료형 매개변수, 객체, 매개변수의 차이
	public int basicParam(int su, String str) {
		su++;
		str+="기본자료형 더하기";
		return su; // 메인 메소드로 su를 리턴함.
	}
	
	public void arrParam(int[] arrInt) {
		arrInt[0] =100;
		arrInt[1] =200;
	}
	
	public void objParam(Lunch lunch) {
		lunch.setName("햄버거");
		lunch.setPrice(8000);
	}
	
	
	public void checkTest() {
		check += 10;
		System.out.println(check);
	}
	public void setCheck(String check) {
		this.check = check;
	}
	
}
