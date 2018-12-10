package com.aa.aainventorysystembe.repositories;


import com.aa.aainventorysystembe.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustomAPI {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Product updateProductQuantity(String productId, int stock) {

        Query query = new Query();

        query.addCriteria(Criteria.where("id").is(productId));

        Update update = new Update();
        update.addToSet("stock", stock);

        return mongoTemplate
                .findAndModify(query, update,
                        new FindAndModifyOptions().returnNew(true), Product.class);
    }
}
