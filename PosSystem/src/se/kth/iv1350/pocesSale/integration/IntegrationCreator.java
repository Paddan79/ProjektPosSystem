package se.kth.iv1350.pocesSale.integration;

import se.kth.iv1350.pocesSale.modell.CashRegister;

/**
 * Class for initiating all other classes in the integrations
 */

public class IntegrationCreator {

    private StoreRegistry storeReg = new StoreRegistry();
    private ItemRegistry itemReg = new ItemRegistry();
    private SaleLog saleLog = new SaleLog();
    private AccountSystem accountSystem = new AccountSystem();
    private InventorySystem inventorySystem = new InventorySystem();
    private CashRegister cashRegister = new CashRegister();

    /**
     * Empty cunstructor
     */

    public IntegrationCreator(){}

    /**
     * Get the value of storeReg
     *
     * @return the value of storeReg
     */

    public StoreRegistry getStoreRegistry(){
        return storeReg;
    }

    /**
     * Get the value of itemRegistry
     *
     * @return the value of itemRegistry
     */

    public ItemRegistry getItemRegistry(){
        return itemReg;
    }

    /**
     * Get the value of saleLog
     *
     * @return the value of saleLog
     */

    public SaleLog getSaleLog(){
        return saleLog;
    }

    /**
     * Get the value of accountSystem
     *
     * @return the value of accountSystem
     */
    public AccountSystem getAccountSystem(){
        return accountSystem;
    }

    /**
     * Get the value of inventorySystem
     *
     * @return the value of inventorySystem
     */
    public InventorySystem getInventorySystem(){
        return inventorySystem;
    }

    /**
     * Get the value of cashRegister
     *
     * @return the value of cashRegister
     */
    public CashRegister getCashRegister(){
        return cashRegister;
    }


}
