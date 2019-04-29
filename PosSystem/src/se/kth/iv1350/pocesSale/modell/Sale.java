package se.kth.iv1350.pocesSale.modell;
import se.kth.iv1350.pocesSale.integration.AccountSystem;
import se.kth.iv1350.pocesSale.integration.InventorySystem;
import se.kth.iv1350.pocesSale.integration.SaleLog;
import se.kth.iv1350.pocesSale.integration.StoreRegistry;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Collects all information regarding a particular sale
 */



public class Sale {

    static final int PROCENT = 100;
    static final int NUMBER_OF_DECIMALS = 100;


    LocalDateTime saleTime;
    protected String storeName;
    protected String storeAdress;
    protected List<Item> shopingCart = new ArrayList<Item>();
    protected double vatAmount;
    protected double runningVATAmount;
    protected double runningTotal;
    protected double recivedAmount;
    protected double changeAmount;



    public Sale(){

    }
    /**
     * Constructor of Sale
     * @param storeInfo
     */


    public Sale(StoreRegistry storeInfo){
       saleTime = LocalDateTime.now();
       this.storeName = storeInfo.getStoreName();
       this.storeAdress = storeInfo.getStoreAdress();
       //Utskrift i Test syfte
       System.out.println(storeName);
       System.out.println(storeAdress);
       System.out.println(saleTime);
    }

    public void addItem(ItemDescriptionDTO itemInfo, int quantity){
        boolean itemExists = false;
        if (shopingCart.isEmpty()){
            addToList(itemInfo,quantity);
        }
        else {
            for (Iterator<Item> it = shopingCart.iterator(); it.hasNext();) {
                Item item  = it.next();
                if (item.getId() == itemInfo.id){
                    item.addQuantity(quantity);
                    itemExists = true;
                }
            }
            if(itemExists == false){
                addToList(itemInfo, quantity);
            }
        }
       runningTotal = calculateRunningTotal(itemInfo, quantity);

    }

    /**
     *  Shows how the sale shall be written when ToString is called.
     *
     * @return Sale String presentation.
     */

    @Override
    public String toString(){
        StringBuilder shopingCartPresentaion = new StringBuilder();
        for (Item scp: shopingCart ) {
            shopingCartPresentaion.append(scp.toString()+ "\n");
        }
            shopingCartPresentaion.append("\nTotal moms " + roundToTwoDecimals(runningVATAmount) + "\n");
            shopingCartPresentaion.append("Totalt belopp " + roundToTwoDecimals(runningTotal) + "\n");
            if(recivedAmount > 0){
            shopingCartPresentaion.append("\nMottaget belopp "+ Math.round(recivedAmount) + "\n");
            shopingCartPresentaion.append("Pengar tillbaka " + Math.round(changeAmount) + "\n");
            }


        return shopingCartPresentaion.toString();
    }

    /**
     * Method to Add an item to the Sale list
     *
     * @param itemInfo - ItemDescriptionDTO
     * @param quantity - How manny the people
     */

    public void addToList(ItemDescriptionDTO itemInfo, int quantity){
        Item itemCreate = new Item( itemInfo , quantity);
        shopingCart.add(itemCreate);
    }

    /**
     * Calculates runningTotal when adding an item
     *
     * @param itemInfo -
     * @param quantity
     * @return runningTotal
     */

    private double calculateRunningTotal(ItemDescriptionDTO itemInfo, int quantity){

       runningTotal = runningTotal + (itemInfo.netPrice + vatCalculate(itemInfo, quantity)) * quantity;

        return runningTotal;
    }

    /**
     * Calculates vatAmount when adding an item, also needed when calculate runningTotal.
     *
     * @param itemInfo
     * @param quantity
     * @return vatAmount
     */

    private double vatCalculate(ItemDescriptionDTO itemInfo, int quantity){
        vatAmount = (itemInfo.netPrice * itemInfo.vat)/PROCENT;
         runningVATAmount = runningVATAmount + (vatAmount*quantity);
         return vatAmount;

    }

    public double giveMeTotal(){
        return runningTotal;
    }

    /**
     * When the customer have paid
     *
     * @param recivedAmount
     * @param sale
     * @return Reciept information
     */

    public Receipt paid(double recivedAmount, Sale sale){
        this.recivedAmount = recivedAmount;
         calculateChange(recivedAmount);
         new SaleLog().logSale(sale);
         new AccountSystem().bookSale(sale);
         new InventorySystem().uppdateQuantity(sale);
         new CashRegister().updateCashAmount(runningTotal);

        return new Receipt(sale);
    }

    /**
     * Cleaning up the presentation
     * @param roundNumber
     * @return RoundedAmounts
     */

    private double roundToTwoDecimals(double roundNumber){
        return Math.round(roundNumber * NUMBER_OF_DECIMALS) / NUMBER_OF_DECIMALS;
    }

    private void calculateChange(double recivedAmount){
        changeAmount = recivedAmount - runningTotal;
    }






}
