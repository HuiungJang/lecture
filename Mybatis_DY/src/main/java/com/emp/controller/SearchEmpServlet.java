package com.emp.controller;

import com.emp.model.service.EmpService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SearchEmpServlet", value = "/searchEmp")
public class SearchEmpServlet extends HttpServlet {
    private static final long serialVersionUID = -1585029513052580964L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String col = request.getParameter("searchType");
        String val = request.getParameter("searchKeyword");
        String gender = request.getParameter("gender");

        int salary;

        try {
            salary = Integer.parseInt(request.getParameter("salary"));
        }catch (NumberFormatException e){
            salary = 0;
        }
        String salaryRef= request.getParameter("le_ge");

        Map<String,Object> param
//                = Map.of("key",col,"val",val,"gender",gender != null? gender:"");
        = new HashMap<>();
        param.put("key",col);
        param.put("val",val);
        param.put("gender",gender);

        param.put("salary",salary);
        param.put("salaryRef",salaryRef);

        param.put("hireDate",request.getParameter("hireDate"));
        param.put("H_le_ge", request.getParameter("H_le_ge"));

        List<Map> res = new EmpService().searchEmp(param);

        request.setAttribute("list",res);
        request.getRequestDispatcher("/view/empList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
