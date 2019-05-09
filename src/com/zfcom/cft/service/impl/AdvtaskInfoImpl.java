package com.zfcom.cft.service.impl;

import com.zfcom.cft.dao.AdvtaskInfoDao;
import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.service.AdvtaskInfoService;
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
@Service("AdvtaskInfoService")
public class AdvtaskInfoImpl implements AdvtaskInfoService {
    private Log logger = LogFactory.getLog(AdvtaskInfoImpl.class);

    @Autowired
    private AdvtaskInfoDao advtaskInfoDao;

    @Transactional(readOnly = true)
    @Override
    public List<AdvtaskInfo> selectByPage(AdvtaskInfo advtaskInfo, PageModel pageModel) {
        Map<String, Object> map = new HashMap<>();
        map.put("AdvtaskInfo", advtaskInfo);
        map.put("pageModel", pageModel);

        Integer recordCount = advtaskInfoDao.count(map);
        pageModel.setRecordCount(recordCount);
        pageModel.setTotalSize(recordCount % pageModel.getPageSize() == 0 ? recordCount / pageModel.getPageSize() : (recordCount / pageModel.getPageSize()) + 1);
        pageModel.setOrder(" adv_id desc");
        List<AdvtaskInfo> ls = advtaskInfoDao.selectByPage(map);
        return ls;
    }

    @Override
    public void update(AdvtaskInfo advtaskInfo) {
        advtaskInfoDao.update(advtaskInfo);
    }

    @Override
    public void deleteWithAdvid(AdvtaskInfo advtaskInfo) {
        advtaskInfoDao.delete(advtaskInfo);
    }

    @Override
    public void add(AdvtaskInfo advtaskInfo) {
        advtaskInfoDao.Insert(advtaskInfo);
    }
}

