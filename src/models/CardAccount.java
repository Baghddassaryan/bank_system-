package models;

import enums.CardStatus;
import enums.CardType;
import enums.Currency;

import java.time.LocalDate;

/**
 * Represents a card account with card details.
 */
public class CardAccount {
    private String accountNumber; // must be 16 digits
    private String cvv; // must be 3 digits
    private LocalDate expirationDate;
    private CardType cardType;
    private double balance;
    private CardStatus cardStatus;
    private Currency currency;

    public CardAccount(String accountNumber, String cvv, LocalDate expirationDate,
                       CardType cardType, double balance, CardStatus cardStatus, Currency currency) {
        if (!accountNumber.matches("\\d{16}")) {
            throw new IllegalArgumentException("Account number must be 16 digits.");
        }
        if (!cvv.matches("\\d{3}")) {
            throw new IllegalArgumentException("CVV must be 3 digits.");
        }
        this.accountNumber = accountNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.cardType = cardType;
        this.balance = balance;
        this.cardStatus = cardStatus;
        this.currency = currency;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getCvv() { return cvv; }
    public LocalDate getExpirationDate() { return expirationDate; }
    public CardType getCardType() { return cardType; }
    public double getBalance() { return balance; }
    public CardStatus getCardStatus() { return cardStatus; }
    public Currency getCurrency() { return currency; }
    public void setBalance(double balance) {this.balance = balance;}
    public void setCardStatus(CardStatus cardStatus) {this.cardStatus = cardStatus;}
}