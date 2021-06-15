package com.mybatis.controller;

import com.mybatis.model.service.MybatisService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "selectStudentListMapServlet", value = "/selectStudentListMap")
public class selectStudentListMapServlet extends HttpServlet {
    private static final long serialVersionUID = -4726970937281574911L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String,Object>> selectStudentListMap = new MybatisService().getInfo();

        request.setAttribute("listMap",selectStudentListMap);
        request.getRequestDispatcher("/views/student.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
