package com.inter.common;

import java.io.Serializable;

// �������̽��� ����� �����ұ�?
// ������ ��
// ������� �������̽��� ������ 
// �߻�Ŭ������ �����ؾߵ�.
// �������̽� ����� ���߻���� ������.


public interface PrintDriver extends MakeBugger,Serializable,Runnable{
	
	void print();
	void scan();
	
	// �������� ��Ȳ���� �߰��޼ҵ带 �����ϴ� ���
	default public void test() {
		System.out.println("hi");
	}
}
