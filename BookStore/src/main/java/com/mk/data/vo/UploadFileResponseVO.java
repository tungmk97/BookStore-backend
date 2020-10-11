package com.mk.data.vo;

public class UploadFileResponseVO {
  private String fileName;
  private String downloadUri;
  private String fileType;
  private long size;

  public UploadFileResponseVO() {

  }

  public UploadFileResponseVO(String fileName, String downloadUri, String fileType, long size) {
    this.fileName = fileName;
    this.downloadUri = downloadUri;
    this.fileType = fileType;
    this.size = size;
  }

  public String getFileName() {
    return this.fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getDownloadUri() {
    return this.downloadUri;
  }

  public void setDownloadUri(String downloadUri) {
    this.downloadUri = downloadUri;
  }

  public String getFileType() {
    return this.fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public long getSize() {
    return this.size;
  }

  public void setSize(long size) {
    this.size = size;
  }

}