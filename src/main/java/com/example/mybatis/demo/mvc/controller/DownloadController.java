package com.example.mybatis.demo.mvc.controller;

import com.example.mybatis.demo.exception.AsyncException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

@Controller
public class DownloadController {

    private static final Logger logger = LoggerFactory.getLogger(DownloadController.class);

    @GetMapping("/download")
    public @ResponseBody HttpEntity<byte[]> downloadB(@RequestParam String filename) throws IOException {
        logger.debug("start download");

        try {
            File file = new File("", filename);
            if(file.exists()) {
                byte[] document = FileCopyUtils.copyToByteArray(file);
                HttpHeaders header = new HttpHeaders();
                header.setContentType(new MediaType("application", "oct"));
                header.set("Content-Disposition", "inline; filename=" + file.getName());
                header.setContentLength(document.length);
                return new HttpEntity<>(document, header);
            }
            throw new RuntimeException("could not find file.");

        } catch(Exception e) {
            throw new AsyncException("download failed.");
        }
    }
}
