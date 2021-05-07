package com.admin.controller;

import com.admin.model.service.AdminService;
import com.member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchMemberServlet", value = "/admin/searchMember")
public class SearchMemberServlet extends HttpServlet {
    private static final long serialVersionUID = -881912918370927433L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchType =request.getParameter("searchType");
        String keyword = request.getParameter("searchKeyword");

        List<Member> result = new AdminService().searchMember(searchType,keyword);
        request.setAttribute("members",result);

        // 숙제
        // 1. 조회된거 페이징 처리하기
        
        request.getRequestDispatcher("/views/admin/memberList.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
