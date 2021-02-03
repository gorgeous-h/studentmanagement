package com.yhpt.studentmanagement.mapper;

import com.yhpt.studentmanagement.entity.School;
import com.yhpt.studentmanagement.vo.SchoolVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SchoolMapper {

    List<SchoolVO> getSchools(Map<String, Object> params);

    int getSchoolsCount(Map<String, Object> params);

    void insertSchool(SchoolVO schoolVO);

    void updateSchool(SchoolVO schoolVO);

    SchoolVO getSchoolVO(Integer schoolId);

    void deleteSchool(Integer schoolId);

    List<School> getAllSchool(Map<String, Object> params);

}
