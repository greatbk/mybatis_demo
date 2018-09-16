package com.example.mybatis.demo.mvc.service;

import com.example.mybatis.demo.common.helper.UploadHelper;
import com.example.mybatis.demo.entity.common.UploadFileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadService.class);

    @Autowired
    private UploadHelper uploadHelper;

    public boolean save(MultipartFile file) {
        try {
            UploadFileInfo uploadFileInfo = uploadHelper.getUploadFileinfo(file);
            uploadHelper.save(file, uploadFileInfo);
            return true;
        } catch(IOException e) {
            logger.error("save failed!", e);
            return false;
        }
    }
}
