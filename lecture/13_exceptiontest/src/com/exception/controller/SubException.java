package com.exception.controller;

import java.io.FileNotFoundException;

public class SubException extends ExceptionHandle{
	
	@Override
	public void fileLoad2() throws FileNotFoundException{
		System.out.println("�������̵� ! ");
	}
	// ��� �޾� �������̵� �� �� �θ�Ŭ���� Exception�� ��������
	// ũ�� �ϸ� �ȵȴ�.
	// �ڽ�Ŭ������ ����ϰų� �����Ѵ�. �� �������� �������.
}
