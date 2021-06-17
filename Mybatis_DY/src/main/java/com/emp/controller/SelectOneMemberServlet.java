package com.emp.controller;

import com.emp.model.service.EmpService;
import com.emp.model.vo.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SelectOneMemberServlet", value = "/selectOneEmp")
public class SelectOneMemberServlet extends HttpServlet {
    private static final long serialVersionUID = -7189014609142219808L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String no = request.getParameter("no");
        Employee e = new EmpService().selectOneEmp(no);

        System.out.println(e);
        request.setAttribute("e",e);
        request.getRequestDispatcher("/view/test.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
