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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class TransactionHistory {
    private JFrame frame;
    private DefaultTableModel transactionModel;
    private JTable transactionTable;
    private String username;
    private ArrayList<Account> accounts;
    private ArrayList<TransactionList> transaction;
    
    public TransactionHistory(String username, ArrayList<Account> accounts, ArrayList<TransactionList> transaction) {
        this.username = username;
        this.accounts = accounts;
        this.transaction = transaction;
        setupGUI();
    }
    
    public void setupGUI() {
        frame = new JFrame();
        frame.setTitle("Transaction History");
        frame.setSize(550,400);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        JPanel formPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        
        formPanel.setLayout(new GridLayout(1,2));
        buttonPanel.setLayout(new GridLayout(1,2));
        mainPanel.setLayout(new GridLayout(3,1));
        
        String columns [] = {"Account ID","Amount","Type"};
        transactionModel  = new DefaultTableModel(columns,0);
        transactionTable = new JTable(transactionModel);
        displayTransaction();
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        
        
        JButton button1 = new JButton("Back");
        button1.addActionListener(e -> {
            new BankManagement(username,accounts,transaction);
            frame.dispose();
        });
        
        buttonPanel.add(button1);
        
        mainPanel.add(formPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(scrollPane);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    public void displayTransaction() {
        for(TransactionList transactions : transaction) {
            transactionModel.addRow(new Object[] {
            transactions.getAccountID(),
            transactions.getAmount(),
            transactions.getType()
        });
        }
    }
}
