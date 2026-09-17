/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankingmanagement;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class CreateAccount {
    private JFrame frame;
    private JTextField accountNo;
    private JTextField name;
    private JComboBox <String> accountType;
    private JTextField initialDep;
    
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<TransactionList> transaction = new ArrayList<>();
    
    public CreateAccount(ArrayList<Account> accounts,ArrayList<TransactionList> transaction) {
        this.transaction = transaction;
        this.accounts = accounts;
        createGUI();
    }
    public void createGUI() {
        frame = new JFrame();
        frame.setTitle("Create Account");
        frame.setSize(550,400);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        JPanel formPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        
        formPanel.setLayout(new GridLayout(4,2));
        buttonPanel.setLayout(new GridLayout(3,2));
        mainPanel.setLayout(new GridLayout(3,1));
        
        JLabel accLabel = new JLabel("Account Number:");
        accountNo = new JTextField();
        accountNo.setColumns(20);
        
        JLabel nameLabel = new JLabel("Name: ");
        name = new JTextField();
        name.setColumns(20);
        
        JLabel accTypeLabel = new JLabel("Account Type: ");
        String typeList [] = {"Student","Savings","Investment","Business"};
        accountType = new JComboBox(typeList);
        
        JLabel depoLabel = new JLabel("Initial Deposit:");
        initialDep = new JTextField();
        initialDep.setColumns(20);
        
        JButton button1 = new JButton("Create Account");
        button1.addActionListener( e -> createAccount());
        JButton button2 = new JButton("Cancel");
        
        JButton button3 = new JButton("to Login");
        button3.addActionListener( e -> {
            new Login(accounts,transaction);
            frame.dispose();
        });
        
        formPanel.add(accLabel);
        formPanel.add(accountNo);
        
        formPanel.add(nameLabel);
        formPanel.add(name);
        
        formPanel.add(accTypeLabel);
        formPanel.add(accountType);
        
        formPanel.add(depoLabel);
        formPanel.add(initialDep);
        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        
        mainPanel.add(formPanel);
        mainPanel.add(buttonPanel);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    public void createAccount() {
        String accNoField = accountNo.getText();
        String nameField = name.getText();
        String typeField = (String) accountType.getSelectedItem();
        String depositField = initialDep.getText();
        
        try {
            int convertedAccNo = Integer.parseInt(accNoField);
            double convertedInitial = Double.parseDouble(depositField);
            
            if(convertedAccNo < 1000 || convertedAccNo > 9999) {
                JOptionPane.showMessageDialog(frame,"Must enter 4 digits for account number.");
                return;
            }
            
            if(convertedInitial < 0) {
                JOptionPane.showMessageDialog(frame,"Initial deposit must be more than 0.");
                return;
            }
            
            for(Account account : accounts) {
                if(convertedAccNo == account.getAccNo()) {
                    JOptionPane.showMessageDialog(frame,"Account number already exist in the system.");
                    return;
                }
            }
            
            Account newAccount = new Account(convertedAccNo,nameField,typeField,convertedInitial);
            accounts.add(newAccount);
            
            JOptionPane.showMessageDialog(frame,"Account creation successful!","Success!",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(frame,"Numbers only!","Invalid!",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    public void cancelCreation() {
        
    }

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<TransactionList> transaction = new ArrayList<>();
        new CreateAccount(accounts,transaction);
    }
}
