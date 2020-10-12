package com.mk.data.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
public class OrderBookId implements Serializable {
  /**
  *
  */
  private static final long serialVersionUID = 1L;

  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "book_id")
  private Long bookId;

  public OrderBookId() {
  }

  public OrderBookId(Long orderId, Long bookId) {
    this.orderId = orderId;
    this.bookId = bookId;
  }

  public Long getOrderId() {
    return this.orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getBookId() {
    return this.bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public OrderBookId orderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

  public OrderBookId bookId(Long bookId) {
    this.bookId = bookId;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof OrderBookId)) {
      return false;
    }
    OrderBookId orderBookId = (OrderBookId) o;
    return Objects.equals(orderId, orderBookId.orderId) && Objects.equals(bookId, orderBookId.bookId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, bookId);
  }

  @Override
  public String toString() {
    return "{" + " orderId='" + getOrderId() + "'" + ", bookId='" + getBookId() + "'" + "}";
  }

}