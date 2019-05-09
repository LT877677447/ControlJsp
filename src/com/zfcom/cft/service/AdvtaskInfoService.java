package com.zfcom.cft.service;

import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.utils.PageModel;

import java.util.List;

public interface AdvtaskInfoService {
    List<AdvtaskInfo> selectByPage(AdvtaskInfo advtaskInfo, PageModel pageModel);

    void update(AdvtaskInfo advtaskInfo);

    void deleteWithAdvid(AdvtaskInfo advtaskInfo);

    void add(AdvtaskInfo advtaskInfo);
}
