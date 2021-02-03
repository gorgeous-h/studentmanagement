package com.yhpt.studentmanagement.mapper;

import com.yhpt.studentmanagement.entity.Region;
import com.yhpt.studentmanagement.excel.RegionExcel;
import com.yhpt.studentmanagement.vo.RegionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RegionMapper {

    List<RegionVO> getRegions(Map<String, Object> params);

    int getRegionsCount(Map<String, Object> params);

    void insertRegion(RegionVO regionVO);

    void updateRegion(RegionVO regionVO);

    RegionVO getRegionVOById(Integer regionId);

    void deleteRegion(Integer regionId);

    List<Region> getRegionsByCityId(Integer cityId);

    void saveRegionsByExcel(@Param("regions") List<RegionExcel> regions);

}
