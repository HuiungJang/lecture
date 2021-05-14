package com.jquery.controller;

import com.jquery.member.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CSVServlet", value = "/ajax/csvTest.do")
public class CSVServlet extends HttpServlet {
    private static final long serialVersionUID = -228561388870603282L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ajax 요청에 csv 방식으로 데이터는 응답해줌
        List<Member> list = new ArrayList<>();
        list.add(new Member("박보검","01012345677","parkBogum.jpg"));
        list.add(new Member("줄리아 로버츠","01012345677","juliaRoberts.jpg"));
        list.add(new Member("멧데이번","01012345677","mattDamon.jpg"));


        // 각 항목은 , 로 구분하고 각 Member 별 \n 구분
        String csv="";
        for(int i = 0; i<list.size(); i++){
            if(i!=0) csv+="\n";

            csv+=list.get(i);
        }

        System.out.println(csv);

        response.setContentType("test/csv;charset=utf-8");
        response.getWriter().println(csv);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
