package com.productservice.productservice.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel{
    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = jakarta.persistence.FetchType.EAGER, mappedBy = "category")
    private List<Product> products;
}
