package com.mk.data.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @CreationTimestamp
  private Date date;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "discount_id")
  private Discount discount;

  @ManyToOne
  @JoinColumn(name = "shipper_id")
  private Shipper shipper;

  private String status;

  @OneToMany(mappedBy = "book")
  private List<OrderBook> books;

  // @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  // @EqualsAndHashCode.Exclude
  // @ToStringExclude
  // @JoinTable(name = "order_book", joinColumns = @JoinColumn(name = "order_id"),
  // inverseJoinColumns = @JoinColumn(name = "book_id"))
  // private List<Book> books;
}