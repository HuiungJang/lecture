package com.filter.comtroller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FilterTestServlet", value = "/filtertest.do")
public class FilterTestServlet extends HttpServlet {
    private static final long serialVersionUID = -5912794062906194955L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("data");

        System.out.println("전송된 데이터 : "+name);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
