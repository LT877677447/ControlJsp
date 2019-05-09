package com.zfcom.cft.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class ApkInfo implements Serializable {
    private Integer apkid;
    private String packagename;
    private String apkname;
    private String apkfile;
    private String reg_scriptfiles;
    private String rem_scriptfiles;
    private String zipfiles;
    private String unzip_regex;
    private String regscriptparams;
    private String remscriptparams;
    private String sdcard_dir;
    private Integer scriptfile_version;
    private MultipartFile MultipartFile_apkfile;
    private MultipartFile MultipartFile_scriptfile;

    public ApkInfo() {
    }

    public ApkInfo(Integer apkid, String packagename, String apkname, String apkfile, String reg_scriptfiles, String rem_scriptfiles, String zipfiles, String unzip_regex, String regscriptparams, String remscriptparams, String sdcard_dir, Integer scriptfile_version, MultipartFile multipartFile_apkfile, MultipartFile multipartFile_scriptfile) {
        this.apkid = apkid;
        this.packagename = packagename;
        this.apkname = apkname;
        this.apkfile = apkfile;
        this.reg_scriptfiles = reg_scriptfiles;
        this.rem_scriptfiles = rem_scriptfiles;
        this.zipfiles = zipfiles;
        this.unzip_regex = unzip_regex;
        this.regscriptparams = regscriptparams;
        this.remscriptparams = remscriptparams;
        this.sdcard_dir = sdcard_dir;
        this.scriptfile_version = scriptfile_version;
        MultipartFile_apkfile = multipartFile_apkfile;
        MultipartFile_scriptfile = multipartFile_scriptfile;
    }

    public Integer getApkid() {
        return apkid;
    }

    public void setApkid(Integer apkid) {
        this.apkid = apkid;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getApkname() {
        return apkname;
    }

    public void setApkname(String apkname) {
        this.apkname = apkname;
    }

    public String getApkfile() {
        return apkfile;
    }

    public void setApkfile(String apkfile) {
        this.apkfile = apkfile;
    }

    public String getReg_scriptfiles() {
        return reg_scriptfiles;
    }

    public void setReg_scriptfiles(String reg_scriptfiles) {
        this.reg_scriptfiles = reg_scriptfiles;
    }

    public String getRem_scriptfiles() {
        return rem_scriptfiles;
    }

    public void setRem_scriptfiles(String rem_scriptfiles) {
        this.rem_scriptfiles = rem_scriptfiles;
    }

    public String getZipfiles() {
        return zipfiles;
    }

    public void setZipfiles(String zipfiles) {
        this.zipfiles = zipfiles;
    }

    public String getUnzip_regex() {
        return unzip_regex;
    }

    public void setUnzip_regex(String unzip_regex) {
        this.unzip_regex = unzip_regex;
    }

    public String getRegscriptparams() {
        return regscriptparams;
    }

    public void setRegscriptparams(String regscriptparams) {
        this.regscriptparams = regscriptparams;
    }

    public String getRemscriptparams() {
        return remscriptparams;
    }

    public void setRemscriptparams(String remscriptparams) {
        this.remscriptparams = remscriptparams;
    }

    public String getSdcard_dir() {
        return sdcard_dir;
    }

    public void setSdcard_dir(String sdcard_dir) {
        this.sdcard_dir = sdcard_dir;
    }

    public Integer getScriptfile_version() {
        return scriptfile_version;
    }

    public void setScriptfile_version(Integer scriptfile_version) {
        this.scriptfile_version = scriptfile_version;
    }

    public MultipartFile getMultipartFile_apkfile() {
        return MultipartFile_apkfile;
    }

    public void setMultipartFile_apkfile(MultipartFile multipartFile_apkfile) {
        MultipartFile_apkfile = multipartFile_apkfile;
    }

    public MultipartFile getMultipartFile_scriptfile() {
        return MultipartFile_scriptfile;
    }

    public void setMultipartFile_scriptfile(MultipartFile multipartFile_scriptfile) {
        MultipartFile_scriptfile = multipartFile_scriptfile;
    }

    @Override
    public String toString() {
        return "ApkInfo{" +
                "apkid=" + apkid +
                ", packagename='" + packagename + '\'' +
                ", apkname='" + apkname + '\'' +
                ", apkfile='" + apkfile + '\'' +
                ", reg_scriptfiles='" + reg_scriptfiles + '\'' +
                ", rem_scriptfiles='" + rem_scriptfiles + '\'' +
                ", zipfiles='" + zipfiles + '\'' +
                ", unzip_regex='" + unzip_regex + '\'' +
                ", regscriptparams='" + regscriptparams + '\'' +
                ", remscriptparams='" + remscriptparams + '\'' +
                ", sdcard_dir='" + sdcard_dir + '\'' +
                ", scriptfile_version=" + scriptfile_version +
                ", MultipartFile_apkfile=" + MultipartFile_apkfile +
                ", MultipartFile_scriptfile=" + MultipartFile_scriptfile +
                '}';
    }
}
