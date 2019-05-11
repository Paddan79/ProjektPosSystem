package se.kth.iv1350.pocesSale.modell;

public class ItemDiscount implements DiscountStrategyPattern {

    private float disc = 50f;


    public ItemDiscount(){

    }

    @Override
    public double calculateDiscount(Sale sale, int discountType) {
        double discAmount = 0;
        for (Item test: sale.shopingCart) {
            if (test.getId() == 1){
                discAmount = test.getItem().netPrice * test.getQuantity()*((100 - disc)/100);
            }
        }

        return  sale.runningTotal - discAmount;
    }
}
