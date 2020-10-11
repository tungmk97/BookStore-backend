package com.mk.data.vo;

import com.mk.data.model.Product;
import com.mk.data.model.ProductCategory;
import lombok.Data;

import java.util.Set;

@Data
public class ProductCategoryVO {
  private Long id;
  private String categoryName;
  private Set<Product> products;
}
