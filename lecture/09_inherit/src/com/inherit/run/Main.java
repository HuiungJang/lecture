package com.inherit.run;

import java.util.Scanner;

import com.inherit.model.vo.Employee;
import com.inherit.model.vo.Student;

public class Main {
	public static void main(String[] args) {
		Student s = new Student();
		Employee e = new Employee();
		// 클래스는 기본적으로 Object클래스를 상속받고 있다.
		System.out.println(s.hashCode() );
		// Obhject가 선언한 메소드.
		
		System.out.println(e.toString() );
		
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.hashCode() );
		
		// 상속관계를 설정하면 자식클래스(sub)는 
		// 부모클래스(super)의 멤버변수, 메소드를 활용할 수 있다.
//		s.setDepartment("자바학부");
//		System.out.println(s.getDepartment());
		
//		String gender =s.getGender();
		
		Student s1 = new Student();
		System.out.println();
		s1.setName("유병승");
		s1.setAge(19);
		s1.setGender("남자");
		s1.setGrade(1);
		s1.setGroup(2);
		s1.setNumber(7);
		
		System.out.println(s1.getName()+" "+s1.getAge()+" "+s1.getGender()+" "
							+s1.getGrade()+" "+s1.getGroup()+" "+s1.getNumber());
		
		
		e.setName("김태희");
		e.setAge(26);
		e.setGender("여자");
		e.setDepartment("연예부");
		e.setJob("연기");
		e.setSalary(10000);
		
		System.out.println(e.getName()+e.getAge()+e.getGender());
		
		// 생성시부터 데이터를 넣고 초기화하기
		Student s2 = new Student("최찬규",27,"남자",3,3,9);
		System.out.println(s2.getName()+s2.getAge()
						+ s2.getGender()+s2.getGroup()+s2.getNumber());
		
	}
	
}
