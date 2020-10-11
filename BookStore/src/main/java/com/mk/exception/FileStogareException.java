package com.mk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileStogareException extends RuntimeException {
  public FileStogareException(String message) {
    super(message);
  }

  public FileStogareException(String message, Throwable cause) {
    super(message, cause);
  }
}
