package com.basicservlet.controller;

// 일반 클래스를 서블릿 클래스로 만들기
// 서블릿 규약을 준수하면 된다.
// 서블릿 규약 -> 클래스에 HttpServlet 클래스를 상속받는다.
// javax.servlet.http.HttpServlet 클래스
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

// 상속을 받은 후 Servlet으로 역할 수행하기위해
// 두개의 메소드를 구현한다.
// 1. doGet()
// 2. doPost()
// -> 재정의 해서 로직(서비스)를 구현
// 위 메소드를 재정의 시에는 규약에 의해 ServletException 을 처리해야한다.
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// 서블릿 클래스 만들기
// 1. 클래스 생성
// 2. 클래스에 HttpServlet를 상속받음
// 3. 상속 후 doGet(), doPost() 메소드 구현
public class BasicServlet extends HttpServlet {

    private static final long serialVersionUID = -1657230970057032072L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("요청왔는데 실행 됨?");

        // HttpServletRequest : 사용자가 보낸 데이터를 저장하는 객체.
        // -> 데이터 관련된 기능 제공하는 객체

        // HttpServletResponse : 사용자에게 응답할 정보를 가지고 있는 객체


        // HttpServletResponse 객체를 이용해서 응답메시지 작성하기
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.write("<html>");
        out.write("<body>");
        out.write("<h1>내가 서블릿에서 반환한 내용</h1>");
        out.write("</body>");
        out.write("</html>");
    }
}
