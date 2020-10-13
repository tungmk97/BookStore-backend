package com.mk.data.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 20)
  private String isbn;
  @Column(length = 100)
  private String title;
  @CreationTimestamp
  private Date publicationDate;
  @UpdateTimestamp
  private Date updateDate;
  @Column(length = 2)
  private Integer edition;
  private Integer availableQuantity;
  private Double price;

  @ManyToOne
  @JoinColumn(name = "address_id") // thong qua khoa ngoai id
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Author author;

  @ManyToOne
  @JoinColumn(name = "publisher_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Publisher publisher;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  @ToStringExclude
  @JoinTable(name = "book_discount", // create a table has name is book_discount
      joinColumns = @JoinColumn(name = "book_id"), // khoa ngoai tro den class hien tai -book
      inverseJoinColumns = @JoinColumn(name = "discount_id")) // khoa ngoai tro den thuocn tinh cua discount
  private Set<Discount> discounts;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  @ToStringExclude
  @JoinTable(name = "book_genres", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
  private Set<Genres> genres;

  @OneToMany(mappedBy = "order")
  private List<OrderBook> orders;
}