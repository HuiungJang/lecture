package com.mybatis.controller;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GetInfoServlet", value = "/getInfo")
public class GetInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 2566231007717891690L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String,Object>> info = new MybatisService().getInfo();

        request.setAttribute("info",info);
        request.getRequestDispatcher("/").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
