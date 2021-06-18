package miniBankProgekt.model;

import miniBankProgekt.service.BankOperations;

import java.util.LinkedList;
/**
 * Класс Сервис "Клиенты".
 *
 * @author Rotar Mikhail
 * @version 1.1
 * @since 13.01.2021
 */

public class UserAccount extends BankOperations {

    private String username;
    private Long accountnumber;
    private String mobilenumber;
    private String accountOpeningDate;
    private LinkedList<Transaction> transactions;
    private float balance;


    public void setaccountOpeningDate(String accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public String getaccountOpeningDate() {
        return accountOpeningDate;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(Long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }


}