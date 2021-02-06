package com.obj.main;
import com.obj.controller.BasicObjTest;
// import com.obj.controller.DefaultTest; // not visible 오류-> 접근제한자에 의해 접근차단됐을때 나옴.
import com.obj.controller.FieldTest;
import com.obj.controller.InitBlockTest;
import com.obj.controller.Student;
import com.obj.controller.Animal;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BasicObjTest(); // BasicObjTest클래스 객체하나 생성.
//		new com.obj.controller.BasicObjTest();  -> 여기서도 사용가능하지만 쓸때마다 경로를 적어줘야함.
//		new DeafaultTest(); 
		// default 접근제한자인 클래스는 다른 패키지에서 사용할 수 없다.
		// 통상 접근제한자는 public을 사용한다.
		
		// FieldTest Class 필드에 접근하기.
		// 1. 클래스를 생성해야함.(new 연산자 사용)
		// 2. 생성된 클래스의 주소를 가지고 접근을 함. -> 접근연산자 ( . )
		FieldTest fieldTest = new FieldTest(); // 클래스명이 타입.
		//fieldTest 객체 생성
		System.out.print(fieldTest.age); //FieldTest에 직접접근해서 age라는 값을 가져와서 출력.
		
		
		
		//필드에 값 넣기
		fieldTest.age = 1;
		System.out.println(fieldTest.age);
		//System.out.println(fieldTest.email);// private 사용되었기에 다른 클래스에서 접근 불가능함.
		//System.out.println(fieldTest.name); // default -> 다른클래스여서 접근불가능.
		
		
		// static 변수에 접근하기.
		FieldTest.nickName = "박명수";
		new FieldTest().age = 1;
		//FieldTest.height = 189.5; // private 
		
		
		
		// 초기화 블럭 이해하기.
		InitBlockTest ib  = new InitBlockTest(); // 객체생성.
//		System.out.println("이름 :"+ ib.name+" 나이 :"+ib.age
//							+" 키 :"+ib.height);
		InitBlockTest ib2 =new InitBlockTest(); // 자동으로 생성.
		
		// Student클래스를 만들어보자
		// 모든 필드는 전체에서 접근할 수 있게 설정.
		// 이름 나이 학년 반 주소 키 설정.
		// 객체의 필드를 출력해보자.
		
		// 출력 했을 때
		// 본인의 정보가 출력되게 설정.
		
		Student stu = new Student(); 
		// class Student 기반으로 stu 객체 생성.
		// cmd+shift+o -> 알아서 import 해줌.
		
//		stu.name = "장희웅";
//		stu.age = 27;
//		stu.grade = 4;
//		stu.group = 5;
//		stu.address = "서울시 종로구";
//		stu.height = 168.0;
		
		System.out.println(stu.name+stu.age+stu.grade+stu.grade+stu.group
				+stu.address+ stu.height);
		System.out.println("stu: "+stu);
		
		Student stu2 = new Student(); 
		// 객체를 새로 생성하면 stu1과 같은 값이 안나옴.
		// new 연산자로 새로운 공간을 만들고 새로운 값을 저장하기 때문에.
		System.out.println("stu2 : "+stu2);
		
		System.out.println(stu2.name+stu2.age+stu2.grade+stu2.grade+stu2.group
				+stu2.address+ stu2.height);
		
		// 매개변수 있는 생성자를 이용
		// 생성시부터 원하는 데이터를 객체에 대입 할 수 있음.
		
		Student s2 = new Student("정유정",20,2,11,"산본",180.7);
		// 매개변수에 넣은 값의 자료형과 순서가 일치해야함.
		
		System.out.println(s2.name+s2.age+s2.grade
			+s2.group+s2.address+s2.height);
		
		Student s3 = new Student("김예진",26,"서울",190.5);
		System.out.println(s3.name+s3.age+s3.grade
				+s3.group+s3.address+s3.height);
		// 생성자가 여러개 있지만 조건에 맞는거 1개만 실행됨.
		
		
		// Animal 클래스 만들어서 출력하기
		// 종류, 이름, 나이, 서식지, 다리 수, 성별 
		// 개 바둑이 9 동네골목 4 남 -> 출력
		// 원숭이 원순이 10 일본 2 여 -> 출력
		// 코끼리 코돌이 77 냉장고 4 여 -> 출력
		
		Animal ani = new Animal("개 ", "바둑이 ", 9," 동네골목 ", 4,'남');
		Animal ani2 = new Animal("원숭이 ", "원순이 ", 10," 일본 ", 2,'여');
		Animal ani3 = new Animal("코끼리 ", "코돌이 ", 77," 냉장고 ", 4,'여');
		
		System.out.println(ani.jong+ani.name+ani.age+ani.home+ani.leg+" "+ani.gender);
		
		System.out.println(ani2.jong+ani2.name+ani2.age+ani2.home+ani2.leg+" "+ani2.gender);
		
		System.out.println(ani3.jong+ani3.name+ani3.age+ani3.home+ani3.leg+" "+ani3.gender);
		
		// 만약 클래스에 매개변수있는 생성자를 만들고 default 생성자를 만들지 않으면?
		// default 생성자를 자동으로 생성해주지 않음.
		
		
	}

}
