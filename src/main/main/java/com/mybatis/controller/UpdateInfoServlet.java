package com.mybatis.controller;

import com.mybatis.model.service.MybatisService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UpdateInfoServlet", value = "/updateInfo")
public class UpdateInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 8985532683712108074L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String,String[]> param = request.getParameterMap();
        Map<String,String> param2 = new HashMap<>();

        for(String key : param.keySet()){
            param2.put(key,param.get(key)[0]);
        }

        int result = new MybatisService().updateInfo(param2);

        response.getWriter().append(result>0?"success":"fail");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
