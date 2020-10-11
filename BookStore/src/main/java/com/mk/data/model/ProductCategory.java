package com.mk.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product_category")
@Data
public class ProductCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "category_name")
  private String categoryName;

  @JsonBackReference
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCategory", fetch = FetchType.LAZY)
  private Set<Product> products;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ProductCategory that = (ProductCategory) o;
    return Objects.equals(id, that.id) && Objects.equals(categoryName, that.categoryName)
        && Objects.equals(products, that.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, categoryName);
  }

  @Override
  public String toString() {
    return "ProductCategory{" + "id=" + id + ", categoryName='" + categoryName + '\'' + '}';
  }

  /**
   * @return Long return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return String return the categoryName
   */
  public String getCategoryName() {
    return categoryName;
  }

  /**
   * @param categoryName the categoryName to set
   */
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  /**
   * @return Set<Product> return the products
   */
  public Set<Product> getProducts() {
    return products;
  }

  /**
   * @param products the products to set
   */
  public void setProducts(Set<Product> products) {
    this.products = products;
  }

}
