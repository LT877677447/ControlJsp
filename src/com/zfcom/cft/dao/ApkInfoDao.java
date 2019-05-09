package com.zfcom.cft.dao;

import com.zfcom.cft.dao.provider.ApkInfoProvider;
import com.zfcom.cft.entity.ApkInfo;
import com.zfcom.cft.utils.Constants;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface ApkInfoDao {

    @SelectProvider(type = ApkInfoProvider.class, method = "selectApkInfoByPage")
    List<ApkInfo> selectByPage(Map<String, Object> params);

    @SelectProvider(type = ApkInfoProvider.class, method = "count")
    Integer count(Map<String, Object> map);

    @Select("select apkid from " + Constants.TABLE_ApkInfo)
    List<Integer> selectAllId();

    @SelectProvider(type = ApkInfoProvider.class, method = "update")
    void update(ApkInfo apkInfo);

    @Delete("delete from " + Constants.TABLE_ApkInfo + " where apkid = #{apkid}")
    void delete(ApkInfo apkInfo);

    @SelectProvider(type = ApkInfoProvider.class,method = "insert")
    void Insert(ApkInfo apkInfo);
}
