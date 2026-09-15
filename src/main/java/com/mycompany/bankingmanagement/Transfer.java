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
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Transfer {
    private JFrame frame;
    private JTextField accountNo;
    private JTextField accountBal;
    private JTextField amount;
    private JTextField accountNm;
    private String username;
    
    private ArrayList<Account> accounts;
    private ArrayList<TransactionList> list;
    
    public Transfer(String username,ArrayList<Account> accounts,ArrayList<TransactionList> list) {
        this.username = username;
        this.accounts = accounts;
        this.list = list;
        setupGUI();
    }
    
    public void setupGUI() {
        frame = new JFrame();
        frame.setTitle("Transfer Money");
        frame.setSize(550,400);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        JPanel formPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        
        formPanel.setLayout(new GridLayout(4,2));
        mainPanel.setLayout(new GridLayout(3,1));
        buttonPanel.setLayout(new GridLayout(2,2));
        
        JLabel balanceLabel = new JLabel("Balance: ");
        accountBal = new JTextField();
        
        for(Account account : accounts) {
            if(username.equals(account.getAccNm())) {
                accountBal.setText(String.valueOf(account.getInitialDep()));
                break;
            }
        }
        accountBal.setColumns(20);
        accountBal.setEditable(false);
        
        JLabel accountNum = new JLabel("Account number: ");
        accountNo = new JTextField();
        accountNo.setColumns(20);
        
        JLabel accountName = new JLabel("Account name: ");
        accountNm = new JTextField();
        accountNm.setColumns(20);
        accountNm.setEditable(false);
        
        
        JLabel amountLabel = new JLabel("Amount: ");
        amount = new JTextField();
        amount.setColumns(20);
        
        JButton button1 = new JButton("Search");
        button1.addActionListener(e -> search());
        
        JButton button2 = new JButton("Transfer");
        button2.addActionListener(e -> transfer());
        
        JButton button3 = new JButton("Back");
        button3.addActionListener(e -> {
            new BankManagement(username,accounts,list);
            frame.dispose();
        });
        
        formPanel.add(balanceLabel);
        formPanel.add(accountBal);
        
        formPanel.add(accountNum);
        formPanel.add(accountNo);
        
        formPanel.add(accountName);
        formPanel.add(accountNm);
        
        formPanel.add(amountLabel);
        formPanel.add(amount);
        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        
        mainPanel.add(formPanel);
        mainPanel.add(buttonPanel);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    public void transfer() {
        
    }
    public void search() {
        String accNoField = accountNo.getText();
            
            if(accNoField.isEmpty()) {
                JOptionPane.showMessageDialog(frame,"Please enter an account number to transfer.");
                return;
            }
            
            try {
                int convertedNumber = Integer.parseInt(accNoField);
                boolean isFound = false;
                
                for(Account account : accounts) {
                    if(convertedNumber == account.getAccNo()) {
                        if(account.getAccNm().equals(username)) {
                            JOptionPane.showMessageDialog(frame,"Cannot transfer to your own account.");
                            accountNm.setText("");
                            amount.setEditable(false);
                            return;
                        }
                        accountNm.setText(account.getAccNm());
                        JOptionPane.showMessageDialog(frame,"Account found!");
                        amount.setEditable(true);
                        isFound = true;
                        break;
                    }
                }
                if(!isFound) {
                    accountNm.setText("");
                    JOptionPane.showMessageDialog(frame,"Account not found!");
                }
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(frame,"Numbers only!");
                return;
            }
    }
}
