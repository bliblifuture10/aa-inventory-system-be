package com.aa.aainventorysystembe.models.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {
    @Id
    private String id;

    private String name;
    private String category;
    private int stock;
    private float price;
    private String image;
}
