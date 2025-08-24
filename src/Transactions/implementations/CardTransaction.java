package Transactions.implementations;

import Transactions.interfaces.Transaction;
import enums.CardStatus;
import exceptions.*;
import models.CardAccount;

/**
 * Represents transactions on a card account.
 */
public class CardTransaction implements Transaction {
    private final CardAccount card;

    public CardTransaction(CardAccount card) {
        this.card = card;
    }

    @Override
    public void deposit(double amount) throws BankTransactionException {
        if (card.getCardStatus() == CardStatus.BLOCKED) {
            throw new BankTransactionException("Cannot deposit: card is blocked.");
        }
        if (amount <= 0) {
            throw new BankTransactionException("Deposit amount must be positive.");
        }
        card.setBalance(card.getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException, BankTransactionException {
        if (card.getCardStatus() == CardStatus.BLOCKED) {
            throw new BankTransactionException("Cannot withdraw: card is blocked.");
        }
        if (amount <= 0) {
            throw new BankTransactionException("Withdraw amount must be positive.");
        }
        if (card.getBalance() < amount) {
            throw new InsufficientFundsException("Not enough balance to withdraw.");
        }
        card.setBalance(card.getBalance() - amount);
    }

    @Override
    public void transfer(Transaction toAccount, double amount)
            throws InsufficientFundsException, BankTransactionException {
        if (card.getCardStatus() == CardStatus.BLOCKED) {
            throw new BankTransactionException("Cannot transfer: card is blocked.");
        }
        withdraw(amount);
        toAccount.deposit(amount);
    }

    /** Block the card */
    public void blockCard() {
        card.setCardStatus(CardStatus.BLOCKED);
    }

    /** Unblock the card */
    public void unblockCard() {
        card.setCardStatus(CardStatus.ACTIVE);
    }

    public CardAccount getCard() {
        return card;
    }
}