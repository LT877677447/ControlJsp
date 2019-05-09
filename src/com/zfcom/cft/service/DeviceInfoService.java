package com.zfcom.cft.service;

import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.entity.DeviceInfo;
import com.zfcom.cft.utils.PageModel;

import java.util.List;

public interface DeviceInfoService {
    List<DeviceInfo> selectByPage(DeviceInfo deviceInfo, PageModel pageModel);

    void update(DeviceInfo deviceInfo);

    void delete(DeviceInfo deviceInfo);

    void add(DeviceInfo deviceInfo);

}
