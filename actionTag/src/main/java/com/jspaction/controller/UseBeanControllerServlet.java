package com.jspaction.controller;

import com.jspaction.model.vo.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UseBeanControllerServlet", value = "/useBeanTest")
public class UseBeanControllerServlet extends HttpServlet {
    private static final long serialVersionUID = -9107231673945891527L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = new Person();
        p.setName("유병승");
        p.setAge(19);
        p.setAddr("경기도 시흥시");

        request.setAttribute("person",p);
        request.getRequestDispatcher("/view/useBeanTest.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
