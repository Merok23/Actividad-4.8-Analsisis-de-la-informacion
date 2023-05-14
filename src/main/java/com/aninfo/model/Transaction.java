package com.aninfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionNumber;

    private double cbu;
    private double sum;

    private String type;

    public Transaction(double cbu, double sum, String type) {
        this.sum = sum;
        this.type = type;
        this.cbu = cbu;
    }

    public Long getTransactionNumber() {
        return transactionNumber;
    }

    public double getTransactionSum(){
        return sum;
    }

    public double getCbu() { return cbu;}

    public String getType(){
        return type;
    }

    public void setTransactionNumber(Long number){
        this.transactionNumber = number;
    }
}
