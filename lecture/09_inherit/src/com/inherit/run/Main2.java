package com.inherit.run;

import com.inherit.model.vo.Cat;
import com.inherit.model.vo.Dog;
import com.inherit.model.vo.Employee;
import com.inherit.model.vo.Student;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("������",19,"��",1,3,3 );
		Employee e = new Employee("�����",28,"��","������","������",100);
		
		s.print(); // ��ü�� ������ ����ϴ� ����� �ϴ� �޼ҵ�.
		e.print(); // ��ü�� ������ ����ϴ� ����� �ϴ� �޼ҵ�.
		
		
		System.out.println(s.toString());
		
		// �������ڷ��� ������ ������ ȣ������ �� �ּҰ� ���;���.
		// �ڹ� ���ο��� ������ �ڷ��� ������ ȣ�������� ObjectŬ������
		// toString()�޼ҵ带 ȣ���ϰ� �Ǿ�����.
		System.out.println(s);
		// toString�� Override�� �߱⶧���� �ּҰ��� �ƴ϶�
		// �Է°��� ����
		System.out.println(e);
		// �����Ǹ� ���� �ʾұ� ������ 
		// �ּҰ��� ����.
		
		
		// ��ü�� ������ϱ�
		Student bs = new Student("������",19,"��",1,3,3);
		Student sh = new Student("�����",19,"��",1,3,3);
		
//		System.out.println(bs == sh); // false 
		// new �����ڷ� ���ο� ��ü�� ������� 
		// �� ��ü�� ���� �ּҰ��� �ٸ��� ������ 
		// ������ ���Ƶ� �ּҰ��� �޶� ���� ��ü�� �ƴϴ�.
//		System.out.println(bs.equals(sh)); // false
		// equals -> this == object�̱� ������ 
		// == �� ����.
		
		//.equals Override �� name�� ������ ���� ��ü��� ����.
		
		
		// employee��ü�� ��� �񱳸� ��������.
		// �̸� �μ� ��å�� ������ ���� �������� �Ǵ�����.
		
		
		Employee a = new Employee("�����",28,"��","������","������",100);
		Employee b = new Employee("�����",28,"��","������","������",100);
		System.out.println(a.equals(b));
		System.out.println( a.hashCode() );
		System.out.println( b.hashCode() );
		
		Cat c = new Cat("�߿�",2,"����̰�");
		System.out.println("����̴� "+ c.bark());
		
		Dog d = new Dog("�ǻ�",2,"����");
		System.out.println("�������� "+ d.bark());

	}

	
}
