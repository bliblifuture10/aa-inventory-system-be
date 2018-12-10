package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.ErrorCode;
import com.aa.aainventorysystembe.models.entity.Product;
import com.aa.aainventorysystembe.models.entity.Transaction;
import com.aa.aainventorysystembe.repositories.ProductRepository;
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

    @Autowired
    ProductRepository productRepository;

    @Override
    public Transaction getTansactionById(String transId) {
        return transactionRepository.findById(transId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorCode.NOT_FOUND.getCode(),
                        ErrorCode.NOT_FOUND.getMessage()
                ));
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getAllTransactionByHolderId(String empId) {
        if(!transactionRepository.existsByHolderId(empId))
        {
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }
        return transactionRepository.findByHolderId(empId);
    }

    @Override
    public List<Transaction> getAllTransactionBySupervisorId(String supervisorId) {
        if(!transactionRepository.existsBySupervisorId(supervisorId))
        {
            throw new ResourceNotFoundException(ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }

        return transactionRepository.findBySupervisorId(supervisorId);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransactionById(String id, Transaction transactionReq) {
        return transactionRepository.findById(id).map(transaction -> {
            String productId = transactionReq.getProductId();
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException(
                    ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage()
            ));
            int currentStock = product.getStock();
            float price = product.getPrice();

            product.setStock(currentStock - (transactionReq.getQty() - transaction.getQty()));

            transaction.setDescription(transactionReq.getDescription());
            transaction.setQty(transactionReq.getQty());
            transaction.setPrice(transaction.getQty() * price);
            transaction.setStatus(transactionReq.getStatus());

            return transactionRepository.save(transaction);
        }).orElseThrow(() -> new ResourceNotFoundException(
                ErrorCode.NOT_FOUND.getCode(),
                ErrorCode.NOT_FOUND.getMessage()
        ));
    }

    @Override
    public Boolean deleteTransactionById(String id) {
        if(!transactionRepository.existsById(id)){
            throw new ResourceNotFoundException(
                    ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage()
            );
        }

        return transactionRepository.deleteByIdEquals(id);
    }
}
