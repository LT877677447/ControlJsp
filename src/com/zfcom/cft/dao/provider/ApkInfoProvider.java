package com.zfcom.cft.dao.provider;

import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.entity.ApkInfo;
import com.zfcom.cft.utils.Constants;
import com.zfcom.cft.utils.MyDateTool;
import com.zfcom.cft.utils.PageModel;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ApkInfoProvider {
    public String selectApkInfoByPage(Map<String, Object> params) {
        PageModel pageModel = (PageModel) params.get("pageModel");
        ApkInfo apkInfo = (ApkInfo) params.get("ApkInfo");

        String sql = new SQL() {
            {
                SELECT("top " + pageModel.getPageSize() + " * ");
                FROM(Constants.TABLE_ApkInfo);
                if (apkInfo != null && apkInfo.getApkid() != null) {
                    WHERE(" apkid = #{apkInfo.apkid}");
                }
                if (apkInfo != null && apkInfo.getPackagename() != null) {
                    WHERE(" packagename = #{apkInfo.packagename}");
                }
                if (apkInfo != null && apkInfo.getApkname() != null) {
                    WHERE(" apkname = #{apkInfo.apkname}");
                }
                if (apkInfo != null && apkInfo.getScriptfile_version() != null) {
                    WHERE(" scriptfile_version = #{apkInfo.scriptfile_version}");
                }
                WHERE(selectApkInfoByPage_Subselect(pageModel, apkInfo));
                if (pageModel.getOrder() != null) {
                    ORDER_BY(pageModel.getOrder());
                }
            }
        }.toString();
        return sql;
    }

    public String count(Map<String, Object> params) {
        ApkInfo apkInfo = (ApkInfo) params.get("ApkInfo");

        String sql = new SQL() {
            {
                SELECT("COUNT(*)");

                FROM(Constants.TABLE_ApkInfo);
                if (null != apkInfo) {
                    if (apkInfo.getApkid() != null) {
                        WHERE(" apkid = #{apkInfo.apkid}");
                    }
                    if (apkInfo.getPackagename() != null) {
                        WHERE(" packagename = #{apkInfo.packagename}");
                    }
                    if (apkInfo.getApkname() != null) {
                        WHERE(" apkname = #{apkInfo.apkname}");
                    }
                    if (apkInfo.getScriptfile_version() != null) {
                        WHERE(" scriptfile_version = #{apkInfo.scriptfile_version}");
                    }
                }
            }
        }.toString();
        return sql;

    }

    private String selectApkInfoByPage_Subselect(PageModel pageModel, ApkInfo apkInfo) {
        String sql = "apkid not in (select top ";
        sql += (pageModel.getPageIndex() - 1) * pageModel.getPageSize();
        sql += " apkid from " + Constants.TABLE_ApkInfo;
        sql += " where 1=1 ";
        if (apkInfo != null && apkInfo.getApkid() != null) {
            sql += " and apkid = " + apkInfo.getApkid();
        }
        if (apkInfo != null && apkInfo.getPackagename() != null) {
            sql += " and packagename = " + apkInfo.getPackagename();
        }
        if (apkInfo != null && apkInfo.getScriptfile_version() != null) {
            sql += " and scriptfile_version = " + apkInfo.getScriptfile_version();
        }
        if (pageModel.getOrder() != null) {
            sql += " order by " + pageModel.getOrder();
        }
        sql += " )";
        return sql;
    }

    public String update(ApkInfo apkInfo){
        SQL sql = new SQL() {
            {
                UPDATE(Constants.TABLE_ApkInfo);
                if (null != apkInfo.getApkid()) {
                    SET(" apkid = #{apkid}");
                }
                if (null != apkInfo.getPackagename()) {
                    SET(" packagename = #{packagename}");
                }
                if (null != apkInfo.getApkname()) {
                    SET(" apkname = #{apkname}");
                }
                if (null != apkInfo.getApkfile()) {
                    SET(" apkfile = #{apkfile}");
                }
                if (null != apkInfo.getReg_scriptfiles()) {
                    SET(" reg_scriptfiles = #{reg_scriptfiles}");
                }
                if (null != apkInfo.getRem_scriptfiles()) {
                    SET(" rem_scriptfiles = #{rem_scriptfiles}");
                }
                if (null != apkInfo.getZipfiles()) {
                    SET(" zipfiles = #{zipfiles}");
                }
                if (null != apkInfo.getUnzip_regex()) {
                    SET(" unzip_regex = #{unzip_regex}");
                }
                if (null != apkInfo.getRegscriptparams()) {
                    SET(" regscriptparams = #{regscriptparams}");
                }
                if (null != apkInfo.getRemscriptparams()) {
                    SET(" remscriptparams = #{remscriptparams}");
                }
                if (null != apkInfo.getSdcard_dir()) {
                    SET(" sdcard_dir = #{sdcard_dir}");
                }
                if (null != apkInfo.getScriptfile_version()) {
                    SET(" scriptfile_version = #{scriptfile_version}");
                }
                WHERE(" apkid = #{apkid}");
            }
        };
        String sre = sql.toString();
        return sre;
    }

    public String insert(ApkInfo apkInfo){
        return new SQL(){
            {
                INSERT_INTO(Constants.TABLE_ApkInfo);
                if(null != apkInfo.getApkid()){
                    VALUES("apkid","#{apkid}");
                }
                if(null != apkInfo.getPackagename()){
                    VALUES("packagename","#{packagename}");
                }
                if(null != apkInfo.getApkname()){
                    VALUES("apkname","#{apkname}");
                }
                if(null != apkInfo.getApkfile()){
                    VALUES("apkfile","#{apkfile}");
                }
                if(null != apkInfo.getReg_scriptfiles()){
                    VALUES("reg_scriptfiles","#{reg_scriptfiles}");
                }
                if(null != apkInfo.getRem_scriptfiles()){
                    VALUES("rem_scriptfiles","#{rem_scriptfiles}");
                }
                if(null != apkInfo.getZipfiles()){
                    VALUES("zipfiles","#{zipfiles}");
                }
                if(null != apkInfo.getUnzip_regex()){
                    VALUES("unzip_regex","#{unzip_regex}");
                }
                if(null != apkInfo.getRegscriptparams()){
                    VALUES("regscriptparams","#{regscriptparams}");
                }
                if(null != apkInfo.getRemscriptparams()){
                    VALUES("remscriptparams","#{remscriptparams}");
                }
                if(null != apkInfo.getSdcard_dir()){
                    VALUES("sdcard_dir","#{sdcard_dir}");
                }
                if(null != apkInfo.getScriptfile_version()){
                    VALUES("scriptfile_version","#{scriptfile_version}");
                }
            }
        }.toString();
    }
}
