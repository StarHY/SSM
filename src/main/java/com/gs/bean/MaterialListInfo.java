package com.gs.bean;

import java.util.Date;

/**
 * Created by Xiao-Qiang on 2017/4/26.
 */
public class MaterialListInfo {
    private String materialId;
    private int materialCount;
    private Date materialCreatedTime;
    private String materialStatus;
    private String userName;
    private String userRequests;
    private String maintainName;
    private double maintainMoney;
    private String accName;

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public int getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(int materialCount) {
        this.materialCount = materialCount;
    }

    public Date getMaterialCreatedTime() {
        return materialCreatedTime;
    }

    public void setMaterialCreatedTime(Date materialCreatedTime) {
        this.materialCreatedTime = materialCreatedTime;
    }

    public String getMaterialStatus() {
        return materialStatus;
    }

    public void setMaterialStatus(String materialStatus) {
        this.materialStatus = materialStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRequests() {
        return userRequests;
    }

    public void setUserRequests(String userRequests) {
        this.userRequests = userRequests;
    }

    public String getMaintainName() {
        return maintainName;
    }

    public void setMaintainName(String maintainName) {
        this.maintainName = maintainName;
    }

    public double getMaintainMoney() {
        return maintainMoney;
    }

    public void setMaintainMoney(double maintainMoney) {
        this.maintainMoney = maintainMoney;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }
}
