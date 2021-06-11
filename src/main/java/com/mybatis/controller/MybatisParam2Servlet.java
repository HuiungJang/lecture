package com.mybatis.controller;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "MybatisParam2Servlet", value = "/paramAll")
public class MybatisParam2Servlet extends HttpServlet {
    private static final long serialVersionUID = -2831447848124620392L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String addr = request.getParameter("addr");

        Student s = new Student();
        s.setStudentName(name);
        s.setStudentEmail(email);
        s.setStudentTel(phone);
        s.setStudentAddr(addr);

        // set 으로 넣는 것과 동일함
        // build 패턴
//        s=Student.builder()
//                .studentName(name).studentEmail(email).studentTel(phone).studentAddr(addr)
//                .build();
//
//        System.out.println(s);

        // mybatis 데이터 전송
//        response.getWriter().append(new MybatisService().insertParamAll(s)>0?"success":"fail");



        Map<String,String[]> param= request.getParameterMap();
        Map<String,String> param2 = new HashMap<>();

//        param2.put("name",param.get("name")[0]);
//        param2.put("phone",param.get("phone")[0]);
//        param2.put("email",param.get("email")[0]);
//        param2.put("addr",param.get("addr")[0]);

        for(String key : param.keySet()){
            param2.put(key,param.get(key)[0]);
        }


        response.getWriter()
                .append(new MybatisService().insertParamMap(param2)>0?"success":"fail");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
