package se.kth.iv1350.pocesSale.modell;

/**
 * Contains information about one particular item.
 */

public class ItemDescriptionDTO {
    String name;
    int id;
    float vat;
    String description;
    double netPrice;

    /**
     * Creates a new instance representing a particular car.
     *
     * @param name - Name of the item
     * @param id - Ean code
     * @param vat - Tax rate
     * @param description
     * @param netPrice - Price without tax.
     */

    public ItemDescriptionDTO(String name, int id, float vat, String description, double netPrice){
        this.name = name;
        this.id = id;
        this.vat = vat;
        this.description = description;
        this.netPrice = netPrice;
    }

    /**
     * Converts ItemDTO to presentation format
     *
     */

    @Override
    public String toString(){
        StringBuilder itemPresentation = new StringBuilder();
        itemPresentation.append("Vara " + name);
        itemPresentation.append(" Eankod " + id);
        itemPresentation.append(" Moms " + vat);
        itemPresentation.append(" Beskrivning " + description);
        itemPresentation.append(" Pris " + netPrice);
        return itemPresentation.toString();
    }




}
