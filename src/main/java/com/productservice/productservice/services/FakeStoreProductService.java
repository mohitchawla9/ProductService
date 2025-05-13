package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.security.JWTObject;
import com.productservice.productservice.security.TokenValidator;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
//import org.springframework.data.redis.core.RedisTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private FakeStoreClient fakeStoreAdapter;
    private TokenValidator tokenValidator;
//    private RedisTemplate<String, FakeStoreProductDto> redisTemplate;

//RedisTemplate redisTemplate
    FakeStoreProductService(FakeStoreClient fakeStoreAdapter, TokenValidator tokenValidator) {
        this.fakeStoreAdapter = fakeStoreAdapter;
        this.tokenValidator = tokenValidator;
//        this.redisTemplate = redisTemplate;
    }

    private static  GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto)
    {
        //Convert FakeStoreProductDto to GenericProductDto before returning
        GenericProductDto genericProductDto = new GenericProductDto();

        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());

        return genericProductDto;
    }


    @Override
    public GenericProductDto getProductById(String authToken,Long id) throws ProductNotFoundException {
        //Integrate the FakeStore API.
        //RestTemplate
        Optional<JWTObject> jwtObjectOptional = tokenValidator.validateToken(authToken);

        if (jwtObjectOptional.isEmpty()) {
            //Invalid token
            //reject the request;
            return null;
        }
        JWTObject jwtObject = jwtObjectOptional.get();
        Long userId = jwtObject.getUserId();

        return convertToGenericProductDto(fakeStoreAdapter.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreAdapter.getAllProducts();
        List<GenericProductDto> result = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return result;
    }

    @Override
    public GenericProductDto deleteProductById( Long id) {
       return convertToGenericProductDto(fakeStoreAdapter.deleteProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto updatedProductDto) {
        return convertToGenericProductDto(fakeStoreAdapter.updateProductById(id, updatedProductDto));
    }

}
