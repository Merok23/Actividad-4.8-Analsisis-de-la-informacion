package com.aninfo.repository;


import com.aninfo.model.Transaction;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.validation.constraints.Null;
import java.util.*;
@RepositoryRestResource
public class TransactionRepositoryDefinition implements TransactionRepository {
    private Map<Long, Transaction> transactionMap;
    private Long transactionNumber;

    public TransactionRepositoryDefinition() {
        this.transactionMap = new HashMap<>();
        this.transactionNumber = 0L;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        transaction.setTransactionNumber(transactionNumber);
        transactionMap.put(transactionNumber, transaction);
        this.transactionNumber++;
        return transaction;
    }
    @Override
    public Transaction getTransaction(long transactionNumber){
        return transactionMap.get(transactionNumber);
    }

    @Override
    public List<Transaction> getTransactionsByAccount(long cbu) {
        List<Transaction> transactionsByAccount = new ArrayList<>();
        for (Transaction transaction : transactionMap.values()) {
            if (transaction.getCbu() == cbu) {
                transactionsByAccount.add(transaction);
            }
        }
        return transactionsByAccount;
    }

    @Override
    public void eliminateTransaction(long transactionNumber) {
        transactionMap.remove(transactionNumber);
    }
}
