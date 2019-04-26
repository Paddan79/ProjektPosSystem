package se.kth.iv1350.pocesSale.integration;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import se.kth.iv1350.pocesSale.modell.ItemDescriptionDTO;

public class ItemRegistry {
    ItemDescriptionDTO apple = new ItemDescriptionDTO("Äpple",1,12.5f, "grönt",23.00);
    ItemDescriptionDTO cola = new ItemDescriptionDTO("Cola",2,12.5f, "Flaska 1.5L",23.00);
    ItemDescriptionDTO snus = new ItemDescriptionDTO("Snus",3,12.5f, "Rund",23.00);
    ItemDescriptionDTO inget = new ItemDescriptionDTO()

    public ItemRegistry(){

    }

    public ItemDescriptionDTO getItem(int id) throws ExceptionHasMessage {
        if(id == 1){
            return apple;
        }

        if(id == 2){
            return cola;
        }
        if(id == 3){
            return snus;
        }

        return

    }


}
