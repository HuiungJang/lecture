package com.jspaction.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ExtraDataServlet", value = "/extraData")
public class ExtraDataServlet extends HttpServlet {
    private static final long serialVersionUID = 6522700553338270233L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie c = new Cookie("test","오늘은여기까지");
        c.setMaxAge(24*60*60);
        response.addCookie(c);

        request.getRequestDispatcher("/view/eltest/extraData.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
