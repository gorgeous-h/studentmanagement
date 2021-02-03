package com.yhpt.studentmanagement.controller;

import com.yhpt.studentmanagement.entity.Nation;
import com.yhpt.studentmanagement.service.NationService;
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
 * @Date: 2020/11/19 14:10
 * @Description:
 */
@RequestMapping("/hjj")
@Controller
public class NationController {
    @Autowired
    private NationService nationService;

    @RequestMapping("/nation/nationManage")
    public String nationManage(){
        return "dictionary/nationManage";
    }

    @ResponseBody
    @RequestMapping("/nation/getNations")
    public Map<String, Object> getNations(HttpServletRequest request){
        int pageNO = Integer.parseInt(request.getParameter("page"));// 当前页
        int pageSize = Integer.parseInt(request.getParameter("rows"));// 每页行数
        Map<String, Object> params = new HashMap<>();
        params.put("pageNO", pageNO);
        params.put("pageSize", pageSize);
        params.put("name", request.getParameter("name"));
        return nationService.getNations(params);
    }

    @ResponseBody
    @RequestMapping("/nation/saveNation")
    public String saveNation(Nation nation){
        if(nation.getId()==null){
            nation.setCreateTime(LocalDateTime.now());
        }
        nationService.saveNation(nation);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/nation/deleteNation")
    public String deleteNation(HttpServletRequest request){
        String nationId = request.getParameter("nationId");
        if (!StringUtils.isEmpty(nationId)){
            nationService.deleteNation(NumberUtils.parseNumber(nationId, Integer.class));
        }
        return "success";
    }

}
