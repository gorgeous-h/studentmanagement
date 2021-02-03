package com.yhpt.studentmanagement.service;

import com.yhpt.studentmanagement.entity.Province;
import com.yhpt.studentmanagement.excel.ProvinceExcel;
import com.yhpt.studentmanagement.mapper.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/18 9:29
 * @Description:
 */
@Transactional
@Service
public class ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;

    public Map<String, Object> getProvinces(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", provinceMapper.getProvinces(params));
        map.put("total", provinceMapper.getProvincesCount(params));
        return map;
    }

    public void saveProvince(Province province) {
        if(province.getId()==null){
            provinceMapper.insertProvince(province);
        } else {
            provinceMapper.updateProvince(province);
        }
    }

    public void deleteProvince(Integer provinceId) {
        provinceMapper.deleteProvince(provinceId);
    }

    public List<Province> getAllProvince() {
        return provinceMapper.getAllProvince();
    }

    public void saveProvincesByExcel(List<ProvinceExcel> provinces, String tableName){
        provinceMapper.saveProvincesByExcel(provinces, tableName);
    }

}
