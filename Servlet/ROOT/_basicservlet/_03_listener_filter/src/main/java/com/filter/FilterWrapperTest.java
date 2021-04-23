package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "FilterWrapperTest", value = "/wrapper.do")
public class FilterWrapperTest implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        // 내가 만든 wrapper 적용하기
        // request를 형변환해서 매개변수로 넣는다.
        MyWrapper myRequest = new MyWrapper((HttpServletRequest)request);



        // Filter에 내가 재정의한 wrapper를 넣는다.
        chain.doFilter(myRequest, response);
    }
}
