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
			System.out.println("??? try 안");
			int data = -1;
			while( (data = fr.read())!= -1) {
				
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			return;
		}catch(IOException e ) {
			e.printStackTrace();
		}
		
		finally { // 이안에 있는 구문은 반드시 실행.
			System.out.println("???");
			
		}
		
		// try에서 선언한 변수를 외부에서 사용가능한가?
		// 안됨. try에서 선언된거는 try안에서만
		
		
		System.out.println("try 밖");

	}
	
	// Exception객체들도 상속관계에 따른 처리방법 있음.
	// Exception 모든 Exception의 부모.
	// 각각의 관계에 따라 부모, 자식관계 있음.
	// 예외처리시 부모 Exception은 자식의 Exception을 처리할 수 있다.
	// 예외처리할때 자식Exception부터 작성하자.
	// 어떤 예외인지 모르겠다? -> Exception e 로 퉁
	// 다만 어떤 건지 모르니까 if문으로 처리해야함.-> 어려움
	
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
				if(fr!=null) fr.close(); // 반드시 닫아줘야함
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void fileLoad2() throws IOException{
		try(FileReader fr = new FileReader("test.txt") ){
			// 괄호안에 닫아야하는 객체들 전부 생성가능.
			
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
		System.out.print("암호입력 : ");
		String pw =sc.next();
		if(!pw.equals("1234")) { 
			// 나의 예외를 발생시키기.
			// throw 예약어를 이용해서 예외를 발생시킴
			throw new MyException("암호가 다름");
		}
	}
}
