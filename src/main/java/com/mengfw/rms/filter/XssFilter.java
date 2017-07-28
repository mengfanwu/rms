package com.mengfw.rms.filter;

import com.mengfw.rms.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by mengfw on 2017/7/28.
 */
@Component
public class XssFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new XssHttpServletRequestWraper(
                (HttpServletRequest)servletRequest),servletResponse);
    }

    @Override
    public void destroy() {

    }
}
