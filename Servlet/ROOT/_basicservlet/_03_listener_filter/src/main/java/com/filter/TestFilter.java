package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter("*.do")
@WebFilter(servletNames = {
    "FilterTest2"
})
// 이걸 쓰려면 서블릿에 이름을 부여해야함.

public class TestFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if(request.getParameter("userId")==null || !request.getParameter("userId").equals("admin")){
            // 이렇게 하면 admin 이 아니면 넘어가고 맞으면 넘어가지 않음.
            HttpServletResponse res = (HttpServletResponse)response;
            res.setContentType("text/html;charset=utf-8;");
            PrintWriter out = res.getWriter();
            String html="<html>";
            html+="<body>";
            html+="<h1 style='color:red'>잘못된 경로로 접근하셨습니다.</h1>";
            html+="</body>";
            html+="</html>";

            out.write(html);

        }else{
            chain.doFilter(request, response);
        }


    }
}
