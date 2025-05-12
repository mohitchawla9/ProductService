package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
//    @Autowired
//    private ProductController productController;
//
//    ProductControllerTest(ProductController productController) {
//        this.productController = productController;
//    }
    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Captor
    private ArgumentCaptor<Long> argumentCaptor;

    @Test
    @DisplayName("Testing 1 + 1 is 2")
    void testOnePlusOneisTwoOrNot(){
//        assert(11 == 1+1);
//        assertEquals(11,1+1,"1+1 should be 2");
//        assertTrue(1==2);
        //checks the expected value (2) vs the output of the expression
        //If assert is TRUE,test case succeeds, else fails
    }

    @Test
    void testGetProductByIdNegativeTC() throws ProductNotFoundException {
            assertThrows(ProductNotFoundException.class,() -> productController.getProductById(1L));
//        assertNull(fakeStoreClient.getProductById(10000L));
    }

    @Test
    void testGetProductByIdMocking() throws ProductNotFoundException {
        GenericProductDto genericProductDto = new GenericProductDto();
//        when(productService.getProductById(100L)).thenReturn(genericProductDto);

        GenericProductDto genericProductDto1 = productController.getProductById(100L);

        assertEquals(genericProductDto,genericProductDto1);
//        productController.getProductById(100L));
    }

    @Test
    void testGetProductByIdMockingExpectaion() throws ProductNotFoundException {
        when(productService.getProductById(10L))
                .thenThrow(ProductNotFoundException.class);

        assertThrows(ProductNotFoundException.class,
                () -> productController.getProductById(1L));
    }

    @Test
    void testGetProductByIdForCustomLogic() throws ProductNotFoundException {
        GenericProductDto genericProductDto = new GenericProductDto();
        when(productService.getProductById(10L))
                .thenReturn(genericProductDto);

        GenericProductDto genericProductDto1 = productController.getProductById(10L);
        assertEquals(genericProductDto,genericProductDto1);

//        assertEquals(genericProductDto,productController.getProductById(10L));
    }

    @Test
    @DisplayName("testProductControllerCallsProductServiceWithSameProductIdAsInput")
    void testIfSameInput() throws ProductNotFoundException {
        //This is the test case to check if productController is passing the same productId to the
        //productService as the input.
        Long id = 100L;

        when(productService.getProductById(id)).thenReturn(new GenericProductDto());

        GenericProductDto genericProductDto =  productController.getProductById(id);

        verify(productService).getProductById(argumentCaptor.capture());

        assertEquals(id, argumentCaptor.getValue());
    }



}
