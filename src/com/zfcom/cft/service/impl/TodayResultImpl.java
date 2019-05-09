package com.zfcom.cft.service.impl;

import com.zfcom.cft.dao.TodayResultDao;
import com.zfcom.cft.entity.TodayResult;
import com.zfcom.cft.service.TodayResultService;
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

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("TodayResultService")
public class TodayResultImpl implements TodayResultService {
    private Log logger = LogFactory.getLog(TodayResultImpl.class);

    @Autowired
    private TodayResultDao todayResultDao;

    @Transactional(readOnly = true)
    @Override
    public List<TodayResult> selectTodayResultByPage(TodayResult todayResult, PageModel pageModel) {
        if(pageModel.getDate_1() == null || pageModel.getDate_2() == null){
            pageModel.setDate_1(null);
            pageModel.setDate_2(null);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("todayResult", todayResult);
        map.put("pageModel", pageModel);

        Integer recordCount = todayResultDao.count(map);
        pageModel.setRecordCount(recordCount);
        pageModel.setTotalSize(recordCount % pageModel.getPageSize() == 0 ? recordCount / pageModel.getPageSize() : (recordCount / pageModel.getPageSize()) + 1);

        List<TodayResult> ls = todayResultDao.selectByPage(map);
        return ls;
    }

}
