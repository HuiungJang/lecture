package com.member.controller;

import com.member.model.service.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberDeleteServlet", value = "/memberDelete")
public class MemberDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = -7428886888634420355L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("userId");

        int result = new Service().deleteMember(id);

        request.setAttribute("msg",result>0?"회원탈퇴가 완료되었습니다.":"회원탈퇴 실패");
        request.setAttribute("loc","/");
        HttpSession session =request.getSession();
        session.invalidate();

        request.getRequestDispatcher("").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
