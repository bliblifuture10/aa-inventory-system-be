package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.ErrorCode;
import com.aa.aainventorysystembe.models.entity.Transaction;
import com.aa.aainventorysystembe.repositories.TransactionRepository;
import com.aa.aainventorysystembe.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public Optional<Transaction> getTansactionById(String transId) {
        if(!transactionRepository.existsById(transId))
        {
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }

        return transactionRepository.findById(transId);
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getAllTransactionByEmpId(String empId) {
        if(!transactionRepository.existsByHolder(empId))
        {
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }
        return transactionRepository.findByHolder(empId);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(String transId, Transaction transaction) {
        return null;
    }

    @Override
    public void deleteTransaction(String transId) {
        transactionRepository.deleteById(transId);
    }
}
