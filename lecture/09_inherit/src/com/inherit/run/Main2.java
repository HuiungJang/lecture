package com.inherit.run;

import com.inherit.model.vo.Cat;
import com.inherit.model.vo.Dog;
import com.inherit.model.vo.Employee;
import com.inherit.model.vo.Student;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("유병승",19,"남",1,3,3 );
		Employee e = new Employee("김상현",28,"남","개발팀","개발자",100);
		
		s.print(); // 객체의 정보를 출력하는 기능을 하는 메소드.
		e.print(); // 객체의 정보를 출력하는 기능을 하는 메소드.
		
		
		System.out.println(s.toString());
		
		// 참조형자료형 변수는 변수를 호출했을 때 주소가 나와야함.
		// 자바 내부에서 참조형 자료형 변수를 호출했을때 Object클래스의
		// toString()메소드를 호출하게 되어잇음.
		System.out.println(s);
		// toString을 Override를 했기때문에 주소값이 아니라
		// 입력값이 나옴
		System.out.println(e);
		// 재정의를 하지 않았기 때문에 
		// 주소값이 나옴.
		
		
		// 객체의 동등성비교하기
		Student bs = new Student("유병승",19,"남",1,3,3);
		Student sh = new Student("김상현",19,"남",1,3,3);
		
//		System.out.println(bs == sh); // false 
		// new 연산자로 새로운 객체를 만들었고 
		// 그 객체는 서로 주소값이 다르기 때문에 
		// 정보가 같아도 주소값이 달라서 같은 객체가 아니다.
//		System.out.println(bs.equals(sh)); // false
		// equals -> this == object이기 때문에 
		// == 과 같다.
		
		//.equals Override 후 name이 같으면 같은 객체라고 본다.
		
		
		// employee객체의 동등성 비교를 구현하자.
		// 이름 부서 직책이 같으면 같은 직원으로 판단하자.
		
		
		Employee a = new Employee("김상현",28,"남","개발팀","개발자",100);
		Employee b = new Employee("김상현",28,"남","개발팀","개발자",100);
		System.out.println(a.equals(b));
		System.out.println( a.hashCode() );
		System.out.println( b.hashCode() );
		
		Cat c = new Cat("야옹",2,"고양이과");
		System.out.println("고양이는 "+ c.bark());
		
		Dog d = new Dog("뽀삐",2,"개과");
		System.out.println("강아지는 "+ d.bark());

	}

	
}
