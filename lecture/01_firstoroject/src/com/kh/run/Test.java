package com.kh.run;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
// IOŬ������ �����ֱ� ������ �ݵ�� import���־���Ѵ�.

public class Test {
	public static void main(String[] args) throws IOException{
		// IO�� �ֱ⶧���� ����ó���� ���־���Ѵ�. try catch���̳� throws�� �� ����.
		
		
		// �ֿܼ��� �Է¹��� ���.
		// �Է� �ޱ����� ���� �� �ʱ�ȭ.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		// Scanner�� next()�� ����.
		// ��������� �ν��ϴ°��� �ƴ� ���ٴ����� �ν��Ѵ�.
		
		// ����ȯ
		// BufferedReader�� �Է¹��� ���� ��� String���� ���ϵȴ�.
		// ������ ���� ����ȯ�� ���� ������ �ʿ��ϴ�.
		int n = Integer.parseInt(br.readLine());
		// readLine�� ���� �Է¹��� ���� int�� ����ȯ.
		
		

		// ���Ͽ��� �Է� ���� ���.
		FileReader fr = new FileReader("�����̸�");
		BufferedReader br_1 = new BufferedReader(fr);
		
		String l = "";
		for(int i = 1; (l = br_1.readLine()) != null; i++) {
			// �Էµ������� ù��° �ٺ��� �������� ���������� 
			// ���پ� �а� l�� ����.
			
			System.out.println(l);
			// ���� ���� ����Ѵ�.
		}
		
		
		// close()
		// �Է��� �������� �ݾ�����Ѵ�.
		br.close();

		
	}
}
