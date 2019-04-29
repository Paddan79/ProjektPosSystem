package se.kth.iv1350.pocesSale.view;

import se.kth.iv1350.pocesSale.controller.Controller;
import se.kth.iv1350.pocesSale.modell.ItemDescriptionDTO;
import se.kth.iv1350.pocesSale.modell.Sale;

/**
 * Fake GUI, Hardcoded programCalls
 */

public class View {

    private Controller contr;

    /**
     * Creates a new instance
     *
     * @param contr The controller taht is used for all operations.
     *
     */

    public View(Controller contr){
        this.contr = contr;
    }

    /**
     * Simulates a user inputs that generates calls to all system operations
     */



    public void sampleExecution() {
        System.out.println("Let's start shopping");
        Sale sale = contr.startSale();
        System.out.println(sale);

        Sale itemInfo = contr.registerItem(1,6);
        System.out.println( "Varukog efter vara 1 \n" +itemInfo);
        contr.registerItem(1,3);
        System.out.println("Varukorg efter vara 2 \n"+itemInfo);
        contr.registerItem(2,1);
        System.out.println( "Varukorg efter vara 3 \n"+itemInfo);

        System.out.println(contr.giveMeTotal());

        System.out.println("\nDetta presenteras på skärmen (pengar tillbaka till kunden): " + contr.pay(400));
        System.out.println("Start a new sale!");
    }
}
