package com.obj.main;

import com.obj.model.vo.Animal;

public class Run4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal cat = new Animal();
		cat.dong("고양이", " 야옹이", 20, 4);
		cat.printDong();
		
		Animal cat1 = new Animal();
		cat1.setJong("호랑이");
		cat1.setAge(20);
		cat1.setLeg(4);
		cat1.setName("무케");
		System.out.println( cat1.getJong() +" "+cat1.getName() 
							+ " "+ cat1.getAge() +" "+ cat1.getLeg() );
		
		
		Animal dog = new Animal();
		dog.dong("개", " 뽀삐", 3, 4 );
		dog.printDong();
		
		Animal dog1 = new Animal();
		dog1.setJong("늑대");
		dog1.setAge(12);
		dog1.setLeg(4);
		dog1.setName("울프");
		System.out.println( dog1.getJong() +" "+dog1.getName() 
							+ " "+ dog1.getAge() +" "+ dog1.getLeg() );
		
		
		Animal monkey = new Animal();
		monkey.dong("원숭이"," 숭이", 6, 2 );
		monkey.printDong();
		
		Animal monkey1 = new Animal();
		monkey1.setJong("침팬지");
		monkey1.setAge(33);
		monkey1.setLeg(2);
		monkey1.setName("캡틴");
		System.out.println( monkey1.getJong() +" "+monkey1.getName() 
							+ " "+ monkey1.getAge() +" "+ monkey1.getLeg() );
		
		
//		Animal.tmp; //static 변수이지만 private로 접근제한 되어있어 직접접근 안됨.
		// staic 접근하는 방법.
		// 클래스명.필드명, 메소드명
		// Animal.tmp;
		// getter와 setter가 static으로 선언이 되어야함.
		
		Animal.setTmp(20); 
		//staic은 공용으로 사용이 가능하다.
		
		
//		System.out.println( cat.getTmp() );
//		System.out.println( dog.getTmp() );
		// 다른 객체에서 tmp에 접근했지만 둘다 접근이 가능은 함.
		
	}

}
