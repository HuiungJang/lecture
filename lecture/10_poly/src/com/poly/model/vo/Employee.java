package com.poly.model.vo;

import java.util.Objects;

public class Employee extends Person{
	
	private String dept;
	private String job;
	private int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	

	public Employee(String name, int age, String address, String dept, String job, int salary) {
		super(name, age, address);
		this.dept = dept;
		this.job = job;
		this.salary = salary;
	}



	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
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
	public String toString() {
		return getName() +" " +getAge() + " " +getAddress()
				+" " +dept + " " +job+" " + salary;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee e = (Employee)obj;
			if(super.getAddress().equals(e.getAddress())
					&& super.getName().equals(e.getName())
					&& super.getAge() == e.getAge()
					&& dept.equals(e.getDept())
					&& job.equals(e.getJob())
					&& salary == e.salary) {
				
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), getAge(), getAddress(),
					dept, job, salary);
	}
	
}
