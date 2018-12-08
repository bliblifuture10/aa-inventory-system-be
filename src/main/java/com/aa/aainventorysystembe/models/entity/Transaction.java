package com.aa.aainventorysystembe.models.entity;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Transaction {
    @Id
    private String Id;

    private String description;
    private Product product;
    private String status;
    private double price;
    private String holder;
}
