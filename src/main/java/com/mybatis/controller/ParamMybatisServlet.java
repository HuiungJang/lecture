package com.mybatis.controller;

import com.mybatis.model.service.MybatisService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ParamMybatisServlet", value = "/paramMybatis")
public class ParamMybatisServlet extends HttpServlet {
    private static final long serialVersionUID = 1412461708767974288L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        int result = new MybatisService().insertParam(name,email);
        response.getWriter().append(result>0?"success":"fail");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
