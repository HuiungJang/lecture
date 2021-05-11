package com.common.filiter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/notice/*", "/admin/*"})
public class LoginCheckFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session =((HttpServletRequest)request).getSession();

        if( session == null || session.getAttribute("loginMember")== null){
            request.setAttribute("msg","로그인 후 이용할 수 있습니다.");
            request.setAttribute("loc","/");
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);

        }else{
            chain.doFilter(request, response);
        }

    }
}
