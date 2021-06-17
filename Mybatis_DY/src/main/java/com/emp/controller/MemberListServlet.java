package com.emp.controller;

import com.emp.model.service.EmpService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MemberListServlet", value = "/memberList")
public class MemberListServlet extends HttpServlet {
    private static final long serialVersionUID = 1716095882205565428L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cPage;
        int numPerPage;

        try{
            cPage = Integer.parseInt(request.getParameter("cPage"));
        }catch (NumberFormatException e){
            cPage =1;
        }

        try{
            numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
        }catch (NumberFormatException e){
            numPerPage = 5;
        }

        int totalData = new EmpService().empCount();
        int totalPage = (int)Math.ceil((double)totalData/numPerPage);
        int pageBarSize = 5;
        int pageNo = ((cPage-1)/pageBarSize) *pageBarSize+1;
        int pageEnd = pageNo+pageBarSize -1;

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
        pageBar += "location.assign('"+request.getRequestURI()+"?cPage='+cPage);}";
        pageBar += "</script>";
//        List<Map> list = new EmpService().getList();
//        페이징 처리를 해보자.

        request.setAttribute("pageBar",pageBar);

        List<Map> list = new EmpService().getList(cPage,numPerPage);

        request.setAttribute("list",list);
        request.getRequestDispatcher("/view/empList.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
