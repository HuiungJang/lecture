package com.vari.basic;

//기본적인 변수선언
public class BasicVariable {

	public static void main(String[] args) {
		// 변수선언하기 -> 저장공간 확보하기 
		// 변수를 선언하는 방법 -> 자료명 변수명;
		// true 아니면 false를 저장하는 공간 확보하기 
		boolean flag;
		/* 
		 변수에 대한 명칭을 지정할 때 규약 
		 1. 대소문자 구분이 되고 길이 제한이 없음.
		 2. 예약어를 사용하면 안됨.ex) int int; (x) String string; (x)
		 3. 첫글자를 숫자로 할 수 없음. ex) int 1number;(x) int number1; (o)
		 4. 특수문자( _ ) 특수문자( $ ) 2개만 사용가능. ex) int _bum;(o) int $num;(o)
		 5. 여러단어로 변수명을 작성할때는 첫글자는 소문자로 그 뒤는 대문자로 작성. -> camelcase(낙타봉표기법)
		 	ex) String memberName; int memberAge;
		 6. 변수에 들어올 예상이 되는 데이터를 알 수 있게 명명하는 것이 좋음.
		 7. 변수명에 한글을 쓸 수 있으나 쓰지 말자.
		 */
		
		/*
		 변수 선언시 주의사항
		 동일한 영역(scope)에서는 동일한 변수명이 있으면 안됨 -> 변수명 중복 안됨.
		 */
		int mathRecord;
		mathRecord = 100;
		System.out.println(mathRecord);
		
		flag = true;
		flag = false;
		
		char gender; // 남, 여 
		gender = '남';// 문자는 ''으로 표시한다.
		
		//문자열 저장하기
		
		String email;
		email = "jhw1345@gmail.com"; // 문자열을 저장할때는 " " 사용 
		
		double height = 180.5;
		
		float weight;
		weight = 65.5f;
		//연산할 때는 반드시 같은 자료형 
		
		// 동일한 자료형의 변수를 여러개 선언.
		int age1, age2, age3, age4;
		// 여러개 선언과 동시에 초기화 하기.
		char alpha ='a', alpha1 ='b', alpha2='c';
		
		//문자열에 대한 추가학습
		//문자열 클래스(객체)
		String nickName = "웅";
		System.out.println(nickName);
		String nickName1 = new String("웅1"); // 문자열을 보여주는 클래스.
		System.out.println(nickName1);
		
		//문자열은 + 연산을 통해 -> "병승" + "선생";
		//두개의 문자열을 결합시킴.
		System.out.println("곧" + " 쉬는시간");
		// 변수명 + 변수명 ?
		String msg = "Today's" + " Friday.";
		System.out.println(msg);
		
		System.out.println(nickName+msg);
		// 문자열 + 숫자 ? => 문자열과 연산하면 문자열로 변환해서 출력함.
		System.out.println("됨?" + 0.115);
		//상수 = 변경할 수 없는 저장공간 
		final String ADMIN = "master";
		System.out.println(ADMIN);
		
	}

}
