package se.kth.iv1350.pocesSale.integration;

/**
 * Thrown when trying to register an item.
 */

public class ItemMissingException extends Exception {

    /**
     * creates a new instance with a message specifying what id was missing.
     *
     * @param id The id that could not be booked.
     */

    public ItemMissingException(int id) {
        super("Felaktigt varuid: "+ id + " - Försök igen");
    }


}
