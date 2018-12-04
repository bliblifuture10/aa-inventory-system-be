package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.entity.Transaction;
import com.aa.aainventorysystembe.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @GetMapping
    public List<Transaction> getAllTransaction(){
        return transactionService.getAllTransaction();
    }

    @GetMapping("id/{transId}")
    public Optional <Transaction> getTransaction(@PathVariable String transId){
        return transactionService.getTansactionById(transId);
    }

    @GetMapping("holder/{empId}")
    public List<Transaction> getTransactionByEmpId(@PathVariable String empId){
        return transactionService.getAllTransactionByEmpId(empId);
    }

    @PostMapping
    public Transaction addTransaction (@Valid @RequestBody Transaction transaction){
        return transactionService.createTransaction(transaction);
    }

    @DeleteMapping
    public  void deleteTransaction(String transId){
        transactionService.deleteTransaction(transId);
    }
}
