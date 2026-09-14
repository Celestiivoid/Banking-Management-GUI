package com.mycompany.bankingmanagement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Withdraw {
    private JFrame frame;
    private JTextField balance;
    private JTextField amount;
    private ArrayList<Account> accounts;
    private ArrayList<TransactionList> transaction;
    private String username;
    
    public Withdraw(String username,ArrayList<Account> accounts,ArrayList<TransactionList> transaction) {
        this.transaction = transaction;
        this.username = username;
        this.accounts = accounts;
        setupGUI();
    }
    public void setupGUI() {
        frame = new JFrame();
        frame.setTitle("Withdraw");
        frame.setSize(550,400);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        JPanel formPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        
        formPanel.setLayout(new GridLayout(2,2));
        mainPanel.setLayout(new GridLayout(3,1));
        buttonPanel.setLayout(new GridLayout(2,2));
        
        JLabel balanceLabel = new JLabel("Balance: ");
        balance = new JTextField();
        
        for(Account account: accounts) {
            if(username.equals(account.getAccNm())) {
                balance.setText(String.valueOf(account.getInitialDep()));
                break;
            }
        }
        
        balance.setEditable(false);
        balance.setColumns(20);
        
        JLabel amountLabel = new JLabel("Amount: ");
        amount = new JTextField();
        amount.setColumns(20);
        
        JButton button1 = new JButton("Withdraw");
        button1.addActionListener( e -> withdraw());
        
        JButton button2 = new JButton("Back");
        button2.addActionListener( e -> {
            new BankManagement(username,accounts,transaction);
            frame.dispose();
        });
        
        formPanel.add(balanceLabel);
        formPanel.add(balance);
        
        formPanel.add(amountLabel);
        formPanel.add(amount);
        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        
        mainPanel.add(formPanel);
        mainPanel.add(buttonPanel);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    public void withdraw() {
        String balanceField = balance.getText();
        String amountField = amount.getText();
        
        if(amountField.isEmpty()) {
            JOptionPane.showMessageDialog(frame,"Please enter an amount to withdraw.");
            return;
        }
        
        try {
            double convertedBalance = Double.parseDouble(balanceField);
            double convertedAmount = Double.parseDouble(amountField);
            
            double afterBalance = convertedBalance - convertedAmount;
            
            for(Account account : accounts) {
                if(username.equals(account.getAccNm())) {
                    if(convertedAmount > account.getInitialDep()) {
                        JOptionPane.showMessageDialog(frame,"Insufficient balance!");
                        return;
                    }
                    account.setInitialDep(afterBalance);
                    balance.setText(String.valueOf(account.getInitialDep()));
                    transaction.add(new TransactionList(account.getAccNo(),"Withdraw",convertedAmount));
                    break;
                }
            }
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(frame,"Numbers only!");
            return;
        }
    }
}
