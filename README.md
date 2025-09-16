# 🏦 Simple Banking System  

This project is a **mini banking application** written in **Java**, simulating account management, cards, deposits, withdrawals, transfers, and appointment scheduling for bank services.  
The project demonstrates **OOP concepts, custom exceptions, abstract classes, interfaces, and Java Collection APIs**.  

---

## 📌 Features  

- 👤 **CardHolder Management** (passport, name, address, accounts, and cards)  
- 💳 **Card Accounts** (Visa, MasterCard, American Express)  
- 🏦 **Bank Accounts** (Debit, Credit)  
- 💰 **Transactions** (Deposit, Withdraw, Transfer)  
- 🚫 **Custom Exceptions** (e.g., `InsufficientFundsException`, `BankTransactionException`)  
- 📆 **Bank Visit Time Slots** (Appointment scheduling with priorities)  

---

## ⚙️ Enums  

- `CardType` → `VISA`, `MASTERCARD`, `AMERICAN_EXPRESS`  
- `CardStatus` → `ACTIVE`, `CLOSED`, `BLOCKED`  
- `Currency` → `AMD`, `USD`, `RUB`  
- `BankAccountType` → `DEBIT`, `CREDIT`  

---

## 🏗️ Models  

- **Address** → `country, region, city, street, house`  
- **Account** → `accountNumber (16 digits), currency, balance`  
- **CardAccount** → `accountNumber (16 digits), cvv (3 digits), expirationDate, cardType, balance, status, currency`  
- **BankAccount** → `accountNumber (16 digits), balance, currency, accountType`  
- **CardHolder** → `passportNumber, fullName, address, cardList, bankAccount`  
- **Bank** → `bankName, address, cardHolderList`  
- **Appointment** → `customerName, serviceType, preferredTime, priority`  

---

## 🚨 Exceptions  

- `InsufficientFundsException` – thrown when account/card has not enough funds.  
- `BankTransactionException` – thrown for invalid operations (e.g., deposit to credit account).  

---

## 🔄 Transactions  

### Interface: `Transaction`  
- `deposit()`  
- `withdraw()`  
- `transfer()`  

### `CardTransaction`  
- Deposit → Not allowed if **card is blocked**  
- Withdraw → Not allowed if **card is blocked** or **insufficient funds**  
- Transfer → Only if **card is active** and funds are sufficient  
- BlockCard → Change card status  

### `BankAccountTransaction`  
- Deposit → Only if account type is **DEBIT**  
- Withdraw → Only if account type is **CREDIT** and balance is sufficient  
- Transfer → From **DEBIT to CREDIT** with balance check  

---

## 📅 Appointment System  

- `AppointmentManager`  
  - `viewAllAppointments()` → Returns all scheduled appointments  
  - `getNextAppointment()` → Returns highest priority appointment  
  - `scheduleAppointment()` → Adds new appointment to the queue  

---

## 📂 Project Structure  

