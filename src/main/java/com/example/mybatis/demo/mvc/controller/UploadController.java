package com.example.mybatis.demo.mvc.controller;

import com.example.mybatis.demo.mvc.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Set;

@Controller
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private UploadService uploadService;

    @GetMapping("uploadForm")
    public String uploadForm() {
        return "uploadForm.simple";
    }

    @PostMapping("upload")
    public ModelAndView upload(@RequestParam MultipartFile file, @RequestParam Map<String, String> param, ModelAndView model) {
        if(file != null) {
            uploadService.save(file);
        }
        if(param != null) {
            Set<String> keySet = param.keySet();
            for(String key : keySet) {
                logger.debug(String.format("%s:%s", key, param.get(key)));
            }
        }
        model.setViewName("upload.simple");
        return model;
    }
}
