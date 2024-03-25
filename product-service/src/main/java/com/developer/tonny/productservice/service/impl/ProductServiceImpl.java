package com.developer.tonny.productservice.service.impl;

import com.developer.tonny.productservice.entity.Product;
import com.developer.tonny.productservice.exception.ProductNotFoundException;
import com.developer.tonny.productservice.model.ProductCreateRequest;
import com.developer.tonny.productservice.model.ProductCreateResponse;
import com.developer.tonny.productservice.repository.ProductRepository;
import com.developer.tonny.productservice.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductCreateResponse createProduct(ProductCreateRequest productCreateRequest) {
        var savedProduct = productRepository.save(mapToProductEntity(productCreateRequest));
        return mapToProductCreateResponse(savedProduct);
    }

    private ProductCreateResponse mapToProductCreateResponse(Product source) {
        ProductCreateResponse target = new ProductCreateResponse();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    private Product mapToProductEntity(ProductCreateRequest source) {
        Product target = new Product();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    @Override
    public List<ProductCreateResponse> findAll() {
        return productRepository.findAll().stream().map(this::mapToProductCreateResponse).toList();
    }

    @Override
    public ProductCreateResponse findById(Integer productId) {
        var pr = productRepository.findById(productId);
        if (pr.isPresent()){
            return mapToProductCreateResponse(pr.get());
        }

        throw new ProductNotFoundException("Product with id not found");
    }

    @Override
    public ProductCreateResponse updateProduct(Integer productId, ProductCreateRequest productCreateRequest) {
        var productToUpdate = productRepository.findById(productId);
        if (productToUpdate.isPresent()){
            var product = productToUpdate.get();
            product.setName(productCreateRequest.getName());
            product.setPrice(productCreateRequest.getPrice());
            product.setProductCode(productCreateRequest.getProductCode());
            var updatedProduct = productRepository.save(product);
            return mapToProductCreateResponse(updatedProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
