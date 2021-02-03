package com.yhpt.studentmanagement.controller;

import com.yhpt.studentmanagement.entity.User;
import com.yhpt.studentmanagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: hjj
 * @Date: 2020/11/9 15:19
 * @Description:
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String logout = request.getParameter("logout");
        if(!StringUtils.isEmpty(logout)&&logout.equals("1")){
            HttpSession session = request.getSession();
            session.removeAttribute("yhpt_user");
        }
        return "login";
    }

    @ResponseBody
    @RequestMapping("/loginValidate")
    public String loginValidate(HttpServletRequest request){
        // Spring工具类：https://blog.csdn.net/jaune161/article/details/51476081
        String responseStr = "success";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        if(!StringUtils.isEmpty(username)){
            user = loginService.getUserByUsername(username);
        }
        if(user==null){
            responseStr = "用户名不存在";
        } else if(!user.getPassword().equals(password)){
            responseStr = "密码错误";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("yhpt_user", user);
        }
        return responseStr;
    }

    // 响应"/"
    @RequestMapping("/")
    public void handleMainPath(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String basePath = request.getContextPath();
        response.sendRedirect(basePath+"/hjj/index");
    }

}
