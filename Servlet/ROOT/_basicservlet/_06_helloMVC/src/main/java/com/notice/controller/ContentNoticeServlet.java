package com.notice.controller;

import com.notice.model.service.NoticeService;
import com.notice.model.vo.Notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContentNoticeServlet", value = "/notice/detailNotice")
public class ContentNoticeServlet extends HttpServlet {
    private static final long serialVersionUID = -8517916371822883327L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int contentNo = Integer.parseInt(request.getParameter("contentNo"));
        System.out.println(contentNo+"번호");

        // primary key 값을 기준으로 가져오기 때문에 중복이 없다 -> List 를 쓸 필요가 없다.
        Notice result = new NoticeService().viewContent(contentNo);

        request.setAttribute("contentView",result);
        request.getRequestDispatcher("/views/notice/noticeDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
