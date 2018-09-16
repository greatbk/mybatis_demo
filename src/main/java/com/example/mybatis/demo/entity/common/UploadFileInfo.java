package com.example.mybatis.demo.entity.common;

public class UploadFileInfo {

    private String filename;
    private String extName;
    private long size;

    private String serverName;
    private String serverPath;

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(String.format("filename: [%s]", filename));
        buf.append(String.format(", extName: [%s]", extName));
        buf.append(String.format(", size: [%d]", size));
        buf.append(String.format(", serverName: [%s]", serverName));
        buf.append(String.format(", serverPath: [%s]", serverPath));
        return buf.toString();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }
}
