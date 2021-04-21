package com.data.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "PageMoveServlet", value = "/pagemove.do")
public class PageMoveServlet extends HttpServlet {
    private static final long serialVersionUID = 1432501832460872594L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 특정 데이터를 request 객체에 보관을 하고 -> request 객체는 데이터를 보관할 수 있다.
        // 응답기능을 하는 서블릿을 호출하여 응답처리하는 로직구현
        // 서버내에서 다른 서블릿의 메소드를 실행 시키는 방법

        // 1. request 객체에 원하는 데이터 넣기
        // setAttribute("키값", Object); => request 객체에 특정테이터 저장
        request.setAttribute("msg","점심 맛있게 먹었나요?");
        request.setAttribute("today",new Date());
        // 만약 key 값이 동일하게 저장이 된다면?
        request.setAttribute("msg","request 객체에 데이터를 넣을 수 있어요");
        // 덮어쓰기 됨

        // 2. request 객체에 저장된 데이터 가져오기
        // getAttribute("키값"); -> request 객체에 저장된 값을 가져오는 기능
        String msg = (String) request.getAttribute("msg");
        Date today = (Date)request.getAttribute("today");

        System.out.println("msg:"+msg);
        System.out.println("today:"+today);

        // 페이지를 다른 서블릿으로 전환하자
        // 다른 서블릿을 호출해보자 -> getRequestDispatcher() 이용해서 처리
        // RequestDispatcher 객체가 생성이 되고 이 객체의 forward() 메소드를 이용하면
        // 지정한 서블릿이 호출됨
        // getRequestDispatcher("서블릿 맵핑주소 || jsp 주소");
        // RequestDispatcher.forward(request,response);
        RequestDispatcher rd = request.getRequestDispatcher("testperson.do");
        rd.forward(request,response);
        // 지정된 서블릿을 호출해서 실행함.
        // 최초 client가 요청한 주소에서 변경이 안됨
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
