package com.mk.conveter;

import com.mk.data.model.Product;
import com.mk.data.model.ProductCategory;
import com.mk.data.vo.ProductVO;
import com.mk.data.vo.ProductVOCustom;

public class CustomConvert {
  public static ProductVO convertProductToProductVO(Product product) {
    ProductVO productVO = new ProductVO();
    productVO.setId(product.getId());
    productVO.setProductCategory(product.getProductCategory());
    productVO.setSku(product.getSku());
    productVO.setName(product.getName());
    productVO.setDescription(product.getDescription());
    productVO.setUnitPrice(product.getUnitPrice());
    productVO.setImageUrl(product.getImageUrl());
    productVO.setActive(product.isActive());
    productVO.setUnitsInStock(product.getUnitsInStock());
    productVO.setDateCreated(product.getDateCreated());
    productVO.setLastUpdated(product.getLastUpdated());

    return productVO;
  }

  public static Product convertProductVOToProduct(ProductVO productVO) {
    Product product = new Product();
    product.setId(product.getId());
    product.setProductCategory(product.getProductCategory());
    product.setSku(product.getSku());
    product.setName(product.getName());
    product.setDescription(product.getDescription());
    product.setUnitPrice(product.getUnitPrice());
    product.setImageUrl(product.getImageUrl());
    product.setActive(product.isActive());
    product.setUnitsInStock(product.getUnitsInStock());
    product.setDateCreated(product.getDateCreated());
    product.setLastUpdated(product.getLastUpdated());

    return product;
  }

  public static Product updateProduct(Product product, ProductVOCustom productCustom, ProductCategory productCategory) {
    product.setName(productCustom.getName());
    product.setSku(productCustom.getSku());
    product.setUnitPrice(productCustom.getUnitPrice());
    product.setUnitsInStock(productCustom.getUnitsInStock());
    product.setDescription(productCustom.getDescription());
    if (product.getProductCategory().getId() != Long.valueOf(productCustom.getIdProductCategory())) {
      product.setProductCategory(productCategory);
    }
    return product;
  }
}