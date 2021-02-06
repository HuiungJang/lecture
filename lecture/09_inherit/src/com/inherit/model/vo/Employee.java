package com.inherit.model.vo;

import java.util.Objects;

public class Employee extends Person{
//	private String name;
//	private int age;
//	private String gender;
	private String department;
	private String job;
	private int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	

	public Employee(String name, int age, String gender, 
					String department, String job, int salary) {
		super(name, age, gender);
//		this.name = name;
//		this.age = age;
//		this.gender = gender;
		this.department = department;
		this.job = job;
		this.salary = salary;
	}


//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}


	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}


	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}


	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override 
	// �ݵ�� ǥ��
	// �θ�Ŭ������ �޼ҵ� �� ���� ������ �޼ҵ�� ��ġ�ϴ� ���� �ִ��� Ȯ������.
	public void print() {
		System.out.println(super.getName()+" "+super.getAge()
				+" "+super.getGender()+" "+department+" "+job+" "+salary);
		// super ����� ������ �θ�Ŭ�������� �����°��̶�� ���� Ȯ���� �����ֱ����ؼ�
		// ��� ����� ����.
		
	}
	
	@Override
	public String toString() {
		return getName()+getAge()+getGender()
		+" "+department+" "+job+" "+salary;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// ���� ���� ��ü�ϱ� -> � ������ �����ϴٰ� �Ǵ����� ����
		if(obj instanceof Employee) {
			Employee e =(Employee)obj;
			if(super.getName().equals(e.getName())
					&& getDepartment().equals(e.department)
					&& getJob().equals(e.job)) {
				// ���� Ŭ�����̱� ������ get�� �Ƚᵵ �������.
				// �̸� �μ� ��å�� ������ ����������� ����.
				// ������ true ��ȯ
				return true;
			}
			
		}
		
		return false;
	}
	// ��� ���Ҷ� �ּҰ��� �������� �����ϰ� ���ֱ�.
		// Object hashCode() �޼ҵ带 ����������.
		// hashCode() -> ��ü�� �ּҸ� ������ִ� �޼ҵ�
		// equals�� Overriding�Ͽ� �����Ҷ��� hashCode���� 
		// Overriding �ؾ���.
		// equals Overriding �Ҷ� ���� ���� �״�� �־��ش�.
		@Override
		public int hashCode() {
			return Objects.hash(getName(),department,job);
		}
	
}
