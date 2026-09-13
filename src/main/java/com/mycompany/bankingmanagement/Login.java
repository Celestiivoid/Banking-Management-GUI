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

public class Login {
    private JFrame frame;
    private JTextField nameField;
    private JTextField noField;
    private ArrayList<Account> accounts;
    private ArrayList<TransactionList> transaction;
    
    public Login(ArrayList<Account> accounts,ArrayList<TransactionList> transaction) {
        this.transaction = transaction;
        this.accounts  = accounts;
        setupGUI();
    }
    public void setupGUI() {
        frame = new JFrame();
        frame.setTitle("Login");
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        JPanel formPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        
        formPanel.setLayout(new GridLayout(2,2));
        buttonPanel.setLayout(new GridLayout(2,2));
        mainPanel.setLayout(new GridLayout(3,1));
        
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameField.setColumns(20);
        
        JLabel accNoLabel = new JLabel("Account Number: ");
        noField = new JTextField();
        noField.setColumns(20);
        
        JButton button1 = new JButton("Login");
        button1.addActionListener( e-> {
            String nameInput = nameField.getText();
            String numberInput = noField.getText();
        
            for(Account account: accounts) {
                int convertedInput = Integer.parseInt(numberInput);
                if(nameInput.equals(account.getAccNm()) && convertedInput == account.getAccNo()) {
                    new BankManagement(nameInput,accounts,transaction);
                    frame.dispose();
                    JOptionPane.showMessageDialog(frame,"Login successful!","Success!",JOptionPane.INFORMATION_MESSAGE);
                return;
                }
            }
            JOptionPane.showMessageDialog(frame,"Login unsucessful!","Warning!",JOptionPane.WARNING_MESSAGE);
            return;
        });
        
        JButton button2 = new JButton("to Account Creation");
        button2.addActionListener( e-> {
            new CreateAccount(accounts);
            frame.dispose();
        });
        
        
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        
        formPanel.add(accNoLabel);
        formPanel.add(noField);
        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        
        mainPanel.add(formPanel);
        mainPanel.add(buttonPanel);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
