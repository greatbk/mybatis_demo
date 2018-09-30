package com.example.mybatis.demo.common.helper;

import com.example.mybatis.demo.entity.common.UploadFileInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class UploadHelper {

    private static final Logger logger = LoggerFactory.getLogger(UploadHelper.class);

    public static final String ALLOW_EXTENSION = "jpg,png,pdf";

    public static final long MAX_SIZE = 3 * 1024 * 1024; //3MB

    @Value("#{config['BASE_UPLOAD_DIR']}")
    private String baseUploadDir;

    @PostConstruct
    public void createBaseUploadDir() {
        logger.debug("start createBaseUploadDir");
        try {
            File f = new File(baseUploadDir);
            if(!f.exists()) {
                f.mkdirs();
                logger.debug("create base upload directory");
            }
        } catch(Exception e) {
            logger.error("Failed to create directory");
        }
    }

    public UploadFileInfo getUploadFileinfo(MultipartFile file) {
        if(file != null) {
            UploadFileInfo uploadFileInfo = new UploadFileInfo();
            uploadFileInfo.setFilename(file.getOriginalFilename());
            uploadFileInfo.setExtname(getExtension(file.getOriginalFilename()));
            uploadFileInfo.setSize(file.getSize());
            uploadFileInfo.setServerName(getTempFilename());
            uploadFileInfo.setServerPath(String.format("%s/%s", baseUploadDir, uploadFileInfo.getServerName()));
            return uploadFileInfo;
        }
        return null;
    }

    public String getExtension(String filename) {
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

    public void save(MultipartFile file) throws IOException {
        UploadFileInfo uploadFileInfo = getUploadFileinfo(file);
        save(file, uploadFileInfo);
    }

    @Scheduled(cron="*/5 * * * * *")
    public void clear() {
        File[] files = new File(baseUploadDir).listFiles();
        long now = System.currentTimeMillis();
        long aliveTime = 24 * 60 * 60 * 1000; //One day
        for(File file : files) {
            if(now - file.lastModified() > aliveTime) {
                logger.info(String.format("remove old file.. %s", file.getName()));
                file.delete();
            }
        }
    }

    public boolean checkExtension(UploadFileInfo uploadFileInfo) {
        if(uploadFileInfo != null && uploadFileInfo.getExtname() != null) {
            List<String> allows = Arrays.asList(ALLOW_EXTENSION.split(","));
            if(allows.contains(uploadFileInfo.getExtname().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
