package models;


import enums.Currency;

/**
 * Represents a basic account.
 */
public class Account {
    private String accountNumber; // must be 16 digits
    private Currency currency;
    private double balance;

    public Account(String accountNumber, Currency currency, double balance) {
        if (!accountNumber.matches("\\d{16}")) {
            throw new IllegalArgumentException("Account number must be 16 digits.");
        }
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public Currency getCurrency() { return currency; }
    public double getBalance() { return balance; }
}