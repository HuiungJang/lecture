package com.test.run;

import com.poly.model.vo.Animal;
import com.poly.model.vo.Cat;
import com.poly.model.vo.Dog;
import com.poly.model.vo.Monkey;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Animal a = new Animal();
		// 추상클래스는 생성이 불가능함.
		// new 못씀.
		
		Cat c = new Cat("c","cat",1,4);
		Monkey m = new Monkey("m","monkey",12,2);
		Dog d = new Dog("d","dog",2,4);
		
//		a =c;
//		((Cat) a).catBark(c);
//		
//		System.out.println(c.catB());
//		
//		a = d;
//		((Dog) a).dogBark(d);
//		
//		a = m;
//		((Monkey) a).monkeyBark(m);
//		System.out.println();
		
		
		Animal[] a2 = new Animal[6];
		
		a2[0] = new Cat("c","cat",1,4);
		a2[1] = new Cat("c2","cat2",2,5);
		a2[2] = new Monkey("m","monkey",12,2);
		a2[3] = new Monkey("m2","monkey2",13,3);
		a2[4] = new Dog("d","dog",2,4);
		a2[5] = new Dog("d2","dog2",3,5);
		
		for(Animal a3 : a2) {
			if( a3 instanceof Cat) {
				Animal a4 =(Animal)a3;
				((Cat) a4).catBark(c);
				System.out.println(a3);
				System.out.println();
				
			}else if( a3 instanceof Dog) {
				Animal a4 =(Animal)a3;
				((Dog) a4).dogBark(d);
				System.out.println(a3);
				System.out.println();
				
			}else if( a3 instanceof Monkey) {
				Animal a4 =(Animal)a3;
				((Monkey) a4).monkeyBark(m);
				System.out.println(a3);
				System.out.println();
				
			}
		}
		
		
		// 동적 바인딩을 이용하면 간편하게 적용할수 있다.
		// 부모 클래스(Animal)에 bark() 메소드를 만들고 
		// 자식 클래스에 bark()를 Override를 한다.
		// 그러면 굳이 형변환 할 필요없이 출력할수있다.
		for(Animal a5 :  a2) {
			//null 값에 대한 예외처리
			if(a5!= null) {
				System.out.println(a5.bark());
				System.out.println(a5);
				// dog class에 Override된 toStrig 호출
				// 부모자료형 변수에 자식꺼를 넣어놨을때 
				// 자식꺼를 실행한다.
			}
		}	
		
		
		
	}
	
	// 추상클래스를 활용하기
	public void abstractTest() {
//		Animal ani = new Animal();
		// 추상클래스는 생성이 불가능함.
		// new 못씀.
		// 자료형으로  사용이 가능함.
		Animal cat = new Cat(); // 상속된 객체만 들어갈수있음.
		// cat이 자식클래스니까 자료형으로만 사용가능 
		// 자식 객체만 받는 변수를 만들 수 있음.
		
//		Object objs =new Object[10];
		
		// 추상메소드를 선언하면 무조건 추상클래스로 선언해야함.
		Animal[] animals = new Animal[10];
		for( Animal a : animals ) {
			System.out.println(a.bark());
		}
	}

}
