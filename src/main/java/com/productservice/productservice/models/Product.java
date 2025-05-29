package com.productservice.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Document(indexName = "products")
public class Product extends BaseModel {
    private String title;
    private String description;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Price price;

    private String image;

    //Category isn't primitive attribute,it is a relation
    @ManyToOne(optional = false)
    private Category category;

    private int inventoryCount ;
}
