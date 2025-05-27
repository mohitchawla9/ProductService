package com.productservice.productservice.repositories;

import com.productservice.productservice.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Override
    List<Product> findAll();
    List<Product> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);

//    List<Product> findAllByTitle(String title);

//    List<Product> findAllByDescription(String title, String description);

//    @Override
//    <S extends Product> List<S> findAll(Example<S> example);

//    List<Product> findByPrice_ValueLessThan(Integer x);

//    @Query(value = "select * from product where id = 1", nativeQuery = true)
//    List<Product> findAllByPrice_ValueBetween(Integer x, Integer y);
}
