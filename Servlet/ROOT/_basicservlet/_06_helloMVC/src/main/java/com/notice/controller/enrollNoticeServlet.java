package com.notice.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "enrollNoticeServlet", value = "/enrollNotice")
public class enrollNoticeServlet extends HttpServlet {
    private static final long serialVersionUID = -8714646858108587073L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String title = request.getParameter("title");
        String filePath =request.getParameter("filePath");
        String content = request.getParameter("content");
//        ((Member) session.getAttribute("loginMember")).getUserId();



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
