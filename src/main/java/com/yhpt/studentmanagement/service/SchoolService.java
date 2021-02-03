package com.yhpt.studentmanagement.service;

import com.yhpt.studentmanagement.entity.School;
import com.yhpt.studentmanagement.mapper.SchoolMapper;
import com.yhpt.studentmanagement.vo.SchoolVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/18 16:34
 * @Description:
 */
@Transactional
@Service
public class SchoolService {
    @Autowired
    private SchoolMapper schoolMapper;

    public Map<String, Object> getSchools(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", schoolMapper.getSchools(params));
        map.put("total", schoolMapper.getSchoolsCount(params));
        return map;
    }

    public void saveSchool(SchoolVO schoolVO) {
        if(schoolVO.getId()==null){
            schoolMapper.insertSchool(schoolVO);
        } else {
            schoolMapper.updateSchool(schoolVO);
        }
    }

    public SchoolVO getSchoolVO(Integer schoolId) {
        return schoolMapper.getSchoolVO(schoolId);
    }

    public void deleteSchool(Integer schoolId) {
        schoolMapper.deleteSchool(schoolId);
    }

    public List<School> getAllSchool(Map<String, Object> params) {
        return schoolMapper.getAllSchool(params);
    }

}
