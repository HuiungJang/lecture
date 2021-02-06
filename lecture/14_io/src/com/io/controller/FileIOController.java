package com.io.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOController {
	
	public void saveFile() {
		// 램에 내가 저장하는 것이기 때문
		// write , output
		// 파일에 특정 데이터를 저장하려면 outputstream을
		// 연결해서 데이터를 저장함
		// 스트림 객체를 생성을 하면 반드시 그 객체는 반환해야함
		// close() 메소드 꼭 써야함 << 반환 
		// 파일에 대한 메소드 이용은 거의 대부분
		// IOException 처리를 해야함
		// OutputStream output = new OutputStream();
		// 불가능 -> 추상클래스니까 
		
		FileOutputStream output = null;
		try {
			output = new FileOutputStream(new File("bs/th.txt"));
			// OutputStream을 시작했을때
			// 파일이 없으면 자동으로 생성함
			// 있으면 있는 파일을 연결함
			
			// 데이터를 넣어보자!
			// FileOutputStream에서 제공하는 write메소드를 이용하면 됨
			byte[] data = "ABCDE".getBytes();
			output.write(data);
			// 안들어감 -> byte 단위 통신이기 때문에 
			// byte 배열로 넣어야함
			output.write("1234".getBytes());
			output.write("점심".getBytes());
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(output != null )
					output.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public void loadFile() {
		// 램에 있는거를 내가 보는것이기 때문에 
		// read, input 
		// 파일에서 데이터를 가져오려면 InputStream객체를 이용함
		// InputStream is = new InputStream();
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("bs/th.txt");
			// 파일의 데이터를 읽어오려면 read() 메소드를 이용
			// int 형으로 반환을 하여 int로 받아야함
			// read 한번에 1byte씩 받아옴
			int data = -1;
			while((data = fis.read()) != -1) {
				System.out.println((char)data);
				// byte 단위로 읽어오기 때문에 
				// 영문자와 특수문자 숫자를 제외한 문자는
				// 깨져서 출력된다. 
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if( fis != null) {
					fis.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 문자열은 Reader / Writer를 사용
	public void saveStrFile() {
		// Writer 
		try (FileWriter w = new FileWriter("bs/th.txt")){
			w.write("점심 맛있게 먹었나요?");
			w.write("황태국! 황태는 동태 말린 것");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadStrFile() {
		// Reader
		try(FileReader fr = new FileReader("bs/th.txt")){
			int data = -1;
			String str = "";
			StringBuffer sb =new StringBuffer();
			// 버퍼사용하는 것이 제일 효율적.
			// String str하거나 print메소드를 사용하는 것은 
			// heap영역에 만들고 붙이는 것을 반복하는 것이기 때문에.
			
			
			while((data = fr.read()) != -1) {
				// .read()는 문자열 끝에 닿으면 -1반환한다.
				// 즉, 파일을 불러오다가 불러올게 없으면 -1 반환
				// 이 반복문에서는 -1이 나오면 반복문이 종료되고
				// data에서 값을 불러오는게 종료된다.
				
				// System.out.print((char)data);
				// 2바이트 단위로 불러옴.
				// str += (char)data;
				sb.append((char)data);
			}
			System.out.println(sb);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
