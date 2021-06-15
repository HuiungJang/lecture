package com.mybatis.controller;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MybatisSelectStudentListServlet", value = "/selectStudentList")
public class MybatisSelectStudentListServlet extends HttpServlet {
    private static final long serialVersionUID = -2689966385253226801L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = new MybatisService().selectList();

        request.setAttribute("list",list);
        request.getRequestDispatcher("/views/studentList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
