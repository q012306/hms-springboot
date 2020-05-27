package com.goodguy.hms.interceptor;

import com.goodguy.hms.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 判断 session 中是否存在 user 属性，如果存在就放行，如果不存在就跳转到 login 页面
 * Interceptor 即拦截器，
 * 在 Springboot 继承拦截器的接口，
 * 然后实现 preHandle 方法。
 * preHandle 方法里的代码会在访问需要拦截的页面时执行。
 */

public class AuthorityInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String uri = httpServletRequest.getRequestURI();
        String page = uri;
        System.out.println(page);
        if(!( page.equals("/login") || page.equals("/api/login") || page.equals("/api/register") )){
            User user = (User) session.getAttribute("user");
            if(user==null) {
                httpServletResponse.sendRedirect("/login");
                return false;
            }
        }
        return true;
    }
}