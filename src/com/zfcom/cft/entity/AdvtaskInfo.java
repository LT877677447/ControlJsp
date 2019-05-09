package com.zfcom.cft.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class AdvtaskInfo implements Serializable {
    private Integer adv_id;
    private String name;
    private Integer prior;
    private Integer adv_type;
    private Integer apkid;
    private Integer cpid;
    private Integer channelid;
    private Integer bdid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end_date;
    private String adv_content;
    private String serverbean;
    private String params;
    private String clientbean_info;
    private Integer requesttime;
    private Integer remaintime;
    private Integer timeline;
    private Integer rem_timeline;
    private Integer remain_lock_dev;
    private String remain_rule;
    private Integer allcount;
    private Integer dayopencount;
    private Integer dayusercount;
    private Integer alldocount;
    private String ext;
    private Integer onlineflag;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date online_time;
    private String alias;

    public AdvtaskInfo() {
    }

    public AdvtaskInfo(Integer adv_id, String name, Integer prior, Integer adv_type, Integer apkid, Integer cpid, Integer channelid, Integer bdid, Date start_date, Date end_date, String adv_content, String serverbean, String params, String clientbean_info, Integer requesttime, Integer remaintime, Integer timeline, Integer rem_timeline, Integer remain_lock_dev, String remain_rule, Integer allcount, Integer dayopencount, Integer dayusercount, Integer alldocount, String ext, Integer onlineflag, Date online_time, String alias) {
        this.adv_id = adv_id;
        this.name = name;
        this.prior = prior;
        this.adv_type = adv_type;
        this.apkid = apkid;
        this.cpid = cpid;
        this.channelid = channelid;
        this.bdid = bdid;
        this.start_date = start_date;
        this.end_date = end_date;
        this.adv_content = adv_content;
        this.serverbean = serverbean;
        this.params = params;
        this.clientbean_info = clientbean_info;
        this.requesttime = requesttime;
        this.remaintime = remaintime;
        this.timeline = timeline;
        this.rem_timeline = rem_timeline;
        this.remain_lock_dev = remain_lock_dev;
        this.remain_rule = remain_rule;
        this.allcount = allcount;
        this.dayopencount = dayopencount;
        this.dayusercount = dayusercount;
        this.alldocount = alldocount;
        this.ext = ext;
        this.onlineflag = onlineflag;
        this.online_time = online_time;
        this.alias = alias;
    }

    public Integer getAdv_id() {
        return adv_id;
    }

    public void setAdv_id(Integer adv_id) {
        this.adv_id = adv_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrior() {
        return prior;
    }

    public void setPrior(Integer prior) {
        this.prior = prior;
    }

    public Integer getAdv_type() {
        return adv_type;
    }

    public void setAdv_type(Integer adv_type) {
        this.adv_type = adv_type;
    }

    public Integer getApkid() {
        return apkid;
    }

    public void setApkid(Integer apkid) {
        this.apkid = apkid;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public Integer getChannelid() {
        return channelid;
    }

    public void setChannelid(Integer channelid) {
        this.channelid = channelid;
    }

    public Integer getBdid() {
        return bdid;
    }

    public void setBdid(Integer bdid) {
        this.bdid = bdid;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getAdv_content() {
        return adv_content;
    }

    public void setAdv_content(String adv_content) {
        this.adv_content = adv_content;
    }

    public String getServerbean() {
        return serverbean;
    }

    public void setServerbean(String serverbean) {
        this.serverbean = serverbean;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getClientbean_info() {
        return clientbean_info;
    }

    public void setClientbean_info(String clientbean_info) {
        this.clientbean_info = clientbean_info;
    }

    public Integer getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(Integer requesttime) {
        this.requesttime = requesttime;
    }

    public Integer getRemaintime() {
        return remaintime;
    }

    public void setRemaintime(Integer remaintime) {
        this.remaintime = remaintime;
    }

    public Integer getTimeline() {
        return timeline;
    }

    public void setTimeline(Integer timeline) {
        this.timeline = timeline;
    }

    public Integer getRem_timeline() {
        return rem_timeline;
    }

    public void setRem_timeline(Integer rem_timeline) {
        this.rem_timeline = rem_timeline;
    }

    public Integer getRemain_lock_dev() {
        return remain_lock_dev;
    }

    public void setRemain_lock_dev(Integer remain_lock_dev) {
        this.remain_lock_dev = remain_lock_dev;
    }

    public String getRemain_rule() {
        return remain_rule;
    }

    public void setRemain_rule(String remain_rule) {
        this.remain_rule = remain_rule;
    }

    public Integer getAllcount() {
        return allcount;
    }

    public void setAllcount(Integer allcount) {
        this.allcount = allcount;
    }

    public Integer getDayopencount() {
        return dayopencount;
    }

    public void setDayopencount(Integer dayopencount) {
        this.dayopencount = dayopencount;
    }

    public Integer getDayusercount() {
        return dayusercount;
    }

    public void setDayusercount(Integer dayusercount) {
        this.dayusercount = dayusercount;
    }

    public Integer getAlldocount() {
        return alldocount;
    }

    public void setAlldocount(Integer alldocount) {
        this.alldocount = alldocount;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Integer getOnlineflag() {
        return onlineflag;
    }

    public void setOnlineflag(Integer onlineflag) {
        this.onlineflag = onlineflag;
    }

    public Date getOnline_time() {
        return online_time;
    }

    public void setOnline_time(Date online_time) {
        this.online_time = online_time;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "AdvtaskInfo{" +
                "adv_id=" + adv_id +
                ", name='" + name + '\'' +
                ", prior=" + prior +
                ", adv_type=" + adv_type +
                ", apkid=" + apkid +
                ", cpid=" + cpid +
                ", channelid=" + channelid +
                ", bdid=" + bdid +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", adv_content='" + adv_content + '\'' +
                ", serverbean='" + serverbean + '\'' +
                ", params='" + params + '\'' +
                ", clientbean_info='" + clientbean_info + '\'' +
                ", requesttime=" + requesttime +
                ", remaintime=" + remaintime +
                ", timeline=" + timeline +
                ", rem_timeline=" + rem_timeline +
                ", remain_lock_dev=" + remain_lock_dev +
                ", remain_rule='" + remain_rule + '\'' +
                ", allcount=" + allcount +
                ", dayopencount=" + dayopencount +
                ", dayusercount=" + dayusercount +
                ", alldocount=" + alldocount +
                ", ext='" + ext + '\'' +
                ", onlineflag=" + onlineflag +
                ", online_time=" + online_time +
                ", alias='" + alias + '\'' +
                '}';
    }
}
