package com.vari.printtest;
import java.util.Scanner;

public class ScannerSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); //객체 생성시 new
//		//학생 정보를 입력하고 출력하는 프로그램 만들기.
//		//학생정보 -> 이름, 나이, 성별, 주소, 학년, 반, 키.
//		System.out.println("===학생정보입력프로그램===");
//		System.out.println("name ?");
//		String name = sc.nextLine();
//		
//		System.out.println("age ?");
//		int age = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.println("gender ?");
//		String gender = sc.nextLine();
//		
//		System.out.println("address ?");
//		String address = sc.nextLine();
//		
//		System.out.println("grade ? ");
//		int grade = sc.nextInt();
//		sc.nextLine(); // 버퍼 비우기.
//		
//		System.out.println("class ? ");
//		int ban = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.println("height ? ");
//		double height = sc.nextDouble();
//		sc.nextLine();
//		
//		System.out.println("===당신이 입력한 학생정보는===");
//		//System.out.prinln(name + age + gender + address + grade + class + height);
//		System.out.printf("name : %s, age : %d, gender : %s, address : %s, grade : %d, class : %d, height : %.2f"
//				,name,age,gender,address,grade,ban,height);
		

		char first = "ABC".charAt(0);
		System.out.println(first);
		first= "ABC".charAt(1);
		System.out.println(first);
		first="ABC".charAt(2);
		System.out.println(first);
		//입력 받은 값을 char형으로 가져오려면
		sc.nextLine().charAt(0); // 입력받은 값 중 첫번째 문자를 char형으로 저장.
		
		
	}

}
