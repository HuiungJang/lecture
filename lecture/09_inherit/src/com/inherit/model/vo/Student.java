package com.inherit.model.vo;

import java.util.Objects;

public class Student extends Person{

//	private String name;
//	private int age;
//	private String gender;
	private int grade;
	private int group;
	private int number;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int age, String gender,
					int grade, int group, int number) {
		
		// �ڽĻ����ڿ��� �θ�����ڸ� ȣ�� �� �� �ִ�.
		// �����Ⱥθ�Ŭ������ ��Ī�ϴ� ����� -> super();
		// this()
		//super(); // �θ��� ����Ʈ �����ڸ� ȣ��.
		super(name, age, gender);
//		this.name =name;
//		this.age =age;
//		this.gender =gender;
		
		this.grade = grade;
		this.group = group;
		this.number =number;
	}
	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() { // Object���� ������ Override
		//	��ü�� ������ ����Ҷ� ��� 
		return getName()+grade + " " + group +" "+ number+" "+email;
		// ����� �޾Ҿ �θ�Ŭ�������� private�� ���������ڷ� ������ ��������� ��������x.
		// getter, setter ����ؼ� �����ؾ��Ѵ�.
		// �θ�Ŭ������ �ߺ��Ǵ� �޼ҵ���� �ƴҶ� ����.
		// email�� protected�� private�� �ٸ���
		// �ļ�Ŭ�������� ���������� �����ϴ�.
	}
	
	// ��ü�� ������ ����ϴ� �޼ҵ� �������ϱ�.
	// Person.print(); �޼ҵ� �ٽ� �����غ���.
	
	@Override // �ݵ�� ǥ�� 
	public void print() { // ����δ� �θ�޼ҵ�� �����ϰ� �ۼ���.
		System.out.println(super.getName()+ " "+super.getAge()
				+" "+super.getGender()+" "+grade+" "+group+" "+number);
		// super ����� ������ �θ�Ŭ�������� �����°��̶�� ���� Ȯ���� �����ֱ����ؼ�
		// ��� ����� ����.
	
	}
	
	// ��ü�� ���ϼ� ���ϱ� ���ؼ��� 
	// Object�� equals�� �������̵��ؼ� �����Ѵ�.
	@Override
	public boolean equals(Object obj) {
		// ���� ���� ��ü�ϱ� -> � ������ �����ϴٰ� �Ǵ����� ����
		if(obj instanceof Student) {
			// ��ü instanceof Ŭ����
			// ��ü�� Ŭ������ ����ȯ�� �������� Ȯ���ϴ� �޼ҵ� 
			// �����ϸ� true �Ұ����ϸ� false  ��ȯ��
			// �ַ� �θ�ü���� �ڽİ�ü���� Ȯ���ϴµ� ����Ѵ�.
			
			Student s =(Student)obj;
			if(super.getName().equals(s.getName()) ) {
				// �θ�Ŭ�������� name�� ��������
				// ���� ��ü�� name�� �����ͼ� 
				// ������ true�� ��ȯ.
				return true;
			}
			
//			if(super.getName().equals(s.getName()) &&
//					grade == s.grade) {
//				// �θ�Ŭ�������� name�� grade�� �������� 
//				// ���� ��ü�� name�� grade�� �����ͼ� 
//				// ������ true�� ��ȯ.
//				return true;
//			}
			
		}	
		return false;
	}
	
	
	
	
}
