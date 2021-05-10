package com.notice.controller;

import com.notice.model.service.NoticeService;
import com.notice.model.vo.Notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NoticeServlet", value = "/notice/noticeList")
public class NoticeServlet extends HttpServlet {
    private static final long serialVersionUID = 2937124316140185038L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 페이징 처리
        int cPage;
        int numPerPage;
        try{
            cPage=Integer.parseInt(request.getParameter("cPage"));
        }catch (NumberFormatException e){
            cPage=1;
        }

        try{
            numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
        }catch (NumberFormatException e){
            numPerPage=5;
        }
        List<Notice> viewList = new NoticeService().viewList(cPage,numPerPage);

        int totalData= new NoticeService().countList();
        int totalPage=  (int)(Math.ceil((double)(totalData/numPerPage)));
        int pageBarSize= 5;
        int pageNo= ((cPage-1)/pageBarSize) * pageBarSize+1;
        int pageEnd= pageNo+pageBarSize -1;

        String pageBar="";

        if(pageNo==1){
            pageBar+="<span>이전</span>";
        }else{
//            pageBar+="<a href='"+request.getContextPath()+"/notice/noticeList?cPage="+(cPage-1)+"&numPerPage="+numPerPage
//                    +"'>이전</a>";
            // 공지사항 개수를 고정하고 싶다면 보낼 필요가 없다
            pageBar+="<a href='"+request.getContextPath()+"/notice/noticeList?cPage="+(cPage-1)+"'>이전</a>";
        }

        while(!(pageNo>pageEnd || pageNo>totalPage)){
            if(cPage== pageNo){
                pageBar+="<span>"+pageNo+"</span>";
            }else{
//                pageBar+="<a href='"+request.getContextPath()+"/notice/noticeList?cPage="+cPage+
//                        "&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
                pageBar+="<a href='"+request.getContextPath()+"/notice/noticeList?cPage="+cPage+"'>"+pageNo+"</a>";
            }
            pageNo++;
        }

        if(pageNo>totalPage){
            pageBar+="<span>다음</span>";
        }else{
//            pageBar+="<a herf='"+request.getContextPath()+"/notice/noticeList?cPage="+cPage+
//                    "&numPerPage="+numPerPage+"'>다음</a>";
            pageBar+="<a herf='"+request.getContextPath()+"/notice/noticeList?cPage="+cPage+"'>다음</a>";
        }


        request.setAttribute("pageBar",pageBar);

        // 페이지 값으로 DB에서 값 가져오기
        request.setAttribute("viewList",viewList);

        request.getRequestDispatcher("/views/notice/noticeList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
