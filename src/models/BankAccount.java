package models;

import enums.BankAccountType;
import enums.Currency;

/**
 * Represents a bank account.
 */
public class BankAccount {
    private String accountNumber; // must be 16 digits
    private double balance;
    private Currency currency;
    private BankAccountType bankAccountType;

    public BankAccount(String accountNumber, double balance, Currency currency, BankAccountType bankAccountType) {
        if (!accountNumber.matches("\\d{16}")) {
            throw new IllegalArgumentException("Account number must be 16 digits.");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.bankAccountType = bankAccountType;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public Currency getCurrency() { return currency; }
    public BankAccountType getBankAccountType() { return bankAccountType; }
    public void setBalance(double balance) {this.balance = balance;}
    public void setBankAccountType(BankAccountType bankAccountType) {this.bankAccountType = bankAccountType;}
}