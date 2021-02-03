package com.yhpt.studentmanagement.mapper;

import com.yhpt.studentmanagement.entity.Nation;
import com.yhpt.studentmanagement.excel.NationExcel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface NationMapper {

    List<Nation> getNations(Map<String, Object> params);

    int getNationsCount(Map<String, Object> params);

    void insertNation(Nation nation);

    void updateNation(Nation nation);

    void deleteNation(Integer nationId);

    List<Nation> getAllNation();

    void saveNationsByExcel(@Param("nations") List<NationExcel> nations);

}
