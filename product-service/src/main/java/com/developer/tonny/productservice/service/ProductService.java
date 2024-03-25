package com.developer.tonny.productservice.service;

import com.developer.tonny.productservice.model.ProductCreateRequest;
import com.developer.tonny.productservice.model.ProductCreateResponse;

import java.util.List;

public interface ProductService {
    ProductCreateResponse createProduct(ProductCreateRequest productCreateRequest);

    List<ProductCreateResponse> findAll();

    ProductCreateResponse findById(Integer productId);

    ProductCreateResponse updateProduct(Integer productId, ProductCreateRequest productCreateRequest);

    void deleteProduct(Integer productId);
}
