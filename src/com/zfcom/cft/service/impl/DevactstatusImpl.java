package com.zfcom.cft.service.impl;

import com.zfcom.cft.dao.DevactstatusDao;
import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.entity.Devactstatus;
import com.zfcom.cft.service.DevactstatusService;
import com.zfcom.cft.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("Duplicates")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("DevactstatusService")
public class DevactstatusImpl implements DevactstatusService {

    @Autowired
    private DevactstatusDao devactstatusDao;

    @Transactional(readOnly = true)
    @Override
    public List<Devactstatus> selectByPage(Devactstatus devactstatus, PageModel pageModel) {
        Map<String, Object> map = new HashMap<>();
        map.put("Devactstatus", devactstatus);
        map.put("pageModel", pageModel);

        Integer recordCount = devactstatusDao.count(map);
        pageModel.setRecordCount(recordCount);
        pageModel.setTotalSize(recordCount % pageModel.getPageSize() == 0 ? recordCount / pageModel.getPageSize() : (recordCount / pageModel.getPageSize()) + 1);

        List<Devactstatus> ls = devactstatusDao.selectByPage(map);
        return ls;
    }
}
