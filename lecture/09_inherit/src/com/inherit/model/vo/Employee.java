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
	// 반드시 표기
	// 부모클래스의 메소드 중 현재 선언한 메소드와 일치하는 것이 있는지 확인해줌.
	public void print() {
		System.out.println(super.getName()+" "+super.getAge()
				+" "+super.getGender()+" "+department+" "+job+" "+salary);
		// super 사용한 이유는 부모클래스에서 가져온것이라는 것을 확실히 보여주기위해서
		// 없어도 상관은 없음.
		
	}
	
	@Override
	public String toString() {
		return getName()+getAge()+getGender()
		+" "+department+" "+job+" "+salary;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// 내가 만든 객체니까 -> 어떤 내용을 동일하다고 판단할지 결정
		if(obj instanceof Employee) {
			Employee e =(Employee)obj;
			if(super.getName().equals(e.getName())
					&& getDepartment().equals(e.department)
					&& getJob().equals(e.job)) {
				// 같은 클래스이기 때문에 get을 안써도 상관없다.
				// 이름 부서 직책이 같으면 같은사람으로 본다.
				// 같으면 true 반환
				return true;
			}
			
		}
		
		return false;
	}
	// 동등성 비교할때 주소값도 가상으로 동일하게 해주기.
		// Object hashCode() 메소드를 재정의해줌.
		// hashCode() -> 객체의 주소를 출력해주는 메소드
		// equals를 Overriding하여 구현할때는 hashCode까지 
		// Overriding 해야함.
		// equals Overriding 할때 넣은 값을 그대로 넣어준다.
		@Override
		public int hashCode() {
			return Objects.hash(getName(),department,job);
		}
	
}
