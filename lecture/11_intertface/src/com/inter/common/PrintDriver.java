package com.inter.common;

import java.io.Serializable;

// 인터페이스는 상속이 가능할까?
// 가능함 ㅇ
// 상속해준 인터페이스에 구현된 
// 추상클래스를 구현해야됨.
// 인터페이스 상속은 다중상속이 가능함.


public interface PrintDriver extends MakeBugger,Serializable,Runnable{
	
	void print();
	void scan();
	
	// 예외적인 상황에서 추가메소드를 구현하는 방식
	default public void test() {
		System.out.println("hi");
	}
}
