package exceptions;

/**
 * General exception for bank transaction errors.
 */
public class BankTransactionException extends Exception {
    public BankTransactionException(String message) {
        super(message);
    }

    public BankTransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}