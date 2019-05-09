package com.zfcom.cft.dao;

import com.zfcom.cft.dao.provider.AdvtaskInfoProvider;
import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.utils.Constants;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface AdvtaskInfoDao {
    @SelectProvider(type = AdvtaskInfoProvider.class, method = "selectAdvtaskInfoByPage")
    List<AdvtaskInfo> selectByPage(Map<String, Object> params);

    @SelectProvider(type = AdvtaskInfoProvider.class, method = "count")
    Integer count(Map<String, Object> map);

    @SelectProvider(type = AdvtaskInfoProvider.class, method = "update")
    void update(AdvtaskInfo advtaskInfo);

    @Delete("delete from "+ Constants.TABLE_AdvtaskInfo +" where adv_id = #{adv_id}")
    void delete(AdvtaskInfo advtaskInfo);

    @SelectProvider(type = AdvtaskInfoProvider.class,method = "insert")
    void Insert(AdvtaskInfo advtaskInfo);
}

