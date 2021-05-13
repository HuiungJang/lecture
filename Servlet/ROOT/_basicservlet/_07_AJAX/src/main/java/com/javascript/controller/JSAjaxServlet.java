package com.javascript.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JSAjaxServlet", value = "/ajaxTest.do")
public class JSAjaxServlet extends HttpServlet {
    private static final long serialVersionUID = 4771649507827186558L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");
        // ajax 요청에 대한 응답을 하는 서블릿
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print("ajax 요청에 대한 응답입니다."+userId);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
