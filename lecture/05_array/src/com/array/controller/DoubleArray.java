package com.array.controller;
import java.util.Random;

public class DoubleArray {
	public void basicDoubleArray() {
		// 2차원 배열 => 바둑판 형식의 저장소의미 
		int[][] arr = new int[3][3];
		arr[0][0] = 100;
		arr[0][1] = 200;
		
		System.out.println(arr[0][0]);
		System.out.println(arr[0][1]);
		
		//for문을 이용해서 2차원 배열 처리하기
		for(int i= 0; i<3; i++) {
			for(int j =0; j<3; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		arr = new int[3][5];
		// 2차원 배열에 값넣기.
		for(int i =0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				arr[i][j] =new Random().nextInt(8)+1;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();

		}
		
	}
}
