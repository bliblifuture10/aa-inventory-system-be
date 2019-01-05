package com.aa.aainventorysystembe.services.impl;

import com.aa.aainventorysystembe.repositories.TransactionRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class TransactionServiceImplTest {

    @InjectMocks
    TransactionServiceImpl transactionService;

    @Mock
    TransactionRepository transactionRepository;


    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
        System.out.println("Running : TearDown");
    }

    @Test
    public void getTansactionById() {

    }

    @Test
    public void getAllTransaction() {
    }

    @Test
    public void getAllTransactionByHolderId() {
    }

    @Test
    public void getAllTransactionBySupervisorId() {
    }

    @Test
    public void createTransaction() {
    }

    @Test
    public void updateTransactionById() {
    }

    @Test
    public void deleteTransactionById() {
    }
}