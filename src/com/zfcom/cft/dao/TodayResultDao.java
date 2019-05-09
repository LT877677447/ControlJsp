package com.zfcom.cft.dao;

import com.zfcom.cft.dao.provider.TodayResultProvider;
import com.zfcom.cft.entity.TodayResult;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface TodayResultDao {

    @SelectProvider(type = TodayResultProvider.class,method = "selectTodayResultByPage")
    List<TodayResult> selectByPage(Map<String, Object> params);

    @SelectProvider(type = TodayResultProvider.class,method = "count")
    Integer count(Map<String, Object> map);
}
