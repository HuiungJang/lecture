package com.kh.run;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test2 {
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 선언
		// 주의할점 System.in이아니라 System.out이다 잘보자!
		
		String str ="가나다라마바사"; // 출력할 문자열
		
		bw.write(str); 
		// 문자열 출력.
		// 가나다라마바사 출력 
		
		bw.newLine(); 
		// 줄바꿈 
		// System.out.println(); 이렇게 한줄 띄우는것 혹은 개행하는 역할
		
		bw.flush(); 
		// 버퍼에 남아있는 데이터를 모두 출력함.
		bw.close(); 
		// 스트림을 닫음 
		
		//버퍼를 점유하고 있기때문에
		//.flust() 
		//.close()
		// 이 두개는 반드시 마지막에 호출해야한다.
		
	}
}
