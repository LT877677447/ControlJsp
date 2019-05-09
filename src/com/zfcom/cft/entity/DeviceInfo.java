package com.zfcom.cft.entity;

import java.io.Serializable;
import java.util.Date;

public class DeviceInfo implements Serializable {
    private String device_tag;
    private Integer clientid;
    private String phone_type;
    private Integer alloc_adv;
    private String alloc_adv_temp;
    private String ext;
    private String ext_old;
    private Date registtime;
    private Date alloctime;
    private Integer alloc_type_old;
    private Integer alloc_type;
    private Integer vpnid;
    private Integer advstatus_reset;
    private Integer nouse;
    private Integer hand_locked;

    public DeviceInfo() {
    }

    public DeviceInfo(String device_tag, Integer clientid, String phone_type, Integer alloc_adv, String alloc_adv_temp, String ext, String ext_old, Date registtime, Date alloctime, Integer alloc_type_old, Integer alloc_type, Integer vpnid, Integer advstatus_reset, Integer nouse, Integer hand_locked) {
        this.device_tag = device_tag;
        this.clientid = clientid;
        this.phone_type = phone_type;
        this.alloc_adv = alloc_adv;
        this.alloc_adv_temp = alloc_adv_temp;
        this.ext = ext;
        this.ext_old = ext_old;
        this.registtime = registtime;
        this.alloctime = alloctime;
        this.alloc_type_old = alloc_type_old;
        this.alloc_type = alloc_type;
        this.vpnid = vpnid;
        this.advstatus_reset = advstatus_reset;
        this.nouse = nouse;
        this.hand_locked = hand_locked;
    }

    public String getDevice_tag() {
        return device_tag;
    }

    public void setDevice_tag(String device_tag) {
        this.device_tag = device_tag;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getPhone_type() {
        return phone_type;
    }

    public void setPhone_type(String phone_type) {
        this.phone_type = phone_type;
    }

    public Integer getAlloc_adv() {
        return alloc_adv;
    }

    public void setAlloc_adv(Integer alloc_adv) {
        this.alloc_adv = alloc_adv;
    }

    public String getAlloc_adv_temp() {
        return alloc_adv_temp;
    }

    public void setAlloc_adv_temp(String alloc_adv_temp) {
        this.alloc_adv_temp = alloc_adv_temp;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getExt_old() {
        return ext_old;
    }

    public void setExt_old(String ext_old) {
        this.ext_old = ext_old;
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }

    public Date getAlloctime() {
        return alloctime;
    }

    public void setAlloctime(Date alloctime) {
        this.alloctime = alloctime;
    }

    public Integer getAlloc_type_old() {
        return alloc_type_old;
    }

    public void setAlloc_type_old(Integer alloc_type_old) {
        this.alloc_type_old = alloc_type_old;
    }

    public Integer getAlloc_type() {
        return alloc_type;
    }

    public void setAlloc_type(Integer alloc_type) {
        this.alloc_type = alloc_type;
    }

    public Integer getVpnid() {
        return vpnid;
    }

    public void setVpnid(Integer vpnid) {
        this.vpnid = vpnid;
    }

    public Integer getAdvstatus_reset() {
        return advstatus_reset;
    }

    public void setAdvstatus_reset(Integer advstatus_reset) {
        this.advstatus_reset = advstatus_reset;
    }

    public Integer getNouse() {
        return nouse;
    }

    public void setNouse(Integer nouse) {
        this.nouse = nouse;
    }

    public Integer getHand_locked() {
        return hand_locked;
    }

    public void setHand_locked(Integer hand_locked) {
        this.hand_locked = hand_locked;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "device_tag='" + device_tag + '\'' +
                ", clientid=" + clientid +
                ", phone_type='" + phone_type + '\'' +
                ", alloc_adv=" + alloc_adv +
                ", alloc_adv_temp='" + alloc_adv_temp + '\'' +
                ", ext='" + ext + '\'' +
                ", ext_old='" + ext_old + '\'' +
                ", registtime=" + registtime +
                ", alloctime=" + alloctime +
                ", alloc_type_old=" + alloc_type_old +
                ", alloc_type=" + alloc_type +
                ", vpnid=" + vpnid +
                ", advstatus_reset=" + advstatus_reset +
                ", nouse=" + nouse +
                ", hand_locked=" + hand_locked +
                '}';
    }
}
