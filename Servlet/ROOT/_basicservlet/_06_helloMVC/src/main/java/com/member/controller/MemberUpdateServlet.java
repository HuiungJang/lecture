package com.member.controller;

import com.common.AESCrypto;
import com.member.model.service.Service;
import com.member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberUpdateServlet", value = "/memberupdate.do")
public class MemberUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = -548762598008501554L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
        // 필터를 통해 인코딩

        System.out.println("정보수정");

        String userId = request.getParameter("userId");
        String userPw = request.getParameter("password");
        String userName = request.getParameter("userName");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");

        String[] hobby= request.getParameterValues("hobby");
        // String hobby= String.join(",", request.getParameterValues("hobby"));
        // 이렇게 한줄로 바꿔도 된다.

        Member member = new Member(userId,userPw,userName,gender,age,email,phone,address,String.join(",",hobby));
        // 이렇게 넣는 것보다. setter를 사용해서 넣도록 하자.

        Service service = new Service();
        int result = service.updateMember(member);

        // 수정페이지로 이동해보자
        String loc = "/memberView.do?userId="+userId;
        request.setAttribute("msg",result>0?"회원정보가 수정되었습니다." : "회원정보 수정 실패");
        request.setAttribute("loc",loc);

       request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
