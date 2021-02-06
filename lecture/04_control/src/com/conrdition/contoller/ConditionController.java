package com.conrdition.contoller;
import java.util.Scanner;

public class ConditionController {
 // 기본 if문 활용하기.
	public void ifTest() {
	Scanner sc = new Scanner(System.in);
	System.out.print("정수입력 : ");
	//입력 받은 값이 양수면 양수입니다. 출력 아니면 아무것도 안함.
	int num = sc.nextInt();
	//삼항연산자 이용.
	System.out.println(num>0? "양수입니다." : "");
	//if문을 적용하려면?
	if(num>0) {
		System.out.println("양수입니다.");
		String name = "possible?";
		System.out.println(name);
		System.out.println("이메일 : ");
		String email = sc.next();
		System.out.println(email);
		}
	
	sc.close();
	}
	
	// 이름을 입력받고 자신의 이름과 동일한 이름이 입력되면.
	// 나는 코딩을 잘할수 있다.아니면 아무것도 안하는 로직.
	
	public void ifTest2() {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
	
		if( name.equals("장희웅")) { //문자열의 비교는 .equals() 사용
			System.out.println("나는 잘할 수 있다.");
		}
		//국어 영어 수학을 입력받고 평균이 60점 이상이면 합격입니다 출력하기.
		
		System.out.println("국어 영어 수학 점수를 입력하세요.");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		
		if((kor+eng+math)/3 >= 60) {
			System.out.println("합격입니다.");
		}
		
		System.out.print("kor ? ");
		int total = sc.nextInt();
		System.out.print("eng ? ");
		total += sc.nextInt(); // 대입연산자. 입력값을 더해서 누적저장.
		System.out.print("math ? ");
		total += sc.nextInt();
		if(total/3.0 >= 60) { 
			// 나누기3.0한 이유는 나누기 하면 소수점이 나올수있음.
			// 3.0으로 나누면 double 형으로 변환이 됨
			// 아니면 소수점 이하는 버리게 됨.
			System.out.println("합격입니다.");
		}
		// 정수 한개 입력받고 정수가 짝수면 짝수다 출력하는 기능.
		
		System.out.print("정수 ? ");
		int num = sc.nextInt();
		sc.nextLine();
		if( num %2 == 0) { 
			System.out.println("짝수다");
			}
		//id password 입력받아 아이디가 admin password admin 일때
		// 로그인 성공 출력하기.
		
		System.out.print("id ? ");
		String id = sc.next();
		System.out.print("password ? ");
		String password = sc.next();
		
		if( (id).equals("admin") && (password).equals("admin")) { 
			System.out.println("로그인 성공");
			}
		// if문은 한개만 쓸 수 있는것이 아니고 여러개 사용가능하다.
		sc.close();
		System.out.println("method end");
	}
	//if ~else 활용하기.
	public void ifelseTest() {
		// if ~else 문은 한개 그룹이다.
		// else예약어는 앞에 if문이 없으면 사용이 불가능하다.
		// if ~else문은 조건에 따라 반드시 둘 중하나만 실행된다.
		
		//입력받은 수가 양수면 양수입니다. 음수면 음수입니다.출력.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수입니다.");
		} else {
			System.out.println("음수입니다.");
		}
		// 미성년자는 가입이 불가능한 로직을 구성.
		// 가입 가능하면 가입가능 불가능하면 불가능 출력.
		
		System.out.print("몇살입니까? ");
		int age = sc.nextInt();
		if(age > 19) {
			System.out.println("가입가능");
		} else {
			System.out.println("불가능");
			System.out.println("====회원가입====");
			System.out.print("id : ");
			String id = sc.next();
			System.out.print("password : ");
			String pw = sc.next();
			System.out.print("nickname : ");
			String nincName = sc.next();
			
		}
		// if 문 두개 쓴거하고 else문 사용한것의 차이??
		// if else문은 if값에 else문이 영향을 받지만 
		// if문 두개 쓰면 앞에있는 if문에 영향받지않는
		// 별도의 구문으로 처리 됨.

	}
	public void ifelseifTest() {
		// 조건의 경우 수가 여러가지 일 경우 사용하는것.
		// 앞의 조건이 해당되지 않으면서 다른 조건을 적용할때 
		Scanner sc = new Scanner(System.in);
		// 성적을 입력했을 때 평균에 따라서 등급부여. 
		// 100~90 -> 수, 89~80 -> 우
		// 79~70 -> 미
		System.out.println("평균입력 : ");
		double avg = sc.nextDouble();
		
		if(avg >= 90 && avg <= 100) {
			System.out.print("수");
		}else if( avg >= 80 ) { // !(avg >= 90 && avg <= 100)&& avg>=80
			System.out.print("우");
		}else if(avg >= 70 ){
			System.out.print("미");
		}else {
			System.out.print(" ");
		}
		//연령별 메세지 출력하기
		// 10대 : 열심히 공부해야지 -> 좋은대학가지 
		// 20대 : 열심히 공부해야지 -> 취업하지 
		// 30대 : 열심히 일해야지 -> 결혼하지 
		// 40대 : 열심히 일해야지 -> 자식들먹이지
		// 50대 : 열심히 일해야지 -> 손자,손녀보지 
		
		System.out.println("나이 입력 : ");
		double age = sc.nextDouble();
		
		if(age >= 10 && age <20) {
			System.out.print("열심히 공부해야지 -> 좋은대학가지");
		}else if(age < 30) { 
			System.out.print("열심히 공부해야지 -> 취업하지 ");
		}else if(age < 40){
			System.out.print("열심히 일해야지 -> 결혼하지");
		}else if(age < 50){
			System.out.print("열심히 일해야지 -> 자식들먹이지");
		}else {
			System.out.print("열심히 일해야지 -> 손자,손녀보지 ");
		}
		
		// 아이디 패스워드 입력받기
		// user01 user01 -> 로그인 성공
		// user01 !user01 -> 패스워드가 틀립니다.
		// !user01 user01 -> 아이디가 틀립니다.
		//!user01 !user01 -> 둘다 모두 틀립니다.
		
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("패스워드 : ");
		String psw = sc.next();
		
		if(id.equals("user01") && psw.equals("user01")) {
			System.out.print("로그인 성공");
			
		}else if(id.equals("user01")) { 
			System.out.print("패스워드가 틀립니다. ");
			
		}else if(psw.equals("user01")){
			System.out.print("아이디가 틀립니다.");
			
		}else {
			System.out.print("둘다 모두 틀립니다.");
			}
	}
		//중첩 if문 사용하기
	public void doubleifTest() {
		// 중첩if문은 전체가 되는 조건에 대해 설정하고 그 안에서 다시 if문을 사용.
		// 나이가 성인이면서 내국인 ->회원가입, 외국인이면 외국인등록번호 
		// 성인이 아니면 가입할 수 없습니다.
		Scanner sc = new Scanner(System.in);
		System.out.println("KH CLUB");
		System.out.print("당신의 나이는 ?");
		int age = sc.nextInt();
		
		if(age>19) {
			System.out.println("1. 내국인  2. 외국인 :");
			String choice = sc.next();
			if(choice.equals("1")) {
				System.out.println("회원가입");
				System.out.print(" name : ");
				String name = sc.next();
				System.out.print("address");
				sc.nextLine();
				String address = sc.nextLine();
				}else if (choice.equals("2")) {
					System.out.println("외국인 등록 번호 1.있다  2. 없다 :");
					int cho = sc.nextInt();
						if(cho == 1) {
							System.out.println("회원가입");
							System.out.print(" name : ");
							String name = sc.next();
							System.out.print("address");
							sc.nextLine();
							String address = sc.nextLine();
							}else{
								System.out.println("회원가입 할 수 없습니다.");
							}
				}else{
					System.out.println("잘못누르셨습니다.");
				}
			
		}else {
			
		}
	}//doubleTest()
	
	//switch 활용하기
	public void switchTest() {
		// switch 문은 조건문으로 예상 되는 값에 따라 분기처리하는 방식.
		// 동등비교를 실행함.
		Scanner sc = new Scanner(System.in);
		System.out.println("====menu=====");
		System.out.println("1. 파스타 2. 오삼불고기 3. 샌드위치 4. 냉면");
		int choice = sc .nextInt();
		switch(choice) {
		case 1:
			System.out.println("~~봉골레하나"); 
			break;
			
		case 2:
			System.out.println("``15입니다.");
			break;
			
		case 3:
			System.out.println("맛있게 먹자");
			break;
			
		case 4:
			System.out.println("박명수 ㅋ");
			break;
			
		default:
			System.out.println("다시해");
			break;
		
		}
		// switch( 여기 ) 안에 들어갈 수 있는 것은 ? 변수의 타입은 ??
		// 정수,문자열
		String name = "pasta";
		switch(name) {
		case "pasta" : 
			System.out.println("pasta delicious");
			break;
		case "bul" :
			System.out.println("bul delicious");
			break;
		}
		//char은 가능한가?
		System.out.println("가. 자바 나. 오라클 다.html/css");
		char cho = sc.next().charAt(0);
		switch (cho) {
			case'가' :
				System.out.println("자바는 쉽다!고 말하고 싶다.");
				ifTest(); //method call, same Class.
				break;
				
			case'나' :
				System.out.println("DB");
				new OtherTest().test(); // method call, not same Class -> create capsule
				
				break;
				
			case'다' :
				System.out.println("화면구현");
				break;
				}
		//switch는 boolean 형태로 사용할 수 없다.
		
//		int su = 100;
//		switch(su > 50) {
//		case true :
//		}
	}
}
