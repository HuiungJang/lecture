package com.cookie.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckCookieServlet", value = "/checkcookie.do")
public class CheckCookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1404421162903766487L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // client 가 보낸 cookie 값 확인하기
        // cookie 값은 request 객체의 getCookies() 메소드를 이용해서 가져옴
        // getCookies() 반환형은 Cookie[] -? 서버에서 저장되는 Cookie 값은 한개가 아니기 때문에

        response.setContentType("text/html;charset=utf-8;");
        String html="<html>";
        html+="<body>";
        html+="<ul>cookie 확인";

        Cookie[] cookies = request.getCookies();
        // 저장된 쿠키가 없으면 null 반환
        if(cookies != null){
            for(Cookie c : cookies){
                html+="<li>"+c.getName()+" : "+c.getValue()+"</li>";
                // Cookie 값을 확인하려면 메소드를 이용한다.
                // getName(), get Value()
                System.out.println(" 키 : "+c.getName()+" 값 : "+c.getValue());
            }
        }
        html+="</ul>";
        html+="<h2><a href='deletecookie.do'>쿠키삭제</a></h2>";
        html+="<h2><a href='"+request.getContextPath()+"'>메인으로</a></h2>";
        html+="</body>";
        html+="</html>";
        response.getWriter().write(html);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
