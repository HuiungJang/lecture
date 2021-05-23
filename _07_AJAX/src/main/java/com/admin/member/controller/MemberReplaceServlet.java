package com.member.controller;

import com.common.AESCrypto;
import com.member.model.service.Service;
import com.member.model.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MemberReplaceServlet", value = "/memberView.do")
public class MemberReplaceServlet extends HttpServlet {
    private static final long serialVersionUID = -2082680917646969575L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트가 보낸 아이디를 기준으로 정보를 가져옴

        String userId = request.getParameter("userId");
        Member m = new Service().checkDuplicateId(userId);

        // 암호화된 정보를 복호화하기
        try{
            m.setPhone(AESCrypto.decrypt(m.getPhone()));
            m.setEmail(AESCrypto.decrypt(m.getEmail()));
        }catch (Exception e){
            e.printStackTrace();
        }

        // m = null 이면 회원정보 수정불가(일치하는 회원이 없음)
        // msg페이지로 이동알림 메세지를 출력하고 로그인을 취소하고 메인화면으로 이동
        // m != null 이면 회원정보 수정으로 들어감

        String view="";
        String loc ="/logout";
        String msg="";
        if(m==null){
            msg="가입된 회원이 아닙니다.";
            view="/views/common/msg.jsp";
        }else{
            view = "/views/member/replaceMemberInfo.jsp";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("loc",loc);
        request.setAttribute("member",m);

        request.getRequestDispatcher(view).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
