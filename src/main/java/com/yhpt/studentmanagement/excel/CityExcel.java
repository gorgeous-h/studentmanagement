package com.yhpt.studentmanagement.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: hjj
 * @Date: 2020/11/20 16:13
 * @Description:
 */
@Data
public class CityExcel extends DictionaryExcel {
    @ExcelProperty("provinceId")
    private Integer provinceId;

}
