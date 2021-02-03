package com.yhpt.studentmanagement.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.yhpt.studentmanagement.entity.Province;
import com.yhpt.studentmanagement.excel.ProvinceExcel;
import com.yhpt.studentmanagement.excel.ProvinceExcelListener;
import com.yhpt.studentmanagement.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/18 9:28
 * @Description:
 */
@RequestMapping("/hjj")
@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @RequestMapping("/province/provinceManage")
    public String provinceManage(){
        return "dictionary/provinceManage";
    }

    @ResponseBody
    @RequestMapping("/province/getProvinces")
    public Map<String, Object> getProvinces(HttpServletRequest request){
        int pageNO = Integer.parseInt(request.getParameter("page"));// 当前页
        int pageSize = Integer.parseInt(request.getParameter("rows"));// 每页行数
        Map<String, Object> params = new HashMap<>();
        params.put("pageNO", pageNO);
        params.put("pageSize", pageSize);
        params.put("name", request.getParameter("name"));
        return provinceService.getProvinces(params);
    }

    @ResponseBody
    @RequestMapping("/province/saveProvince")
    public String saveProvince(Province province){
        if(province.getId()==null){
            province.setCreateTime(LocalDateTime.now());
        }
        provinceService.saveProvince(province);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/province/deleteProvince")
    public String deleteProvince(HttpServletRequest request){
        String provinceId = request.getParameter("provinceId");
        if (!StringUtils.isEmpty(provinceId)){
            provinceService.deleteProvince(NumberUtils.parseNumber(provinceId, Integer.class));
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/province/saveProvincesByExcel")
    public String saveProvincesByExcel(MultipartFile excelFile, HttpServletRequest request) {
        String tableName = request.getParameter("tableName");
        ExcelReader excelReader = null;
        try (InputStream inputStream = excelFile.getInputStream()) {
            excelReader = EasyExcel.read(inputStream, ProvinceExcel.class, new ProvinceExcelListener(provinceService, tableName)).build();
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 这里一定别忘记关闭，读的时候会创建临时文件，到时磁盘会崩
            if (excelReader != null) {
                excelReader.finish();
            }
        }
        return "success";
    }

}
