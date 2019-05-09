package com.zfcom.cft.dao;

import com.zfcom.cft.dao.provider.AdvtaskInfoProvider;
import com.zfcom.cft.dao.provider.DeviceInfoProvider;
import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.entity.DeviceInfo;
import com.zfcom.cft.utils.Constants;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface DeviceInfoDao {
    @SelectProvider(type = DeviceInfoProvider.class, method = "selectByPage")
    List<DeviceInfo> selectByPage(Map<String, Object> params);

    @SelectProvider(type = DeviceInfoProvider.class, method = "count")
    Integer count(Map<String, Object> map);

    @SelectProvider(type = DeviceInfoProvider.class, method = "update")
    void update(DeviceInfo deviceInfo);

    @Delete("delete from " + Constants.TABLE_DeviceInfo + " where device_tag = #{device_tag}")
    void delete(DeviceInfo deviceInfo);

    @SelectProvider(type = DeviceInfoProvider.class, method = "insert")
    void Insert(DeviceInfo deviceInfo);
}
