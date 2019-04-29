package se.kth.iv1350.pocesSale.startupp;

import se.kth.iv1350.pocesSale.controller.Controller;
import se.kth.iv1350.pocesSale.integration.IntegrationCreator;
import se.kth.iv1350.pocesSale.integration.Printer;
import se.kth.iv1350.pocesSale.view.View;

/**
 * The class that Inisiates the whole program.
 */

public class Main {

    /**
     * Contains the <code>main</code> method. Performs all startup of the applications
     */

    public static void main(String[] args) {

        IntegrationCreator creator = new IntegrationCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(creator,printer);
        new View(controller).sampleExecution();
    }
}
