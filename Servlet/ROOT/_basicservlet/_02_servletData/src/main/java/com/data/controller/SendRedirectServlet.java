package com.data.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet", value = "/sendredirect.do")
public class SendRedirectServlet extends HttpServlet {
    private static final long serialVersionUID = 7040678740248424678L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 서버에서 전환시키는 두번째 방법
        // response 객체의 sendRedirect() 메소드를 이용하기
        response.sendRedirect("testperson.do");
        // 1. url 주소창이 매개변수 값으로 변경
        // request에서 있던 값들 전부 소멸 -> 새로 서버에 요청하는 것

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
