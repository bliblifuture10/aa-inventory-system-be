package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.models.Response;
import com.aa.aainventorysystembe.models.entity.Transaction;
import com.aa.aainventorysystembe.services.TransactionService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/transaction")
public class TransactionController extends GlobalController{

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public Response<List<Transaction>> getAllTransaction(){
        return toResponse(transactionService.getAllTransaction());
    }

    @GetMapping("/id/{id}")
    public Response<Transaction> getTransaction(@PathVariable String id){
        return toResponse(transactionService.getTansactionById(id));
    }

    @GetMapping("/holder/{id}")
    public Response<List<Transaction>> getTransactionByHolderId(@PathVariable String id){
        return toResponse(transactionService.getAllTransactionByHolderId(id));
    }

    @PostMapping
    public Response<Transaction> addTransaction (@Valid @RequestBody Transaction transaction){
        return toResponse(transactionService.createTransaction(transaction));
    }

    @PutMapping("/id/{id}")
    public Response<Transaction> updateTransactionById(@PathVariable String id, @Valid @RequestBody Transaction transactionReq){
        return toResponse(transactionService.updateTransactionById(id, transactionReq));
    }

    @DeleteMapping("/id/{id}")
    public Response<Boolean> deleteTransactionById(@PathVariable String id){
        return toResponse(transactionService.deleteTransactionById(id));
    }
}
