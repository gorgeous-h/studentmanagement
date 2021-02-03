package com.yhpt.studentmanagement.entity;

import com.yhpt.studentmanagement.common.Dictionary;

/**
 * @Author: hjj
 * @Date: 2020/11/18 9:26
 * @Description:
 */
public class City extends Dictionary {
    private Province province;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
