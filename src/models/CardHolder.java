package models;

import java.util.List;

/**
 * Represents a cardholder (bank client).
 */
public class CardHolder {
    private String passportNumber;
    private String fullName;
    private Address address;
    private List<CardAccount> cardList;
    private BankAccount bankAccount;

    public CardHolder(String passportNumber, String fullName, Address address,
                      List<CardAccount> cardList, BankAccount bankAccount) {
        this.passportNumber = passportNumber;
        this.fullName = fullName;
        this.address = address;
        this.cardList = cardList;
        this.bankAccount = bankAccount;
    }

    public String getPassportNumber() { return passportNumber; }
    public String getFullName() { return fullName; }
    public Address getAddress() { return address; }
    public List<CardAccount> getCardList() { return cardList; }
    public BankAccount getBankAccount() { return bankAccount; }
}