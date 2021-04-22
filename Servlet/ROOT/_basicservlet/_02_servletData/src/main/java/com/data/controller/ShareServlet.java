package com.data.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShareServlet", value = "/share.do")
public class ShareServlet extends HttpServlet {
    private static final long serialVersionUID = 5799097589301665927L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 데이터 저장 할 수 있는 객체 가져오기
        // 1. ServletContext 객체 불러오기 -> 서버전역에서 사용 가능한 데이터를 저장 할 수 있는 객체
        // 저장내용 유효기간 -> 서버 runtime 부터 서버 shutdown 까지
        // request.getServletContext();
        // 이렇게 가져와도 됨
        ServletContext context = getServletContext();
        context.setAttribute("context","contextData");

        // 2. HttpSession 객체 불러오기 -> 개발자가 지정한 기간동안 사용자 별로 데이터를 저장할 수 있는 객체
        // 저장내용 유효기간 -> session 생성 순간부터 session 소멸 될 때 까지.
        // ( invalidate() )
        HttpSession session = request.getSession();
        // client 에게 session id값이 부여됨
        session.setAttribute("session","sessionData");

        // 3.HttpServletRequest 객체 -> client 가 Request를 보내면 생성되는 객체
        // 요청(request)에 대한 응답(response)을 하면 종료
        request.setAttribute("request","requestData");

        // RequestDispatcher를 이용해서 처리하기
//        RequestDispatcher rd = request.getRequestDispatcher("usedata.do");
//        rd.forward(request,response); // 다른 서블릿으로 전환

        // sendRedirect로 이동하면 ?
        response.sendRedirect("usedata.do");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
