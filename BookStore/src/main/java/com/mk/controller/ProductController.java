package com.mk.controller;

import com.mk.conveter.CustomConvert;
import com.mk.conveter.DozerMapper;
import com.mk.data.model.Product;
import com.mk.data.model.ProductCategory;
import com.mk.data.vo.ProductCategoryVO;
import com.mk.data.vo.ProductVO;
import com.mk.data.vo.ProductVOCustom;
import com.mk.service.FileStogareService;
import com.mk.service.ProductCategoryService;
import com.mk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("v1/products")
public class ProductController {

  @Autowired
  ProductService productService;

  @Autowired
  ProductCategoryService productCategoryService;

  @Autowired
  FileStogareService fileStogareService;

  @GetMapping("/search/findByCategoryId")
  public ResponseEntity<PagedModel<ProductVO>> findProductByCategoryId(@RequestParam("id") Long id,
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "10") int size, PagedResourcesAssembler assembler) {
    Pageable pageable = PageRequest.of(page, size);
    Page<ProductVO> productVOs = productService.findByCategoryId(id, pageable);

    return new ResponseEntity<>(assembler.toModel(productVOs), HttpStatus.OK);
  }

  @GetMapping("/search/findByNameContaining")
  public ResponseEntity<PagedModel<ProductVO>> findByNameContaining(@RequestParam("name") String name,
      @RequestParam("page") int page, @RequestParam("size") int size, PagedResourcesAssembler assembler) {
    Pageable pageable = PageRequest.of(page, size);
    Page<ProductVO> productVOS = productService.findByNameContaining(name, pageable);

    return new ResponseEntity<>(assembler.toModel(productVOS), HttpStatus.OK);
  }

  @GetMapping("/search/{productId}")
  public ResponseEntity<ProductVO> findProductById(@PathVariable("productId") Long id) {
    Product product = productService.findProductById(id);
    return new ResponseEntity<>(DozerMapper.parseObject(product, ProductVO.class), HttpStatus.OK);
  }

  @PostMapping(consumes = { "multipart/form-data" })
  public ResponseEntity<ProductVO> createNewProduct(@ModelAttribute ProductVOCustom productCustomVO,
      @RequestParam("file") MultipartFile multipartFile) {
    long productCategoryID = Long.parseLong(productCustomVO.getIdProductCategory());
    ProductCategory productCategory = productCategoryService.findProductCategoryById(productCategoryID);
    // ProductVO productVO = DozerMapper.parseObject(productCustomVO,
    // ProductVO.class);
    // productVO.setProductCategory(DozerMapper.parseObject(productCategory,
    // ProductCategory.class));
    // System.out.println("==" + productVO);
    String filePart = fileStogareService.createFile(multipartFile);
    Product product = DozerMapper.parseObject(productCustomVO, Product.class);
    product.setProductCategory(productCategory);
    product.setImageUrl(filePart);
    Product productNew = productService.save(product);
    return new ResponseEntity<>(CustomConvert.convertProductToProductVO(productNew), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<ProductVO> updateProduct(@RequestBody ProductVOCustom productCustomVO) {
    long productCategoryID = Long.parseLong(productCustomVO.getIdProductCategory());
    ProductCategory productCategory = productCategoryService.findProductCategoryById(productCategoryID);
    Product product = productService.findProductById(Long.valueOf(productCustomVO.getId()));
    CustomConvert.updateProduct(product, productCustomVO, productCategory);
    Product productUpdate = productService.save(product);
    return new ResponseEntity<>(CustomConvert.convertProductToProductVO(productUpdate), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable("id") Long id) {
    Product product = productService.findProductById(id);
    productService.delete(product);
  }

}