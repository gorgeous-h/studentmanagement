package com.yhpt.studentmanagement.service;

import com.yhpt.studentmanagement.entity.SchoolType;
import com.yhpt.studentmanagement.mapper.SchoolTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/18 16:07
 * @Description:
 */
@Transactional
@Service
public class SchoolTypeService {
    @Autowired
    private SchoolTypeMapper schoolTypeMapper;

    public Map<String, Object> getSchoolTypes(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", schoolTypeMapper.getSchoolTypes(params));
        map.put("total", schoolTypeMapper.getSchoolTypesCount(params));
        return map;
    }

    public void saveSchoolType(SchoolType schoolType) {
        if(schoolType.getId()==null){
            schoolTypeMapper.insertSchoolType(schoolType);
        } else {
            schoolTypeMapper.updateSchoolType(schoolType);
        }
    }

    public void deleteSchoolType(Integer schoolTypeId) {
        schoolTypeMapper.deleteSchoolType(schoolTypeId);
    }

    public List<SchoolType> getAllSchoolType() {
        return schoolTypeMapper.getAllSchoolType();
    }

}
