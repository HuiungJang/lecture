package com.listener;

import java.util.Date;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//리스너구현 클래스 작성
public class ContextListenerTest implements ServletContextListener,ServletContextAttributeListener{

	
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		//ServletContext객체에 setAttribute로 값을 추가했을때 실행기능
		System.out.println("context에 값을 추가함");
		System.out.println(event.getName());
		System.out.println(event.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		//ServletContext객체에 removeAttribute로 값을 삭제했을때
		System.out.println("context에 값을 삭제함");
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("context에 값을 수정함");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//서버가 종료되면 실행되는 리스너 매소드
		System.out.println("서버가 종료됨..흑흑 망함...");
		Date today=new Date();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//서버가 시작되면 실행되는 리스너 매소드
		System.out.println("서버가 시작됨.");
		
	}
	
	
	
}
