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

    //�������ְ���set/get����ĵ��ʽ�����ĸ��ΪСд
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
