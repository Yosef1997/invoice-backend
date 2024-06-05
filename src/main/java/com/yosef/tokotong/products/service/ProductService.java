package com.yosef.tokotong.products.service;

import com.yosef.tokotong.products.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

  public List<Product> getProducts ();

  public Optional<Product> getProductDetail (Long id);

  public Product createProduct(Long merchantId, Product product);
}
