package com.productservice.productservice.services;

import com.productservice.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(Long id);
    List<GenericProductDto> getAllProducts();
    void deleteProductById(Long id);
    void createProduct();
    void updateProductById();
}
