package com.data.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginCheckServlet", value = "/logincheck.do")
public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자가 보낸 데이터를 입력받고 가져오기
        String id = request.getParameter("userId");
        String pw = request.getParameter("userPw");

        if(id.equals("admin") && pw.equals("1234")){
            HttpSession session =request.getSession();
            session.setAttribute("login",id);
        }


        // 가져온 데이터의 아이디가 admin 비밀번호가 1234이면
        // 가져온 데이터를 session에 저장 아니면 저장 x
        RequestDispatcher rd = request.getRequestDispatcher("printmain.do");
        rd.forward(request,response);

        // 화면 출력 서블릿으로 전환
        // printmain.do
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
