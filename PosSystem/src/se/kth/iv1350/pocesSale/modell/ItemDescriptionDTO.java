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




}
