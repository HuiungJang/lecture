package com.emp.controller;

import com.emp.model.service.EmpService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MemberListServlet", value = "/memberList")
public class MemberListServlet extends HttpServlet {
    private static final long serialVersionUID = 1716095882205565428L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map> list = new EmpService().getList();

        request.setAttribute("list",list);
        request.getRequestDispatcher("/view/empList.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
