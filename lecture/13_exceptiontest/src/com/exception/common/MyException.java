package com.exception.common;

import java.io.Serializable;

public class MyException extends RuntimeException implements Serializable{
	// ����ó�� ��ü�� ������
	// Exception��ü�� ��ӹ����� Exception��ü�� ��
	// ��� ���̵� ������� Exception�� ��ӹ��� ��ü�� ��ӹ����� ��.
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4119272505420334756L;

	public MyException(String name) {
		super(name);
	}

}
