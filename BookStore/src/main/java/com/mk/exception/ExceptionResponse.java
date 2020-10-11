package com.mk.exception;

import java.util.Date;

public class ExceptionResponse {
  private Date datetime;
  private String message;
  private String details;

  public ExceptionResponse(Date datetime, String message, String details) {
    this.datetime = datetime;
    this.message = message;
    this.details = details;
  }

  public Date getDatetime() {
    return datetime;
  }

  public void setDatetime(Date datetime) {
    this.datetime = datetime;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }
}
