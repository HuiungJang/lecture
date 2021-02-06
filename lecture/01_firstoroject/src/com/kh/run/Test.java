package com.kh.run;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
// IO클래스에 속해있기 때문에 반드시 import해주어야한다.

public class Test {
	public static void main(String[] args) throws IOException{
		// IO에 있기때문에 예외처리를 해주어야한다. try catch문이나 throws를 꼭 쓰자.
		
		
		// 콘솔에서 입력받을 경우.
		// 입력 받기위한 선언 및 초기화.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		// Scanner의 next()와 같다.
		// 공백단위로 인식하는것이 아닌 한줄단위로 인식한다.
		
		// 형변환
		// BufferedReader로 입력받은 값은 모두 String으로 리턴된다.
		// 때문에 따로 형변환을 통한 가공이 필요하다.
		int n = Integer.parseInt(br.readLine());
		// readLine을 통해 입력받은 값을 int로 형변환.
		
		

		// 파일에서 입력 받을 경우.
		FileReader fr = new FileReader("파일이름");
		BufferedReader br_1 = new BufferedReader(fr);
		
		String l = "";
		for(int i = 1; (l = br_1.readLine()) != null; i++) {
			// 입력된파일의 첫번째 줄부터 다음줄이 없을때까지 
			// 한줄씩 읽고 l에 저장.
			
			System.out.println(l);
			// 읽은 값을 출력한다.
		}
		
		
		// close()
		// 입력이 끝났으면 닫아줘야한다.
		br.close();

		
	}
}
