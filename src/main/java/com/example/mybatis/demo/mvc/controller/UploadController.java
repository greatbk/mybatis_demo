package com.example.mybatis.demo.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Set;

@Controller
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @GetMapping("uploadForm")
    public String uploadForm() {
        return "uploadForm.simple";
    }

    @PostMapping("upload")
    public String upload(@RequestParam MultipartFile file, @RequestParam Map<String, String> param) {
        if(file != null) {
            logger.debug(file.toString());
        }
        if(param != null) {
            Set<String> keySet = param.keySet();
            for(String key : keySet) {
                logger.debug(key);
            }
        }
        return "upload.simple";
    }
}
