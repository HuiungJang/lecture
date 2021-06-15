package com.mybatis.controller;

import com.mybatis.model.service.MybatisService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InsertTestServlet", value = "/insertStudentTest")
public class InsertTestServlet extends HttpServlet {
    private static final long serialVersionUID = -4062983693946272945L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        int result = new MybatisService().insertStudent();
        response.getWriter().append(result>0?"입력성공":"입력실패");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
