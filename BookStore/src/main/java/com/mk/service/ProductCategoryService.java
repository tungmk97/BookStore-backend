package com.mk.service;

import com.mk.data.model.ProductCategory;
import com.mk.data.vo.ProductCategoryVO;

import java.util.List;

public interface ProductCategoryService {

  /**
   * The method to get all product category.
   *
   * @return all product category.
   */
  List<ProductCategoryVO> getAllProductCategory();

  ProductCategoryVO createNewCategory(ProductCategoryVO category);

  ProductCategory findProductCategoryById(long id);

  ProductCategoryVO updateProductCategory(ProductCategoryVO categoryVO);

  void deleteCategory(int id);

  List<ProductCategoryVO> searchByKeyWord(String keyword);
}
