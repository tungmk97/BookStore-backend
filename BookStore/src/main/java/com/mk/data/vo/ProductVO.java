package com.mk.data.vo;

import com.mk.data.model.ProductCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductVO {
  private Long idProductCategory;
  private Long id;
  private ProductCategory productCategory;
  private String sku;
  private String name;
  private String description;
  private BigDecimal unitPrice;
  private String imageUrl;
  private boolean active;
  private int unitsInStock;
  private Date dateCreated;
  private Date lastUpdated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public int getUnitsInStock() {
    return unitsInStock;
  }

  public void setUnitsInStock(int unitsInStock) {
    this.unitsInStock = unitsInStock;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public ProductCategory getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(ProductCategory productCategory) {
    this.productCategory = productCategory;
  }

  public Long getIdProductCategory() {
    return idProductCategory;
  }

  public void setIdProductCategory(Long idProductCategory) {
    this.idProductCategory = idProductCategory;
  }

  @Override
  public String toString() {
    return "{" + " idProductCategory='" + getIdProductCategory() + "'" + ", id='" + getId() + "'"
        + ", productCategory='" + getProductCategory() + "'" + ", sku='" + getSku() + "'" + ", name='" + getName() + "'"
        + ", description='" + getDescription() + "'" + ", unitPrice='" + getUnitPrice() + "'" + ", imageUrl='"
        + getImageUrl() + "'" + ", active='" + isActive() + "'" + ", unitsInStock='" + getUnitsInStock() + "'"
        + ", dateCreated='" + getDateCreated() + "'" + ", lastUpdated='" + getLastUpdated() + "'" + "}";
  }

}
