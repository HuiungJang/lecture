package com.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //request.getSession() -> 메소드가 실행되면 session이 생성
        System.out.println("세션생성");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // session.invalidate() -> 메소드가 실행 되면 실행
        System.out.println("세션소멸");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Session 생성");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
