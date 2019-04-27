package se.kth.iv1350.pocesSale.modell;

public class Item {
    // måste denna inehålla ett id också? ( finns i itemdescription dto)
    private int quantity;

    private ItemDescriptionDTO item;

    public ItemDescriptionDTO getItem(){
        return item;
    }

    public Item(ItemDescriptionDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public String toString(){
        StringBuilder itemPresentation = new StringBuilder();
        itemPresentation.append( item + " Mängd " + quantity);

        return itemPresentation.toString();
    }

    /**
     * Uppdates quantity of existing items in shopingCart.
     *
     * @param quantity
     */

    public void addQuantity(int quantity){
        this.quantity = this.quantity + quantity;
    }

    public int getId(){
        return item.id;
    }


}
