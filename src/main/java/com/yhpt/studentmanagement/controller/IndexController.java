package com.yhpt.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: hjj
 * @Date: 2020/11/9 14:50
 * @Description:
 */
@RequestMapping("/hjj")
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index/index";
    }

    @RequestMapping("/easyuiTabs")
    public String easyuiTabs(){
        return "easyuiTabs";
    }

}
