package se.kth.iv1350.pocesSale.integration;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import se.kth.iv1350.pocesSale.modell.ItemDescriptionDTO;

/**
 * Database containing all diffrent item that can be sold
 * The data base that later on will be implemented could have been simulated by creating a list, but is now
 * hardcoded itemObjects.
 */

public class ItemRegistry {



    private ItemDescriptionDTO apple = new ItemDescriptionDTO("Äpple",1,25.0f, "grönt",23.00);
    private ItemDescriptionDTO cola = new ItemDescriptionDTO("Cola",2,12.0f, "Flaska 1.5L",30.00);
    private ItemDescriptionDTO snus = new ItemDescriptionDTO("Snus",3,6.0f, "Rund",45.00);


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

        return null;

    }


}
