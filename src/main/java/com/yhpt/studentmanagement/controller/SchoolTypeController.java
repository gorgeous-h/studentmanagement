package com.yhpt.studentmanagement.controller;

import com.yhpt.studentmanagement.entity.SchoolType;
import com.yhpt.studentmanagement.service.SchoolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/18 16:06
 * @Description:
 */
@RequestMapping("/hjj")
@Controller
public class SchoolTypeController {
    @Autowired
    private SchoolTypeService schoolTypeService;

    @RequestMapping("/schoolType/schoolTypeManage")
    public String roleManage(){
        return "dictionary/schoolTypeManage";
    }

    @ResponseBody
    @RequestMapping("/schoolType/getSchoolTypes")
    public Map<String, Object> getSchoolTypes(HttpServletRequest request){
        int pageNO = Integer.parseInt(request.getParameter("page"));// 当前页
        int pageSize = Integer.parseInt(request.getParameter("rows"));// 每页行数
        Map<String, Object> params = new HashMap<>();
        params.put("pageNO", pageNO);
        params.put("pageSize", pageSize);
        params.put("name", request.getParameter("name"));
        return schoolTypeService.getSchoolTypes(params);
    }

    @ResponseBody
    @RequestMapping("/schoolType/saveSchoolType")
    public String saveSchoolType(SchoolType schoolType){
        if(schoolType.getId()==null){
            schoolType.setCreateTime(LocalDateTime.now());
        }
        schoolTypeService.saveSchoolType(schoolType);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/schoolType/deleteSchoolType")
    public String deleteSchoolType(HttpServletRequest request){
        String schoolTypeId = request.getParameter("schoolTypeId");
        if (!StringUtils.isEmpty(schoolTypeId)){
            schoolTypeService.deleteSchoolType(NumberUtils.parseNumber(schoolTypeId, Integer.class));
        }
        return "success";
    }

}
