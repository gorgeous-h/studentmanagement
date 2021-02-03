package com.yhpt.studentmanagement.entity;

import com.yhpt.studentmanagement.common.Dictionary;

/**
 * @Author: hjj
 * @Date: 2020/11/18 16:31
 * @Description:
 */
public class School extends Dictionary {
    private Region region;
    private SchoolType schoolType;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public SchoolType getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(SchoolType schoolType) {
        this.schoolType = schoolType;
    }
}
