package com.basicservlet.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/life.do")
public class lifeServlet extends HttpServlet {
    private static final long serialVersionUID = 2065281219433524180L;

    public lifeServlet() {
        super();
        System.out.println("서블릿 기본생성자 호출");
    }
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy()메소드 호출-> 객체 삭제");

    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init()메소드 호출");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service()메소드 호출");
        super.service(req, res);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
