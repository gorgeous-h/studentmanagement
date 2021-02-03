package com.yhpt.studentmanagement.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yhpt.studentmanagement.service.ProvinceService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hjj
 * @Date: 2020/11/20 14:30
 * @Description:
 */
public class ProvinceExcelListener extends AnalysisEventListener {
    private ProvinceService provinceService;
    private static final int BATCH_COUNT = 10;
    private List<ProvinceExcel> provinces = new ArrayList<>();
    private String tableName;

    public ProvinceExcelListener(ProvinceService provinceService, String tableName) {
        this.provinceService = provinceService;
        this.tableName = tableName;
    }

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        provinces.add((ProvinceExcel) o);
        if(provinces.size()>=BATCH_COUNT){
            saveData();
            provinces.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }

    private void saveData() {
        provinceService.saveProvincesByExcel(provinces, tableName);
    }

    public List<ProvinceExcel> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<ProvinceExcel> provinces) {
        this.provinces = provinces;
    }
}
