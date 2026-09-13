/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingmanagement;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.ArrayList;

public class BankManagement {
    private JFrame frame;
    private JTextField welcomeField;
    private String username;
    private JTextField balanceField;
    private JTextField nameField;
    private ArrayList<Account> accounts;
    private ArrayList<TransactionList> transaction;
    
    
    public BankManagement(String username,ArrayList<Account> accounts,ArrayList<TransactionList> transaction) {
        this.transaction = transaction;
        this.username = username;
        this.accounts = accounts;
        setupGUI();
    }
    
    public void setupGUI() {
        frame = new JFrame();
        frame.setTitle("Bank Management System");
        frame.setSize(550,400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        JPanel formPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel welcomePanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        
        welcomePanel.setLayout(new GridLayout(1,2));
        formPanel.setLayout(new GridLayout(2,2));
        mainPanel.setLayout(new GridLayout(3,1));
        buttonPanel.setLayout(new GridLayout(3,2));
        
        welcomeField = new JTextField();
        welcomeField.setText("Welcome, " + username + "!");
        welcomeField.setEditable(false);
        
        JLabel nameLabel = new JLabel("Account name: ");
        nameField = new JTextField();
        for(Account account : accounts) {
            if(username.equals(account.getAccNm())) {
                nameField.setText(account.getAccNm());
                break;
            }
        }
        nameField.setEditable(false);
        nameField.setColumns(20);
        
        JLabel balanceLabel = new JLabel("Balance: ");
        balanceField = new JTextField();
        for(Account account : accounts) {
            if(username.equals(account.getAccNm())) {
                balanceField.setText(String.valueOf(account.getInitialDep()));
                break;
            }
        }
        balanceField.setEditable(false);
        balanceField.setColumns(20);
        
        JButton button1 = new JButton("Deposit");
        button1.addActionListener( e -> {
         new Deposit(username,accounts,transaction); 
         frame.dispose();
        });
        
        JButton button2 = new JButton("Withdraw");
        button2.addActionListener( e -> {
            new Withdraw(username,accounts);
            frame.dispose();
        });
        
        JButton button3 = new JButton("Back to login");
        button3.addActionListener( e -> {
            new Login(accounts,transaction);
            frame.dispose();
        });
        
        JButton button4 = new JButton("Transaction History");
        button4.addActionListener( e -> {
            System.out.println("Transaction History button clicked");
    System.out.println("Transaction list: " + transaction);
            new TransactionHistory(username,accounts,transaction);
            frame.dispose();
        });
        
        welcomePanel.add(welcomeField);
        
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        
        formPanel.add(balanceLabel);
        formPanel.add(balanceField);
        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        
        mainPanel.add(welcomePanel);
        mainPanel.add(formPanel);
        mainPanel.add(buttonPanel);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
