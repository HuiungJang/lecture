package com.jquery.controller;

import com.jquery.member.vo.Member;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "JsonBasicServlet", value = "/json/basicData")
public class JsonBasicServlet extends HttpServlet {
    private static final long serialVersionUID = -6807518270373670078L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 서버에서 json으로 응답하기 위해서는 라이브러리를 이용하면 됨
        // json-simple 이용해서 json 으로 응답하기
        // 단일 객체와 다수객체(List)를 json 방식으로 보낼수 있다.
        // 단일 객체 -> JSONObject 클래스 이용
        // 다수 객체 -> JSONArray 클래스 이용 -> JSONObject를 담는 객체임

        Member m = new Member("박보검","01012341234","parkBogum.jpg");

        JSONObject jo= new JSONObject();
        jo.put("name",m.getName());
        jo.put("phone",m.getPhone());
        jo.put("profile",m.getProfile());
        jo.put("age",new Integer(29));
        jo.put("height",new Double(199.1));

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jo); // 객체로 넘김
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
