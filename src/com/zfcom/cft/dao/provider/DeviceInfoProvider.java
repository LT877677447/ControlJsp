package com.zfcom.cft.dao.provider;

import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.entity.DeviceInfo;
import com.zfcom.cft.utils.Constants;
import com.zfcom.cft.utils.MyDateTool;
import com.zfcom.cft.utils.PageModel;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

@SuppressWarnings("Duplicates")
public class DeviceInfoProvider {
    public String selectByPage(Map<String, Object> params) {
        PageModel pageModel = (PageModel) params.get("pageModel");
        DeviceInfo deviceInfo = (DeviceInfo) params.get("DeviceInfo");

        String sql = new SQL() {
            {
                SELECT("top " + pageModel.getPageSize() + " * ");
                FROM(Constants.TABLE_DeviceInfo);
                if (null != deviceInfo) {
                    if (deviceInfo.getDevice_tag() != null) {
                        WHERE(" device_tag = #{deviceInfo.device_tag}");
                    }
                    if (deviceInfo.getClientid() != null) {
                        WHERE(" clientid = #{deviceInfo.clientid}");
                    }
                    if (deviceInfo.getPhone_type() != null) {
                        WHERE(" phone_type = #{deviceInfo.phone_type}");
                    }
                    if (deviceInfo.getAlloc_adv() != null) {
                        WHERE(" alloc_adv = #{deviceInfo.alloc_adv}");
                    }
                    if (deviceInfo.getAlloc_adv_temp() != null) {
                        WHERE(" alloc_adv_temp = #{deviceInfo.alloc_adv_temp}");
                    }
                    if (deviceInfo.getExt() != null) {
                        WHERE(" ext = #{deviceInfo.ext}");
                    }
                    if (deviceInfo.getExt_old() != null) {
                        WHERE(" ext_old = #{deviceInfo.ext_old}");
                    }
                    if (deviceInfo.getRegisttime() != null) {
                        WHERE(" registtime = "+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",deviceInfo.getRegisttime())+" ");
                    }
                    if (deviceInfo.getAlloctime() != null) {
                        WHERE(" alloctime = "+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",deviceInfo.getAlloctime())+" ");
                    }
                    if (deviceInfo.getAlloc_type_old() != null) {
                        WHERE(" alloc_type_old = #{deviceInfo.alloc_type_old}");
                    }
                    if (deviceInfo.getAlloc_type() != null) {
                        WHERE(" alloc_type = #{deviceInfo.alloc_type}");
                    }
                    if (deviceInfo.getVpnid() != null) {
                        WHERE(" vpnid = #{deviceInfo.vpnid}");
                    }
                    if (deviceInfo.getAdvstatus_reset() != null) {
                        WHERE(" advstatus_reset = #{deviceInfo.advstatus_reset}");
                    }
                    if (deviceInfo.getNouse() != null) {
                        WHERE(" nouse = #{deviceInfo.nouse}");
                    }
                    if (deviceInfo.getHand_locked() != null) {
                        WHERE(" hand_locked = #{deviceInfo.hand_locked}");
                    }
                }
                WHERE(selectAdvtaskInfoByPage_Subselect(pageModel, deviceInfo));
                if (pageModel.getOrder() != null) {
                    ORDER_BY(pageModel.getOrder());
                }
            }
        }.toString();
        return sql;
    }

    public String count(Map<String, Object> params) {
        DeviceInfo deviceInfo = (DeviceInfo) params.get("DeviceInfo");

        String sql = new SQL() {
            {
                SELECT("COUNT(*)");

                FROM(Constants.TABLE_DeviceInfo);
                if (null != deviceInfo) {
                    if (deviceInfo.getDevice_tag() != null) {
                        WHERE(" device_tag = #{deviceInfo.device_tag}");
                    }
                    if (deviceInfo.getClientid() != null) {
                        WHERE(" clientid = #{deviceInfo.clientid}");
                    }
                    if (deviceInfo.getPhone_type() != null) {
                        WHERE(" phone_type = #{deviceInfo.phone_type}");
                    }
                    if (deviceInfo.getAlloc_adv() != null) {
                        WHERE(" alloc_adv = #{deviceInfo.alloc_adv}");
                    }
                    if (deviceInfo.getAlloc_adv_temp() != null) {
                        WHERE(" alloc_adv_temp = #{deviceInfo.alloc_adv_temp}");
                    }
                    if (deviceInfo.getExt() != null) {
                        WHERE(" ext = #{deviceInfo.ext}");
                    }
                    if (deviceInfo.getExt_old() != null) {
                        WHERE(" ext_old = #{deviceInfo.ext_old}");
                    }
                    if (deviceInfo.getRegisttime() != null) {
                        WHERE(" registtime = "+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",deviceInfo.getRegisttime())+" ");
                    }
                    if (deviceInfo.getAlloctime() != null) {
                        WHERE(" alloctime = "+MyDateTool.Format("yyyy-MM-dd HH:mm:ss",deviceInfo.getAlloctime())+" ");
                    }
                    if (deviceInfo.getAlloc_type_old() != null) {
                        WHERE(" alloc_type_old = #{deviceInfo.alloc_type_old}");
                    }
                    if (deviceInfo.getAlloc_type() != null) {
                        WHERE(" alloc_type = #{deviceInfo.alloc_type}");
                    }
                    if (deviceInfo.getVpnid() != null) {
                        WHERE(" vpnid = #{deviceInfo.vpnid}");
                    }
                    if (deviceInfo.getAdvstatus_reset() != null) {
                        WHERE(" advstatus_reset = #{deviceInfo.advstatus_reset}");
                    }
                    if (deviceInfo.getNouse() != null) {
                        WHERE(" nouse = #{deviceInfo.nouse}");
                    }
                    if (deviceInfo.getHand_locked() != null) {
                        WHERE(" hand_locked = #{deviceInfo.hand_locked}");
                    }
                }
            }
        }.toString();
        return sql;

    }

    private String selectAdvtaskInfoByPage_Subselect(PageModel pageModel, DeviceInfo deviceInfo) {
        String sql = "device_tag not in (select top ";
        sql += (pageModel.getPageIndex() - 1) * pageModel.getPageSize();
        sql += " device_tag from " + Constants.TABLE_DeviceInfo;
        sql += " where 1=1 ";
        if (null != deviceInfo) {
            if (deviceInfo.getDevice_tag() != null) {
                sql += " and device_tag = " + deviceInfo.getDevice_tag();
            }
            if (deviceInfo.getClientid() != null) {
                sql += " and clientid = " + deviceInfo.getClientid();
            }
            if (deviceInfo.getPhone_type() != null) {
                sql += " and phone_type = " + deviceInfo.getPhone_type();
            }
            if (deviceInfo.getAlloc_adv() != null) {
                sql += " and alloc_adv = " + deviceInfo.getAlloc_adv();
            }
            if (deviceInfo.getAlloc_adv_temp() != null) {
                sql += " and alloc_adv_temp = " + deviceInfo.getAlloc_adv_temp();
            }
            if (deviceInfo.getExt() != null) {
                sql += " and ext = " + deviceInfo.getExt();
            }
            if (deviceInfo.getExt_old() != null) {
                sql += " and ext_old = " + deviceInfo.getExt_old();
            }
            if (deviceInfo.getRegisttime() != null) {
                sql += " and registtime = " + MyDateTool.Format("yyyy-MM-dd HH:mm:ss",deviceInfo.getRegisttime());
            }
            if (deviceInfo.getAlloctime() != null) {
                sql += " and alloc_time = " + MyDateTool.Format("yyyy-MM-dd HH:mm:ss",deviceInfo.getAlloctime());
            }
            if (deviceInfo.getAlloc_type_old() != null) {
                sql += " and alloc_type_old = " + deviceInfo.getAlloc_type_old();
            }
            if (deviceInfo.getAlloc_type() != null) {
                sql += " and alloc_type = " + deviceInfo.getAlloc_type();
            }
            if (deviceInfo.getVpnid() != null) {
                sql += " and vpnid = " + deviceInfo.getVpnid();
            }
            if (deviceInfo.getAdvstatus_reset() != null) {
                sql += " and advstatus_reset = " + deviceInfo.getAdvstatus_reset();
            }
            if (deviceInfo.getNouse() != null) {
                sql += " and nouse = " + deviceInfo.getNouse();
            }
            if (deviceInfo.getHand_locked() != null) {
                sql += " and hand_locked = " + deviceInfo.getHand_locked();
            }
        }
        if (pageModel.getOrder() != null) {
            sql += " order by " + pageModel.getOrder();
        }
        sql += " )";
        return sql;
    }

    public String update(DeviceInfo deviceInfo){
        SQL sql = new SQL() {
            {
                UPDATE(Constants.TABLE_DeviceInfo);
                if (null != deviceInfo.getDevice_tag()) {
                    SET(" device_tag = #{device_tag}");
                }
                if (null != deviceInfo.getClientid()) {
                    SET(" clientid = #{clientid}");
                }
                if (null != deviceInfo.getPhone_type()) {
                    SET(" phone_type = #{phone_type}");
                }
                if (null != deviceInfo.getAlloc_adv()) {
                    SET(" alloc_adv = #{alloc_adv}");
                }
                if (null != deviceInfo.getAlloc_adv_temp()) {
                    SET(" alloc_adv_temp = #{alloc_adv_temp}");
                }
                if (null != deviceInfo.getExt_old()) {
                    SET(" ext = #{ext}");
                }
                if (null != deviceInfo.getExt_old()) {
                    SET(" ext_old = #{ext_old}");
                }
                if (null != deviceInfo.getRegisttime()) {
                    SET(" registtime = '" + MyDateTool.Format("yyyy-MM-dd HH:mm:ss", deviceInfo.getRegisttime())+"'");
                }
                if (null != deviceInfo.getAlloctime()) {
                    SET(" alloctime = '" + MyDateTool.Format("yyyy-MM-dd HH:mm:ss", deviceInfo.getAlloctime())+"'");
                }
                if (null != deviceInfo.getAlloc_type_old()) {
                    SET(" alloc_type_old = #{alloc_type_old}");
                }
                if (null != deviceInfo.getAlloc_type()) {
                    SET(" alloc_type = #{alloc_type}");
                }
                if (null != deviceInfo.getVpnid()) {
                    SET(" vpnid = #{vpnid}");
                }
                if (null != deviceInfo.getAdvstatus_reset()) {
                    SET(" advstatus_reset = #{advstatus_reset}");
                }
                if (null != deviceInfo.getNouse()) {
                    SET(" nouse = #{nouse}");
                }
                if (null != deviceInfo.getHand_locked()) {
                    SET(" hand_locked = #{hand_locked}");
                }
                WHERE(" device_tag = #{device_tag}");
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
