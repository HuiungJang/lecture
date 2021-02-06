package com.operator.controller;
import java.util.Scanner;

public class OperatorTest {
	// 단항연산테스트.
	public void singleOp() {
		//부정연산.
		// ! -> 진위형을 반전시키는 연산.
		boolean flag = true;
		System.out.println(flag);
		
		boolean flag2 =! flag; // flag의 진위형을 반전시켜 flag2에 저장.
		System.out.println(flag2);
		
		System.out.println(!flag); // flag의 진위형을 반전시켜 출력.
		
		// 부정연산은 비교연산, 논리연산 결과를 부정할때 많이 사용.
		// 기능(메소드)에서 출력하는 논리값을 부정시킬때. 
		
		// 증가연산 -> ++
		int num = 10;
		num++;
		num++;
		num++;
		num++;
		System.out.println("num : "+num);
		
		// 감소연산 -> --
		num--;
		System.out.println("num : "+num);
		
		// 다른 연산과 같이 실행되면 전위와 후위가 다름.
		int num2 = 10;
		int result = num2++; //대입연산자 계산 후 프린트 -> 1증가.
		System.out.println(result);
		System.out.println(num2);
	
		int num3 = 10;
		int result2 = ++num3; //전위연산자 1증가 후 프린트.
		System.out.println(result2);
		System.out.println(num3);
		
		//증가, 감소연산 -> 자기자신(변수의 값)을 1증가/감소 시키는 연산.
		//for 문이나 누적 갯수 등을 연산할 때 사용.
	}//singleOp()
	
	//산술연산 연습.
	public void calculator() {
		// 산술연산은 - + * / %(나머지 값)
		
		// 더하기 연산.
		int num = 10;
		int num2 = 20;
		System.out.println("변수이용 : " +(num+num2));
		System.out.println("리터럴이용 : " +(10+20));
		int result = num + num2;
		
		System.out.println(num+"+"+num2+"="+result);
		
		//빼기 연산.
		result = num - num2;
		System.out.println(num+"-"+num2+"="+result);
		
		//곱하기
		result = num * num2;
		System.out.println(num+"*"+num2+"="+result);
		
		//나누기.
		//무조건 정수나온다는 보장이 없기때문에 double형으로 저장해야함.
		int num3 = 5;
		int num4 = 9;
		System.out.println((double)num3/num4);
		System.out.println((double)(num3/num4)); 
		
		// num3/num4는 이미 int형으로 0.0나옴.
		//double result2 = (double)(num3/num4);
		
		//나머지 연산 -> %
		System.out.println("나머지 연산 : " + (num3%num4));
		System.out.println("나머지 연산 : " + (5%3));
		
		// 수가 3의 배수인지 확인하기. -> 3으로 나눈 나머지가 0
		// 수가 짝수인지, 홀수인지 확인하기. -> 2로 나눈 나머지가 0
	
	}//calculator() 
	
	// 기본 더하기 계산기 만들기
	// 두개의 값을 입력받아 더하기 연산하며 출력하기.
	// 00 + 00 = 00
	public void ex_calculator() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("더하기를 할 값 정수 2개를 입력해주세요.");
		System.out.print("더하기를 할 값 첫번째 : ");
		int num1 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("더하기를 할 값 두번째 : ");
		int num2 = sc.nextInt();
		
		int result = num1 + num2;
		
		System.out.println("계산값은 " + num1 +" + " +num2 + " = "+ result +"입니다.");
		
		sc.close();
	}
	
	//비교연산자 확인하기.
	public void compareOp() {
		//대소비교 연산자 -> 수의 크기를 비교하는 연산자.
		int age = 19;
		int age2 = 27;
		int age3 =27;
		// 변수||리터럴 < 변수||리터럴
		boolean result = age < age2; // age가 age2 보다 작니?
		System.out.println(result);
		result = age >age2;
		System.out.println(result);
		result = age2 > age3;
		System.out.println(result);
		result = age2 >= age3;
		System.out.println(result);
		
		//문자(char)에 대한 대소비교.
		char ch1 = 'A';
		char ch2 = 'C';
		System.out.println(ch1 < ch2);
		
		//나이를 입력받고 19세 초과인지 확인.
		Scanner sc= new Scanner(System.in);
		System.out.print("나이를 입력해주세요 : ");
//		int age4 = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.println("20세 이상이면 true 아니면 false.");
//		System.out.println(age4 > 19); // 기준점으로 삼을 수 있다.
//		
//		// 동등비교연산자.
//		// 일치여부를 판단.
//		// == 숫자, 문자, 문자열???
//		System.out.println("======동등비교=======");
//		int num = 20;
//		System.out.println(num == 10);
//		System.out.println(num == 20);
//		System.out.println(num == age4);
//		System.out.println(ch1 == 'A'); // true
//		
//		System.out.println("======문자열비교=======");
		String msg = "오늘 수업 요기까지";
//		String msg2 = "오늘 수업 요기까지";
		String msg3 = new String("오늘 수업 요기까지");
//		System.out.println(msg == msg2);
//		System.out.println(msg == msg3); // x
		// 문자열은 참조형, 참조형은 클래스.
		
		// 문자열의 동등비교는 어떻게???
		// 문자열.equals(비교문자); 
		System.out.println(msg.equals(msg3));
		
		System.out.println("id : ");
		String id = sc.next();
		System.out.println(id.equals("admin"));
		
		//문자열 동등비교 부정하기.
		System.out.println("동등비교부정");
		System.out.println(!id.equals("admin")); // admin과 다르니? 다르면 true 같으면 false.
		System.out.println();
		
		//문자열을 제외한 동등비교 부정(일치하지 않지?)->  !=
		int num1 = 20;
		int num2 = 30;
		System.out.println(num1==num2);
		System.out.println(num1 != num2);
		
		// 빼기, 나누기, 나머지 메소드 만들기.
		// 입력받은 값이 20보다 큰지 확인하는 메소드.
		// 입력받은 값이 대문자인지 확인하는 메소드. 대문자->true
		
	
	}
	public void logicCompare() {
		//일반 논리연산
		//AND (A&&B) -> A와 B가 모두 true 일때 true;
		//OR (A||B) -> A 또는 B가 true일때 true;
		
		//사는곳이 시흥이고 이름이 유병승인 사람.
		String name = "yu";
		String address = "si";
		String name2 = "jeong";
		String address2 = "si";
		
		System.out.println(name.equals("yu") && address.equals("si")); // true
		System.out.println(name2.equals("yu") && address.equals("si")); //false
		
		//나이가 20대인 사람을 구하시오.
		// 20대? 20<=나이 <=29.
//		int age = 28;
//		System.out.println(20 <= age && 29 >= age);
		
		//id = admin && passwoerd = 1234 ->true
		Scanner sc = new Scanner(System.in);
//		System.out.print("id ? : ");
//		String id = sc.nextLine();
//		System.out.print("password ? :");
//		String password = sc.nextLine();
//		
//		System.out.println(id.equals("admin")&& password.equals("1234"));
//		
		// 당신의 나이가 10대이면서 성별이 여자인사람.
		// 나이 . 성별 .
		
		System.out.print("age ? : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("gender (M/F) ? : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print(age<=19 && age >= 10 && gender == 'F');
		
		// 주소지가 경기도나 강원도인 사람.
		System.out.print("주소지 ? : ");
		String address1 = sc.nextLine();
		
		System.out.print(address1.equals("경기도") || address1.equals("강원도"));
		
		// 사는곳이 광주거나 서울, 나이30대, 남자.
		
		 System.out.print(age >= 30 && age <= 39 &&
				 ( address1.equals("광주") || address1.equals("서울") ) && gender == 'M');
		// 연산자 우선순위 생각해서 조건을 정해야함. 
		// ||(or) 연산자 쓸 때 주의하고 ()로 묶어줘야함.
		// 특히 &&(and) 연산자랑 같이 쓸 때.
	}
	
	public void complexOp() {
		//변수에 있는 값에 특정연산 한 후 다시 대입하는 연산자.
		int su = 100;
		//su++; -> su = su+1
		// 변수 += 수; -> 변수 = 변수 + ;
		su += 200;
		System.out.println(su); // 300
		
		// 누적합계를 계산할 수 있음.
		int total = 0; // storage
		total += 100000; // total = total + 100000;
		total += 200000; // total = total + 200000;
		
		total *= 3;
		System.out.println(total);
		// 문자열 누적연산
		// 문자열 + 문자열 -> 결합연산.
		
		String msg = " ";
		msg += "hi";
		
		// 사용자에게 5번 입력받고 입력받은값을 한번에 출력
		// 문자열도 누적이 가능하다.
		Scanner sc = new Scanner(System.in);
		System.out.println("message ? ");
		String message = sc.nextLine();
		
		System.out.println("message ? ");
		message += sc.nextLine();
		
		System.out.println("message ? ");
		message += sc.nextLine();
		
		System.out.println("message ? ");
		message += sc.nextLine();
		
		System.out.println("message ? ");
		message += sc.nextLine();
		
		System.out.println(message);
		
		}
	
	// 삼항연산자 실습.
	public void thirdOp() {
		// 삼항연산자는 조건식에 의해 실행된 구문을 결정하는 연산.
		// 조건문 ? true일때 실행될 구문 : false일때 실행될 구문;
		// 단독으로 쓰이지는 못하고 어떤 변수가 받거나 해야함.
		int su = 12;
		// su 가 10이면 10이다 출력, su가 10이 아니면 10이 아니다 출력.
		String msg = su == 10 ? "10이다." : "10이 아니다.";
		System.out.println(msg);
		
		// 숫자를 입력받아 100보다 크면 우와크다. 아니면 에이작다 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해주세요.");
		int num = sc.nextInt();
		
		String msg2 = (num >= 100) ? "우와크다." : "에이작다.";
		System.out.println(msg2);
		
		
		// 미성년이면 공부하세요. 아니면 돈버세요.
		// 나이를 입력받아 처리하기.
		System.out.print("나이를 입력해주세요. : ");
		int age = sc.nextInt();
		System.out.println((age >= 19) ? "공부하세요." : "돈버세요.");
		
		// 삼항연산자의 중첩.
		// 미성년인지 확인하고 미성년아니고 남자면 왼쪽으로 가세요. 아니면 오른쪽으로 가세요.
		// 미성년이면 나이 더 먹고와.
		System.out.print("성별이 무엇인가요? (남자면 M 입력/ 여자면 F 입력) ");
		char gender = sc.next().charAt(0);
		
		System.out.println((age<19)? "나이 더 먹고와.": 
			((gender == 'M'|| gender== 'm')? "왼쪽으로 가세요.":"오른쪽으로 가세요."));
	
		// kh학생이면 코딩하세요, 아니면 취업하세요.
		// 학생여부를 입력받아 처리하기.
		
		System.out.print("kh 학생이신가요 ? (Y/N) : ");
		char stu = sc.next().charAt(0);
		System.out.println((stu == 'Y' || stu =='y') ? "코딩하세요." : "취업하세요.");
		}
	
	// 비트연산 실습.
	public void bitOp() {
		//비트연산 실행하기.
		// 저장소에 있는 비트끼리 연산을 의미함.
		// A&B : 둘 비트 모두 ] 1일 경우만 1
		// A|B : 둘 비트 중 하나만 1이면 1
		// A^B(XOR) : 둘다 다를 때 1 같으면 0
		// ~A : 1일때 0, 0일때 1
		int a = 10, b = 22;
		String basic = " ";
		for(int i = 0; i<32; i++) {
			basic += "0";
			}
		String bit = basic + Integer.toBinaryString(a);
		bit = bit.substring(bit.length()-32);
		System.out.println(bit+ " -> a 비트값");
		
		bit = basic+Integer.toBinaryString(b);
		bit = bit.substring(bit.length()-32);
		System.out.println(bit+ " -> b 비트값");
		
		bit = basic + Integer.toBinaryString(a&b);
		bit = bit.substring(bit.length()-32);
		System.out.println(bit+ " -> a&b연산");
		
		bit = basic + Integer.toBinaryString(a|b);
		bit = bit.substring(bit.length()-32);
		System.out.println(bit+ " -> a|b연산");
		
		bit = basic + Integer.toBinaryString(a^b);
		bit = bit.substring(bit.length()-32);
		System.out.println(bit+ " -> a^b연산");
		
		bit = basic + Integer.toBinaryString(~a);
		bit = bit.substring(bit.length()-32);
		System.out.println(bit+ " -> ~a연산");
	}
}//public class
