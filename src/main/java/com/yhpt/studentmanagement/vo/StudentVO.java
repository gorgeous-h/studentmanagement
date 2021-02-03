package com.yhpt.studentmanagement.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: hjj
 * @Date: 2020/11/19 16:07
 * @Description:
 */
public class StudentVO {
    private Integer id;
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;
    private Integer schoolId;
    private String schoolName;
    private String schoolRegionName; // 学校所在的 省/市/区
    private String schoolTypeName; // 学校的类型
    private Integer provinceId;
    private Integer cityId;
    private Integer regionId;
    private Integer schoolTypeId;
    private String gender;
    private Integer nationId;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private LocalDate birthday; // 出生日期
    private Integer addressRegionId;
    private String address; // 住址（详细地址）
    private String idNumber; // 身份证号
    private String mobilePhoneNumber; // 手机号码
    private Integer addressProvinceId;
    private Integer addressCityId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolRegionName() {
        return schoolRegionName;
    }

    public void setSchoolRegionName(String schoolRegionName) {
        this.schoolRegionName = schoolRegionName;
    }

    public String getSchoolTypeName() {
        return schoolTypeName;
    }

    public void setSchoolTypeName(String schoolTypeName) {
        this.schoolTypeName = schoolTypeName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getSchoolTypeId() {
        return schoolTypeId;
    }

    public void setSchoolTypeId(Integer schoolTypeId) {
        this.schoolTypeId = schoolTypeId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getAddressRegionId() {
        return addressRegionId;
    }

    public void setAddressRegionId(Integer addressRegionId) {
        this.addressRegionId = addressRegionId;
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

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Integer getAddressProvinceId() {
        return addressProvinceId;
    }

    public void setAddressProvinceId(Integer addressProvinceId) {
        this.addressProvinceId = addressProvinceId;
    }

    public Integer getAddressCityId() {
        return addressCityId;
    }

    public void setAddressCityId(Integer addressCityId) {
        this.addressCityId = addressCityId;
    }
}
