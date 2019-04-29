package se.kth.iv1350.pocesSale.integration;

import se.kth.iv1350.pocesSale.modell.CashRegister;

public class IntegrationCreator {

    private StoreRegistry storeReg = new StoreRegistry();
    private ItemRegistry itemReg = new ItemRegistry();
    private SaleLog saleLog = new SaleLog();
    private AccountSystem accountSystem = new AccountSystem();
    private InventorySystem inventorySystem = new InventorySystem();
    private CashRegister cashRegister = new CashRegister();


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

    public SaleLog getSaleLog(){
        return saleLog;
    }
    public AccountSystem getAccountSystem(){
        return accountSystem;
    }
    public InventorySystem getInventorySystem(){
        return inventorySystem;
    }
    public CashRegister getCashRegister(){
        return cashRegister;
    }


}
