package com.yhpt.studentmanagement.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhpt.studentmanagement.entity.Province;
import com.yhpt.studentmanagement.entity.School;
import com.yhpt.studentmanagement.entity.SchoolType;
import com.yhpt.studentmanagement.service.ProvinceService;
import com.yhpt.studentmanagement.service.SchoolService;
import com.yhpt.studentmanagement.service.SchoolTypeService;
import com.yhpt.studentmanagement.vo.SchoolVO;
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
 * @Date: 2020/11/18 16:34
 * @Description:
 */
@RequestMapping("/hjj")
@Controller
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private SchoolTypeService schoolTypeService;

    @RequestMapping("/school/schoolManage")
    public String roleManage(){
        return "dictionary/schoolManage";
    }

    @ResponseBody
    @RequestMapping("/school/getSchools")
    public Map<String, Object> getSchools(HttpServletRequest request){
        int pageNO = Integer.parseInt(request.getParameter("page"));// 当前页
        int pageSize = Integer.parseInt(request.getParameter("rows"));// 每页行数
        Map<String, Object> params = new HashMap<>();
        params.put("pageNO", pageNO);
        params.put("pageSize", pageSize);
        params.put("name", request.getParameter("name"));
        return schoolService.getSchools(params);
    }

    @RequestMapping("/school/toSchoolForm")
    public String toSchoolForm(HttpServletRequest request, Model model) throws JsonProcessingException {
        List<Province> provinces = provinceService.getAllProvince();
        List<SchoolType> schoolTypes = schoolTypeService.getAllSchoolType();
        ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        model.addAttribute("provinces", mapper.writeValueAsString(provinces));
        model.addAttribute("schoolTypes", mapper.writeValueAsString(schoolTypes));
        model.addAttribute("schoolId", request.getParameter("schoolId"));
        return "dictionary/schoolForm";
    }

    @ResponseBody
    @RequestMapping("/school/saveSchool")
    public String saveSchool(SchoolVO schoolVO){
        StringBuilder strbuilder = new StringBuilder();
        if(schoolVO.getId()==null){
            schoolVO.setCreateTime(LocalDateTime.now());
            strbuilder.append("add");
        } else {
            strbuilder.append("update");
        }
        // strbuilder.append(schoolService.saveSchool(schoolVO));

        // mybatis mysql保存成功返回主键不生效：https://blog.csdn.net/qq_42714869/article/details/83824051
        schoolService.saveSchool(schoolVO);
        strbuilder.append(schoolVO.getId());
        return strbuilder.toString();
    }

    @ResponseBody
    @RequestMapping("/school/getSchoolVO")
    public SchoolVO getSchoolVO(HttpServletRequest request){
        SchoolVO schoolVO = null;
        String schoolId = request.getParameter("schoolId");
        if(!StringUtils.isEmpty(schoolId)){
            schoolVO = schoolService.getSchoolVO(NumberUtils.parseNumber(schoolId, Integer.class));
        }
        return schoolVO;
    }

    @ResponseBody
    @RequestMapping("/school/deleteSchool")
    public String deleteSchool(HttpServletRequest request){
        String schoolIdStr = request.getParameter("schoolId");
        if(!StringUtils.isEmpty(schoolIdStr)){
            schoolService.deleteSchool(NumberUtils.parseNumber(schoolIdStr, Integer.class));
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/school/getAllSchool")
    public List<School> getAllSchool(HttpServletRequest request){
        Map<String, Object> params = new HashMap<>();
        params.put("provinceId", request.getParameter("provinceId"));
        params.put("cityId", request.getParameter("cityId"));
        params.put("regionId", request.getParameter("regionId"));
        params.put("schoolTypeId", request.getParameter("schoolTypeId"));
        return schoolService.getAllSchool(params);
    }

}
