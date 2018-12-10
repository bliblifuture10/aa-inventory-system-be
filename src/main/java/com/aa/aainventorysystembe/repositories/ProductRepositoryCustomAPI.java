package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.entity.Product;

public interface ProductRepositoryCustomAPI {

    Product updateProductQuantity(String productId, int stock);
}
