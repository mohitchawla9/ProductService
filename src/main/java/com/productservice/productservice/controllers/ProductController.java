package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    //@Autowired
    private ProductService productService;

    //Constructor Injection
   public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
      this.productService = productService;
   }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        //return "Product fetched with id: " + id;
        return productService.getProductById(id);
    }

    @GetMapping("")
    public List<GenericProductDto> getAllProducts() { return productService.getAllProducts();}

    @DeleteMapping("/{id}")
    public void deleteProductById() { }

    public void createProduct() { }

    public void updateProductById(){ }
}

/*

3 ways of Dependency Injection :-

1. Constructor Injection
2. Field Injection
3. Setter Injection

*/
