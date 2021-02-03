package com.yhpt.studentmanagement.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yhpt.studentmanagement.service.CityService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hjj
 * @Date: 2020/11/20 16:14
 * @Description:
 */
public class CityExcelListener extends AnalysisEventListener {
    private CityService cityService;
    private static final int BATCH_COUNT = 10;
    private List<CityExcel> cities = new ArrayList<>();

    public CityExcelListener(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        cities.add((CityExcel) o);
        if(cities.size()>=BATCH_COUNT){
            saveData();
            cities.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }

    private void saveData() {
        cityService.saveCitiesByExcel(cities);
    }

    public List<CityExcel> getCities() {
        return cities;
    }

    public void setCities(List<CityExcel> cities) {
        this.cities = cities;
    }
}
