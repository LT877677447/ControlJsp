package com.zfcom.cft.service;

import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.entity.Devactstatus;
import com.zfcom.cft.utils.PageModel;

import java.util.List;

public interface DevactstatusService {
    List<Devactstatus> selectByPage(Devactstatus devactstatus, PageModel pageModel);



}
