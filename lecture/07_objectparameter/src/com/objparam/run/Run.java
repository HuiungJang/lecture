package com.objparam.run;

import com.objparam.controller.ObjectParam;
import com.objparam.model.vo.Lunch;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectParam op = new ObjectParam();
		int su =100;
		String str = "호호호";
		/*
		 * 메인 메소드와 클래스의 메소드는 저장공간이 다르다
		 * 메인메소드에 기본자료형으로 아무리 추가를 해도
		 * 클래스의 메소드는 수정이 안됨.
		 * 수정하려면 클래스의 메소드에서 메인 메소드로 리턴값을 주어야한다.
		 * 기본자료형은 원본값 수정이 안된다.
		 * 복사본을 수정하는 것 
		 * 
		 */
		
		// op.basicParam(su, str);
		su = op.basicParam(su, str);
		// 클래스에서 날아온 리턴값을 받음.
		System.out.println(su + " : " +str);
		
		
		
		// 배열은 어떨까? 
		int[] arr = {1,2,3,4};
		op.arrParam(arr);
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		// 메인 메소드에 배열은 초기화하고 클래스의 메소드로 보내면
		// 클래스의 메소드로 배열의 주소값이 간다. 
		// 메소드에서 배열 값을 넣으면 값이 수정이 된다.
		// 즉, HEAP 메모리의 주소값을 알면 접근이 가능하고 수정도 가능하다.
		
		// 객체는 어떨까?
		Lunch l = new Lunch();
		l.setCategory("한식");
		l.setName("청국장");
		l.setPrice(9000);
		l.setCapacity(1);
		
		System.out.println(l.getName() + " "+l.getCategory() 
					+ " "+l.getPrice()+ " "+l.getCapacity());
		
		op.objParam(l);
		System.out.println(l.getName() + " "+l.getCategory() 
		+ " "+l.getPrice()+ " "+l.getCapacity());
		// HEAP영역에 생성된 저장소는 주소값을 알면
		// 어떤 STACK영역에서도 접근이 가능함.
		
		
//		op.setCheck("대입!! 값");
//		op.checkTest();
		new ObjectParam().setCheck("이건?"); 
		// new 연산자를 사용하면 새로운 객체를 만든것. n1이라고하면 
		new ObjectParam().checkTest(); 
		// 새로운 객체를 또 만듦. n2라는 객체를 만들고
		// n1 객체에 값이 들어있지만 n2에서 출력하는것
		// n1객체에 값을 넣었으니 n2에는 당연히 값이 없고 
		// n2에서 출력하니 default 값인 null과 메소드가 실행되어서 10이 나오고 
		// null10이 출력됨.
		
	}

}
