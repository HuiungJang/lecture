package com.mybatis.controller;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchStudentServlet", value = "/searchStudent")
public class searchStudentServlet extends HttpServlet {
    private static final long serialVersionUID = -4583745801473584614L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        List<Student> searchStudent = new MybatisService().searchStudent(email);

        request.setAttribute("list",searchStudent);
        request.getRequestDispatcher("/views/studentList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }
}
