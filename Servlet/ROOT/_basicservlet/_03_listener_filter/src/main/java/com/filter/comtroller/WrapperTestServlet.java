package com.filter.comtroller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WrapperTestServlet", value = "/wrapper.do")
public class WrapperTestServlet extends HttpServlet {
    private static final long serialVersionUID = -3420733356637507645L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = request.getParameter("info");
        String msg = request.getParameter("msg");
        System.out.println("info: "+info);
        System.out.println("msg: "+msg);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
