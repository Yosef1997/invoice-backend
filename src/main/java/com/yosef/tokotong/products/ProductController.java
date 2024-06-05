package com.yosef.tokotong.products;

import com.yosef.tokotong.products.entity.Product;
import com.yosef.tokotong.products.service.ProductService;
import com.yosef.tokotong.response.Response;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
@Log
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/")
  public ResponseEntity<Response<List<Product>>> getProducts () {
    return Response.successResponse("All products fetched", productService.getProducts());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<Optional<Product>>> getProductDetail (@PathVariable("id") long id) {
    return Response.successResponse("Detail product fetched success", productService.getProductDetail(id));
  }

  @PostMapping("/{merchantId}")
  public ResponseEntity<Response<Object>> createProducts (@Validated @PathVariable Long merchantId, @RequestBody Product product) {
    return Response.successResponse("Create product success", productService.createProduct(merchantId, product));
  }
}
