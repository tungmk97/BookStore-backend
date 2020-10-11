package com.mk.repository;

import com.mk.data.model.Product;
import com.mk.data.vo.ProductVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Page<Product> findByProductCategoryId(@RequestParam("id") Long id, Pageable pageable);

  Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
