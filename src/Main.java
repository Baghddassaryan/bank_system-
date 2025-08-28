import enums.BankAccountType;
import enums.CardStatus;
import enums.CardType;
import enums.Currency;
import models.*;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Address bankAddress = new Address(
                "USA",
                "New York",
                "New York",
                "Wall Street",
                "48");
        Address cardHolderAddress = new Address(
                "USA",
                "New York",
                "New York",
                "Wall Street",
                "51");
        List<CardAccount> cardAccounts1 = new ArrayList<CardAccount>(){
            CardAccount cardAccount = new CardAccount("7777777777777777", "777", LocalDate.of(3000, 1, 1), CardType.MASTERCARD, 100_000_000 , CardStatus.ACTIVE, Currency.USD);
        };
        BankAccount bankAccount1 = new BankAccount("7777777777777777", 100_000_000, Currency.USD, BankAccountType.DEBIT);
        CardHolder cardHolder1 = new CardHolder("AA777777", "Gurgen Baghdasaryan", cardHolderAddress, cardAccounts1, bankAccount1);
        List<CardHolder> cardHolders = new ArrayList<>();
        cardHolders.add(cardHolder1);
        Bank BaghdasaryanBankCJSC = new Bank("Baghdasaryan", bankAddress, cardHolders);

    }
}