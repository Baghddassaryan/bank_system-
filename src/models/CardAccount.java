package models;

import enums.CardStatus;
import enums.CardType;
import enums.Currency;

import java.time.LocalDate;

/**
 * Represents a card account with card details.
 */
public class CardAccount extends Account {


    private final String cvv;
    private final LocalDate expirationDate;
    private final CardType cardType;
    private CardStatus cardStatus;

    public CardAccount(String accountNumber, String cvv, LocalDate expirationDate,
                       CardType cardType, double balance, CardStatus cardStatus, Currency currency) {
        super(accountNumber, currency, balance);
        if (!cvv.matches("\\d{3}")) {
            throw new IllegalArgumentException("CVV must be 3 digits.");
        }
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.cardType = cardType;
        this.cardStatus = cardStatus;
    }

    public String getCvv() { return cvv; }
    public LocalDate getExpirationDate() { return expirationDate; }
    public CardType getCardType() { return cardType; }
    public CardStatus getCardStatus() { return cardStatus; }
    public void setCardStatus(CardStatus cardStatus) {this.cardStatus = cardStatus;}
}