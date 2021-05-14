package com.jquery.controller;

import com.admin.model.service.AdminService;
import com.google.gson.Gson;
import com.member.model.vo.Member;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "JsonListDataServlet", value = "/json/listData")
public class JsonListDataServlet extends HttpServlet {
    private static final long serialVersionUID = 8111380725889306192L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String keyword= request.getParameter("keyword");
        List<Member> list = new AdminService().searchMember("username",keyword,1,10);

        // List 로 받아온 데이터를 JSON으로 전환해 넘기려면
        // JSONArray 클래스를 이용한다.
//        JSONArray jArray = new JSONArray();
//        for(Member m : list){
//            JSONObject jo = new JSONObject();
//            jo.put("userId",m.getUserId());
//            jo.put("userName",m.getUserName());
//            jo.put("age",m.getAge());
//            jo.put("email",m.getEmail());
//
//            jArray.add(jo);
//        }

        response.setContentType("application/json;charset=utf-8");
        new Gson().toJson(list,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
