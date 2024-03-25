package com.developer.tonny.productservice.controller;

import com.developer.tonny.productservice.model.GenericResponse;
import com.developer.tonny.productservice.model.ProductCreateRequest;
import com.developer.tonny.productservice.model.ProductCreateResponse;
import com.developer.tonny.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //    get all products
    @GetMapping
    public GenericResponse<List<ProductCreateResponse>> list() {
        List<ProductCreateResponse> pr = productService.findAll();
        GenericResponse<List<ProductCreateResponse>> resp = GenericResponse.<List<ProductCreateResponse>>builder()
                .success(true)
                .msg("Data fetched Successfully")
                .data(pr)
                .build();
        log.info("We returned : {}", pr);
        return resp;

    }

    //    get a product by id
    @GetMapping("/{id}")
    public GenericResponse<ProductCreateResponse> getOne(@PathVariable Integer id) {
        ProductCreateResponse pr = productService.findById(id);
        GenericResponse<ProductCreateResponse> resp = GenericResponse.<ProductCreateResponse>builder()
                .success(true)
                .msg("Data fetched Successfully")
                .data(pr)
                .build();
        log.info("We returned : {}", pr);
        return resp;
    }

    @PostMapping
    public GenericResponse<ProductCreateResponse> createProduct(
            @RequestBody ProductCreateRequest productCreateRequest) {
        log.info("We received : {}", productCreateRequest);
        ProductCreateResponse pr = productService.createProduct(productCreateRequest);
        GenericResponse<ProductCreateResponse> resp = GenericResponse.<ProductCreateResponse>builder()
                .success(true)
                .msg("Data saved Successfully")
                .data(pr)
                .build();
        log.info("We returned : {}", pr);
        return resp;
    }
//    edit a product
    @PutMapping("/{id}")
    public GenericResponse<ProductCreateResponse> updateProduct(
            @PathVariable Integer id,
            @RequestBody ProductCreateRequest productCreateRequest) {
        log.info("We received : {}", productCreateRequest);
        ProductCreateResponse pr = productService.updateProduct(id, productCreateRequest);
        GenericResponse<ProductCreateResponse> resp = GenericResponse.<ProductCreateResponse>builder()
                .success(true)
                .msg("Data updated Successfully")
                .data(pr)
                .build();
        log.info("We returned : {}", pr);
        return resp;
    }

    //    delete a product
    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        GenericResponse<String> resp = GenericResponse.<String>builder()
                .success(true)
                .msg("Data deleted Successfully")
                .data("Product with id " + id + " deleted")
                .build();
        log.info("We returned : {}", resp);
        return resp;
    }
}
