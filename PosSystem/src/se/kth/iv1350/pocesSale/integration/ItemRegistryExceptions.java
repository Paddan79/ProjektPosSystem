package se.kth.iv1350.pocesSale.integration;

import se.kth.iv1350.pocesSale.modell.Item;

/**
 * Thrown when something goes wrong while performing an operation in the <code>itemRegistry</code>.
 */

public class ItemRegistryExceptions extends RuntimeException {

    /**
     * Creates a new instance representing the condition described in the specified message.
     *      *
     * @param msg A message that describes what went wrong.
     */

    public ItemRegistryExceptions(String msg){
        super(msg);
    }

}
