package com.productservice.productservice.services;

import com.productservice.productservice.models.Product;

public interface ProductService {

    String getProductById(Long id);
    void getAllProducts();
    void deleteProductById(Long id);
    void createProduct();
    void updateProductById();
}
