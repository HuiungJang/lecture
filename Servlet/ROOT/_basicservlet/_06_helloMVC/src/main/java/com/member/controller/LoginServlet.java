package com.member.controller;

import com.member.model.service.Service;
import com.member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.websocket.Session;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 7101664638528192148L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. client가 보낸 값 가져오기
        String id = request.getParameter("userId");
        String pw = request.getParameter("userPw");

        // 2. 가져온 값이 DB에 있는지 확인
        Member m = new Service().login(id,pw);

        /*
        requset -> 요청이 들어오면 생성되고 다른 요청 들어오면 사라짐
        session -> 생성되면 invalidate 될때 까지 남음
        context -> 서버가 시작하면 생성되고 중단되면 사라짐
         */

        if (m == null) {
            // m 값이 null 이면 실패

        }else{
            // m값이 null 아니면 성공
//            request.setAttribute("loginMember",m);
//            이걸로 저장하면 새로운 requset가 들어오면 초기화됨 -> 저장 x

            HttpSession session = request.getSession();
            session.setAttribute("loginMember",m);
        }

        // 로그인 성공, 실패 -> 메인으로
        // 페이지 이동하는 방법 2개, sendRedirect / RequestDispatcher
        RequestDispatcher rd = request.getRequestDispatcher("");
        rd.forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
