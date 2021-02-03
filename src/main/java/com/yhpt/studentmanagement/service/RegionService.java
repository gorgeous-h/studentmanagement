package com.yhpt.studentmanagement.service;

import com.yhpt.studentmanagement.entity.Region;
import com.yhpt.studentmanagement.excel.RegionExcel;
import com.yhpt.studentmanagement.mapper.RegionMapper;
import com.yhpt.studentmanagement.vo.RegionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/18 11:40
 * @Description:
 */
@Transactional
@Service
public class RegionService {
    @Autowired
    private RegionMapper regionMapper;

    public Map<String, Object> getRegions(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", regionMapper.getRegions(params));
        map.put("total", regionMapper.getRegionsCount(params));
        return map;
    }

    public void saveRegion(RegionVO regionVO) {
        if(regionVO.getId()==null){
            regionMapper.insertRegion(regionVO);
        } else {
            regionMapper.updateRegion(regionVO);
        }
    }

    public RegionVO getRegionVOById(Integer regionId) {
        return regionMapper.getRegionVOById(regionId);
    }

    public void deleteRegion(Integer regionId) {
        regionMapper.deleteRegion(regionId);
    }

    public List<Region> getRegionsByCityId(Integer cityId) {
        return regionMapper.getRegionsByCityId(cityId);
    }

    public void saveRegionsByExcel(List<RegionExcel> regions) {
        regionMapper.saveRegionsByExcel(regions);
    }

}
