package com.aa.aainventorysystembe.services;

import com.aa.aainventorysystembe.models.entity.Transaction;
import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction getTansactionById(String transId);
    List<Transaction> getAllTransaction();
    List<Transaction> getAllTransactionByHolderId(String empId);
    List<Transaction> getAllTransactionBySupervisorId(String supervisorId);

    Transaction createTransaction(Transaction transaction);
    Transaction updateTransactionById(String id, Transaction transaction);
    Boolean deleteTransactionById(String id);
}
