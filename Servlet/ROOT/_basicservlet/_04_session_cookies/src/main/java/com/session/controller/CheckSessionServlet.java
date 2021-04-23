package com.session.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckSessionServlet", value = "/checksession.do")
public class CheckSessionServlet extends HttpServlet {
    private static final long serialVersionUID = 6316709797168921956L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // session에 있는 값 확인 하기
        // session을 가져올 때 getSession(true/ false);
        // true -> 세션이 있으면 세션을 가져오고 default 없으면 생성함
        // false -> 있으면 가져오고 없으면 null
        HttpSession session = request.getSession(false);
        System.out.println(session);
        if(session !=null) {
            String msg = (String) session.getAttribute("checktest");
            System.out.println(msg);
        }else{
            System.out.println("session 없음");
        }
        response.sendRedirect(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
