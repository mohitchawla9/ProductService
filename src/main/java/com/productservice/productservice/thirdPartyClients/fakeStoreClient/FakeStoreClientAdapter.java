package com.productservice.productservice.thirdPartyClients.fakeStoreClient;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class FakeStoreClientAdapter {

    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProductsUrl = "https://fakestoreapi.com/products";

    FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        //Integrate the FakeStore API
        //RestTemplate
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class , id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if(fakeStoreProductDto == null){
            //throw an exception
            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist.");
        }

        return responseEntity.getBody();
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductsUrl, FakeStoreProductDto[].class);

        return List.of(responseEntity.getBody());
    }


    public FakeStoreProductDto deleteProductById( Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor,id);

        return responseEntity.getBody();
    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(genericProductsUrl, genericProductDto, FakeStoreProductDto.class);

        return responseEntity.getBody();
    }


    public FakeStoreProductDto updateProductById(Long id, GenericProductDto updatedProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.exchange(
                specificProductUrl,
                HttpMethod.PATCH,
                new org.springframework.http.HttpEntity<>(updatedProductDto),
                FakeStoreProductDto.class,
                id
        );

        return responseEntity.getBody();
    }

}
