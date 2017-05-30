package com.mengfw.filter;

import com.google.common.collect.Lists;
import com.mengfw.bean.Constant;
import com.mengfw.bean.GlobalContext;
import com.mengfw.bean.GlobalRequest;
import com.mengfw.bean.GlobalResult;
import com.mengfw.helper.ServletHelper;
import com.mengfw.model.Emp;
import com.mengfw.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by MFW on 2017/5/27.
 */
@WebFilter(filterName="globalFilter",urlPatterns="/*")
public class GlobalFilter implements Filter {
    private static  final Logger LOGGER = LoggerFactory.getLogger(GlobalFilter.class);
    private String loginUrl = "/static/page/login.html";
    private List<String> whiteUrlList = Lists.newArrayList();
    private AntPathMatcher pathMatcher = new AntPathMatcher();
    private EmpService empService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        initWhiteUrls();
        ServletContext servletContext = filterConfig.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        empService = (EmpService) ctx.getBean("empServiceImpl");
    }

    private void initWhiteUrls() {
        whiteUrlList.add("/static/page/login.html");
        whiteUrlList.add("/home/**");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest &&  servletResponse instanceof HttpServletResponse){
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse)servletResponse;
            if(this.isRequestInWhiteUrls(request.getRequestURI().substring(request.getContextPath().length()))) {
                chain.doFilter(request, response);
            }else {
                if(!checkToken(request)){
                    sendRedirectResponse(response);
                }else{
                    chain.doFilter(request, response);
                }
            }
        }else {
            chain.doFilter(servletRequest,servletResponse);
        }

    }

    private void sendRedirectResponse(HttpServletResponse response) throws IOException {
        if(ServletHelper.isPost()) {
            GlobalResult result = new GlobalResult();
            result.setLogin(false);
            result.setSuccess(false);
            result.getModel().put("loginUrl",this.loginUrl);
            ServletHelper.sendPostResponse(result);
        } else {
            response.sendRedirect(this.loginUrl);
        }
    }

    private  String getIp(HttpServletRequest request) {
        String forwardedIp = request.getHeader("X-Real-IP");
        return StringUtils.isEmpty(forwardedIp)?request.getRemoteAddr():forwardedIp;
    }
    private boolean checkToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie empIdCookie = getCookie(cookies, Constant.EMP_ID_COOKIE_KEY);
        Cookie tokenCookie = getCookie(cookies, Constant.EMP_TOKEN_COOKIE_KEY);
        if(empIdCookie == null || tokenCookie == null){
            return false;
        }
        Integer empId = Integer.parseInt(empIdCookie.getValue());
        String token = tokenCookie.getValue();
        Emp emp = empService.selectByKey(empId);
        if(emp == null || StringUtils.isEmpty(token) || !token.equals(emp.getToken())){
            return false;
        }
        GlobalRequest globalRequest = new GlobalRequest();
        globalRequest.setUrl(request.getRequestURI());
        globalRequest.setIp(getIp(request));
        globalRequest.setMethod(request.getMethod());
        globalRequest.setAccountId(empId);
        globalRequest.setLogin(true);
        request.getSession().setAttribute(Constant.GLOBAL_CONTEXT_KEY,new GlobalContext(globalRequest));
        return true;
    }
    private Cookie getCookie(Cookie[]cookies,String key){
        if(cookies == null || cookies.length <= 0){
            return null;
        }
        for (Cookie cookie:cookies){
            if(cookie.getName().equals(key)){
                return cookie;
            }
        }
        return null;
    }
    private boolean isRequestInWhiteUrls(String url) {
        Iterator var2 = this.whiteUrlList.iterator();
        String whiteUrl;
        do {
            if(!var2.hasNext()) {
                return false;
            }

            whiteUrl = (String)var2.next();
        } while(!this.pathMatcher.match(whiteUrl, url));

        return true;
    }

    @Override
    public void destroy() {

    }

}
