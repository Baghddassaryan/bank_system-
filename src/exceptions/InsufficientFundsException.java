package exceptions;
/**
 * Exception thrown when an account does not have enough funds
 * to complete a transaction.
 */
public class InsufficientFundsException extends BankTransactionException  {
    public InsufficientFundsException(String message) {
        super(message);
    }
    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
}