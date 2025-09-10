package transactions.impl;

import transactions.Transaction;
import enums.BankAccountType;
import exceptions.*;
import models.BankAccount;

/**
 * Represents transactions for a bank account (Debit / Credit).
 */
public class BankAccountTransactionImpl implements Transaction {
    private final BankAccount account;

    public BankAccountTransactionImpl(BankAccount account) {
        this.account = account;
    }

    @Override
    public void deposit(double amount) throws BankTransactionException {

        if (amount <= 0) {
            throw new BankTransactionException("Deposit amount must be positive.");
        }
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException, BankTransactionException {
        if (amount <= 0) {
            throw new BankTransactionException("Withdraw amount must be positive.");
        }

        if (account.getBankAccountType() == BankAccountType.DEBIT) {
            if (account.getBalance() < amount) {
                throw new InsufficientFundsException("Not enough balance in debit account.");
            }
            account.setBalance(account.getBalance() - amount);
        } else {
            // Credit account: allow overdraft (balance can go negative)
            account.setBalance(account.getBalance() - amount);
        }
    }

    @Override
    public void transfer(Transaction toAccount, double amount)
            throws InsufficientFundsException, BankTransactionException {
        if (toAccount == null) {
            throw new IllegalArgumentException("Target account cannot be null.");
        }

        if (this == toAccount) {
            throw new BankTransactionException("Cannot transfer to the same account.");
        }


        if (!(toAccount instanceof BankAccountTransactionImpl targetAccount)) {
            throw new BankTransactionException("Transfer allowed only between bank accounts.");
        }

        if (this.account.getBankAccountType() != BankAccountType.DEBIT ||
                targetAccount.account.getBankAccountType() != BankAccountType.CREDIT) {
            throw new BankTransactionException("Transfers allowed only from debit account to credit account.");
        }

        // check enough balance on debit side
        if (account.getBalance() < amount) {
            throw new InsufficientFundsException("Not enough balance to transfer.");
        }

        this.withdraw(amount);
        targetAccount.deposit(amount);
    }

    public BankAccount getAccount() {
        return account;
    }
}