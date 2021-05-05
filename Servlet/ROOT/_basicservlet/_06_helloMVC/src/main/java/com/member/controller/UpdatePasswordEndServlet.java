package com.member.controller;

import com.member.model.service.Service;
import com.member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePasswordEndServlet", value = "/updatepasswordend")
public class UpdatePasswordEndServlet extends HttpServlet {
    private static final long serialVersionUID = 7976357844343239000L;

    // 전송된 회원아이디의 패스워드를 변경하는 메소드

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("userId");

        String psw = request.getParameter("password");
        String pswNew = request.getParameter("password_new");

        Member m = new Service().login(id,psw);

        String msg= "";
        String loc="";
        String script="";
        if(m != null){

            int result = new Service().changePw(id, pswNew);
            msg = result > 0 ? "비밀번호가 변경되었습니다." : "비밀번호 변경이 실패했습니다.";
            script = "window.close();";
            // 스크립트 문구를 request에 담아서 보낼 수 도 있다.

        }else {
            msg="비밀번호가 일치하지 않습니다.";
            loc="/updatepassword?userId="+id;
        }

        request.setAttribute("msg", msg);
        request.setAttribute("loc", loc);
        request.setAttribute("close",script);
        request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
