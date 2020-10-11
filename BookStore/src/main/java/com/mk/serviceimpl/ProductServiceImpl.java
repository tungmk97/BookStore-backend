package com.mk.serviceimpl;

import com.mk.conveter.CustomConvert;
import com.mk.conveter.DozerMapper;
import com.mk.data.model.Product;
import com.mk.data.vo.ProductVO;
import com.mk.exception.ResourceNotFoundException;
import com.mk.repository.ProductRepository;
import com.mk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository productRepository;

  @Override
  public Page<ProductVO> findByCategoryId(Long id, Pageable pageable) {
    Page<Product> lstProduct = productRepository.findByProductCategoryId(id, pageable);

    // return lstProductVO.map(this::convertToProductVO);
    return lstProduct.map(this::convertToProductVO);
  }

  private ProductVO convertToProductVO(Product product) {
    return CustomConvert.convertProductToProductVO(product);
  }

  @Override
  public Page<ProductVO> findByNameContaining(String name, Pageable pageable) {
    Page<Product> products = productRepository.findByNameContaining(name, pageable);
    return products.map(this::convertToProductVO);
  }

  @Override
  public Product findProductById(Long id) {
    Product entity = productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not Record for this ID"));
    return entity;
  }

  @Override
  public Product save(Product productVO) {
    Product product = productRepository.save(productVO);

    return product;
  }

  @Override
  public void delete(Product product) {
    productRepository.delete(product);
  }
}
