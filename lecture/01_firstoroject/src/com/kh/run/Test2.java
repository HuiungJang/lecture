package com.kh.run;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test2 {
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// ����
		// �������� System.in�̾ƴ϶� System.out�̴� �ߺ���!
		
		String str ="�����ٶ󸶹ٻ�"; // ����� ���ڿ�
		
		bw.write(str); 
		// ���ڿ� ���.
		// �����ٶ󸶹ٻ� ��� 
		
		bw.newLine(); 
		// �ٹٲ� 
		// System.out.println(); �̷��� ���� ���°� Ȥ�� �����ϴ� ����
		
		bw.flush(); 
		// ���ۿ� �����ִ� �����͸� ��� �����.
		bw.close(); 
		// ��Ʈ���� ���� 
		
		//���۸� �����ϰ� �ֱ⶧����
		//.flust() 
		//.close()
		// �� �ΰ��� �ݵ�� �������� ȣ���ؾ��Ѵ�.
		
	}
}
