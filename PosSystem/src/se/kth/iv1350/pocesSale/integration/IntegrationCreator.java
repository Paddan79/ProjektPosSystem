package se.kth.iv1350.pocesSale.integration;

public class IntegrationCreator {

    private StoreRegistry storeReg = new StoreRegistry();
    private ItemRegistry itemReg = new ItemRegistry();

    /**
     * Get the value of storeReg
     *
     * @return the value of storeReg
     */


    public IntegrationCreator(){


    }

    public StoreRegistry getStoreRegistry(){
        return storeReg;
    }

    public ItemRegistry getItemRegistry(){
        return itemReg;
    }

}
