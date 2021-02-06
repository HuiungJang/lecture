package com.repeat.controller;
import java.util.Scanner;

public class RepeatController {
	//기본for문 활용하기.
	public void basicFor() {
		// for문 작성하기.
		// for(초기식; 조건식; 증감식){반복할코드작성}
		// 초기식 : 변수에 선언 -> 반복할때 기준이 되는 값(횟수를 세는 값);
		// 조건식 : 반복문을 중단할 수 있는 조건 -> true면 반복문 실행, false면 중단
		// * 조건식 대부분 초기식에서 선언한 변수를 사용.
		// 증감식 : 초기식에서 선언한 변수를 변경시키는 연산.
		
		// 안녕하세요 문구를 5번 출력하세요.
//		System.out.println("안녕하세요."); // 1
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
		
		// for문을 사용함.
		// 1~100까지 출력하는 반복문.
//		for(int i = 1; i <= 100; i++) {
//			System.out.println(i);
//		}
//		
//		// 1~50까지 출력하는 반복문.
//		for(int i = 1; i <= 50; i++) {
//			System.out.println(i);
//		}
		
		//1~100까지 수에서 짝수만 출력하기.
		//if문 쓰고 짝수 출력.
//		for(int i = 1; i <= 100; i++) {
//			if (i%2 == 0){
//			System.out.println(i);
//			}
//		} // -> 계산2번함 for문 계산. if문 계산.
//		//if문 안쓰고 짝수 출력.
//		for(int i = 2; i<=100; i+=2) {
//			System.out.println(i);
//		} // -> 계산 1번함 for문 계산 -> if문 쓴 것보다 효율적.
//		
//		// 1~100까지 수에서 홀수만 출력하기.
//		for(int i = 1; i <= 100; i++) {
//			if (i%2 != 0){
//			System.out.println(i);
//			}
//		}
//		for(int i = 1; i<=100; i+=2) {
//			System.out.println(i);
//		}
		
		// 학생정보를 입력받아 출력하는 프로그램이.
		// 5명의 학생을 입력받아 출력하게 할 것.
		Scanner sc = new Scanner(System.in);
//		
//		for(int i = 1; i<=5; i++) {
//			System.out.print("이름 입력해주세요.");
//			String name = sc.nextLine();
//			
//			System.out.println("age?");
//			int age = sc.nextInt();
//			sc.nextLine();
//			
//			System.out.println("Class? ");
//			int ban = sc.nextInt();
//			sc.nextLine();
//
//			System.out.println(name+ " " + age + " " + ban);
//		}
		
		// 1~50까지 수에서 짝수면 짝 홀수면 홀 출력하기.
		for(int i = 1; i <= 50; i++) {
			if (i%2 != 0){
			System.out.println(i+" 홀");
			}else{
				System.out.println(i+" 짝");
			}
		}
		//100부터 1까지 출력하기.
		for(int i = 100; i >= 1; i--) {
			System.out.println(i);
		}
		
		// for 문 활용하기.
		// for문의 초기식, 조건식, 증감식을 다 활용해야하나? -> 무조건 있어야하는 것은 아니다.
		String msg = "0";
		for(; !msg.equals("0");) {
			System.out.println("??");
			msg = sc.next();
		}// 무한루프문.
		
		for(;; ){// -> 무한루프. 
			System.out.println("무한이다!");
		}
			
	}//basicFor()
	
	//응용 for문 활용하기.
	public void extraFor() {
		
	// 사용자가 입력한 수만큼 반복하는 for문 구성하기.
	// 여러분은 할 수 있다 출력.	
		Scanner sc = new Scanner(System.in);
//	int n = sc.nextInt();
//	for ( int i = 1; i<=n; i++) {
//		System.out.println("여러분은 할 수 있다.");
//	}
		
	// 성적의 합계, 평균을 구하는 프로그램 작성
	// 학생수를 입력받고 학생에 대한 국어,영어,수학 점수를 입력받고
	// 학생 수별 합계와 평균을 구하는 프로그램 작성.
	System.out.println("학생수 몇 명? ");
	int n = sc.nextInt();
	int sum = 0;
	
	for(int i = 0; i <n; i++) {
		
		System.out.println("국어성적 : ");
		sum += sc.nextInt();
		
		System.out.println("영어성적 : ");
		sum += sc.nextInt();
		
		System.out.println("수학성적 : ");
		sum += sc.nextInt();
		sc.nextLine();
		
		
		System.out.println("평균 : "+ sum/3.0+ "  합계 : " + sum);
		System.out.println();
		sum = 0;// -> sum 값 0으로 초기화.
		
		
		// 여기까지 이렇게 쓰면sum 값이 누적되어서 1번에는 문제없지만 2번에는 1+2의 값이 생김.
		// 해결하려면 sum값을 초기화 시켜야함.
		// for문 안쪽에 sum 값을 선언하고 초기화함.
	}
		// 변수명은 동적으로 선언할 수 없다.
		// int 변수=0; << 정적으로 선언함. 메소드로 변수명 만드는거.
	}//extraFor()
	
	// 계산기 프로그램 만들기.
	// 1. 한번만 실행하는 계산기.
	// 2. 입력한 수 만큼 계산 가능한 계산기 만들기.
	
	// 1-1 -> 입력 두개, 연산자 입력 받아서 처리.
	// 1-2 -> 추가적으로 계산할 수를 입력받음.
	
	
	//while문 사용하기
	public void whileTest() {
		//기본적인 while문 사용하기.
		// 1~100까지 출력해보자.
		int i=0; //while의 초기식으로 사용할 변수.
		while(i<=100) {// = for(int i =0; i<100; i++)
			System.out.print((i+1)+" ");
			i++; // 증가식.
		}
		int a= 10;
		while(a>10) {
			System.out.println("a : "+a);
		}
		// 반복문의 코드를 무조건 한번은 실행할 때 사용.
		do {
			//중복할 코드
			System.out.println("a : "+a);
		}while(a>10); // 참이면 do 안에 있는 구문 반복.
	}
	public void doubleForTest() {
		//중첩 반복문활용하기.
		for(int i  = 0; i<10; i++) {
			System.out.println("외곽 : "+i);
			for(int j = 0; j <10; j++) {
				System.out.print("내곽 : " +j);
			}
			System.out.println();

		}
		//구구단 출력하기.
		for(int i = 2; i<10; i++) {
			System.out.println(i);
			for(int j = 1; j<10; j++) {
				System.out.println(i+ "X" + j+"="+i*j);
			}
		}
		
		for(int i = 0; i <10; i++) {
			for(int j = 0; i<10; i++) {
				System.out.println(i+" : "+j);
			}
		}
		
		for(int i = 0; i<10; i++) {
			int j = 0;
			System.out.println(i+" : "+j);
		}
		
		// apple을 입력받아 각 문자별 중복갯수 확인.
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 중복체크하는 프로그램");
		String str = sc.next();
		// str.length(); -> 문자열의 길이를 알려주는 메소드.
		// 스트링변수명|| 스트링리터럴.length(); -> 문자열의 길이.
		for(int i =0; i<str.length(); i++) {
			int count =0;
			//System.out.println(str.charAt(i)+ " : ");
			for(int j = 0; j<str.length(); j++) {
			//	System.out.print(str.charAt(j));
				if( i!=j && str.charAt(i) == str.charAt(j) ){
					count++;
				}
			}
			System.out.println(str.charAt(i)+": "+ count +"중복");
		}
	// 별찍기 
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void breakContinueTest() {
		// break문
		// 무한 for문에서 loop를 중단시킬때 사용.
		Scanner sc =new Scanner(System.in);
//		String orderMenu="";
//		while(true) {
//			System.out.println("===점심주문 프로그램====");
//			System.out.println("1. 회");
//			System.out.println("2. 연어덮밥");
//			System.out.println("3. 감자탕");
//			System.out.println("4. 샌드위치");
//			System.out.print("입력 : ");
//			int cho = sc.nextInt();
//			switch(cho) {
//				case 1: orderMenu += "회 \n";
//					break;
//				case 2: orderMenu += "연어덮밥 \n";
//					break;
//				case 3: orderMenu += "감자탕 \n";
//					break;
//				case 4: orderMenu += "샌드위치 \n";
//					break;			
//			}
//			
//			System.out.println("계속주문하시겠습니까? (Y/N)");
//			char selected =sc.next().charAt(0);
//			if(selected =='N') {
//				System.out.println("주문내역");
//				System.out.println(orderMenu);
//				break;
//			}
//		}
//		System.out.println("주문프로그램종료");
//		
//		
//		for(int i = 0; i<10; i++) {
//			if(i%2 == 0) {
//				continue;
//			}
//			System.out.println(i);
//		}
//		for(int i = 2; i<10; i++) {
//			if(i%2 ==1) {
//				continue;
//			}
//			System.out.println(i+"단 출력?(1. 응 2. 아니) ");
//			if( sc.nextInt()==2) {
//				continue;
//			}
//			for(int j = 1; j <10; j++) {
//			System.out.println(i+"X"+j+"="+(i*j));
//				
//			}
//		}
//		//이중 for문에서 break문
//		gugu: // for문에 이름부여.
//		for(int i =2; i<10;i++) {
//			for(int j =1 ; j<10; j++) {
//				if(j>5) {
//					//break;
//					break gugu;
//				}
//				System.out.println(i+"X"+j+"="+(i*j));
//			}
//		}
		
		// 문자열을 입력받고 그 문자열 내에서 중복값이 있으면
		// 중복값발생! 을 출력할것 자기 자신은 제외.
		// ABBC -> B중복값. B중복발생!.
		// ABC -> 중복값없음.
		
		
	}
	public void checkDuplicate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열? ");
		String st = sc.nextLine();
		System.out.println("입력한 문자열수 : "+st.length());
		boolean flag =false;
		stop:
		for(int i = 0; i<st.length(); i++) {
			//System.out.println(st.charAt(i));
			for(int j = 0; j<st.length(); j++) {
				//	System.out.print(st.charAt(i) == st.charAt(j));
					if(i!=j&&st.charAt(i) == st.charAt(j)) {
						System.out.println(st.charAt(i)+"중복값 발생!");
						flag =true;
						break stop;
					}
				}
				System.out.println();
			}
			System.out.println(flag? "": "중복값 없음");
		}
	
	
	
}//Class

	