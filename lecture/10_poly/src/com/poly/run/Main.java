package com.poly.run;

import com.poly.controller.PolyController;
import com.poly.model.vo.Employee;
import com.poly.model.vo.Person;
import com.poly.model.vo.Student;
import com.poly.model.vo.Tearcher;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("�⺻",20,"�����");
			
		System.out.println(p.getName()+p.getAge()+p.getAddress());
		
		Student s = new Student("������",19,"��⵵ �����",1,3,3);
		Employee e = new Employee("�����",29,"����� ���α�","������","���",100);
		
		System.out.println(s);
		System.out.println(e);
		
		// ������
		// �θ𺯼��� �ڽİ�ü�� �����ϴ� ��.
		// �ڷ����� �ٸ����� ���Կ����� ����
		// �ٸ� ���Թ޴� ���� �θ��϶���!
		p =s;
		System.out.println(p.getAddress()+ p.getAge()+ p.getName());
		
		
		Tearcher t = new Tearcher();
		Person p1 = new Person();
		
		p1 = new Tearcher();
		// �θ�Ÿ���� ������ �ڽİ�ü�� ����������
		// �� ������ �θ�Ŭ�������� ������ ���븸 ���ٰ�����.
		// p�� s�� �����ؼ�.
		// p. <<<< �������� s���ִ°��� ����.
		
		// �����Ϸ��� �ݵ�� ����������ȯ�� �ؾ���.
		// ���ٿ����ڰ� �ֿ켱 �����̶�
		// (Student)p.   <<< �̷��� �ȵ�.
		// ((Student)p). << ��ȣ�ѹ��� ����� �ؾ���.
		System.out.println( ((Student)p).getGrade() );
		
		// Person p �� ����� ����ִ��� �ƴ� ���� �����ұ�?
		// ����� �𸥴�.
		// ������ �̰��� �˰� �������� 
		// instanceof�� ����Ѵ�.
		// �θ𺯼��� instanceof Ȯ��Ŭ������
		// �θ𺯼��� �ִ°��� Ȯ��Ŭ������ �¾�?
		// ������ true �ƴϸ� false
		
		
		PolyController pc = new PolyController();
//		pc.printStudent(s);
//		pc.printEmployee(e);
//		pc.printPerson(p1);
//		pc.printTearcher( new Tearcher("�ڹ�","����") );
		pc.printObject(s);
		pc.printObject(e);
		
		// �������� �̿��ϸ� �����͸� ���� �����Ҽ� �ֵ�.
		
		Student[] students= new Student[10];
		Employee[] emp = new Employee[10];
		Tearcher[] tea = new Tearcher[10];
		
		students[0] = new Student("������",19,"��⵵ ����",1,2,3);
		students[1] = new Student("ȫ����", 26,"�����",2,3,13);
		emp[0] = new Employee("�迹��", 26, "�����","������","������",200);
		emp[1] = new Employee("������", 26, "�����","������","��������",100);
		
		// ���α׷����� �����ϰ��ִ� data�� ���ϼ���
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
		
		System.out.println("�����ǰ� �ִ� ��� : "+ count);
		
		// �������� �̿��ؼ� �Ѱ� �ڷ������� ��ü�迭�� �����ϸ� ���ϰ� ���������ϴ�.
		
		Person[]  ps = new Person[40];
		ps[0] = new Student("������",19,"��⵵ ����",1,2,3);
		ps[1] = new Student("ȫ����", 26,"�����",2,3,13);
		ps[2] = new Employee("�迹��", 26, "�����","������","������",200);
		ps[3] = new Employee("������", 26, "�����","������","��������",100);
		
		
		// �и��Ϸ��� instanceof ����ؼ� �з�����
		count = 0;
		for(int i = 0 ; i<ps.length; i++) {
			if(ps[i] != null)
				count++;
		}
		
		System.out.println("�����ǰ� �ִ� ��� : "+ count);
		
		// �θ��ڷ��� �迭���� �ڽİ�ü�� ����غ���.
		
		for(int i = 0 ; i<ps.length; i++) {
			if(ps[i] instanceof Student) {  
				// ps[i]�� Student�� ������ 
				// ������ ���������� Student���� Employee��
				// �ΰ��� ps�� �����߱⶧���� �з��Ѵ�.
				
				Student s1 = (Student)ps[i];
				System.out.println(s1.getName()+s1.getGrade());
			}else if(ps[i] instanceof Employee) {
				// ps[i]�� Employee�� ������ 
				Employee e1 = (Employee)ps[i];
				System.out.println(e1.getName()+ e1.getDept());
			}
			//System.out.println(ps[i]);
		}
		
		// for - each ��
		// �迭���� �����͸� �ٷ� ������ִ±���.
		for(Person p2 : ps) { 
			// ps �迭�� 0������ �����ͼ� p2�� ����.
			// p2�� �ڷ����� �迭�� �ڷ����� �ݵ�� ���ƾ� ��밡����.
			
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
