package com.mk.data.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "order_book")
@Data
public class OrderBook {

  @EmbeddedId
  private OrderBookId orderBookId;

  @ManyToOne
  @MapsId("orderId")
  private Order order;

  @ManyToOne
  @MapsId("bookId")
  private Book book;

  private Double totalMoney;
}