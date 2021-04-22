package com.data.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessiondDelServlet", value = "/sessiondel.do")
public class SessionDelServlet extends HttpServlet {
    private static final long serialVersionUID = -5977449724061901986L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // session 객체는 개발자가 삭제하기 전까지 유지된다.
        // session 객체를 삭제하는 방법 : session.invalidate() 메소드를 호출

        HttpSession session = request.getSession();
        session.invalidate();
        // 세션을 삭제하는 기능.

        RequestDispatcher rd = request.getRequestDispatcher("usedata.do");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
