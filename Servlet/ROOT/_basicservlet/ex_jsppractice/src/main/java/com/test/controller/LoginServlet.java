package com.test.controller;

import com.test.model.service.Testservice;
import com.test.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = -8122881516909936387L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트가 보낸 데이터 가져오기
        String id = request.getParameter("userId");
        String pw = request.getParameter("userPw");

        // DB에 userId, pw 일치하는 회원이 있는지 확인

        Testservice service = new Testservice();
        Member m = service.login(id,pw);

        if(m!=null){
            // 로그인 성공
            HttpSession session = request.getSession();
            session.setAttribute("loginMember",m);
        }else{
            // 로그인 실패
        }

        // 응답페이지 설정
        RequestDispatcher rd = request.getRequestDispatcher("");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
