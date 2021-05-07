package com.common.filiter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "BlockFilter", value="/*")
public class BlockFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest r = null;
//        String blockUrlGet = r.getHeader("referer");
//        String script ="<script>document.location.href='return index.jsp'</script>";
//
//        if(blockUrlGet == null){
//            r.setAttribute("msg","정상적인 접근이 아닙니다.");
//            r.setAttribute("loc","/");
//            r.setAttribute("script",script);
//            r.getRequestDispatcher("/views/common/msg.jsp").forward((HttpServletRequest)request,(HttpServletResponse)response);
//        }

        chain.doFilter(request,response);
    }
}
