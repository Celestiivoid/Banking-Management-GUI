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
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Deposit {
    private JFrame frame;
    private JTextField balance;
    private JTextField amount;
    
    public Deposit() {
        setupGUI();
    }
    
    public void setupGUI() {
        frame = new JFrame();
        frame.setTitle("Deposit");
        frame.setSize(550,400);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        
        JPanel formPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        
        formPanel.setLayout(new GridLayout(2,2));
        mainPanel.setLayout(new GridLayout(3,1));
        
        JLabel balanceLabel = new JLabel("Balance: ");
        balance = new JTextField();
        balance.setColumns(20);
        balance.setEditable(false);
        
        JLabel amountLabel = new JLabel("Amount: ");
        amount = new JTextField();
        amount.setColumns(20);
        
        formPanel.add(balanceLabel);
        formPanel.add(balance);
        
        formPanel.add(amountLabel);
        formPanel.add(amount);
        
        mainPanel.add(formPanel);
        
        frame.add(mainPanel);
        
        frame.setVisible(true);
    }
}
