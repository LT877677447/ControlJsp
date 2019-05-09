package com.zfcom.cft.service.impl;

import com.zfcom.cft.dao.ApkInfoDao;
import com.zfcom.cft.entity.ApkInfo;
import com.zfcom.cft.service.ApkInfoService;
import com.zfcom.cft.utils.PageModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("Duplicates")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("ApkInfoService")
public class ApkInfoImpl implements ApkInfoService {
    private Log logger = LogFactory.getLog(ApkInfoImpl.class);

    @Autowired
    private ApkInfoDao apkInfoDao;

    @Transactional(readOnly = true)
    @Override
    public List<ApkInfo> selectApkInfoByPage(ApkInfo apkInfo, PageModel pageModel) {
        Map<String, Object> map = new HashMap<>();
        map.put("ApkInfo", apkInfo);
        map.put("pageModel", pageModel);

        Integer recordCount = apkInfoDao.count(map);
        pageModel.setRecordCount(recordCount);
        pageModel.setTotalSize(recordCount % pageModel.getPageSize() == 0 ? recordCount / pageModel.getPageSize() : (recordCount / pageModel.getPageSize()) + 1);

        List<ApkInfo> ls = apkInfoDao.selectByPage(map);
        return ls;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Integer> selectAllId() {
        return apkInfoDao.selectAllId();
    }

    @Override
    public void update(ApkInfo apkInfo) {
        apkInfoDao.update(apkInfo);
    }

    @Override
    public void deleteWithApkid(ApkInfo apkInfo) {
        apkInfoDao.delete(apkInfo);
    }

    @Override
    public void add(ApkInfo apkInfo) {
        apkInfoDao.Insert(apkInfo);
    }


}
