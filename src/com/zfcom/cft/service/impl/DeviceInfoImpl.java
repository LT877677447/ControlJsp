package com.zfcom.cft.service.impl;

import com.zfcom.cft.dao.DeviceInfoDao;
import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.entity.DeviceInfo;
import com.zfcom.cft.service.DeviceInfoService;
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

@SuppressWarnings({"UnclearExpression", "Duplicates"})
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("DeviceInfoService")
public class DeviceInfoImpl implements DeviceInfoService {
    private Log logger = LogFactory.getLog(DeviceInfoImpl.class);

    @Autowired
    private DeviceInfoDao deviceInfoDao;

    @Transactional(readOnly = true)
    @Override
    public List<DeviceInfo> selectByPage(DeviceInfo deviceInfo, PageModel pageModel) {
        Map<String, Object> map = new HashMap<>();
        map.put("DeviceInfo", deviceInfo);
        map.put("pageModel", pageModel);

        Integer recordCount = deviceInfoDao.count(map);
        pageModel.setRecordCount(recordCount);
        pageModel.setTotalSize(recordCount % pageModel.getPageSize() == 0 ? recordCount / pageModel.getPageSize() : (recordCount / pageModel.getPageSize()) + 1);

        List<DeviceInfo> ls = deviceInfoDao.selectByPage(map);
        return ls;
    }

    @Override
    public void update(DeviceInfo deviceInfo) {
        deviceInfoDao.update(deviceInfo);
    }

    @Override
    public void delete(DeviceInfo deviceInfo) {
        deviceInfoDao.delete(deviceInfo);
    }

    @Override
    public void add(DeviceInfo deviceInfo) {
        deviceInfoDao.Insert(deviceInfo);
    }




}
