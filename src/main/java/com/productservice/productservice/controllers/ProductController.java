package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
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
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        //return "Product fetched with id: " + id;
        return productService.getProductById(id);
    }

    @GetMapping("")
    public List<GenericProductDto> getAllProducts() { return productService.getAllProducts();}

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id) {
       return productService.deleteProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
       return productService.createProduct(genericProductDto);
    }

    @PatchMapping("/{id}")
    public void updateProductById(@RequestBody GenericProductDto genericProductDto, @PathVariable("id") Long id) {
       productService.updateProductById(id, genericProductDto);
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//       return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
//    }

}

/*
3 ways of Dependency Injection :-

1. Constructor Injection
2. Field Injection
3. Setter Injection

*/
