package com.poly.run;

import com.poly.controller.PolyController;
import com.poly.model.vo.Employee;
import com.poly.model.vo.Person;
import com.poly.model.vo.Student;
import com.poly.model.vo.Tearcher;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("기본",20,"서울시");
			
		System.out.println(p.getName()+p.getAge()+p.getAddress());
		
		Student s = new Student("유병승",19,"경기도 시흥시",1,3,3);
		Employee e = new Employee("김상현",29,"서울시 구로구","개발팀","사원",100);
		
		System.out.println(s);
		System.out.println(e);
		
		// 다형성
		// 부모변수가 자식객체를 보관하는 것.
		// 자료형이 다르지만 대입연산이 가능
		// 다만 대입받는 것이 부모일때만!
		p =s;
		System.out.println(p.getAddress()+ p.getAge()+ p.getName());
		
		
		Tearcher t = new Tearcher();
		Person p1 = new Person();
		
		p1 = new Tearcher();
		// 부모타입의 변수에 자식객체를 대입했을때
		// 그 변수는 부모클래스에서 선언한 내용만 접근가능함.
		// p에 s를 대입해서.
		// p. <<<< 접근으로 s에있는것을 못씀.
		
		// 접근하려면 반드시 강제적형변환을 해야함.
		// 접근연산자가 최우선 연산이라
		// (Student)p.   <<< 이렇게 안됨.
		// ((Student)p). << 괄호한번더 씌우고 해야함.
		System.out.println( ((Student)p).getGrade() );
		
		// Person p 에 어떤것이 들어있는지 아는 것이 가능할까?
		// 결론은 모른다.
		// 때문에 이것을 알고 싶을때는 
		// instanceof를 사용한다.
		// 부모변수명 instanceof 확인클래스명
		// 부모변수에 있는것이 확인클래스가 맞아?
		// 맞으면 true 아니면 false
		
		
		PolyController pc = new PolyController();
//		pc.printStudent(s);
//		pc.printEmployee(e);
//		pc.printPerson(p1);
//		pc.printTearcher( new Tearcher("자바","음악") );
		pc.printObject(s);
		pc.printObject(e);
		
		// 다형성을 이용하면 데이터를 쉽게 관리할수 있따.
		
		Student[] students= new Student[10];
		Employee[] emp = new Employee[10];
		Tearcher[] tea = new Tearcher[10];
		
		students[0] = new Student("유병승",19,"경기도 시흥",1,2,3);
		students[1] = new Student("홍서연", 26,"서울시",2,3,13);
		emp[0] = new Employee("김예진", 26, "서울시","개발팀","개발자",200);
		emp[1] = new Employee("김태희", 26, "서울시","영업팀","영업부장",100);
		
		// 프로그램에서 관리하고있는 data를 구하세요
		int count = 0;
		for(int i = 0 ; i<students.length; i++) {
			if(students[i] != null) 
				count++;
		}
		
		for(int i = 0 ; i<emp.length; i++) {
			if(emp[i] != null)
				count++;
		}
		
		for(int i = 0 ; i<tea.length; i++) {
			if(tea[i] != null)
				count++;
		}
		
		System.out.println("관리되고 있는 사람 : "+ count);
		
		// 다형성을 이용해서 한개 자료형으로 객체배열에 보관하면 편리하게 관리가능하다.
		
		Person[]  ps = new Person[40];
		ps[0] = new Student("유병승",19,"경기도 시흥",1,2,3);
		ps[1] = new Student("홍서연", 26,"서울시",2,3,13);
		ps[2] = new Employee("김예진", 26, "서울시","개발팀","개발자",200);
		ps[3] = new Employee("김태희", 26, "서울시","영업팀","영업부장",100);
		
		
		// 분리하려면 instanceof 사용해서 분류하자
		count = 0;
		for(int i = 0 ; i<ps.length; i++) {
			if(ps[i] != null)
				count++;
		}
		
		System.out.println("관리되고 있는 사람 : "+ count);
		
		// 부모자료형 배열에서 자식객체를 출력해보기.
		
		for(int i = 0 ; i<ps.length; i++) {
			if(ps[i] instanceof Student) {  
				// ps[i]가 Student가 맞으면 
				// 위에서 다형성으로 Student형과 Employee형
				// 두개를 ps에 저장했기때문에 분류한다.
				
				Student s1 = (Student)ps[i];
				System.out.println(s1.getName()+s1.getGrade());
			}else if(ps[i] instanceof Employee) {
				// ps[i]가 Employee가 맞으면 
				Employee e1 = (Employee)ps[i];
				System.out.println(e1.getName()+ e1.getDept());
			}
			//System.out.println(ps[i]);
		}
		
		// for - each 문
		// 배열에서 데이터를 바로 출력해주는구문.
		for(Person p2 : ps) { 
			// ps 배열을 0번부터 가져와서 p2에 저장.
			// p2의 자료형과 배열의 자료형이 반드시 같아야 사용가능함.
			
			// System.out.println(p2);
			if(p2 instanceof Student) {
				Student s1 = (Student)p2;
				System.out.println(s1.getName()+s1.getGrade() );
			}else if(p2 instanceof Employee) {
				Employee e1 = (Employee)p2;
				System.out.println(e1.getName()+e1.getJob());
			}
		}
		
		
	}

}
