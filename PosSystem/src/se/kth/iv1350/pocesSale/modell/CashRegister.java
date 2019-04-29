package se.kth.iv1350.pocesSale.modell;

public class CashRegister {

    private double balance;

    public CashRegister(){
        this.balance = 100.00;
    }

    public void updateCashAmount(double paidAmount){
        balance = balance + paidAmount;
        testLog();
    }

    private void testLog(){
        System.out.println("Nytt kassa belopp\n" + Math.round(balance));
    }

    public double getBalance(){
        return balance;
    }
}