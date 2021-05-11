package com.notice.controller;

import com.notice.model.service.NoticeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MoveDeleteServlet", value = "/notice/deletenotice")
public class DeleteNoticeServlet extends HttpServlet {
    private static final long serialVersionUID = 8420127114959103677L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

        int result = new NoticeService().deleteNotice(noticeNo);

        String msg="";
        String loc="";

        if(result>0){
            msg="공지사항을 삭제했습니다.";
            loc="/notice/noticeList";
        }else{
            msg="공지사항 삭제가 실패했습니다.";
            loc="/";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("loc",loc);
        request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
