package com.admin.controller;

import com.admin.model.service.AdminService;
import com.common.AESCrypto;
import com.member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MemberListServlet", value = "/admin/memberList")
public class MemberListServlet extends HttpServlet {
    private static final long serialVersionUID = 28397928389643109L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       // 관리자가 아닌 사용자가 접근했을 때 예외 처리하기
        HttpSession session = request.getSession(false);
        Member loginMember = (Member)session.getAttribute("loginMember");

        // 클릭시 전체 회원에 대한 정보를 조회해서 가져옴
        List<Member> list = new AdminService().viewMember();

        if(session == null || loginMember == null || !loginMember.getUserId().equals("admin")){
            // 잘못된 경로로 접근하셨습니다.  이 페이지 사용권한이 없습니다.
            request.setAttribute("msg","잘못된 경로로 접근하셨습니다.  이 페이지 사용권한이 없습니다.");
            request.setAttribute("loc","/");
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);
        }else{

            for(Member m : list) {
                try {
                    m.setPhone(AESCrypto.decrypt(m.getPhone()));
                    m.setEmail(AESCrypto.decrypt(m.getEmail()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // 가져온 값을 jsp 페이지에 전달
            request.setAttribute("members",list);
            request.getRequestDispatcher("/views/admin/memberList.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
