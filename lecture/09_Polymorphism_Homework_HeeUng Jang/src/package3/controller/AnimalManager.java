package package3.controller;

import package3.model.vo.Animal;
import package3.model.vo.Cat;
import package3.model.vo.Dog;

public class AnimalManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal[] ani = new Animal[5];
		
		ani[0] = new Dog("��1","������1",12);
		ani[1] = new Cat("�߿�!","�����","��","���");
		ani[2] = new Cat("��","������","�Ʒ���","������");
		ani[3] = new Dog("��2","������2",12);
		ani[4] = new Dog("��3","������3",12);
		
		for(int i = 0; i<ani.length; i++) {
			if(ani[i] instanceof Dog) {
				((Dog)ani[i]).speak();
			}else
				((Cat)ani[i]).speak();
		}
		
	}
}
