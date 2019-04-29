package se.kth.iv1350.pocesSale.integration;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores name and address
 */

public class StoreRegistry {
    private String name = "Hemsköp";
    private String adress = "Rissnetorg";

    /**
     * Empty constructor
     */
    public StoreRegistry(){


    }

    /**
     * Method to get store name
     * @return Name
     */

    public String getStoreName(){

        return name;
    }

    /**
     * Method to get store address
     * @return Address
     */

    public String getStoreAdress(){
        return adress;
    }






}
