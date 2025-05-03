package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.models.Product;

public interface ProductService {

    GenericProductDto getProductById(Long id);
    void getAllProducts();
    void deleteProductById(Long id);
    void createProduct();
    void updateProductById();
}
