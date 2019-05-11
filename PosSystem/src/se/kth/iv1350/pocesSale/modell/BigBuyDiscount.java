package se.kth.iv1350.pocesSale.modell;

import se.kth.iv1350.pocesSale.modell.Sale;

public class BigBuyDiscount implements DiscountStrategyPattern {
    private float disc = 10f;


    public BigBuyDiscount(){

    }

    @Override
  public double calculateDiscount(Sale sale, int discountType) {
        return  sale.runningTotal * ((100-disc)/100);
  }



}


