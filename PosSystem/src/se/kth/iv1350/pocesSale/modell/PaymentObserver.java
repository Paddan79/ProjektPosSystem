package se.kth.iv1350.pocesSale.modell;


public interface PaymentObserver {
    /**
     * Invoked when a sale has been paid.
     *
     * @param paidAmount - the amount paid for the sale
     */
    void newPayment(double paidAmount);
}