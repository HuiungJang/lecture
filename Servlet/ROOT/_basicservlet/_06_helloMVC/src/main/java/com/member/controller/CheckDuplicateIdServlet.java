package com.member.controller;

import com.common.AESCrypto;
import com.member.model.service.Service;
import com.member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckDuplicateIdServlet", value = "/checkDuplicateId")
public class CheckDuplicateIdServlet extends HttpServlet {
    private static final long serialVersionUID = -1582607331568543857L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  클라이언트가 전송한 id 값이 db에 있는지 확인해주는 서비스
        String id = request.getParameter("userId");
        // DB에서 확인한 로직
        Member m = new Service().checkDuplicateId(id);

        //결과에서 m이 null 이면 중복되지않음
        request.setAttribute("result",m);
        request.getRequestDispatcher("/views/member/checkDuplicateId.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
