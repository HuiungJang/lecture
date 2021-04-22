package com.listener.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionListenerTestServlet", value = "/sessiontest.do")
public class SessionListenerTestServlet extends HttpServlet {
    private static final long serialVersionUID = 6085361471744071681L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session= request.getSession();

       session.setAttribute("loginUser","user1");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
