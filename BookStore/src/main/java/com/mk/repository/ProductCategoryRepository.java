package com.mk.repository;

import com.mk.data.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

//    @Query("SELECT p FROM ProductCategory p WHERE p.categoryName LIKE '%keyword%'")
    List<ProductCategory> findByCategoryNameContaining(@Param("keyword") String keyword);
}
