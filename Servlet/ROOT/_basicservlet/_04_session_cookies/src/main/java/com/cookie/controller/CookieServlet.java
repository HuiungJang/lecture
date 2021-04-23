package com.cookie.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieServlet", value = "/cookietest.do")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 3656510256176706948L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 쿠키 생성해서 client 에게 저장시키기.
        Cookie c = new Cookie("userId","heeung"); // Cookie 객체 생성시 저장할 key,value 값을 생성자의 매개변수로 넣는다.

        c.setMaxAge(24*60*60); // 1일동안 쿠키 유지

        // 생성된 쿠키는 client에게 저장요청을 한다.
        // response.addCookie() 메소드를 이용한다.
        response.addCookie(c);

        Cookie c2 = new Cookie("email","jhw1345@gmail.com");
        c2.setMaxAge(10);
        response.addCookie(c2);

        // 응답페이지 작성하기
        response.setContentType("text/html;charset=utf-8;");
        String html="<html>";
        html+="<body>";
        html+="<p>쿠키를 저장했습니다</p>";
        html+="<button onclick='location.assign(\"checkcookie.do\");'>저장된 쿠키확인</button>";
        html+="</body>";
        html+="</html>";
        response.getWriter().write(html);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
