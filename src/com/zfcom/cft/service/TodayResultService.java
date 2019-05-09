package com.zfcom.cft.service;

import com.zfcom.cft.entity.TodayResult;
import com.zfcom.cft.utils.PageModel;

import java.util.List;

public interface TodayResultService {

    List<TodayResult> selectTodayResultByPage(TodayResult todayResult, PageModel pageModel);
}
