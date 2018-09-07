package com.web.domain;

/**
 * @author hujtb
 * @create on 2018-08-17-11:18
 */
public class Address {
    private String street;
    private String doorNum;

    public String getSttreet() {
        return street;
    }

    //属性名字按照set/get后面的单词将首字母变为小写
    public void setSttreet(String street) {
        this.street = street;
    }

    public String getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(String doorNum) {
        this.doorNum = doorNum;
    }
}
