package com.poly.controller;

import com.poly.model.vo.Circle;
import com.poly.model.vo.Rectangle;
import com.poly.model.vo.Shape;

public class Controller {	
	public static void main(String[] args) {
		Circle[] cArr = new Circle[3];
		Rectangle[] rArr = new Rectangle[3];
		
		Circle c = new Circle();
		
		cArr[0] = new Circle(3);
		cArr[1] = new Circle(4);
		cArr[2] = new Circle(5);
		
		for(int i = 0; i< cArr.length; i++) {
			System.out.println( c.draw( cArr[i].getRadius()) );
		}
		
		
		Rectangle r = new Rectangle();
				
		rArr[0] = new Rectangle(3,5);
		rArr[1] = new Rectangle(4,5);
		rArr[2] = new Rectangle(5,5);

		for(int i = 0; i< rArr.length; i++) {
			System.out.println( r.draw(rArr[i].getWidth(),rArr[i].getHeight()) );
		}
		
		System.out.println();
		
		
		Shape[] sha = new Shape[6];
		
		sha[0] = new Circle(3);
		sha[1] = new Circle(4);
		sha[2] = new Circle(5);
		sha[3] = new Rectangle(3,5);
		sha[4] = new Rectangle(4,5);
		sha[5] = new Rectangle(5,5);
		
		for(int i = 0; i<sha.length; i++) {
			if(sha[i] instanceof Circle) {
				System.out.println( c.draw( ((Circle) sha[i]).getRadius()) );
			}else if(sha[i] instanceof Rectangle) {
				System.out.println( r.draw(((Rectangle) sha[i]).getWidth(),((Rectangle) sha[i]).getHeight()) );
			}
		}
		
	}
	

}


