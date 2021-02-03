package com.yhpt.studentmanagement.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhpt.studentmanagement.entity.Nation;
import com.yhpt.studentmanagement.entity.Province;
import com.yhpt.studentmanagement.entity.SchoolType;
import com.yhpt.studentmanagement.service.NationService;
import com.yhpt.studentmanagement.service.ProvinceService;
import com.yhpt.studentmanagement.service.SchoolTypeService;
import com.yhpt.studentmanagement.service.StudentService;
import com.yhpt.studentmanagement.vo.StudentVO;
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
 * @Date: 2020/11/19 14:36
 * @Description:
 */
@RequestMapping("/hjj")
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private SchoolTypeService schoolTypeService;
    @Autowired
    private NationService nationService;

    @RequestMapping("/student/studentManage")
    public String studentManage(){
        return "student/studentManage";
    }

    @ResponseBody
    @RequestMapping("/student/getStudents")
    public Map<String, Object> getStudents(HttpServletRequest request){
        int pageNO = Integer.parseInt(request.getParameter("page"));// 当前页
        int pageSize = Integer.parseInt(request.getParameter("rows"));// 每页行数
        Map<String, Object> params = new HashMap<>();
        params.put("pageNO", pageNO);
        params.put("pageSize", pageSize);
        params.put("name", request.getParameter("name"));
        return studentService.getStudents(params);
    }

    @RequestMapping("/student/toStudentForm")
    public String toStudentForm(HttpServletRequest request, Model model) throws JsonProcessingException {
        List<Province> provinces = provinceService.getAllProvince();
        List<SchoolType> schoolTypes = schoolTypeService.getAllSchoolType();
        List<Nation> nations = nationService.getAllNation();
        ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        model.addAttribute("provinces", mapper.writeValueAsString(provinces));
        model.addAttribute("schoolTypes", mapper.writeValueAsString(schoolTypes));
        model.addAttribute("nations", mapper.writeValueAsString(nations));
        model.addAttribute("studentId", request.getParameter("studentId"));
        return "student/studentForm";
    }

    @ResponseBody
    @RequestMapping("/student/saveStudent")
    public String saveStudent(StudentVO studentVO){
        StringBuilder strbuilder = new StringBuilder();
        if(studentVO.getId()==null){
            studentVO.setCreateTime(LocalDateTime.now());
            strbuilder.append("add");
        } else {
            strbuilder.append("update");
        }
        studentService.saveStudent(studentVO);
        strbuilder.append(studentVO.getId());
        return strbuilder.toString();
    }

    @ResponseBody
    @RequestMapping("/student/getStudentVO")
    public StudentVO getStudentVO(HttpServletRequest request){
        StudentVO studentVO = null;
        String studentId = request.getParameter("studentId");
        if(!StringUtils.isEmpty(studentId)){
            studentVO = studentService.getStudentVO(NumberUtils.parseNumber(studentId, Integer.class));
        }
        return studentVO;
    }

    @ResponseBody
    @RequestMapping("/student/deleteStudent")
    public String deleteStudent(HttpServletRequest request){
        String studentId = request.getParameter("studentId");
        if (!StringUtils.isEmpty(studentId)){
            studentService.deleteStudent(NumberUtils.parseNumber(studentId, Integer.class));
        }
        return "success";
    }

}
