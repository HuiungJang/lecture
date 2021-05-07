package com.member.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 6308292029157656135L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        내가한거
//        HttpSession session = request.getSession();
//        session.invalidate();
//
//        RequestDispatcher rd = request.getRequestDispatcher("");
//        rd.forward(request,response);

        // 샘이 한거
        // 1. session 불러오기
        HttpSession session =request.getSession(false);
        // 2. 세션이 있으면 삭제, 없으면 통과
        if(session!=null){
            session.invalidate();

            // 4. 로그아웃 성공시 메시지 띄우기
            request.setAttribute("msg","로그아웃 했습니다.");
            request.setAttribute("loc","/");

            RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg.jsp");
            rd.forward(request,response);
        }
        // 3. 응답페이지 지정
        // 메인화면으로 이동
//        response.sendRedirect(request.getContextPath());




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
