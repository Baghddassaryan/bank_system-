package models;


import java.util.List;

/**
 * Represents a bank.
 */
public class Bank {
    private String bankName;
    private Address address;
    private List<CardHolder> cardHolders;

    public Bank(String bankName, Address address, List<CardHolder> cardHolders) {
        this.bankName = bankName;
        this.address = address;
        this.cardHolders = cardHolders;
    }

    public String getBankName() { return bankName; }
    public Address getAddress() { return address; }
    public List<CardHolder> getCardHolders() { return cardHolders; }
}
