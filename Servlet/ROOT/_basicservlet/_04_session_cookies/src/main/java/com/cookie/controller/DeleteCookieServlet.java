package com.cookie.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCookieServlet", value = "/deletecookie.do")
public class DeleteCookieServlet extends HttpServlet {
    private static final long serialVersionUID = 7785000949801034124L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 저장된 쿠키 삭제하기
        // 쿠키의 key 값을 이용하여 유효기간을 조정하여 삭제를 한다.
        // 동일한 값의 cookie를 생성해서 유효기간 설정을 0으로 하면 cookie가 삭제됨
        Cookie c = new Cookie("userId","");
        c.setMaxAge(0);
        response.addCookie(c);

        response.sendRedirect(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
