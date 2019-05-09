package se.kth.iv1350.pocesSale.controller;

/**
 * thrown when an operation fails, and the reason is not important.
 */

public class OperationFailedEceptions extends Exception {

    /**
     * Creates a new instace with the specifeied message and root cause
     *
     * @param msg The exceptions message.
     * @param cause The exception that caused this exception.
     */

    public OperationFailedEceptions(String msg, Exception cause){
        super(msg,cause);
    }
}
