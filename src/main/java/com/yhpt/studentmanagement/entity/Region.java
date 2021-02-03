package com.yhpt.studentmanagement.entity;

import com.yhpt.studentmanagement.common.Dictionary;

/**
 * @Author: hjj
 * @Date: 2020/11/18 11:36
 * @Description:
 */
public class Region extends Dictionary {
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
