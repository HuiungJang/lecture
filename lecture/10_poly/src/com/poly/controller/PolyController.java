package com.poly.controller;

import com.poly.model.vo.Employee;
import com.poly.model.vo.Person;
import com.poly.model.vo.Student;
import com.poly.model.vo.Tearcher;

public class PolyController {
	
	public void printObject(Object obj) {
		if(obj instanceof Student) {
			Student s= (Student)obj;
			System.out.println(s.getName()+s.getGrade()+s.getGroup());
		} else if(obj instanceof Employee) {
			Employee e= (Employee)obj;
			System.out.println(e.getName()+ e.getDept() + e.getJob() );
		}
	}
	
	
	public void printStudent(Student s ) {
		System.out.println(s.getName()+s.getAge()+s.getGrade()+s.getGroup());
		
	}
	
	public void printEmployee(Employee e) {
		System.out.println(e);
	}
	
	public void printTearcher(Tearcher t) {
		System.out.println(t.getName()+ t.getSubject()+t.getMajor());
	}
	
	public void printPerson(Person p) {
		
		System.out.println(p.getAddress()+p.getName()+p.getAge());
	}
	

}
