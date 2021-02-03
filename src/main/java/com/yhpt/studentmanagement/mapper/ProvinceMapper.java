package com.yhpt.studentmanagement.mapper;

import com.yhpt.studentmanagement.entity.Province;
import com.yhpt.studentmanagement.excel.ProvinceExcel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProvinceMapper {

    List<Province> getProvinces(Map<String, Object> params);

    int getProvincesCount(Map<String, Object> params);

    void insertProvince(Province province);

    void updateProvince(Province province);

    void deleteProvince(Integer provinceId);

    List<Province> getAllProvince();

    void saveProvincesByExcel(@Param("provinces") List<ProvinceExcel> provinces, @Param("tableName") String tableName);

}
