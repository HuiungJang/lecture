package com.exception.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.exception.common.MyException;

public class ExceptionHandle {
	
	public void testException() throws FileNotFoundException{
		new FileReader("test.txt");
		
	}
	
	
	public void tryCatchTest() {
		
		try {
			FileReader fr = new FileReader("test.txt");
			System.out.println("??? try ��");
			int data = -1;
			while( (data = fr.read())!= -1) {
				
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			return;
		}catch(IOException e ) {
			e.printStackTrace();
		}
		
		finally { // �̾ȿ� �ִ� ������ �ݵ�� ����.
			System.out.println("???");
			
		}
		
		// try���� ������ ������ �ܺο��� ��밡���Ѱ�?
		// �ȵ�. try���� ����ȰŴ� try�ȿ�����
		
		
		System.out.println("try ��");

	}
	
	// Exception��ü�鵵 ��Ӱ��迡 ���� ó����� ����.
	// Exception ��� Exception�� �θ�.
	// ������ ���迡 ���� �θ�, �ڽİ��� ����.
	// ����ó���� �θ� Exception�� �ڽ��� Exception�� ó���� �� �ִ�.
	// ����ó���Ҷ� �ڽ�Exception���� �ۼ�����.
	// � �������� �𸣰ڴ�? -> Exception e �� ��
	// �ٸ� � ���� �𸣴ϱ� if������ ó���ؾ���.-> �����
	
	public void fileLoad() {
		
		FileReader fr = null;
		try {
			fr = new FileReader("test.txt");
			
			int data = -1;
			while( (data = fr.read()) != -1 ) {
				System.out.println((char)data);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null) fr.close(); // �ݵ�� �ݾ������
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void fileLoad2() throws IOException{
		try(FileReader fr = new FileReader("test.txt") ){
			// ��ȣ�ȿ� �ݾƾ��ϴ� ��ü�� ���� ��������.
			
			int data = -1;
			while((data = fr.read()) != -1) {
				System.out.println((char)data);
			}
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			
		}
	}
	
	public void myExceptionUse() throws MyException{
		Scanner sc = new Scanner(System.in);
		System.out.print("��ȣ�Է� : ");
		String pw =sc.next();
		if(!pw.equals("1234")) { 
			// ���� ���ܸ� �߻���Ű��.
			// throw ���� �̿��ؼ� ���ܸ� �߻���Ŵ
			throw new MyException("��ȣ�� �ٸ�");
		}
	}
}
