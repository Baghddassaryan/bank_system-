import enums.BankAccountType;
import enums.CardStatus;
import enums.CardType;
import enums.Currency;
import exceptions.BankTransactionException;
import models.*;
import transactions.Transaction;
import transactions.impl.BankAccountTransactionImpl;

import java.time.LocalDate;
import java.util.*;

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
        List<CardAccount> cardAccounts1 = new ArrayList<CardAccount>() {
            final CardAccount cardAccount = new CardAccount("7777777777777777", "777", LocalDate.of(3000, 1, 1), CardType.MASTERCARD, 100_000_000, CardStatus.ACTIVE, Currency.USD);
        };
        List<CardAccount> cardAccounts2 = new ArrayList<CardAccount>() {
            final CardAccount cardAccount = new CardAccount("5555555555555555", "555", LocalDate.of(3000, 1, 1), CardType.VISA, 100_000_000, CardStatus.ACTIVE, Currency.USD);
        };

        BankAccount bankAccount1 = new BankAccount("7777777777777777", 100_000, Currency.USD, BankAccountType.DEBIT);
        BankAccount bankAccount2 = new BankAccount("5555555555555555", 100_000, Currency.USD, BankAccountType.CREDIT);

        CardHolder cardHolder1 = new CardHolder("AA777777", "Gurgen Baghdasaryan", cardHolderAddress, cardAccounts1, bankAccount1);
        CardHolder cardHolder2 = new CardHolder("AA55555", "Gurgen Baghdasaryan", cardHolderAddress, cardAccounts2, bankAccount2);


        List<CardHolder> cardHolders = new ArrayList<>();
        cardHolders.add(cardHolder1);
        cardHolders.add(cardHolder2);
        Bank bankBaghdasaryanCJSC = new Bank("Baghdasaryan", bankAddress, cardHolders);

        System.out.println(bankAccount1.getBalance());
        System.out.println(bankAccount2.getBalance());

        Transaction transaction2 = new BankAccountTransactionImpl(bankAccount2);
        Transaction transaction1 = new BankAccountTransactionImpl(bankAccount1);

        try {
            transaction1.transfer(transaction2, 100);
        } catch (BankTransactionException e) {
            System.out.println(e);
        }
        System.out.println(bankAccount1.getBalance());
        System.out.println(bankAccount2.getBalance());


    }
}