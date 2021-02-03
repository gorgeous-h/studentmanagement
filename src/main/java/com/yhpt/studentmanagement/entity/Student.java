package com.yhpt.studentmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yhpt.studentmanagement.common.Dictionary;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Author: hjj
 * @Date: 2020/11/19 11:40
 * @Description:
 */
public class Student extends Dictionary {
    private String gender; // 性别
    private Nation nation; // 民族
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private LocalDate birthday; // 出生日期
    private Region addressRegion; // 住址（地区）
    private String address; // 住址（详细地址）
    private String idNumber; // 身份证号
    private School school; // 在读学校
    private String mobilePhoneNumber; // 手机号码

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Region getAddressRegion() {
        return addressRegion;
    }

    public void setAddressRegion(Region addressRegion) {
        this.addressRegion = addressRegion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }
}
