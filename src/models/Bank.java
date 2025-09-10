package models;


import java.util.List;
import java.util.Objects;

/**
 * Represents a bank.
 */
public class Bank {
    private final String bankName;
    private final Address address;
    private final List<CardHolder> cardHolders;

    public Bank(String bankName, Address address, List<CardHolder> cardHolders) {
        this.bankName = bankName;
        this.address = address;
        this.cardHolders = cardHolders;
    }

    public String getBankName() { return bankName; }
    public Address getAddress() { return address; }
    public List<CardHolder> getCardHolders() { return cardHolders; }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", address=" + address +
                ", cardHolders=" + cardHolders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bank)) return false;
        Bank bank = (Bank) o;
        return Objects.equals(bankName, bank.bankName) &&
                Objects.equals(address, bank.address) &&
                Objects.equals(cardHolders, bank.cardHolders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, address, cardHolders);
    }
}