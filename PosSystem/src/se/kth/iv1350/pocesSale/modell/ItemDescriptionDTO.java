package se.kth.iv1350.pocesSale.modell;

public class ItemDescriptionDTO {
    String name;
    int id;
    float vat;
    String description;
    double netPrice;

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
