package package3.controller;

import package3.model.vo.Animal;
import package3.model.vo.Cat;
import package3.model.vo.Dog;

public class AnimalManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal[] ani = new Animal[5];
		
		ani[0] = new Dog("멍1","강아지1",12);
		ani[1] = new Cat("야옹!","고양이","집","노랑");
		ani[2] = new Cat("멍","강아지","아래집","점박이");
		ani[3] = new Dog("멍2","강아지2",12);
		ani[4] = new Dog("멍3","강아지3",12);
		
		for(int i = 0; i<ani.length; i++) {
			if(ani[i] instanceof Dog) {
				((Dog)ani[i]).speak();
			}else
				((Cat)ani[i]).speak();
		}
		
	}
}
