package com.aa.aainventorysystembe.models.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    private String Id;

    private String name;
    private String Category;
    private int stock;
    private float price;
    private String image;
}
