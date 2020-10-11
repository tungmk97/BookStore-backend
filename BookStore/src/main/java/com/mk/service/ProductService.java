package com.mk.service;

import com.mk.data.model.Product;
import com.mk.data.vo.ProductVO;
import com.mk.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

  /**
   * The method to find product category by id.
   *
   * @param id       id of category want to search.
   * @param pageable to paging.
   * @return a List product have category is id
   */
  Page<ProductVO> findByCategoryId(Long id, Pageable pageable);

  /**
   * The method to find product have name containing param name
   *
   * @param name     name to search
   * @param pageable to paging
   * @return listProduct
   */
  Page<ProductVO> findByNameContaining(String name, Pageable pageable);

  /**
   * The method to find product by product id
   *
   * @param id id to search product
   * @return a optional of product
   */
  Product findProductById(Long id);

  Product save(Product productVO);

  void delete(Product product);
}
