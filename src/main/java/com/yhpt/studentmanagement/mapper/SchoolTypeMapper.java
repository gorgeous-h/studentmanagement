package com.yhpt.studentmanagement.mapper;

import com.yhpt.studentmanagement.entity.SchoolType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SchoolTypeMapper {

    List<SchoolType> getSchoolTypes(Map<String, Object> params);

    int getSchoolTypesCount(Map<String, Object> params);

    void insertSchoolType(SchoolType schoolType);

    void updateSchoolType(SchoolType schoolType);

    void deleteSchoolType(Integer schoolTypeId);

    List<SchoolType> getAllSchoolType();

}
