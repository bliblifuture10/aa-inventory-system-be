package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends MongoRepository<Transaction, String>{

    Optional<Transaction> findById(String transId);
    List<Transaction> findByHolder (String empId);

    boolean existsById(String transId);
    boolean existsByHolder(String empId);

    void deleteById(String transId);
}
