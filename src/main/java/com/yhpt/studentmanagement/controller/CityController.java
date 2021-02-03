package com.yhpt.studentmanagement.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhpt.studentmanagement.entity.City;
import com.yhpt.studentmanagement.entity.Province;
import com.yhpt.studentmanagement.excel.CityExcel;
import com.yhpt.studentmanagement.excel.CityExcelListener;
import com.yhpt.studentmanagement.service.CityService;
import com.yhpt.studentmanagement.service.ProvinceService;
import com.yhpt.studentmanagement.vo.CityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/18 10:04
 * @Description:
 */
@RequestMapping("/hjj")
@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private ProvinceService provinceService;

    @RequestMapping("/city/cityManage")
    public String cityManage(Model model) throws JsonProcessingException {
        List<Province> provinces = provinceService.getAllProvince();
        ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        model.addAttribute("provinces", mapper.writeValueAsString(provinces));
        return "dictionary/cityManage";
    }

    @ResponseBody
    @RequestMapping("/city/getCities")
    public Map<String, Object> getCities(HttpServletRequest request){
        int pageNO = Integer.parseInt(request.getParameter("page"));// 当前页
        int pageSize = Integer.parseInt(request.getParameter("rows"));// 每页行数
        Map<String, Object> params = new HashMap<>();
        params.put("pageNO", pageNO);
        params.put("pageSize", pageSize);
        params.put("name", request.getParameter("name"));
        return cityService.getCities(params);
    }

    @ResponseBody
    @RequestMapping("/city/saveCity")
    public String saveCity(CityVO cityVO){
        if(cityVO.getId()==null){
            cityVO.setCreateTime(LocalDateTime.now());
        }
        cityService.saveCity(cityVO);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/city/deleteCity")
    public String deleteCity(HttpServletRequest request){
        String cityId = request.getParameter("cityId");
        if (!StringUtils.isEmpty(cityId)){
            cityService.deleteCity(NumberUtils.parseNumber(cityId, Integer.class));
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/city/getCitiesByProvinceId")
    public List<City> getCitiesByProvinceId(HttpServletRequest request){
        List<City> cities = new ArrayList<>();
        String provinceId = request.getParameter("provinceId");
        if (!StringUtils.isEmpty(provinceId)){
            cities = cityService.getCitiesByProvinceId(NumberUtils.parseNumber(provinceId, Integer.class));
        }
        return cities;
    }

    @ResponseBody
    @RequestMapping("/city/saveCitiesByExcel")
    public String saveCitiesByExcel(MultipartFile cityExcelFile) {
        ExcelReader excelReader = null;
        try (InputStream inputStream = cityExcelFile.getInputStream()) {
            excelReader = EasyExcel.read(inputStream, CityExcel.class, new CityExcelListener(cityService)).build();
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
