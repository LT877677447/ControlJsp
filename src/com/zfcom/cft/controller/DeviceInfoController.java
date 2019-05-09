package com.zfcom.cft.controller;

import com.zfcom.cft.entity.AdvtaskInfo;
import com.zfcom.cft.entity.Devactstatus;
import com.zfcom.cft.entity.DeviceInfo;
import com.zfcom.cft.service.DevactstatusService;
import com.zfcom.cft.service.DeviceInfoService;
import com.zfcom.cft.utils.MyDateTool;
import com.zfcom.cft.utils.PageModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
public class DeviceInfoController {
    private static final Log logger = LogFactory.getLog(DeviceInfoController.class);

    @Autowired
    @Qualifier("DeviceInfoService")
    private DeviceInfoService deviceInfoService;

    @RequestMapping("/index/DeviceInfos")
    public ModelAndView DevactstatusPages(HttpServletRequest request,
                                          HttpServletResponse response,
                                          ModelAndView modelAndView,
                                          @ModelAttribute PageModel pageModel,
                                          @ModelAttribute DeviceInfo deviceInfo) {
        List<DeviceInfo> ls = deviceInfoService.selectByPage(deviceInfo, pageModel);
        modelAndView.setViewName("/content/index/DeviceInfo.jsp");
        modelAndView.addObject("DeviceInfo", deviceInfo);
        modelAndView.addObject("DeviceInfoList", ls);
        modelAndView.addObject("pageModel", pageModel);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/DeviceInfos/pageQuery")
    public Object PageQuery(HttpServletRequest request,
                            HttpServletResponse response,
                            @ModelAttribute PageModel pageModel,
                            @ModelAttribute DeviceInfo deviceInfo) {
        Map<String, Object> map = new HashMap<>();
        List<DeviceInfo> ls = deviceInfoService.selectByPage(deviceInfo, pageModel);
        List<String> registTime = new ArrayList<>();
        List<String> allocTime = new ArrayList<>();

        for (DeviceInfo result : ls) {
            registTime.add(MyDateTool.Format("yyyy年MM月dd日 HH时mm分ss秒", result.getRegisttime()));
        }
        for (DeviceInfo result : ls) {
            allocTime.add(MyDateTool.Format("yyyy年MM月dd日 HH时mm分ss秒", result.getAlloctime()));
        }
        map.put("RigistTime", registTime);
        map.put("AllocTime", allocTime);
        map.put("DeviceList", ls);
        map.put("pageModel", pageModel);
        map.put("DeviceInfo", deviceInfo);
        return map;
    }

    @ResponseBody
    @RequestMapping("/DeviceInfos/Edit")
    public Object Edit(HttpServletRequest request,
                       HttpServletResponse response,
                       @ModelAttribute PageModel pageModel,
                       @RequestBody DeviceInfo deviceInfo) {
        Map<String, Object> map = new HashMap<>();
        try {
            deviceInfoService.update(deviceInfo);
            map.put("result","success");
        } catch (Exception e) {
            map.put("result","failure");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/DeviceInfos/Delete")
    public Object Delete(HttpServletRequest request,
                         HttpServletResponse response,
                         @ModelAttribute PageModel pageModel,
                         @RequestBody DeviceInfo deviceInfo) {
        Map<String, Object> map = new HashMap<>();
        try {
            deviceInfoService.delete(deviceInfo);
            map.put("result", "success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", "failure");
        }
        return map;
    }

}
