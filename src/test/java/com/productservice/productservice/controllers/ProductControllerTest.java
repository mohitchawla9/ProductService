package com.productservice.productservice.controllers;

import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
}
