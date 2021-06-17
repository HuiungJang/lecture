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

        String[] deptCode = request.getParameterValues("deptCode");

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

        param.put("deptCode",deptCode);

        List<Map> res = new EmpService().searchEmp(param);

        // 페이징 처리
        int cPage;
        int numPerPage;

        try{
            cPage= Integer.parseInt(request.getParameter("cPage"));
        }catch (NumberFormatException e){
            cPage=1;
        }

        try{
            numPerPage= Integer.parseInt(request.getParameter("numPerPage"));
        }catch (NumberFormatException e){
            numPerPage=5;
        }

        int totalData= res.size();
        int totalPage = (int)Math.ceil((double)totalData/numPerPage);
        int pageBarSize= 5;
        int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
        int pageEnd = pageNo+pageBarSize-1;

        String pageBar = "<ul class ='pagination justify-content-center pagination-sm'>";
        if(pageNo == 1){
            pageBar+="<li class='page-item disabled'>";
            pageBar+="<a class='page-link' href='#' tabindex='-1'>이전</a>";
            pageBar+="</li>";
        }else{
            pageBar+="<li class='page-item'>";
            pageBar+="<a class='page-link' href='javascript:fn_paging("+(pageNo-1)+")' tabindex='-1'>이전</a>";
            pageBar+="</li>";
        }

        while(!(pageNo>pageEnd||pageNo>totalPage) ){
            if(pageNo == cPage){
                pageBar+="<li class='page-item active'>";
                pageBar+="<a class='page-link'>"+pageNo+"</a>";
                pageBar+="</li>";
            }else{
                pageBar+="<li class='page-item'>";
                pageBar+="<a class='page-link' href='javascript:fn_paging("+(pageNo)+")'>"+pageNo+"</a>";
                pageBar+="</li>";
            }
            pageNo++;
        }

        if(pageNo > totalPage ){
            pageBar+="<li class='page-item disabled'>";
            pageBar+="<a class='page-link'>다음</a>";
            pageBar+="</li>";
        }else{
            pageBar+="<li class='page-item'>";
            pageBar+="<a class='page-link' href='javascript:fn_paging("+(pageNo)+")'>다음</a>";
            pageBar+="</li>";
        }
        pageBar += "</ul>";
        pageBar += "<script>";
        pageBar += "function fn_paging(cPage){";
        pageBar += "location.assign('"+request.getRequestURI()
                +"?cPage='+cPage"
                +"&searchType='"+param.get(col)+""
                +"&searchKeyword='"+param.get(val)+""
                +"&gender='"+param.get(gender)+""
                +"&salary='"+param.get(salary)+""
                +"&salaryRef='"+param.get(salaryRef)+"";

        String p = "";
        for(int i=0; i<deptCode.length; i++) {
            p +="+"+"&deptCode='" + param.get(deptCode[i]) + ""+"+";
        };

        pageBar += p;

        pageBar +="&hireDate='"+param.get(request.getParameter("hireDate"))+""
                +"&H_le_ge='"+param.get(request.getParameter("H_le_ge"))+""
                +");}";
        pageBar += "function checked(){";

        pageBar += "};";
        pageBar += "</script>";




        List<Map> paging = new EmpService().searchEmpPaging(param,cPage,numPerPage);

        request.setAttribute("pageBar",pageBar);
        request.setAttribute("param",res);
        request.setAttribute("list",paging);
        request.getRequestDispatcher("/view/empList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
