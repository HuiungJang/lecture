package com.vari.printtest;

public class PrintTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print(false); System.out.println(); 차이.
		String name = "HeeUng";
		int age = 19;
		double height =180.5;
		double weight = 65.5;
		char gender = 'M';
		
		//print 메소드 활용하기.
		System.out.print(name);
		System.out.print(age);
		System.out.print(height);
		System.out.print(weight);
		System.out.print(gender);
		
		//println 메소드 활용하기.
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(weight);
		System.out.println(gender);
		
		//printf 용해서 출력하기.
		//이름은 name 변수입니다 출력하기.
		
		System.out.printf("이름은 %s 입니다. \n",name);
		System.out.printf("나이는 %d 입니다. \n", age);
		System.out.printf("이름은 %s 나이는 %d입니다.\n",name, age);
		
		//printf 메소드는 값의 정렬, 소수점 자리수 표현을 쉽게 가능함.
		//정렬.
		System.out.printf("%8s %d \n",name , age);
		//8칸을 주고 오른쪽 정렬.
		System.out.printf("%-8s %d \n",name , age);
		//8칸을 주고 왼쪽 정렬.
		
		//소수점.
		System.out.printf("%f \n",height);
		System.out.printf("%.2f \n",height); //소수점 두번째 자리까지.
		
		// 몸무게를 소수점 3자리까지.
		System.out.printf("%.3f \n",weight); //소수점 세번째 자리까지.
		
		//나는 00이고, 나이는 00이고, 성별은 0, 키는 000.00 몸무게는 00.0입니다.
		//나는 00이고, 나이는 00이고 
		//성별은 0, 키는 000.00 몸무게는 00.0입니다.
		System.out.printf("나는 %s이고, 나이는 %d이고 성별은 %c, 키는 %.2f 몸무게는 %.1f 입니다. \n", name, age, gender, height, weight);
		System.out.printf("나는 %s이고, 나이는 %d이고\n성별은 %c, 키는 %.2f 몸무게는 %.1f 입니다. \n", name, age, gender, height, weight);
		
		System.out.println();
		System.out.println();
		
		//escape 문
		//문자열에서 특정기능을 수행하는 구문.
		
		// \t 일정간격의 띄어쓰기. 문자열리터럴 안에서 사용.
		String msg = "안녕하세요";
		System.out.println(msg);
		msg="안녕 \t하세요";
		System.out.println(msg);
		
		// \n 개행.
		msg = " 여러분 점심은 \n 맛있게 먹었나요?";
		System.out.println(msg);
		
		msg = " \"야 뭐해!\"라고 말했다.";
		System.out.println(msg);
		
		msg = "<button oneclick = 'fn_click();'>실행</button>";
		
		String path = "c:\\USER\\USER1";
		System.out.println(path);
	}
}