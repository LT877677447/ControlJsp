package com.zfcom.cft.entity;

import java.io.Serializable;
import java.util.Date;

public class TodayResult implements Serializable {
    private Integer tid;
    private Integer advid;
    private Integer isremain;
    private Integer newuser_success_count;
    private Integer newuser_err_count;
    private Integer newuser_success_opentcount;
    private Integer newuser_err_opentcount;
    private Integer remain_olduser_success_count;
    private Integer remain_newuser_success_count;
    private Integer remain_olduser_success_opentcount;
    private Integer remain_newuser_success_opentcount;
    private Integer remain_err_opentcount;

    private Date result_time;

    public TodayResult() {
    }

    public TodayResult(Integer tid, Integer advid, Integer isremain, Integer newuser_success_count, Integer newuser_err_count, Integer newuser_success_opentcount, Integer newuser_err_opentcount, Integer remain_olduser_success_count, Integer remain_newuser_success_count, Integer remain_olduser_success_opentcount, Integer remain_newuser_success_opentcount, Integer remain_err_opentcount, Date result_time) {
        this.tid = tid;
        this.advid = advid;
        this.isremain = isremain;
        this.newuser_success_count = newuser_success_count;
        this.newuser_err_count = newuser_err_count;
        this.newuser_success_opentcount = newuser_success_opentcount;
        this.newuser_err_opentcount = newuser_err_opentcount;
        this.remain_olduser_success_count = remain_olduser_success_count;
        this.remain_newuser_success_count = remain_newuser_success_count;
        this.remain_olduser_success_opentcount = remain_olduser_success_opentcount;
        this.remain_newuser_success_opentcount = remain_newuser_success_opentcount;
        this.remain_err_opentcount = remain_err_opentcount;
        this.result_time = result_time;
    }


    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getAdvid() {
        return advid;
    }

    public void setAdvid(Integer advid) {
        this.advid = advid;
    }

    public Integer getIsremain() {
        return isremain;
    }

    public void setIsremain(Integer isremain) {
        this.isremain = isremain;
    }

    public Integer getNewuser_success_count() {
        return newuser_success_count;
    }

    public void setNewuser_success_count(Integer newuser_success_count) {
        this.newuser_success_count = newuser_success_count;
    }

    public Integer getNewuser_err_count() {
        return newuser_err_count;
    }

    public void setNewuser_err_count(Integer newuser_err_count) {
        this.newuser_err_count = newuser_err_count;
    }

    public Integer getNewuser_success_opentcount() {
        return newuser_success_opentcount;
    }

    public void setNewuser_success_opentcount(Integer newuser_success_opentcount) {
        this.newuser_success_opentcount = newuser_success_opentcount;
    }

    public Integer getNewuser_err_opentcount() {
        return newuser_err_opentcount;
    }

    public void setNewuser_err_opentcount(Integer newuser_err_opentcount) {
        this.newuser_err_opentcount = newuser_err_opentcount;
    }

    public Integer getRemain_olduser_success_count() {
        return remain_olduser_success_count;
    }

    public void setRemain_olduser_success_count(Integer remain_olduser_success_count) {
        this.remain_olduser_success_count = remain_olduser_success_count;
    }

    public Integer getRemain_newuser_success_count() {
        return remain_newuser_success_count;
    }

    public void setRemain_newuser_success_count(Integer remain_newuser_success_count) {
        this.remain_newuser_success_count = remain_newuser_success_count;
    }

    public Integer getRemain_olduser_success_opentcount() {
        return remain_olduser_success_opentcount;
    }

    public void setRemain_olduser_success_opentcount(Integer remain_olduser_success_opentcount) {
        this.remain_olduser_success_opentcount = remain_olduser_success_opentcount;
    }

    public Integer getRemain_newuser_success_opentcount() {
        return remain_newuser_success_opentcount;
    }

    public void setRemain_newuser_success_opentcount(Integer remain_newuser_success_opentcount) {
        this.remain_newuser_success_opentcount = remain_newuser_success_opentcount;
    }

    public Integer getRemain_err_opentcount() {
        return remain_err_opentcount;
    }

    public void setRemain_err_opentcount(Integer remain_err_opentcount) {
        this.remain_err_opentcount = remain_err_opentcount;
    }

    public Date getResult_time() {
        return result_time;
    }

    public void setResult_time(Date result_time) {
        this.result_time = result_time;
    }


    @Override
    public String toString() {
        return "TodayResult{" +
                "tid=" + tid +
                ", advid=" + advid +
                ", isremain=" + isremain +
                ", newuser_success_count=" + newuser_success_count +
                ", newuser_err_count=" + newuser_err_count +
                ", newuser_success_opentcount=" + newuser_success_opentcount +
                ", newuser_err_opentcount=" + newuser_err_opentcount +
                ", remain_olduser_success_count=" + remain_olduser_success_count +
                ", remain_newuser_success_count=" + remain_newuser_success_count +
                ", remain_olduser_success_opentcount=" + remain_olduser_success_opentcount +
                ", remain_newuser_success_opentcount=" + remain_newuser_success_opentcount +
                ", remain_err_opentcount=" + remain_err_opentcount +
                ", result_time=" + result_time +
                '}';
    }
}
