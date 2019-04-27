package se.kth.iv1350.pocesSale.startupp;

import se.kth.iv1350.pocesSale.controller.Controller;
import se.kth.iv1350.pocesSale.integration.IntegrationCreator;
import se.kth.iv1350.pocesSale.integration.Printer;
import se.kth.iv1350.pocesSale.view.View;


public class Main {

    public static void main(String[] args) {

        /**
         * Contains the <code>main</code> method. Performs all startup of the applications
         */

        IntegrationCreator creator = new IntegrationCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(creator,printer);
        new View(controller).sampleExecution();



    }
}
