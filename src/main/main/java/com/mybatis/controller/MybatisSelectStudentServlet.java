package com.mybatis.controller;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MybatisSelectStudentServlet", value = "/selectStudent")
public class MybatisSelectStudentServlet extends HttpServlet {
    private static final long serialVersionUID = -469765631537810745L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        Student s = new MybatisService().selectStudent(no);
        // sql 의 컬럼명과 vo의 멤버변수 이름이 일치하면 자동으로 매칭해서 가져옴
        // 다르거나 없으면 null
        request.getRequestDispatcher("/views/student.jsp").forward(request,response);
        System.out.println(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
