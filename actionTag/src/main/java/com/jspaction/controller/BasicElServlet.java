package com.jspaction.controller;

import com.jspaction.model.vo.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "BasicElServlet", value = "/basicEl")
public class BasicElServlet extends HttpServlet {
    private static final long serialVersionUID = 7890467004735935546L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> list = Arrays.asList(new Person[]{
                new Person("양호준",27,"서울시"),
                new Person("장희웅",27,"서울시"),
                new Person("김두호",28,"서산")
        });

        Person p = new Person("이진주",23,"경기도");

        request.setAttribute("p",p);
        request.setAttribute("list",list);

        request.getSession().setAttribute("name","유병승");
        getServletContext().setAttribute("email","123123@naver.com");

        request.getRequestDispatcher("/view/eltest/dataTest.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
