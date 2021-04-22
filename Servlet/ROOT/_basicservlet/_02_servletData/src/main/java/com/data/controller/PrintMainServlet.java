package com.data.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PrintMainServlet", value = "/printmain.do")
public class PrintMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String sessionData = (String)session.getAttribute("login");


        String html = "<html>";
        html+="<body>";

        if(sessionData != null){
            // 로그인 성공시
            html+="<h1>로그인 성공 "+sessionData+"님 로그인을 환영합니다.</h1>";
            html+="<button onclick='location.replace(\""+request.getContextPath()+"/sessiondel.do\")'>로그아웃</button>";
        }else{
            // 로그인 실패시
            html+="<h1 style='color:red;'>로그인 실패</h1>";
            html+="<button onclick='location.replace(\""+request.getContextPath()+"/views/login.html\")'>로그아웃</button>";
        }

        html+="</body>";
        html+="</html>";

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(html);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
