package com.bigguy.movie.moviebox.interceptor;/**
 * @Auther: hechen
 * @Date: 2019/4/11 15:52
 * @Description: ...
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hechen
 * @data 2019/4/11
 */
public class AdminLoginInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(getClass());

    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        // 拦截所有的 /admin/* 页面

        HttpSession session = httpServletRequest.getSession();


        Object admin = session.getAttribute("admin");

        // 没有登入，跳转到登入的界面
        if(null == admin){
//            httpServletRequest.getRequestDispatcher("/admin/login.html").forward(httpServletRequest,httpServletResponse);
            httpServletResponse.setContentType("text/html; charset=UTF-8");

            httpServletResponse.sendRedirect("/admin/login.html");
            logger.info("管理员没有登入，准备重定向 -> 管理员登入界面!");

            return false;
        }

        // 表示已经登入，放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
