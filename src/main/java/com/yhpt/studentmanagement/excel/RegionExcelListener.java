package com.yhpt.studentmanagement.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yhpt.studentmanagement.service.RegionService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hjj
 * @Date: 2020/11/20 17:34
 * @Description:
 */
public class RegionExcelListener extends AnalysisEventListener {
    private RegionService regionService;
    private static final int BATCH_COUNT = 10;
    private List<RegionExcel> regions = new ArrayList<>();

    public RegionExcelListener(RegionService regionService) {
        this.regionService = regionService;
    }

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        regions.add((RegionExcel) o);
        if(regions.size()>=BATCH_COUNT){
            saveData();
            regions.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }

    private void saveData() {
        regionService.saveRegionsByExcel(regions);
    }

    public List<RegionExcel> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionExcel> regions) {
        this.regions = regions;
    }
}
