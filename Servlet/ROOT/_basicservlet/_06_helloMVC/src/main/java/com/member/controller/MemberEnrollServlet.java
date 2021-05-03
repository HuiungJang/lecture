package com.member.controller;

import com.common.JDBCTemplate;
import com.member.model.dao.MemberDao;
import com.member.model.service.Service;
import com.member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

import static com.common.JDBCTemplate.getConnection;

@WebServlet(name = "MemberEnrollServlet", value = "/memberenroll.do")
public class MemberEnrollServlet extends HttpServlet {
    private static final long serialVersionUID = -1924063707853272559L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 회원가입 로직 처리하기
        // 1. 클라이언트가 가입을 위해 전송하는 데이터를 받아옴
        // request.getParameter , getParameterValues()
        // 한글 입력시 깨짐. -> 인코딩해야함
        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String userPw = request.getParameter("password");
        String userName = request.getParameter("userName");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String[] hobby= request.getParameterValues("hobby");

        // 다중값을 보관하기 위해 vo 객체를 생성함.
        Member member = new Member(userId,userPw,userName,gender,age,email,phone,address,String.join(",",hobby));


        Service service = new Service();
        int result = service.enrollMember(member);

        request.setAttribute("msg",result>0?"회원가입이 완료되었습니다." : "회원가입 실패");
        request.setAttribute("loc","/");

        RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg.jsp");
        rd.forward(request,response);

        System.out.println(member);


//        request.getRequestDispatcher("/views/member/member.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
