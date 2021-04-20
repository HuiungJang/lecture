package com.basicservlet.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = -7265385672946503710L;
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws
            ServletException,IOException {
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("<style>");
        out.write("h1{color:white; background-color:green;}");
        out.write("</style>");
        out.write("</head>");
        out.write("<body>");
        out.write("<h1>안녕 나는 장희웅이야~ 반가워~ 나 서블릿 잘 만들지</h1>");
        out.write("</body>");
        out.write("</html>");
    }
}
