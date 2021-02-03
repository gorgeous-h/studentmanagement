package com.yhpt.studentmanagement.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: hjj
 * @Date: 2020/11/20 17:32
 * @Description:
 */
@Data
public class RegionExcel extends DictionaryExcel {
    @ExcelProperty("cityId")
    private Integer cityId;
}
