package com.io.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOController {
	
	public void saveFile() {
		// ���� ���� �����ϴ� ���̱� ����
		// write , output
		// ���Ͽ� Ư�� �����͸� �����Ϸ��� outputstream��
		// �����ؼ� �����͸� ������
		// ��Ʈ�� ��ü�� ������ �ϸ� �ݵ�� �� ��ü�� ��ȯ�ؾ���
		// close() �޼ҵ� �� ����� << ��ȯ 
		// ���Ͽ� ���� �޼ҵ� �̿��� ���� ��κ�
		// IOException ó���� �ؾ���
		// OutputStream output = new OutputStream();
		// �Ұ��� -> �߻�Ŭ�����ϱ� 
		
		FileOutputStream output = null;
		try {
			output = new FileOutputStream(new File("bs/th.txt"));
			// OutputStream�� ����������
			// ������ ������ �ڵ����� ������
			// ������ �ִ� ������ ������
			
			// �����͸� �־��!
			// FileOutputStream���� �����ϴ� write�޼ҵ带 �̿��ϸ� ��
			byte[] data = "ABCDE".getBytes();
			output.write(data);
			// �ȵ� -> byte ���� ����̱� ������ 
			// byte �迭�� �־����
			output.write("1234".getBytes());
			output.write("����".getBytes());
			
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
		// ���� �ִ°Ÿ� ���� ���°��̱� ������ 
		// read, input 
		// ���Ͽ��� �����͸� ���������� InputStream��ü�� �̿���
		// InputStream is = new InputStream();
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("bs/th.txt");
			// ������ �����͸� �о������ read() �޼ҵ带 �̿�
			// int ������ ��ȯ�� �Ͽ� int�� �޾ƾ���
			// read �ѹ��� 1byte�� �޾ƿ�
			int data = -1;
			while((data = fis.read()) != -1) {
				System.out.println((char)data);
				// byte ������ �о���� ������ 
				// �����ڿ� Ư������ ���ڸ� ������ ���ڴ�
				// ������ ��µȴ�. 
				
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
	
	// ���ڿ��� Reader / Writer�� ���
	public void saveStrFile() {
		// Writer 
		try (FileWriter w = new FileWriter("bs/th.txt")){
			w.write("���� ���ְ� �Ծ�����?");
			w.write("Ȳ�±�! Ȳ�´� ���� ���� ��");
			
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
			// ���ۻ���ϴ� ���� ���� ȿ����.
			// String str�ϰų� print�޼ҵ带 ����ϴ� ���� 
			// heap������ ����� ���̴� ���� �ݺ��ϴ� ���̱� ������.
			
			
			while((data = fr.read()) != -1) {
				// .read()�� ���ڿ� ���� ������ -1��ȯ�Ѵ�.
				// ��, ������ �ҷ����ٰ� �ҷ��ð� ������ -1 ��ȯ
				// �� �ݺ��������� -1�� ������ �ݺ����� ����ǰ�
				// data���� ���� �ҷ����°� ����ȴ�.
				
				// System.out.print((char)data);
				// 2����Ʈ ������ �ҷ���.
				// str += (char)data;
				sb.append((char)data);
			}
			System.out.println(sb);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
