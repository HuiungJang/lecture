package com.array.controller;
import java.util.Scanner;

import java.util.Random;

public class ArrayController {
	
	public void basicArray() {
		// 배열은 동일한 자료형의 변수 여러개를 관리하는 것.
		// 배열의 선언은 변수와 비슷함 자료형 뒤에[] 또는 변수명 뒤에 []
		// 배열은 선언을 한다고 바로 사용할 수 없다. ->할당필요.
		// 배열의 할당은 -> new 연산자로 할당을 함.
		// 자료형[] 변수명 = new 자료형[생성할 변수의 개수];
		
		// 배열 선언하기
//		int[]  nums;
//		nums = new int[5]; // 길이가 5인 배열 할당.
//		
////		for(int i =0; i<5; i++){
////			nums[i];
////		}
//		
//		int[] nums2 = new int[3];
//		
//		// 배열의 저장공간에 접근하기
//		// 배열 할당 시 부여된 인덱스 번호로 저장공간에 접근.
//		// 배열명[인덱스번호]; <- 저장공간 호
//		System.out.println("nums[0] : " + nums[0]);
//		
//		// 배열은 할당을 통해 저장공간을 만들면 default 값으로 초기화됨.
//		// int -> 0 char-> ' ', double -> 0.0 String-> null
//		
//		//배열의 저장공간에 값 대입하기.
//		nums[0] =100;
//		System.out.println("num[0] 100 대입 후 : "+nums[0]);
//		
//		// index 번호의 최대값을 넘어서 접근을 하면.
////		System.out.println(nums[5]); //runtime시 배열 범위 초과 오류
//		
//		// 배열의 각 변수에 대입을 해보자
//		String[] names = new String[3];
//		names[0] = "유병승";
//		names[1] = "정유정";
//		names[2] = "권설영";
//		
//		System.out.println(names[0]);
//		System.out.println(names[1]);
//		System.out.println(names[2]);
//		
//		//for문으로 배열 출력하기.
//		for(int i =0; i<3; i++) {
//			//System.out.println(i);
//			System.out.println(names[i]);		
//		}
//		
//		for(int i=0; i<3; i++) {
//			 names[i] = "힘내요 ! 잠깨고 ! ";
//		}
//		
//		for(int i = 0; i<names.length; i++) {
//			System.out.println(names[i]);
//		}
//		
//		// 배열로 생성된 저장공간(변수) 자료형이 고정됨.
//		int[] ages =new int[5];
//		ages[0] = 100;
//	//	ages[1] = "유병승"; ->불가능int형 배열에 String형 리터럴을 넣을 수 없음.
//		
//		
//		
//		// 저장공간이 3개인 String배열을 만들고
//		// 3개의 주소를 입력받고 각 베열에 저장하고
//		// 출력하세요.
//		Scanner sc = new Scanner(System.in);
//		String[] address = new String[3];
//		
//		for(int i= 0; i<address.length; i++) {
//			System.out.println("주소를 입력하세요 : ");
//			address[i] = sc.nextLine();
//		}
//		
//		for(int i = 0; i<3; i++) {
//			System.out.println(address[i]);
//		}
//		
//		// 배열의 길이를 확인하려면.
//		// 배열명.length
//		
//		
//		String[] studentName = new String[10];
//		studentName[0] = "지수현";
//		studentName[1] = "김상현";
//		studentName[2] = "신충현";
//		studentName[3] = "이진주";
//		studentName[4] = "이우식";
//		
//		// 학생이름 중 신충현이 있는지 확인하는 로직.
//		boolean check = false;
//		for(int i =0; i<studentName.length; i++) {
//			if(studentName[i].equals("신충현")) {
//				check = true;
//			}
//		}
//		System.out.println(check? "있어":"없어");

		
		
		//입력받은 이름이 있는지 찾는 로직 구현
//		Scanner sc = new Scanner(System.in);
//		
//		boolean nameCheck = false;
//		System.out.println("검색할 이름.");
//		String inN = sc.nextLine();
//		String[] in = new String[inN.length()];
//		
//		for(int i =0; i<in.length; i++) {
//			if(in[i].equals(inN)) {
//				nameCheck = true;
//			}
//		}
//		System.out.println(inN+"은"+(nameCheck? "중복 " : "중복 아님"));
	//배열을 생성과 동시에 초기화하기(값을 바로 대입하기)
		double[] height = new double[10];
		height[0] = 180.1;
		double[] height2 = { 123.1, 123.2, 123.3, 123.4, 123.5};
		for(int i =0; i<height.length; i++) {
			System.out.println(height2[i]);
		}
		
		for(int i = 0; i<height.length; i++) {
			System.out.println(height[i]);
		}
	
	}
	// 배열 저장공간 활용하기.
	public void changeData() {
		// 배열에 저장된 데이터들간의 위치조정.
		// 배열에는 순서가 있는데 그 순서를 변경.
		int[] num = {1,4 ,6, 2, 3, 7}; 
		// 2번 인덱스 6-> 3 인덱스 2와 위치변경.
		for(int i = 0; i<num.length; i++) {
			System.out.print(num[i]+" ");
		}
		
		// 임시 저장소 만들어서 거기에 옮길값저장해놓고 
		// 3자교환하기.
		System.out.println();
		int tmp = num[2];
		num[2] = num[3];
		num[3] = tmp;
		
		for(int i = 0; i<num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
		// 배열 순차정렬하기.
		for(int i= 0; i<num.length; i++) { // 몇번 반복할꺼냐? -> num길이만큼 반복한다.
			for(int j =0; j<i; j++) {  // 몇번 반복할꺼냐? -> i번만큼 반복한다. 왜?-> 왼쪽, 오른쪽 비교해야하니까.
				System.out.println( j+" "+num[i] + " : " + num[j] );
				
				//오름차순 정렬(작->큰 순서대로)
				if( num[i]<num[j] ) { // -> 왼쪽이 오른쪽보다 작으면 즉, 오름차순\ 부등호 방향 반대면 내림차순.
					//변경하기.
					int t =  num[i];
					num[i] = num[j];
					num[j] = t; // 왼쪽오른쪽 자리바꿔라.
				}
				
			}
			System.out.println();
		}
		for(int i = 0; i<num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
		System.out.println();
	}
	public void test() {
		// int 10 배열을 선언하고 
		// 4,5,9,10,22,4,53,12,15,88 을 대입 
		// 값에서 짝수의 갯수 출력하기.
		// 홀수의 갯수 출력하기. 
		
		int[] nAry= {4,5,9,10,22,4,53,12,16,88};
		int jjac = 0;
		int hol = 0;
		
		for(int i = 0; i<nAry.length; i++) {
			if(nAry[i] % 2 == 0) {
				jjac++;
			}else {
				hol++;
			}
		}
		
		System.out.println("짝수: " + jjac);
		System.out.println("홀수: " + hol);
//		System.out.println("홀수: "+ (nAry.length-jjac)); -> 변수 선언과 else 선언 필요없이 홀수 구하기/ 전체수 - 짝수 = 홀수 
	}
	
	public void randomTest() {
		// 랜덤값 출력하기 -> 숫자 
		// Math클래스에서 제공하는 random() 기능이용.
		System.out.println( Math.random() ); // 메소드가 실핼될때다마다 랜덤값 출력.
		// random 값을 정수로 변경하려면?
		System.out.println( (int)(Math.random()*10) ); // 0~9까지
		System.out.println((int) Math.random()*10 ); // 괄호 주의. 연산자 우선순위 생각.
		
		System.out.println( (int)(Math.random()*5) ); // 0~4 
		
		// 1~45 번호 랜덤으로 출력하기.
		System.out.println( ((int)Math.random()*44)+1 ); //1~45
		// 6개 자리에 각 번호 들어감 -> 중복값이 없어야함.
		
		// 배열 int 6개 짜리 배열 만들고.
		// 각 배열 인덱스에 랜덤값을 넣기 단, 1~28까지 수 중.
		
		int[] ran = new int[6];
		for(int i =0; i<ran.length; i++) {
			ran[i]=(int)(Math.random()*27)+1;
			}
		
		for(int i =0; i<ran.length; i++) {
			System.out.print(ran[i]+" ");
		}
		// 랜덤값출력 
		// Random 객체를 이용하는 방법.
		// Random 객체의 nextInt() 기능을 이용함.
		System.out.println();
		System.out.println(new Random().nextInt() );
		//nextInt(범위값) -> nextInt(10); 0~10까지 
		System.out.println(new Random().nextInt(10)+1); // 1~10 
	}
	
	// 배열을 복사해보자.
	public void copyArray() {
		// 두가지방식
		// 1. 얕은 복사 -> 배열명의 주소값을 복사 
			String[] hobby = {"1.a", "2.b", "3.c", "4.d"};
			String[] hobby2 = hobby; // 얇은 복사.
			System.out.println(hobby);
			System.out.println(hobby2);
			System.out.println(hobby[0]);
			System.out.println(hobby2[0]);
			
			hobby2[0] = "1.a";
			System.out.println(hobby[0]);
			System.out.println(hobby2[0]);
			System.out.println();
		// 2. 깊은 복사 -> 배열에 연결된 공간을 복사 
			String[] hobby3 = new String[hobby.length];
			for(int i = 0; i<hobby.length; i++) {
				hobby3[i]=hobby[i];
			}
			
			hobby3[0]="축";
			
			for(int i =0; i <hobby.length; i++) {
				System.out.println(hobby[i]);
			}
			System.out.println("hobby3 출력");
			for(int i =0; i <hobby3.length; i++) {
				System.out.println(hobby3[i]);
			}
		//	System.arraycopy() 를 사용해서 복사
			System.out.println();
			String[] hobby4 = new String[5];
			System.arraycopy(hobby3, 1, hobby4, 2, 1);
			
			for(int i = 0; i<hobby4.length; i++) {
				System.out.print(hobby4[i]+" ");
			}
			System.out.println();
	}
	
}
