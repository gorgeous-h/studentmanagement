package com.yhpt.studentmanagement.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhpt.studentmanagement.entity.Province;
import com.yhpt.studentmanagement.entity.Region;
import com.yhpt.studentmanagement.excel.RegionExcel;
import com.yhpt.studentmanagement.excel.RegionExcelListener;
import com.yhpt.studentmanagement.service.ProvinceService;
import com.yhpt.studentmanagement.service.RegionService;
import com.yhpt.studentmanagement.vo.RegionVO;
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
 * @Date: 2020/11/18 11:39
 * @Description:
 */
@RequestMapping("/hjj")
@Controller
public class RegionController {
    @Autowired
    private RegionService regionService;
    @Autowired
    private ProvinceService provinceService;

    @RequestMapping("/region/regionManage")
    public String regionManage(Model model) throws JsonProcessingException {
        List<Province> provinces = provinceService.getAllProvince();
        ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        model.addAttribute("provinces", mapper.writeValueAsString(provinces));
        return "dictionary/regionManage";
    }

    @ResponseBody
    @RequestMapping("/region/getRegions")
    public Map<String, Object> getRegions(HttpServletRequest request){
        int pageNO = Integer.parseInt(request.getParameter("page"));// 当前页
        int pageSize = Integer.parseInt(request.getParameter("rows"));// 每页行数
        Map<String, Object> params = new HashMap<>();
        params.put("pageNO", pageNO);
        params.put("pageSize", pageSize);
        params.put("name", request.getParameter("name"));
        return regionService.getRegions(params);
    }

    @ResponseBody
    @RequestMapping("/region/saveRegion")
    public String saveRegion(RegionVO regionVO){
        if(regionVO.getId()==null){
            regionVO.setCreateTime(LocalDateTime.now());
        }
        regionService.saveRegion(regionVO);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/region/getRegionVOById")
    public RegionVO getRegionVOById(HttpServletRequest request){
        RegionVO regionVO = null;
        String regionId = request.getParameter("regionId");
        if (!StringUtils.isEmpty(regionId)){
            regionVO = regionService.getRegionVOById(NumberUtils.parseNumber(regionId, Integer.class));
        }
        return regionVO;
    }

    @ResponseBody
    @RequestMapping("/region/deleteRegion")
    public String deleteRegion(HttpServletRequest request){
        String regionId = request.getParameter("regionId");
        if (!StringUtils.isEmpty(regionId)){
            regionService.deleteRegion(NumberUtils.parseNumber(regionId, Integer.class));
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/region/getRegionsByCityId")
    public List<Region> getRegionsByCityId(HttpServletRequest request){
        List<Region> regions = new ArrayList<>();
        String cityId = request.getParameter("cityId");
        if (!StringUtils.isEmpty(cityId)){
            regions = regionService.getRegionsByCityId(NumberUtils.parseNumber(cityId, Integer.class));
        }
        return regions;
    }

    @ResponseBody
    @RequestMapping("/region/saveRegionsByExcel")
    public String saveRegionsByExcel(MultipartFile regionExcelFile) {
        ExcelReader excelReader = null;
        try (InputStream inputStream = regionExcelFile.getInputStream()) {
            excelReader = EasyExcel.read(inputStream, RegionExcel.class, new RegionExcelListener(regionService)).build();
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
