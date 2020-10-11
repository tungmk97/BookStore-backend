package com.mk.data.vo;

import com.mk.data.model.ProductCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductVOCustom {
  private String idProductCategory;
  private String id;
  private String sku;
  private String name;
  private String description;
  private BigDecimal unitPrice;
  private String imageUrl;
  private boolean active;
  private int unitsInStock;
  private Date dateCreated;
  private Date lastUpdated;

  public String getIdProductCategory() {
    return this.idProductCategory;
  }

  public void setIdProductCategory(String idProductCategory) {
    this.idProductCategory = idProductCategory;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSku() {
    return this.sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getUnitPrice() {
    return this.unitPrice;
  }

  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public boolean isActive() {
    return this.active;
  }

  public boolean getActive() {
    return this.active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public int getUnitsInStock() {
    return this.unitsInStock;
  }

  public void setUnitsInStock(int unitsInStock) {
    this.unitsInStock = unitsInStock;
  }

  public Date getDateCreated() {
    return this.dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getLastUpdated() {
    return this.lastUpdated;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  @Override
  public String toString() {
    return "{" + " idProductCategory='" + getIdProductCategory() + "'" + ", id='" + getId() + "'" + ", sku='" + getSku()
        + "'" + ", name='" + getName() + "'" + ", description='" + getDescription() + "'" + ", unitPrice='"
        + getUnitPrice() + "'" + ", imageUrl='" + getImageUrl() + "'" + ", active='" + isActive() + "'"
        + ", unitsInStock='" + getUnitsInStock() + "'" + ", dateCreated='" + getDateCreated() + "'" + ", lastUpdated='"
        + getLastUpdated() + "'" + "}";
  }

}
