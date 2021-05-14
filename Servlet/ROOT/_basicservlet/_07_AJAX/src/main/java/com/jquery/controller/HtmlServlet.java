package com.jquery.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HtmlServlet", value = "/ajax/htmlTest.do")
public class HtmlServlet extends HttpServlet {
    private static final long serialVersionUID = -2112698004194808026L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg","ㅋㅋㅋㅋㅋㅋㅋㅋ");
        request.getRequestDispatcher("/views/result/htmlTest.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

