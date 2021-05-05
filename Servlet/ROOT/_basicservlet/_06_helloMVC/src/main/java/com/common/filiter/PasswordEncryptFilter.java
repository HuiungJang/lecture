package com.common.filiter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// 필터링의 기준은 주소매핑만 하는 것이 아니라 서블릿 이름으로도 가능

@WebFilter(servletNames={
        "LoginServlet","MemberEnrollServlet","MemberUpdateServlet","UpdatePasswordEndServlet"
})
public class PasswordEncryptFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        PasswordEncryptWrapper pew = new PasswordEncryptWrapper((HttpServletRequest)request);

        chain.doFilter(pew, response);
    }
}
