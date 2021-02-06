package com.test.run;

import com.poly.model.vo.Animal;
import com.poly.model.vo.Cat;
import com.poly.model.vo.Dog;
import com.poly.model.vo.Monkey;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Animal a = new Animal();
		// �߻�Ŭ������ ������ �Ұ�����.
		// new ����.
		
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
		
		
		// ���� ���ε��� �̿��ϸ� �����ϰ� �����Ҽ� �ִ�.
		// �θ� Ŭ����(Animal)�� bark() �޼ҵ带 ����� 
		// �ڽ� Ŭ������ bark()�� Override�� �Ѵ�.
		// �׷��� ���� ����ȯ �� �ʿ���� ����Ҽ��ִ�.
		for(Animal a5 :  a2) {
			//null ���� ���� ����ó��
			if(a5!= null) {
				System.out.println(a5.bark());
				System.out.println(a5);
				// dog class�� Override�� toStrig ȣ��
				// �θ��ڷ��� ������ �ڽĲ��� �־������ 
				// �ڽĲ��� �����Ѵ�.
			}
		}	
		
		
		
	}
	
	// �߻�Ŭ������ Ȱ���ϱ�
	public void abstractTest() {
//		Animal ani = new Animal();
		// �߻�Ŭ������ ������ �Ұ�����.
		// new ����.
		// �ڷ�������  ����� ������.
		Animal cat = new Cat(); // ��ӵ� ��ü�� ��������.
		// cat�� �ڽ�Ŭ�����ϱ� �ڷ������θ� ��밡�� 
		// �ڽ� ��ü�� �޴� ������ ���� �� ����.
		
//		Object objs =new Object[10];
		
		// �߻�޼ҵ带 �����ϸ� ������ �߻�Ŭ������ �����ؾ���.
		Animal[] animals = new Animal[10];
		for( Animal a : animals ) {
			System.out.println(a.bark());
		}
	}

}
