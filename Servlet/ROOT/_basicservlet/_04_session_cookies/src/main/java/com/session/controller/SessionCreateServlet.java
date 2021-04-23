package com.session.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionCreateServlet", value = "/sessiontest.do")
public class SessionCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 4372909050236821823L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // session 서버에 저장되는 데이터로
        // request 객체에서 getSession() 으로 생성이 되고
        // 클라이언트에 JSESSIONID로 생성된 session 객체의 id 값을 전송함
        // 다시 사이트에 접속 할 때 cookies 에 있는 JSESSIONID 값을 가져와 session 값을
        // 확인할 수 있다.
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10);
        session.setAttribute("checktest","있음");
        response.sendRedirect(request.getContextPath());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
