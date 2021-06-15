package com.mybatis.controller;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "MybatisStudentMapServlet", value = "/selectStudentMap")
public class MybatisStudentMapServlet extends HttpServlet {
    private static final long serialVersionUID = -7416849192512621452L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));

        Map student = new MybatisService().selectStudentMap(no);

        System.out.println(student);
        request.setAttribute("student",student);
        request.getRequestDispatcher("/views/student.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
