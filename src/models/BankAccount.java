package models;

import enums.BankAccountType;
import enums.Currency;

/**
 * Represents a bank account.
 */
public class BankAccount extends Account {

    private BankAccountType bankAccountType;

    public BankAccount(String accountNumber, double balance, Currency currency, BankAccountType bankAccountType) {
        super(accountNumber, currency, balance);
        if (!accountNumber.matches("\\d{16}")) {
            throw new IllegalArgumentException("Account number must be 16 digits.");
        }
        this.bankAccountType = bankAccountType;
    }

    public BankAccountType getBankAccountType() { return bankAccountType; }
    public void setBankAccountType(BankAccountType bankAccountType) {this.bankAccountType = bankAccountType;}
}