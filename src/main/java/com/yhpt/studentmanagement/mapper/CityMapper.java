package com.yhpt.studentmanagement.mapper;

import com.yhpt.studentmanagement.entity.City;
import com.yhpt.studentmanagement.excel.CityExcel;
import com.yhpt.studentmanagement.vo.CityVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CityMapper {

    List<CityVO> getCities(Map<String, Object> params);

    int getCitiesCount(Map<String, Object> params);

    void insertCity(CityVO cityVO);

    void updateCity(CityVO cityVO);

    void deleteCity(Integer cityId);

    List<City> getCitiesByProvinceId(Integer provinceId);

    void saveCitiesByExcel(@Param("cities") List<CityExcel> cities);
}
