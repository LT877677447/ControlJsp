package com.zfcom.cft.dao.provider;

import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.entity.Devactstatus;
import com.zfcom.cft.utils.Constants;
import com.zfcom.cft.utils.MyDateTool;
import com.zfcom.cft.utils.PageModel;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

@SuppressWarnings("Duplicates")
public class DevactstatusProvider {
    public String selectByPage(Map<String, Object> params) {
        PageModel pageModel = (PageModel) params.get("pageModel");
        Devactstatus devactstatus = (Devactstatus) params.get("Devactstatus");
        String sql = new SQL() {
            {
                SELECT("top " + pageModel.getPageSize() + " * ");
                FROM(Constants.TABLE_Devactstatus);
                if (null != devactstatus) {
                    if (devactstatus.getActsid() != null) {
                        WHERE(" actsid = #{devactstatus.actsid}");
                    }
                    if (devactstatus.getDev_tag() != null) {
                        WHERE(" dev_tag = #{devactstatus.dev_tag}");
                    }
                    if (devactstatus.getLastlogintime() != null) {
                        WHERE(" lastlogintime = "+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",devactstatus.getLastlogintime())+" ");
                    }
                    if (devactstatus.getLastfetchtasktime() != null) {
                        WHERE(" lastfetchtasktime = "+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",devactstatus.getLastfetchtasktime())+" ");
                    }
                    if (devactstatus.getOnline() != null) {
                        WHERE(" online = #{devactstatus.online}");
                    }
                }
                WHERE(selectAdvtaskInfoByPage_Subselect(pageModel, devactstatus));
                if (pageModel.getOrder() != null) {
                    ORDER_BY(pageModel.getOrder());
                }
            }
        }.toString();
        return sql;
    }

    public String count(Map<String, Object> params) {
        Devactstatus devactstatus = (Devactstatus) params.get("Devactstatus");
        String sql = new SQL() {
            {
                SELECT("COUNT(*)");
                FROM(Constants.TABLE_Devactstatus);
                if (null != devactstatus) {
                    if (devactstatus.getActsid() != null) {
                        WHERE(" actsid = #{devactstatus.actsid}");
                    }
                    if (devactstatus.getDev_tag() != null) {
                        WHERE(" dev_tag = #{devactstatus.dev_tag}");
                    }
                    if (devactstatus.getLastlogintime() != null) {
                        WHERE(" lastlogintime = "+MyDateTool.Format("yyyy-MM-dd HH:mm:ss", devactstatus.getLastlogintime())+" ");
                    }
                    if (devactstatus.getLastfetchtasktime() != null) {
                        WHERE(" lastfetchtasktime = "+MyDateTool.Format("yyyy-MM-dd HH:mm:ss", devactstatus.getLastfetchtasktime())+" ");
                    }
                    if (devactstatus.getOnline() != null) {
                        WHERE(" online = #{devactstatus.online}");
                    }
                }
            }
        }.toString();
        return sql;
    }

    private String selectAdvtaskInfoByPage_Subselect(PageModel pageModel, Devactstatus devactstatus) {
        String sql = "dev_tag not in (select top ";
        sql += (pageModel.getPageIndex() - 1) * pageModel.getPageSize();
        sql += " dev_tag from " + Constants.TABLE_Devactstatus;
        sql += " where 1=1 ";
        if (null != devactstatus) {
            if (devactstatus.getActsid() != null) {
                sql += " and actsid = " + devactstatus.getActsid();
            }
            if (devactstatus.getDev_tag() != null) {
                sql += " and dev_tag = " + devactstatus.getDev_tag();
            }
            if (devactstatus.getStatus() != null) {
                sql += " and status = " + devactstatus.getStatus();
            }
            if (devactstatus.getOnline() != null) {
                sql += " and online = " + devactstatus.getOnline();
            }
            if (devactstatus.getLastfetchtasktime() != null) {
                sql += " and lastfetchtasktime = " + MyDateTool.Format("yyyy-MM-dd HH:mm:ss",devactstatus.getLastfetchtasktime());
            }
            if (devactstatus.getLastlogintime() != null) {
                sql += " and lastlogintime = " + MyDateTool.Format("yyyy-MM-dd HH:mm:ss",devactstatus.getLastlogintime());
            }
        }
        if (pageModel.getOrder() != null) {
            sql += " order by " + pageModel.getOrder();
        }
        sql += " )";
        return sql;
    }

    public String update(AdvtaskInfo advtaskInfo) {
        SQL sql = new SQL() {
            {
                UPDATE(Constants.TABLE_AdvtaskInfo);
                if (null != advtaskInfo.getApkid()) {
                    SET(" apkid = #{apkid}");
                }
                if (null != advtaskInfo.getOnlineflag()) {
                    SET(" onlineflag = #{onlineflag}");
                }
                if (null != advtaskInfo.getAdv_type()) {
                    SET(" adv_type = #{adv_type}");
                }
                if (null != advtaskInfo.getName()) {
                    SET(" name = #{name}");
                }
                if (null != advtaskInfo.getAdv_id()) {
                    SET(" adv_id = #{adv_id}");
                }
                if (null != advtaskInfo.getEnd_date()) {
                    SET(" end_date = '" + MyDateTool.Format("yyyy-MM-dd HH:mm:ss", advtaskInfo.getEnd_date())+"'");
                }
                if (null != advtaskInfo.getStart_date()) {
                    SET(" start_date = '" + MyDateTool.Format("yyyy-MM-dd HH:mm:ss", advtaskInfo.getStart_date())+"'");
                }
                if (null != advtaskInfo.getAdv_content()) {
                    SET(" adv_content = #{adv_content}");
                }
                if (null != advtaskInfo.getAlias()) {
                    SET(" alias = #{alias}");
                }
                if (null != advtaskInfo.getAllcount()) {
                    SET(" allcount = #{allcount}");
                }
                if (null != advtaskInfo.getAlldocount()) {
                    SET(" alldocount = #{alldocount}");
                }
                if (null != advtaskInfo.getDayopencount()) {
                    SET(" dayopencount = #{dayopencount}");
                }
                if (null != advtaskInfo.getDayusercount()) {
                    SET(" dayusercount = #{dayusercount}");
                }
                if (null != advtaskInfo.getPrior()) {
                    SET(" prior = #{prior}");
                }
                if (null != advtaskInfo.getRem_timeline()) {
                    SET(" rem_timeline = #{rem_timeline}");
                }
                if (null != advtaskInfo.getRemain_rule()) {
                    SET(" remain_rule = #{remain_rule}");
                }
                if (null != advtaskInfo.getRemaintime()) {
                    SET(" remaintime = #{remaintime}");
                }
                if (null != advtaskInfo.getRequesttime()) {
                    SET(" requesttime = #{requesttime}");
                }
                if (null != advtaskInfo.getTimeline()) {
                    SET(" timeline = #{timeline}");
                }
                WHERE(" adv_id = #{adv_id}");
            }
        };
        String sre = sql.toString();
        return sre;
    }

    public String insert(AdvtaskInfo advtaskInfo){
        return new SQL(){
            {
                INSERT_INTO(Constants.TABLE_AdvtaskInfo);
                if(null != advtaskInfo.getAdv_id()){
                    VALUES("adv_id","#{adv_id}");
                }
                if(null != advtaskInfo.getName()){
                    VALUES("name","#{name}");
                }
                if(null != advtaskInfo.getPrior()){
                    VALUES("prior","#{prior}");
                }
                if(null != advtaskInfo.getAdv_type()){
                    VALUES("adv_type","#{adv_type}");
                }
                if(null != advtaskInfo.getApkid()){
                    VALUES("apkid","#{apkid}");
                }
                if(null != advtaskInfo.getCpid()){
                    VALUES("cpid","#{cpid}");
                }
                if(null != advtaskInfo.getChannelid()){
                    VALUES("channelid","#{channelid}");
                }
                if(null != advtaskInfo.getBdid()){
                    VALUES("bdid","#{bdid}");
                }
                if(null != advtaskInfo.getStart_date()){
                    VALUES("start_date","'"+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",advtaskInfo.getStart_date())+"'");
                }
                if(null != advtaskInfo.getEnd_date()){
                    VALUES("end_date","'"+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",advtaskInfo.getEnd_date())+"'");
                }
                if(null != advtaskInfo.getAdv_content()){
                    VALUES("adv_content","#{adv_content}");
                }
                if(null != advtaskInfo.getServerbean()){
                    VALUES("serverbean","#{serverbean}");
                }
                if(null != advtaskInfo.getParams()){
                    VALUES("params","#{params}");
                }
                if(null != advtaskInfo.getClientbean_info()){
                    VALUES("clientbean_info","#{clientbean_info}");
                }
                if(null != advtaskInfo.getRequesttime()){
                    VALUES("requesttime","#{requesttime}");
                }
                if(null != advtaskInfo.getRemaintime()){
                    VALUES("remaintime","#{remaintime}");
                }
                if(null != advtaskInfo.getTimeline()){
                    VALUES("timeline","#{timeline}");
                }
                if(null != advtaskInfo.getRem_timeline()){
                    VALUES("rem_timeline","#{rem_timeline}");
                }
                if(null != advtaskInfo.getRemain_lock_dev()){
                    VALUES("remain_lock_dev","#{remain_lock_dev}");
                }
                if(null != advtaskInfo.getRemain_rule()){
                    VALUES("remain_rule","#{remain_rule}");
                }
                if(null != advtaskInfo.getAllcount()){
                    VALUES("allcount","#{allcount}");
                }
                if(null != advtaskInfo.getDayopencount()){
                    VALUES("dayopencount","#{dayopencount}");
                }
                if(null != advtaskInfo.getDayusercount()){
                    VALUES("dayusercount","#{dayusercount}");
                }
                if(null != advtaskInfo.getAlldocount()){
                    VALUES("alldocount","#{alldocount}");
                }
                if(null != advtaskInfo.getExt()){
                    VALUES("ext","#{ext}");
                }
                if(null != advtaskInfo.getOnlineflag()){
                    VALUES("onlineflag","#{onlineflag}");
                }
                if(null != advtaskInfo.getOnline_time()){
                    VALUES("online_time","#{online_time}");
                }
                if(null != advtaskInfo.getAlias()){
                    VALUES("alias","#{alias}");
                }
            }
        }.toString();
    }
}
