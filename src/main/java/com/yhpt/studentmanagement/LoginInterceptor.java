package com.yhpt.studentmanagement;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: hjj
 * @Date: 2020/11/9 15:17
 * @Description:
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        Object sessionObj = request.getSession().getAttribute("yhpt_user");
        if(sessionObj!=null){
            return true;
        }
        String basePath = request.getContextPath();
        response.sendRedirect(basePath+"/login");
        return false;
    }

}
