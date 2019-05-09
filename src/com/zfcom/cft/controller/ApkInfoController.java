package com.zfcom.cft.controller;


import com.zfcom.cft.entity.ApkInfo;
import com.zfcom.cft.service.ApkInfoService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
@Controller
public class ApkInfoController {
    private static final Log logger = LogFactory.getLog(ApkInfoController.class);

    @Autowired
    @Qualifier("ApkInfoService")
    private ApkInfoService apkInfoService;

    @RequestMapping("/index/APKList")
    public ModelAndView ApkInfoPage(HttpServletRequest request,
                                    HttpServletResponse response,
                                    ModelAndView modelAndView,
                                    @ModelAttribute PageModel pageModel,
                                    @ModelAttribute ApkInfo apkInfo) {
        if (null == pageModel.getPageIndex()) {
            throw new RuntimeException(this.getClass().getName() + " :pageModel is null...");
        }
        pageModel.setOrder(" apkid desc");
        List<ApkInfo> ls = apkInfoService.selectApkInfoByPage(apkInfo, pageModel);

        modelAndView.setViewName("/content/index/ApkInfoList.jsp");
//        modelAndView.setViewName("/content/index/todayResultList.jsp");
        modelAndView.addObject("ApkInfo", apkInfo);
        modelAndView.addObject("ApkInfoList", ls);
        modelAndView.addObject("pageModel", pageModel);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/ApkInfo/PageQuery")
    public Object PageQuery(HttpServletRequest request,
                            HttpServletResponse response,
//                            @ModelAttribute PageModel pageModel,
                            @RequestBody PageModel pageModel,
                            @ModelAttribute ApkInfo apkInfo) {
        Map<String, Object> map = new HashMap<>();
        pageModel.setOrder(" apkid desc");
        List<ApkInfo> ls = apkInfoService.selectApkInfoByPage(apkInfo, pageModel);
        map.put("ApkInfoList", ls);
        map.put("pageModel", pageModel);
        map.put("ApkInfo", apkInfo);
        return map;
    }

    @SuppressWarnings("Duplicates")
    @ResponseBody
    @RequestMapping("/ApkInfo/Edit")
    public Object Edit(HttpServletRequest request,
                       HttpServletResponse response,
                       @ModelAttribute PageModel pageModel,
                       @ModelAttribute ApkInfo apkInfo) throws IOException {
        Map<String, Object> map = new HashMap<>();
        MultipartFile apkfile = apkInfo.getMultipartFile_apkfile();
        MultipartFile scriptfile = apkInfo.getMultipartFile_scriptfile();
        if (null != apkfile) {
            String path = "D:\\WebServer\\files\\apks";
            saveFile(apkfile, path);
            String apkFIleName = apkfile.getOriginalFilename();
            apkInfo.setApkfile(apkFIleName);
        }
        if (null != scriptfile) {
            String path = "D:\\WebServer\\files\\scripts";
            saveFile(scriptfile, path);
            String scriptFileName = scriptfile.getOriginalFilename();
            apkInfo.setReg_scriptfiles(scriptFileName);
            apkInfo.setRem_scriptfiles(scriptFileName);
            apkInfo.setZipfiles("/data/data/" + scriptFileName.substring(0, scriptFileName.indexOf(".apk")));
        }
        try {
            apkInfoService.update(apkInfo);
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "failure");
            e.printStackTrace();
        }
        return map;
    }

    @SuppressWarnings("Duplicates")
    @ResponseBody
    @RequestMapping("/ApkInfo/Add")
    public Object Add(HttpServletRequest request,
                       HttpServletResponse response,
                       @ModelAttribute PageModel pageModel,
                       @ModelAttribute ApkInfo apkInfo) throws IOException {
        Map<String, Object> map = new HashMap<>();
        MultipartFile apkfile = apkInfo.getMultipartFile_apkfile();
        MultipartFile scriptfile = apkInfo.getMultipartFile_scriptfile();
        if (null != apkfile) {
            String path = "D:\\WebServer\\files\\apks";
            saveFile(apkfile, path);
            String apkFIleName = apkfile.getOriginalFilename();
            apkInfo.setApkfile(apkFIleName);
        }
        if (null != scriptfile) {
            String path = "D:\\WebServer\\files\\scripts";
            saveFile(scriptfile, path);
            String scriptFileName = scriptfile.getOriginalFilename();
            apkInfo.setReg_scriptfiles(scriptFileName);
            apkInfo.setRem_scriptfiles(scriptFileName);
            apkInfo.setZipfiles("/data/data/" + scriptFileName.substring(0, scriptFileName.indexOf(".apk")));
        }
        if(apkInfo.getSdcard_dir() == null){
            apkInfo.setSdcard_dir("/");
        }
        if(apkInfo.getUnzip_regex() == null){
            apkInfo.setUnzip_regex("{\"fileName\": \".*\\\\.jar|.*\\\\.so|.*\\\\.apk|.*\\\\.dex|.*\\\\.jpg|.*\\\\.png|.*\\\\.gif|.*\\\\.bmp|.*\\\\.wav|.*\\\\.mp3|.*\\\\.aac|.*/cache/.*\",\"fileSizeMax\": 2048}");
        }
        try {
            apkInfoService.add(apkInfo);
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "failure");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/ApkInfo/Delete")
    public Object delete(HttpServletRequest request,
                         HttpServletResponse response,
                         @ModelAttribute PageModel pageModel,
                         @RequestBody ApkInfo apkInfo) {
        Map<String, Object> map = new HashMap<>();
        try {
            apkInfoService.deleteWithApkid(apkInfo);
            map.put("result","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result","failure");
        }
        return map;
    }

    private void saveFile(MultipartFile scriptfile, String path) throws IOException {
        String fileName = scriptfile.getOriginalFilename();
        File dest = new File(path, fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        scriptfile.transferTo(dest);
    }


}
