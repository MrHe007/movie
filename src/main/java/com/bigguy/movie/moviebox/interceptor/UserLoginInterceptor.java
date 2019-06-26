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
public class UserLoginInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(getClass());

    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        // 没有登入，跳转到登入的界面
        if(null == user){
//            httpServletRequest.getRequestDispatcher("/user/login.html").forward(httpServletRequest,httpServletResponse);

//            httpServletResponse.sendRedirect("/user/login.html");

            //告诉ajax我是重定向
            httpServletResponse.setHeader("REDIRECT", "REDIRECT");
            //告诉ajax我重定向的路径
            httpServletResponse.setHeader("CONTENTPATH", "/user/login.html");
            httpServletResponse.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);

            logger.info("用户没有登入，准备跳转到登入界面!");
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
