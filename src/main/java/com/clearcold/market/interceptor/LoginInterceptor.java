package com.clearcold.market.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();

        // 设置允许直接访问的路径
        String[] allowPaths = {
                "/login",          // 登录请求路径
                "/register",       // 注册请求路径
                "/loginError",     // 登录错误页面
                "/static/",        // 静态资源
                "/css/",           // CSS
                "/js/",            // JavaScript
                "/images/"        // 图片
        };

        // 检查是否在允许路径中
        for (String path : allowPaths) {
            if (requestURI.startsWith(contextPath + path)) {
                return true;
            }
        }

        // 已登录用户放行
        if (session != null && session.getAttribute("user") != null) {
            return true;
        }

        // 未登录跳转到登录页
        response.sendRedirect(contextPath + "/login");
        return false;
    }
}
