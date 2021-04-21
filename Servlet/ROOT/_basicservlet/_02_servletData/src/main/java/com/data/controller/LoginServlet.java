package com.data.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 8239367328934591724L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get 방식으로 처리하기");
        // 클라이언트가 보낸 데이터 확인
        // 클라이언트가 front에서 보낸 데이터를 parameter라고 지칭
        // 클라이언트가 보낸 데이터는 HttpServletRequest 객체에 저장
        // getParameter("key|| input 태그의 name 속성에 있는 값")메소드를 이용해서 가져옴


        // post 방식으로 전송된 영어,숫자, 제외한 데이터는 글자깨짐 현상이 발생한다.
        // 해결하기 위해서는
        // setCharacterEncoding("utf-8") 메소드를 사용한다.
        request.setCharacterEncoding("utf-8");

        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        // 가져온 데이터는 String 타입을 갖는다.
        System.out.println("아이디: "+userId+" 패스워드 : "+userPw);

        response.setContentType("text/html;charset=utf-8");
        String html="<html>";
        html+="<body>";
        html+="<h1>당신이 입력한 아이디는 "+userId+"이고</h1>";
        html+="<h3>비밀번호는"+userPw.substring(0,2)+"****</h3>";
        html+="</body>";
        html+="</html>";
        PrintWriter out = response.getWriter();
        out.write(html);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post 방식으로 처리하기");
        doGet(request,response);
        // 받은 값을 전부 doGet메소드로 보내면
        // 로직을 doGet 메소드에 한 번만 구현하면 된다.
        // doGet 은 기본값이니까.

    }
}
