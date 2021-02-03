package com.yhpt.studentmanagement.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: hjj
 * @Date: 2020/11/20 14:18
 * @Description:
 */
@Data
public class DictionaryExcel {
    @ExcelProperty("name")
    private String name;

}
