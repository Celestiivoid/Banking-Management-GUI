/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingmanagement;

public class Account {
    private int accountNumber;
    private String accountName;
    private String accountType;
    private double initialDeposit;
    
    
    Account(int accountNumber, String accountName, String accountType, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.initialDeposit = initialDeposit;
    }
    
    int getAccNo() {
        return accountNumber;
    }
    String getAccNm() {
        return accountName;
    }
    String getAccTp() {
        return accountType;
    }
    double getInitialDep() {
        return initialDeposit;
    }
    
    void setInitialDep(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }
}
