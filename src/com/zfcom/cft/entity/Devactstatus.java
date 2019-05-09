package com.zfcom.cft.entity;

import java.io.Serializable;
import java.util.Date;

public class Devactstatus implements Serializable {
    private Integer actsid;
    private String dev_tag;
    private Date lastlogintime;
    private Date lastfetchtasktime;
    private Integer online;
    private String status;

    public Devactstatus() {
    }

    public Devactstatus(Integer actsid, String dev_tag, Date lastlogintime, Date lastfetchtasktime, Integer online, String status) {
        this.actsid = actsid;
        this.dev_tag = dev_tag;
        this.lastlogintime = lastlogintime;
        this.lastfetchtasktime = lastfetchtasktime;
        this.online = online;
        this.status = status;
    }

    public Integer getActsid() {
        return actsid;
    }

    public void setActsid(Integer actsid) {
        this.actsid = actsid;
    }

    public String getDev_tag() {
        return dev_tag;
    }

    public void setDev_tag(String dev_tag) {
        this.dev_tag = dev_tag;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Date getLastfetchtasktime() {
        return lastfetchtasktime;
    }

    public void setLastfetchtasktime(Date lastfetchtasktime) {
        this.lastfetchtasktime = lastfetchtasktime;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Devactstatus{" +
                "actsid=" + actsid +
                ", dev_tag='" + dev_tag + '\'' +
                ", lastlogintime=" + lastlogintime +
                ", lastfetchtasktime=" + lastfetchtasktime +
                ", online=" + online +
                ", status='" + status + '\'' +
                '}';
    }
}
