package com.example.mybatis.demo.common.helper;

import com.example.mybatis.demo.entity.common.UploadFileInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class UploadHelper {

    private static final Logger logger = LoggerFactory.getLogger(UploadHelper.class);

    @Value("#{config['BASE_UPLOAD_DIR']}")
    private String baseUploadDir;

    public UploadFileInfo getUploadFileinfo(MultipartFile file) {
        if(file != null) {
            UploadFileInfo uploadFileInfo = new UploadFileInfo();
            uploadFileInfo.setFilename(file.getOriginalFilename());
            uploadFileInfo.setExtName(getExtName(file.getOriginalFilename()));
            uploadFileInfo.setSize(file.getSize());
            uploadFileInfo.setServerName(getTempFilename());
            uploadFileInfo.setServerPath(String.format("%s/%s", baseUploadDir, uploadFileInfo.getServerName()));
            return uploadFileInfo;
        }
        return null;
    }

    public String getExtName(String filename) {
        if(filename != null) {
            int index = filename.lastIndexOf(".");
            if(index >= 0) {
                return filename.substring(index + 1, filename.length());
            }
        }
        return null;
    }

    public String getTempFilename() {
        return String.format("%s%d", RandomStringUtils.randomAlphabetic(8), System.currentTimeMillis());
    }

    public void save(MultipartFile file, UploadFileInfo uploadFileInfo) throws IOException {
        if(file != null && uploadFileInfo != null) {
            File f = new File(uploadFileInfo.getServerPath());
            file.transferTo(f);
        }
    }
}
