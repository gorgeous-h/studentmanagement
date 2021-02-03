package com.yhpt.studentmanagement.service;

import com.yhpt.studentmanagement.entity.City;
import com.yhpt.studentmanagement.excel.CityExcel;
import com.yhpt.studentmanagement.mapper.CityMapper;
import com.yhpt.studentmanagement.vo.CityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/18 10:05
 * @Description:
 */
@Transactional
@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    public Map<String, Object> getCities(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", cityMapper.getCities(params));
        map.put("total", cityMapper.getCitiesCount(params));
        return map;
    }

    public void saveCity(CityVO cityVO) {
        if(cityVO.getId()==null){
            cityMapper.insertCity(cityVO);
        } else {
            cityMapper.updateCity(cityVO);
        }
    }

    public void deleteCity(Integer cityId) {
        cityMapper.deleteCity(cityId);
    }

    public List<City> getCitiesByProvinceId(Integer provinceId) {
        return cityMapper.getCitiesByProvinceId(provinceId);
    }

    public void saveCitiesByExcel(List<CityExcel> cities) {
        cityMapper.saveCitiesByExcel(cities);
    }

}
