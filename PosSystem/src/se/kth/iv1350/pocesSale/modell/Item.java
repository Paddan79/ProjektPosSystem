package se.kth.iv1350.pocesSale.modell;

/**
 * Contains The information for a whole item.
 */

public class Item {

    private int quantity;

    private ItemDescriptionDTO item;



    /**
     * Cunstructor for item
     *
     * @param item
     * @param quantity
     */

    public Item(ItemDescriptionDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * String representive
     *
     * @return item information as a string
     */

    public String toString(){
        StringBuilder itemPresentation = new StringBuilder();
        itemPresentation.append( item + " Mängd " + quantity);

        return itemPresentation.toString();
    }

    /**
     * Give the item info back.
     * @return item - itemDescriptionDTO
     */

    public ItemDescriptionDTO getItem(){
        return item;
    }

    /**
     * Uppdates quantity of existing items in shopingCart.
     *
     * @param quantity
     */

    public void addQuantity(int quantity){
        this.quantity = this.quantity + quantity;
    }

    /**
     * Give id for an item
     * @return
     */

    public int getId(){
        return item.id;
    }


}
