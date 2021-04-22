package com.data.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(name = "InitParamServlet", value = "/initparam.do")
public class InitParamServlet extends HttpServlet {
    private static final long serialVersionUID = 1257821332909936525L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 초기값으로 설정한(web.xml에 init-param으로 미리 설정) 데이터 가져오기
        System.out.println(getInitParameter("email"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
