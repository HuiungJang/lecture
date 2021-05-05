package com.member.controller;

import com.member.model.service.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberDeleteServlet", value = "/memberDelete")
public class MemberDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = -7428886888634420355L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 내가한거
//        request.setCharacterEncoding("UTF-8");
//
//        String id = request.getParameter("userId");
//
//        int result = new Service().deleteMember(id);
//
//        request.setAttribute("msg",result>0?"회원탈퇴가 완료되었습니다.":"회원탈퇴 실패");
//        request.setAttribute("loc","/");
//        HttpSession session =request.getSession();
//        session.invalidate();
//
//        request.getRequestDispatcher("").forward(request,response);

        // 클라이언트가 보낸 id 값(PK값)을 기준으로 조회함
        // 샘이 한거
        String userId = request.getParameter("userId");
        int result = new Service().deleteMember("userId");

        String msg = result>0?"정상적으로 탈퇴되었습니다.":"탈퇴에 실패했습니다. 다시 시도해주세요";
        String loc = result>0?"logout":"/memberView.do";

        request.setAttribute("msg",msg);
        request.setAttribute("loc",loc);

        request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
