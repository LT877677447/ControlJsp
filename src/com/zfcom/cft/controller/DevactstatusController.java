package com.zfcom.cft.controller;

import com.zfcom.cft.entity.Devactstatus;
import com.zfcom.cft.service.DevactstatusService;
import com.zfcom.cft.utils.MyDateTool;
import com.zfcom.cft.utils.PageModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("Duplicates")
@Controller
public class DevactstatusController {
    private static final Log logger = LogFactory.getLog(DevactstatusController.class);

    @Autowired
    @Qualifier("DevactstatusService")
    private DevactstatusService devactstatusService;

    @RequestMapping("/index/Devactstatus")
    public ModelAndView DevactstatusPages(HttpServletRequest request,
                                          HttpServletResponse response,
                                          ModelAndView modelAndView,
                                          @ModelAttribute PageModel pageModel,
                                          @ModelAttribute Devactstatus devactstatus) {
        List<Devactstatus> ls = devactstatusService.selectByPage(devactstatus, pageModel);
        modelAndView.setViewName("/content/index/Devactstatus.jsp");
        modelAndView.addObject("Devactstatus", devactstatus);
        modelAndView.addObject("DevactstatusList", ls);
        modelAndView.addObject("pageModel", pageModel);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/Devactstatus/pageQuery")
    public Object PageQuery(HttpServletRequest request,
                            HttpServletResponse response,
                            @ModelAttribute PageModel pageModel,
                            @ModelAttribute Devactstatus devactstatus) {
        Map<String, Object> map = new HashMap<>();
        List<Devactstatus> ls = devactstatusService.selectByPage(devactstatus, pageModel);
        List<String> lastLoginTime = new ArrayList<>();
        List<String> lastFetchTaskTime = new ArrayList<>();

        for (Devactstatus result : ls) {
            if (null != result.getLastlogintime()) {
                lastLoginTime.add(MyDateTool.Format("yyyy年MM月dd日 HH时mm分ss秒", result.getLastlogintime()));
            }
        }
        for (Devactstatus result : ls) {
            if (null != result.getLastfetchtasktime()) {
                lastFetchTaskTime.add(MyDateTool.Format("yyyy年MM月dd日 HH时mm分ss秒", result.getLastfetchtasktime()));
            }
        }
        map.put("LastLoginTime", lastLoginTime);
        map.put("LastFetchTaskTime", lastFetchTaskTime);
        map.put("DevactstatusList", ls);
        map.put("pageModel", pageModel);
        map.put("Devactstatus", devactstatus);
        return map;
    }

}
