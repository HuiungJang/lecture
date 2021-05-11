package com.notice.controller;

import com.notice.model.service.NoticeService;
import com.notice.model.vo.Notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MoveReviseServlet", value = "/notice/moveRevise")
public class MoveReviseServlet extends HttpServlet {
    private static final long serialVersionUID = -4045683822711734980L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 수정페이지로 이동하는 서블릿
        int contentNo = Integer.parseInt(request.getParameter("noticeNo"));
        Notice result = new NoticeService().viewContent(contentNo);

        request.setAttribute("revise",result);
        request.getRequestDispatcher("/views/notice/reviseNotice.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
