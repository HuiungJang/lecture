package com.user.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MessageViewServlet", value = "/msg.do")
public class MessageViewServlet extends HttpServlet {
    private static final long serialVersionUID = 6120218900511693872L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String html="<html>";
        html+="<body>";
        html+="<script>";
        html+="alert('"+request.getAttribute("msg")+"')";
        html+="location.replace('"+request.getContextPath()+"/mainpage.do');";
        html+="</script>";
        html+="</body>";
        html+="</html>";
        response.getWriter().write(html);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
