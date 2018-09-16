package com.example.mybatis.demo.mvc.service;

import com.example.mybatis.demo.common.helper.UploadHelper;
import com.example.mybatis.demo.entity.common.UploadFileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadService.class);

    @Autowired
    private UploadHelper uploadHelper;

    public void save(MultipartFile file) {
        try {
            UploadFileInfo uploadFileInfo = uploadHelper.getUploadFileinfo(file);
            uploadHelper.save(file, uploadFileInfo);
        } catch(IOException e) {
            logger.error("save failed!", e);
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron="*/5 * * * * *")
    public void clear() {
        uploadHelper.clear();
    }
}
