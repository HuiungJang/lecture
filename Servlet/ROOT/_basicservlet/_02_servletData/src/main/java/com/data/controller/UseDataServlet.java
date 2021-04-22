package com.data.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UseDataServlet", value = "/usedata.do")
public class UseDataServlet extends HttpServlet {
    private static final long serialVersionUID = 941615956216321584L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 데이터 저장객체에 저장되어있는 데이터 호출하기
        ServletContext context =request.getServletContext();
        HttpSession session =request.getSession();

        String requestData = (String)request.getAttribute("request");
        String contextData = (String)context.getAttribute("context");
        String sessionData = (String)session.getAttribute("session");
        String html = "<html>";
        html+="<body>";
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        html+="<ul>";
        html+="<li> requestData:"+requestData+"</li>";
        html+="<li> contextData:"+contextData+"</li>";
        html+="<li> sessionData:"+sessionData+"</li>";
        html+="</ul>";
        html+="<button onclick='location.assign(\"/_02_servletData_war_exploded/sessiondel.do\")'>session삭제</button>";
        html+="</body>";
        html+="</html>";

        out.write(html);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
