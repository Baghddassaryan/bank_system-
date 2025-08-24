package Transactions.interfaces;


import exceptions.BankTransactionException;
import exceptions.InsufficientFundsException;

/**
 * Represents a bank transaction.
 * Provides operations for depositing, withdrawing,
 * and transferring money between accounts.
 */
public interface Transaction {

    /**
     * Deposit money into the account.
     *
     * @param amount the amount to deposit, must be positive
     * @throws BankTransactionException if the deposit cannot be completed
     */
    void deposit(double amount) throws BankTransactionException;

    /**
     * Withdraw money from the account.
     *
     * @param amount the amount to withdraw, must be positive
     * @throws InsufficientFundsException if there is not enough balance
     * @throws BankTransactionException   if the withdrawal cannot be completed
     */
    void withdraw(double amount) throws InsufficientFundsException, BankTransactionException;

    /**
     * Transfer money to another account.
     *
     * @param toAccount the target account to receive funds
     * @param amount    the amount to transfer, must be positive
     * @throws InsufficientFundsException if the source account has insufficient balance
     * @throws BankTransactionException   if the transfer cannot be completed
     */
    void transfer(Transaction toAccount, double amount)
            throws InsufficientFundsException, BankTransactionException;
}
