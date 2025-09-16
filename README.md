# 🏦 Simple Banking System

A **mini banking application** built in **Java** that simulates account management, card operations, deposits, withdrawals, transfers, and appointment scheduling.

This project demonstrates concepts of **OOP, custom exceptions, abstract classes, interfaces, and Java collection APIs**.

---

## 📌 Features

### 🔹 Core Banking
- Manage **Bank Accounts** (Debit & Credit).
- Manage **Bank Cards** (Visa, MasterCard, American Express).
- Perform **Transactions**:
    - Deposit
    - Withdraw
    - Transfer

### 🔹 Card & Account Rules
- Blocked cards cannot be used for transactions.
- Debit accounts allow deposits.
- Credit accounts allow withdrawals.
- Balance and currency validation for transactions.

### 🔹 Appointment System
- Schedule customer appointments for:
    - Account Opening
    - Loan Consultation
    - Card Issue
- Priority-based appointment handling.

---

## 📂 Project Structure

```bash
bank_system/
│
├── enums/
│   ├── CardType.java
│   ├── CardStatus.java
│   ├── Currency.java
│   ├── ServiceType.java
│   └── BankAccountType.java
│
├── models/
│   ├── Address.java
│   ├── Appointment.java
│   ├── Account.java
│   ├── CardAccount.java
│   ├── BankAccount.java
│   ├── CardHolder.java
│   └── Bank.java
│
├── transactions/
│   ├── Transaction.java
│   ├── CardTransaction.java
│   ├── AppointmentManager.java
│   └── BankAccountTransaction.java
│
│
├── exceptions/
│   ├── InsufficientFundsException.java
│   └── BankTransactionException.java
│
├── Main.java
└── README.md
```

---

## ⚙️ Installation & Usage

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/bank_system.git
cd bank_system
```

### 2. Compile the Project
```bash
javac Main.java
```

### 3. Run the Application
```bash
java Main
```

---

## 📖 Example Usage

```java
Address address = new Address("Armenia", "Yerevan", "Kentron", "Tumanyan", "25A");
CardAccount card = new CardAccount("1234567890123456", "123", "12/28", 
                                   CardType.VISA, 1000.0, CardStatus.ACTIVE, Currency.USD);

CardTransaction transaction = new CardTransaction();
transaction.deposit(card, 500.0);
transaction.withdraw(card, 200.0);

System.out.println("Balance: " + card.getBalance());
```

---

## 🛑 Custom Exceptions

- `InsufficientFundsException` → Thrown when withdrawal/transfer exceeds balance.
- `BankTransactionException` → General exception for invalid operations.

---

## 🎯 Concepts Implemented

- ✅ **OOP** (Encapsulation, Inheritance, Polymorphism, Abstraction)
- ✅ **Custom Exceptions** for business rules
- ✅ **Abstract Classes & Interfaces** (`Transaction`)
- ✅ **Java Collections API** for managing card lists, accounts, and appointments

---

## 📅 Future Improvements

- Add **database integration** for persistent storage.
- Implement **user authentication system**.
- Add **GUI / Web interface**.

---

## 📜 License

This project is licensed under the **MIT License** – free to use and modify.

---

