package com.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

// Wrapper 클래스 만들기
// HttpServletRequestWrapper 클래스를 상속받아서 구현함
// 상속받아서 구현하게 되면 매개변수 있는 생성하 한개를 선언해야함.

public class MyWrapper extends HttpServletRequestWrapper {

    // HttpServletRequest 객체를 매개변수로 받아야함.
    // 반드시 선언해야한다.
    public MyWrapper(HttpServletRequest request) {
        super(request);
    }

    // 개발자의 로직대로 구현할 메소드를 재정의 하면 됨.

    @Override
    public String getParameter(String key) {
        // HttpServletRequest.getParameter 값을 가져와서
        // -HU- 문자열을 붙여서 출력해주는 메소드로 변경
        return super.getParameter(key)+"-HU-";
    }
}
