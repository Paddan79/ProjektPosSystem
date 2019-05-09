package se.kth.iv1350.pocesSale.modell;

/**
 * Contains balance in the cashRegister
 */

public class CashRegister {

    private double balance;

    /**
     * this is a empty parameter cunstructor, but since the system dont have a GUI, where the cashier enters
     * the amount of money in the cash register, I have an entered 100 SEK in the balance.
     */

    public CashRegister(){
        this.balance = 100.00;
    }

    /**
     * Increases the balance with paid amount.
     * @param paidAmount - amount paid.
     */

    public void updateCashAmount(double paidAmount){
        balance = balance + paidAmount;
        testLog();
    }

    private void testLog(){
        System.out.println("Nytt kassa belopp\n" + Math.round(balance));
    }

    /**
     * Method for test purposes. Will surely be useed later on, when system has more functionality.
     * @return balance - in cash register.
     */

    public double getBalance(){
        return balance;
    }
}