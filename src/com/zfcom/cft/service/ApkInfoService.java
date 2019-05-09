package com.zfcom.cft.service;

import com.zfcom.cft.entity.ApkInfo;
import com.zfcom.cft.utils.PageModel;

import java.util.List;

public interface ApkInfoService {

    List<ApkInfo> selectApkInfoByPage(ApkInfo apkInfo, PageModel pageModel);

    List<Integer> selectAllId();

    void update(ApkInfo apkInfo);

    void deleteWithApkid(ApkInfo apkInfo);

    void add(ApkInfo apkInfo);
}
