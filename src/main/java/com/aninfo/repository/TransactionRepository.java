package com.aninfo.repository;

import com.aninfo.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    Transaction createTransaction(Transaction transaction);
    Transaction getTransaction(long transactionNumber);
    List<Transaction> getTransactionsByAccount(long cbu);

    void eliminateTransaction(long transactionNumber);
}
