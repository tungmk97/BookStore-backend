package com.mk.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.mk.data.vo.ProductVOCustom;
import com.mk.data.vo.UploadFileResponseVO;
import com.mk.service.FileStogareService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/file/v1")
public class FileController {

  @Autowired
  private FileStogareService fileStogareService;

  @PostMapping("/uploadFile")
  public UploadFileResponseVO uploadFile(@RequestParam("file") MultipartFile multipartFile) {
    String fileName = fileStogareService.createFile(multipartFile);
    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/file/v1/downloadFile/")
        .path(fileName).toUriString();

    return new UploadFileResponseVO(fileName, fileDownloadUri, multipartFile.getContentType(), multipartFile.getSize());
  }

  @PostMapping("/uploadMultifile")
  public List<UploadFileResponseVO> uploadMultipathFile(@RequestParam("files") MultipartFile[] multipartFiles) {
    return Arrays.asList(multipartFiles).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
  }

  @GetMapping("/downloadFile/{fileName:.+}")
  public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
    Resource resource = fileStogareService.loadFileAsResource(fileName);
    String contentType = null;
    try {
      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    if (contentType == null) {
      contentType = "application/octet-stream";
    }

    return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=/" + resource.getFilename() + "/")
        .body(resource);
  }
}