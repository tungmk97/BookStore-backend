package com.mk.serviceimpl;

import com.mk.conveter.DozerMapper;
import com.mk.data.model.Product;
import com.mk.data.model.ProductCategory;
import com.mk.data.vo.ProductCategoryVO;
import com.mk.exception.ResourceNotFoundException;
import com.mk.repository.ProductCategoryRepository;
import com.mk.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

  @Autowired
  ProductCategoryRepository productCategoryRepository;

  @Override
  public List<ProductCategoryVO> getAllProductCategory() {
    List<ProductCategory> productCategories = productCategoryRepository.findAll();
    return DozerMapper.parseListObject(productCategories, ProductCategoryVO.class);
  }

  @Override
  public ProductCategoryVO createNewCategory(ProductCategoryVO category) {
    ProductCategory productCategory = DozerMapper.parseObject(category, ProductCategory.class);
    ProductCategory newCategory = productCategoryRepository.save(productCategory);
    return DozerMapper.parseObject(newCategory, ProductCategoryVO.class);
  }

  @Override
  public ProductCategory findProductCategoryById(long id) {
    ProductCategory productCategory = productCategoryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Id not found"));

    return productCategory;
  }

  @Override
  public ProductCategoryVO updateProductCategory(ProductCategoryVO categoryVO) {
    ProductCategory productCategory = productCategoryRepository
        .save(DozerMapper.parseObject(categoryVO, ProductCategory.class));

    return DozerMapper.parseObject(productCategory, ProductCategoryVO.class);
  }

  @Override
  public void deleteCategory(int id) {
    this.productCategoryRepository.deleteById((long) id);
  }

  @Override
  public List<ProductCategoryVO> searchByKeyWord(String keyword) {
    List<ProductCategory> lstCategory = this.productCategoryRepository.findByCategoryNameContaining(keyword);

    return DozerMapper.parseListObject(lstCategory, ProductCategoryVO.class);
  }
}
