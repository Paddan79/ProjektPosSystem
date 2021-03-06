package se.kth.iv1350.pocesSale.modell;
import se.kth.iv1350.pocesSale.integration.AccountSystem;
import se.kth.iv1350.pocesSale.integration.InventorySystem;
import se.kth.iv1350.pocesSale.integration.SaleLog;
import se.kth.iv1350.pocesSale.integration.StoreRegistry;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Collects all information regarding a particular sale
 */



public class Sale {
    private List<PaymentObserver> paymentObserverList = new ArrayList<>();
    static final int PROCENT = 100;
    static final int NUMBER_OF_DECIMALS = 100;
    private DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);


    LocalDateTime saleDateTime;
    protected String storeName;
    protected String storeAdress;
    protected List<Item> shopingCart = new ArrayList<Item>();
    protected double vatAmount;
    protected double runningVATAmount;
    protected double runningTotal;
    protected double recivedAmount;
    protected double changeAmount;

    /**
     * Empty constructor of Sale
     */

    public Sale() {

    }

    /**
     * Constructor of Sale
     *
     * @param storeInfo
     */


    public Sale(StoreRegistry storeInfo) {
        saleDateTime = LocalDateTime.now();

        this.storeName = storeInfo.getStoreName();
        this.storeAdress = storeInfo.getStoreAdress();
        //PrintOut  for Test purposes.
        System.out.println(storeName);
        System.out.println(storeAdress);
        System.out.println(saleDateTime.format(formatter));
    }

    /**
     * Adds an item to the shopping cart with the given quantity or
     * if the item already exists, it adds the quantity to that of the existing item in the shopping cart.
     *
     * @param itemInfo - needed information about the item
     * @param quantity - the quantity of items registered at one time
     */
    public void addItem(ItemDescriptionDTO itemInfo, int quantity) {
        boolean itemExists = false;
        if (shopingCart.isEmpty()) {
            addToList(itemInfo, quantity);
        } else {
            for (Iterator<Item> it = shopingCart.iterator(); it.hasNext(); ) {
                Item item = it.next();
                if (item.getId() == itemInfo.id) {
                    item.addQuantity(quantity);
                    itemExists = true;
                }
            }
            if (itemExists == false) {
                addToList(itemInfo, quantity);
            }
        }
        runningTotal = calculateRunningTotal(itemInfo, quantity);

    }

    /**
     * Shows how the sale shall be written when ToString is called.
     *
     * @return Sale String presentation.
     */

    @Override
    public String toString() {
        StringBuilder shopingCartPresentaion = new StringBuilder();
        for (Item scp : shopingCart) {
            shopingCartPresentaion.append(scp.toString() + "\n");
        }
        shopingCartPresentaion.append("\nTotal moms " + roundToTwoDecimals(runningVATAmount) + "\n");
        shopingCartPresentaion.append("Totalt belopp " + roundToTwoDecimals(runningTotal) + "\n");
        if (recivedAmount > 0) {
            shopingCartPresentaion.append("\nMottaget belopp " + Math.round(recivedAmount) + "\n");
            shopingCartPresentaion.append("Pengar tillbaka " + Math.round(changeAmount) + "\n");
        }


        return shopingCartPresentaion.toString();
    }

    /**
     * Method to Add an item to the Sale list
     *
     * @param itemInfo - ItemDescriptionDTO - information about the item
     * @param quantity - the quantity of items registered at one time
     */

    private void addToList(ItemDescriptionDTO itemInfo, int quantity) {
        Item itemCreate = new Item(itemInfo, quantity);
        shopingCart.add(itemCreate);
    }

    /**
     * Calculates runningTotal when adding an item
     *
     * @param itemInfo -  ItemDescriptionDTO - information about the item
     * @param quantity - the quantity of items registered at one time
     * @return runningTotal - the total price including VAT for the items already registered
     */

    private double calculateRunningTotal(ItemDescriptionDTO itemInfo, int quantity) {

        runningTotal = runningTotal + (itemInfo.netPrice + vatCalculate(itemInfo, quantity)) * quantity;

        return runningTotal;
    }

    /**
     * Calculates vatAmount when adding an item, also needed when calculate runningTotal.
     *
     * @param itemInfo - ItemDescriptionDTO - information about the item
     * @param quantity - the quantity of items registered at one time
     * @return vatAmount - tax to be paid for the added item
     */

    private double vatCalculate(ItemDescriptionDTO itemInfo, int quantity) {
        vatAmount = (itemInfo.netPrice * itemInfo.vat) / PROCENT;
        runningVATAmount = runningVATAmount + (vatAmount * quantity);
        return vatAmount;

    }

    public double giveMeTotal() {
        return runningTotal;
    }

    /**
     * Strategy Pattern on the discount.
     * @param sale - so that the Totalprice get's the discount
     * @param discType - just something that shall be given by an external in order to chose what discount that should
     *                 be applied in each sale or not.
     * @return - the discounted total price.
     */

    public double calculateNewPrice(Sale sale, int discType){

        if (discType == 1) {
            DiscountStrategyPattern discountStrategyPatternBigBuy = new BigBuyDiscount();
            runningTotal = discountStrategyPatternBigBuy.calculateDiscount(sale, discType);

            return roundToTwoDecimals(runningTotal);
        }
        else if(discType == 2){
            DiscountStrategyPattern discountStrategyPatternItemDiscount = new ItemDiscount();
            runningTotal = discountStrategyPatternItemDiscount.calculateDiscount(sale,discType);
            return roundToTwoDecimals(runningTotal);
        }
        else
            return roundToTwoDecimals(runningTotal);
    }

    /**
     * When the customer have paid
     *
     * @param recivedAmount - amoount of money recieved from the customer
     * @param sale          - Object containing information about the whole sale
     * @return Reciept information
     */

    public Receipt paid(double recivedAmount, Sale sale) {
        this.recivedAmount = recivedAmount;
        calculateChange(recivedAmount);
        new SaleLog().logSale(sale);
        new AccountSystem().bookSale(sale);
        new InventorySystem().uppdateQuantity(sale);
        new CashRegister().updateCashAmount(runningTotal);
        notifyObservers(runningTotal);
        return new Receipt(sale);
    }


    private double roundToTwoDecimals(double roundNumber) {
        return Math.round(roundNumber * NUMBER_OF_DECIMALS) / NUMBER_OF_DECIMALS;
    }

    private void calculateChange(double recivedAmount) {
        changeAmount = recivedAmount - runningTotal;
    }

    private void notifyObservers(double paidAmount) {
     for (PaymentObserver obs : paymentObserverList) {
        obs.newPayment(paidAmount);
     }
    }
    /**
     * The specified observer will be notified when this rental has been paid.
     * This method is not used for the moment.
     *
     * @param obs The observer to notify.
     */

    public void addPaymentObserver(PaymentObserver obs) {
        paymentObserverList.add(obs);
    }

    /**
     * All the specified observers will be notified when this rental has been paid.
     *
     * @param observers The observers to notify.
     */
    public void addPaymentObservers(List<PaymentObserver> observers) {
        paymentObserverList.addAll(observers);
    }
}
