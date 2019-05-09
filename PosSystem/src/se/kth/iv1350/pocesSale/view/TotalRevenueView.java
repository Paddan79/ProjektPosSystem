package se.kth.iv1350.pocesSale.view;

import se.kth.iv1350.pocesSale.modell.PaymentObserver;



public class TotalRevenueView implements PaymentObserver {
    private double totalRevenue = 0;

    /**
     * This is a empty parameter cunstructor, that initiates the <code>totalRevenue</code> at start of program
     */
    protected TotalRevenueView() {
        this.totalRevenue = 0;
    }

    /**
     * Increases the <code>totalRevenue</code> with paid amount.
     * @param paidAmount - amount paid.
     */
    @Override
    public void newPayment ( double paidAmount){
        totalRevenue = totalRevenue + paidAmount;
     //   printCurrentState(totalRevenue);
        showOnDisplay();
    }

    private void showOnDisplay() {

        System.out.println(" DISPLAY: Totalt betalt belopp:\n " + Math.round(totalRevenue));

    }


    /**
     * Method for test purposes. Will surely be used later on, when system has more functionality.
     * @return totalRevenue - since system startup.
     */

    public double getTotalRevenue(){
        return totalRevenue;
    }


}
