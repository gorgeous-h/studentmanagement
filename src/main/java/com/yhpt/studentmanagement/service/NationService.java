package com.yhpt.studentmanagement.service;

import com.yhpt.studentmanagement.entity.Nation;
import com.yhpt.studentmanagement.excel.NationExcel;
import com.yhpt.studentmanagement.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/19 14:10
 * @Description:
 */
@Transactional
@Service
public class NationService {
    @Autowired
    private NationMapper nationMapper;

    public Map<String, Object> getNations(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", nationMapper.getNations(params));
        map.put("total", nationMapper.getNationsCount(params));
        return map;
    }

    public void saveNation(Nation nation) {
        if(nation.getId()==null){
            nationMapper.insertNation(nation);
        } else {
            nationMapper.updateNation(nation);
        }
    }

    public void deleteNation(Integer nationId) {
        nationMapper.deleteNation(nationId);
    }

    public List<Nation> getAllNation() {
        return nationMapper.getAllNation();
    }

    public void saveNationsByExcel(List<NationExcel> nations) {
        nationMapper.saveNationsByExcel(nations);
    }

}
