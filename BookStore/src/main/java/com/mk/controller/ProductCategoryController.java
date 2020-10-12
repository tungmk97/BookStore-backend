package com.mk.controller;

import com.mk.data.model.ProductCategory;
import com.mk.data.vo.ProductCategoryVO;
import com.mk.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("v1/product-category")
public class ProductCategoryController {
  ProductCategoryService productCategoryService;

  @Autowired
  public ProductCategoryController(ProductCategoryService productCategoryService) {
    this.productCategoryService = productCategoryService;
  }

  @GetMapping
  public ResponseEntity<List<ProductCategory>> getAllProductCategory() {
    List<ProductCategory> lstProductCategory = productCategoryService.getAllProductCategory();
    return new ResponseEntity<>(lstProductCategory, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ProductCategoryVO> createNewProductCategory(@RequestBody ProductCategoryVO categoryVO) {
    try {
      return new ResponseEntity<>(this.productCategoryService.createNewCategory(categoryVO), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public void deleteCategory(@PathVariable("id") int id) {
    this.productCategoryService.deleteCategory(id);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductCategory> findCategoryByID(@PathVariable("id") long id) {
    return new ResponseEntity<>(productCategoryService.findProductCategoryById(id), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<ProductCategoryVO> updateProductCategory(@RequestBody ProductCategoryVO categoryVO) {
    return new ResponseEntity<>(productCategoryService.updateProductCategory(categoryVO), HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<List<ProductCategoryVO>> searchProductCategory(@RequestParam("keyword") String keyword) {

    return new ResponseEntity<>(productCategoryService.searchByKeyWord(keyword), HttpStatus.OK);
  }

}
