package com.java_web;

import java.util.ArrayList;

import org.json.JSONObject;

public class DepositManager extends TransactionManager {

  public DepositManager (String accountNumber) {
    super(accountNumber);
  }

  public ArrayList<TransactionLog> runDeposits (JSONObject json, short count) {
    
    for (int i = 0; i < count; i++) {

      final int counter = i + 1;
      final String amountKey = TransactionDetailsKeys.amount.name();      
      final double amount = Double.parseDouble((String) json.get(amountKey));
      final double adjustedAmount = (double) amount * counter;
      
      if (deposit(adjustedAmount)) System.out.println("deposited " + adjustedAmount); 
    }    
    
    return this.depositHistory();
  }
}