package com.exception.controller;

import java.util.Scanner;

import com.exception.common.MyException;

public class RuntimeExceptionTest {
	public static void main(String[] args) {
		// ArithmeticException : ���������� ����� �Ұ����� ��쿡 �߻�
		Scanner sc =new Scanner(System.in);
		
		System.out.println("�� : ");
		int su = sc.nextInt();
		
		System.out.println("�� : ");
		int su1 = sc.nextInt();
		
		try{
		System.out.println(su/su1);
		}catch(ArithmeticException e) {
			// Exception ���� e�� ����.
			System.out.println(e.getMessage());
			// Exception�� ���� �޼���.
			e.printStackTrace();
			// �޼ҵ尡 ����� ����.
			// ��� Exception �߻������� Ȯ���Ҽ��ִ� ��±���.
			
			System.out.println("���ڿ� 0�� �ֽ��ϴ�. ");
		}
		// 0���� ������ �߻� 
		
		// NegativeArraySizeExcption : �迭���� ����
		// int[] arrInt = new int [-10];
		// ArrayIndexOutOfBounds : ������ �ε����� �迭�� ���̸� �ʰ�������.
		String[] names = new String[2];
		try {
			names[3] = "11";
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�ε��� ������ �ʰ��߽��ϴ�.");
			String[] tmp = new String[names.length+10];
			System.arraycopy(names, 0, tmp, 0, names.length);
			names = tmp;
			names[3] = "11";
		}
		System.out.println("??");
		System.out.println(names[3]);
		
		// ClassCasException Ŭ���� ����ȯ�� ����
		Object obj = new String("hi");
		//Scanner s2 = (Scanner)obj;
		
		// chcekedException : �ݵ�� ����ó�� �ؾ��ϴ� ��
		// FileReader fr = new FileReader("test.txt");
		
//		new ExceptionHandle().testException();
		new ExceptionHandle().tryCatchTest();
		new ExceptionHandle().fileLoad();
		
		try {
			new ExceptionHandle().myExceptionUse();
		}catch(MyException e) {
			e.printStackTrace();
		}
		
	}
}
