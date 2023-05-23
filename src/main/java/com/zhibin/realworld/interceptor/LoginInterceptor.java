package com.zhibin.realworld.interceptor;

import com.zhibin.realworld.exception.LoginException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    // 返回 true 表示拦截判断通过，可以访问后面的接口
    // 返回 false 表示拦截未通过，直接返回结果给前端
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 1.得到 HttpSession 对象
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userinfo") != null) {
            // 表示已经登录
            return true;
        }
        // 执行到此代码表示未登录，未登录就跳转到登录页面
//        response.sendRedirect("/login.html");
        throw new LoginException(999,"you have not login, please login first");
//        response.sendError(999,"you have not login, please login first");
//        return false;
    }
}
