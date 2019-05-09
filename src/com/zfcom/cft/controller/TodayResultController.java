package com.zfcom.cft.controller;

import com.zfcom.cft.entity.TodayResult;
import com.zfcom.cft.service.TodayResultService;
import com.zfcom.cft.utils.MyDateTool;
import com.zfcom.cft.utils.PageModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class TodayResultController {
    private static final Log logger = LogFactory.getLog(TodayResultController.class);


    @Autowired
    @Qualifier("TodayResultService")
    private TodayResultService todayResultService;

    @RequestMapping("/index/todayResult")
    public ModelAndView TodayResultPage(HttpServletRequest request,
                              HttpServletResponse response,
                              ModelAndView modelAndView,
                              @ModelAttribute PageModel pageModel,
                              @ModelAttribute TodayResult todayResult) {
        if (null == pageModel.getPageIndex()) {
            throw new RuntimeException(this.getClass().getName() + " :pageModel is null...");
        }
        List<TodayResult> ls = todayResultService.selectTodayResultByPage(todayResult, pageModel);

        modelAndView.setViewName("/content/index/todayResultList.jsp");
        todayResult.setResult_time(new Date());
        modelAndView.addObject("todayResult", todayResult);

        modelAndView.addObject("todayResultList", ls);
        modelAndView.addObject("pageModel", pageModel);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/todayResult/PageQuery")
    public Object PageQuery(HttpServletRequest request,
                            HttpServletResponse response,
                            @ModelAttribute PageModel pageModel,
                            @ModelAttribute TodayResult todayResult,
                            Model model) {
        Map<String, Object> map = new HashMap<>();
        List<TodayResult> ls = todayResultService.selectTodayResultByPage(todayResult, pageModel);
        List<String> strings = new ArrayList<>();
        for (TodayResult result : ls) {
            strings.add(MyDateTool.Format("yyyy年MM月dd日 HH时mm分ss秒", result.getResult_time()));
        }
        map.put("TodayResults", ls);
        map.put("todayResult", todayResult);
        map.put("ResultTime", strings);
        map.put("pageModel", pageModel);
        return map;
    }

}
