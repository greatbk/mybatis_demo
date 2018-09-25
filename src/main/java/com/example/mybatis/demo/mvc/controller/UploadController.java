package com.example.mybatis.demo.mvc.controller;

import com.example.mybatis.demo.common.helper.UploadHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

@Controller
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private UploadHelper uploadHelper;

    @GetMapping("uploadForm")
    public String uploadForm() {
        return "uploadForm.simple";
    }

    /**
     * In the windows tomcat8 environment, the following code error occurred. On Macs, versions of tomcat8, 8.5, and 9 did not fail.
     * @param file
     * @param param
     * @param model
     * @return
     */
    @PostMapping("upload9")
    public String upload9(@RequestParam("file") MultipartFile file, @RequestParam Map<String, String> param, Model model) {
        logger.debug("start upload9");

        try {
            if(file != null) {
                uploadHelper.save(file);
            }
            model.addAttribute("fileInfo", uploadHelper.getUploadFileinfo(file));
            model.addAttribute("param", param);
            return "upload.simple";

        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * If you encounter errors when uploading, try the following:
     * @param request
     * @param param
     * @param model
     * @return
     */
    @PostMapping("upload8")
    public String upload8(@RequestParam MultipartHttpServletRequest request, @RequestParam Map<String, String> param, Model model) {
        logger.debug("start upload8");

        try {
            if(request.getFile("file") != null) {
                uploadHelper.save(request.getFile("file"));
            }
            model.addAttribute("fileInfo", uploadHelper.getUploadFileinfo(request.getFile("file")));
            model.addAttribute("param", param);
            return "upload.simple";

        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
