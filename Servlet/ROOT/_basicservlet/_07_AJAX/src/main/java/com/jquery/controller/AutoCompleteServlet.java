package com.jquery.controller;


import com.admin.model.service.AdminService;
import com.member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AutoCompleteServlet", value = "/ajax/search.do")
public class AutoCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = -7913903956644734636L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword= request.getParameter("keyword");
        List<Member> members = new AdminService().searchMember("username",keyword,0,0);

        System.out.println(members);

        String csv="";
        for(int i =0; i<members.size(); i++){
            if(i != 0 ) csv+=",";
            csv += members.get(i).getUserName();

        }
        System.out.println(csv);
        response.setContentType("text/csv;charset=utf-8");
        response.getWriter().write(csv);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
