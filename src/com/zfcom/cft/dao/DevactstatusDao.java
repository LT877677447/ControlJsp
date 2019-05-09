package com.zfcom.cft.dao;

import com.zfcom.cft.dao.provider.AdvtaskInfoProvider;
import com.zfcom.cft.dao.provider.DevactstatusProvider;
import com.zfcom.cft.entity.Devactstatus;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface DevactstatusDao {

    @SelectProvider(type = DevactstatusProvider.class, method = "selectByPage")
    List<Devactstatus> selectByPage(Map<String, Object> params);

    @SelectProvider(type = DevactstatusProvider.class, method = "count")
    Integer count(Map<String, Object> map);
}
