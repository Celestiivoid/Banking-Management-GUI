/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingmanagement;

public class TransactionList {
    private int accountID;
    private double amount;
    private String type;

    public TransactionList(int accountID, double amount, String type) {
        this.accountID = accountID;
        this.amount = amount;
        this.type = type;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
