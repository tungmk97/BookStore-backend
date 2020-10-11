package com.mk.service;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.mk.config.FileStogareConfig;
import com.mk.exception.FileStogareException;
import com.mk.exception.MyFileNotFoundException;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStogareService {

  private final Path fileStogareLocation;

  @Autowired
  public FileStogareService(FileStogareConfig fileStogareConfig) {
    this.fileStogareLocation = Paths.get(fileStogareConfig.getUploadDir()).toAbsolutePath().normalize();

    try {
      Files.createDirectories(this.fileStogareLocation);
    } catch (Exception e) {
      throw new FileStogareException("Could not create dir", e);
    }
  }

  public String createFile(MultipartFile file) {
    String fileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
    try {
      if (fileName.contains("..")) {
        throw new FileStogareException("Sory! file name invalid!!! " + fileName);
      }
      Path targetLocation = this.fileStogareLocation.resolve(fileName);
      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

      return fileName;
    } catch (Exception e) {
      throw new FileStogareException("Could not store file " + fileName, e);
    }
  }

  public Resource loadFileAsResource(String fileName) {
    try {
      Path filePath = this.fileStogareLocation.resolve(fileName).normalize();
      Resource resources = new UrlResource(filePath.toUri());
      if (resources.exists()) {
        return resources;
      } else {
        throw new MyFileNotFoundException("Canot found file " + fileName);
      }

    } catch (Exception e) {
      throw new MyFileNotFoundException("Canot found file " + fileName);
    }
  }
}