package com.aa.aainventorysystembe.repositories;

import com.aa.aainventorysystembe.models.entity.Transaction;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends MongoRepository<Transaction, String>{
    Optional<Transaction> findById(String transId);
    List<Transaction> findByHolderId (String empId);
    List<Transaction> findBySupervisorId (String empId);

    boolean existsById(String transId);
    boolean existsByHolderId(String empId);
    boolean existsBySupervisorId(String empId);

    Boolean deleteByIdEquals(String transId);
}
