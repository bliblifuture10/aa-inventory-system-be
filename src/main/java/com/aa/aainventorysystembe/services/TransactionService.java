package com.aa.aainventorysystembe.services;

import com.aa.aainventorysystembe.models.entity.Transaction;
import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Optional<Transaction> getTansactionById(String transId);
    List<Transaction> getAllTransaction();
    List<Transaction> getAllTransactionByEmpId(String empId);

    Transaction createTransaction(Transaction transaction);
    Transaction updateTransaction(String transId, Transaction transaction);

    void deleteTransaction(String transId);
}
