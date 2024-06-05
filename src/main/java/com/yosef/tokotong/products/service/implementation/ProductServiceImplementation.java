package com.yosef.tokotong.products.service.implementation;

import com.yosef.tokotong.exceptions.applicationException.ApplicationException;
import com.yosef.tokotong.exceptions.notFoundException.NotFoundException;
import com.yosef.tokotong.merchant.entity.Merchant;
import com.yosef.tokotong.merchant.repository.MerchantRepository;
import com.yosef.tokotong.products.entity.Product;
import com.yosef.tokotong.products.repository.ProductRepository;
import com.yosef.tokotong.products.service.ProductService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log
public class ProductServiceImplementation implements ProductService {
  private final ProductRepository productRepository;

  private final MerchantRepository merchantRepository;

  public ProductServiceImplementation (ProductRepository productRepository, MerchantRepository merchantRepository) {
    this.productRepository = productRepository;
    this.merchantRepository = merchantRepository;
  }

  @Override
  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> getProductDetail(Long id) {
    var result = productRepository.findById(id);
    if (result.isEmpty()){
      throw new NotFoundException("Detail product with id: " + id + " not found");
    }
    return result;
  }

  @Override
  public Product createProduct(Long merchantId, Product product) {
    Optional<Merchant> merchant = merchantRepository.findById(merchantId);
    if (merchant.isEmpty()) {
      throw new NotFoundException("Merchant not found with id: " + merchantId);
    }
    product.setMerchant(merchant.get());
    return productRepository.save(product);
  }
}
