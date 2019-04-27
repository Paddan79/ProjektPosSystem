package se.kth.iv1350.pocesSale.modell;
import se.kth.iv1350.pocesSale.integration.StoreRegistry;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Collects all information regarding a particular sale
 */

public class Sale {

    LocalDateTime saleTime;
    private String storeName;
    private String storeAdress;
    private List<Item> shopingCart = new ArrayList<Item>();
    private double vatAmount;
    private double runningVATAmount;
    private double runningTotal;



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
    @Override
    public String toString(){
        StringBuilder shopingCartPresentaion = new StringBuilder();
        for (Item scp: shopingCart ) {
            shopingCartPresentaion.append(scp.toString()+ "\n");
        }
            shopingCartPresentaion.append("Total skatt hittills " + runningVATAmount + "\n");
            shopingCartPresentaion.append("Totalt belopp hittills " + runningTotal + "\n");


        return shopingCartPresentaion.toString();
    }

    public void addToList(ItemDescriptionDTO itemInfo, int quantity){
        Item itemCreate = new Item( itemInfo , quantity);
        shopingCart.add(itemCreate);
    }

    /**
     * Calculates runningTotal when adding an item
     *
     * @param itemInfo
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
        vatAmount = (itemInfo.netPrice * itemInfo.vat)/100;
         runningVATAmount = runningVATAmount + (vatAmount*quantity);
         return vatAmount;

    }

    public double giveMeTotal(){
        return runningTotal;
    }


}
