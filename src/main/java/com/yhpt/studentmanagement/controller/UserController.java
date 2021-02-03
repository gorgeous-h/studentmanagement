package com.yhpt.studentmanagement.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhpt.studentmanagement.entity.Role;
import com.yhpt.studentmanagement.entity.User;
import com.yhpt.studentmanagement.service.RoleService;
import com.yhpt.studentmanagement.service.UserService;
import com.yhpt.studentmanagement.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/10 16:50
 * @Description:
 */
@RequestMapping("/hjj")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/user/userManage")
    public String userManage(Model model) throws JsonProcessingException {
        List<Role> roles = roleService.getAllRole();
        ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        model.addAttribute("roles", mapper.writeValueAsString(roles));
        return "user/userManage";
    }

    @ResponseBody
    @RequestMapping("/user/getUsers")
    public Map<String, Object> getUsers(HttpServletRequest request){
        int pageNO = Integer.parseInt(request.getParameter("page"));// 当前页
        int pageSize = Integer.parseInt(request.getParameter("rows"));// 每页行数
        Map<String, Object> params = new HashMap<>();
        params.put("pageNO", pageNO);
        params.put("pageSize", pageSize);
        params.put("nickname", request.getParameter("nickname"));
        return userService.getUsers(params);
    }

    @ResponseBody
    @RequestMapping("/user/saveUser")
    public String saveUser(UserVO userVO){
        if(userVO.getId()==null){
            userVO.setCreateTime(LocalDateTime.now());
        }
        userService.saveUser(userVO);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/user/getUserByUsername")
    public User getUserByUsername(HttpServletRequest request){
        User user = null;
        String username = request.getParameter("username");
        if (!StringUtils.isEmpty(username)){
            user = userService.getUserByUsername(username);
        }
        return user;
    }

    @ResponseBody
    @RequestMapping("/user/getUserById")
    public UserVO getUserById(HttpServletRequest request){
        UserVO userVO = null;
        String userId = request.getParameter("userId");
        if (!StringUtils.isEmpty(userId)){
            userVO = userService.getUserVOById(NumberUtils.parseNumber(userId, Integer.class));
        }
        return userVO;
    }

    @ResponseBody
    @RequestMapping("/user/deleteUser")
    public String deleteUser(HttpServletRequest request){
        String userId = request.getParameter("userId");
        if (!StringUtils.isEmpty(userId)){
            userService.deleteUser(NumberUtils.parseNumber(userId, Integer.class));
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/user/checkPwd")
    public boolean checkPwd(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        if (!StringUtils.isEmpty(userId)){
            User user = userService.getUserById(NumberUtils.parseNumber(userId, Integer.class));
            return user.getPassword().equals(password);
        }
        return false;
    }

    @ResponseBody
    @RequestMapping("/user/modifyPwd")
    public String modifyPwd(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        if (!StringUtils.isEmpty(userId)){
            userService.modifyPwd(NumberUtils.parseNumber(userId, Integer.class), password);
        }
        return "success";
    }
}
