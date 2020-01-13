package com.bolijiang3d.program.common.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class  XFrameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //必须
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //实际设置
        resp.setHeader("x-frame-options", "SAMEORIGIN");
        //调用下一个过滤器（这是过滤器工作原理，不用动）
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
