package com.inter.common;

public interface MakeBugger {
	
	// ���� �����ϴ� ����� �����ϴ� �������̽�.
	// �������̽��� ������� ������ �Ұ�����.
//	private int count; // �Ұ���.
	
	public static final int COUNT  = 100;
	// ����� �����ϴ�.
	String TITLE = "���Ÿ����";
	// String �տ� public static final�� �����Ǿ�����
	// �������̽��� ������ �Ұ�����.
	
	
	// �������̽� ���ο��� �߻�޼ҵ常 ������ ������. 
//	public void makeBugger() {
//		System.out.println("���Ÿ���� ");
//	}
	public abstract void makeBugger();
	
	void infoBugger();
	// public abstract ���������� ���� �ݵ�� ���ԵǾ��ְ�
	// �ڵ����� �տ� �ٿ���.
}
