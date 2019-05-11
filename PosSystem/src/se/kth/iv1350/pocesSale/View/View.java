package se.kth.iv1350.pocesSale.view;

import com.sun.xml.internal.ws.handler.HandlerException;
import se.kth.iv1350.pocesSale.LogHandler.LogHandler;
import se.kth.iv1350.pocesSale.controller.Controller;
import se.kth.iv1350.pocesSale.controller.OperationFailedEceptions;
import se.kth.iv1350.pocesSale.integration.ItemMissingException;
import se.kth.iv1350.pocesSale.integration.ItemRegistry;
import se.kth.iv1350.pocesSale.modell.ItemDescriptionDTO;
import se.kth.iv1350.pocesSale.modell.PaymentObserver;
import se.kth.iv1350.pocesSale.modell.Sale;

import java.io.IOException;

/**
 * Fake GUI, Hardcoded programCalls
 */

public class View {

    private Controller contr;
    private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
    private LogHandler logger;


    /**
     * Creates a new instance
     *
     * @param contr The controller that is used for all operations.
     *
     */

    public View(Controller contr) throws IOException {
        this.contr = contr;
        contr.addPaymentObserver(new TotalRevenueView());
        this.logger = LogHandler.getLogger();
    }

    /**
     * Simulates a user inputs that generates calls to all system operations
     */



    public void sampleExecution() {
        System.out.println("Let's start shopping");
        Sale sale = contr.startSale();


        try {
            Sale itemInfo = contr.registerItem(1, 6);
            contr.registerItem(1, 3);
            contr.registerItem(2, 1);
            contr.registerItem(7, 1);

        }
        catch (ItemMissingException exc){
            errorMessageHandler.showErrorMsg(exc.getMessage());
        }
        catch (OperationFailedEceptions exc){
            errorMessageHandler.showErrorMsg("Databes failed to work");
        }

        try {
            contr.registerItem(99,1);
        }
        catch (OperationFailedEceptions exc){
            handleException("Correct: Databes failed to work",exc);
        }
        catch (ItemMissingException exc){
            handleException("Item not found \n" ,exc);
        }
        System.out.println("Belopp före rabatt: " + contr.giveMeTotal());

        System.out.println("Rabbaterat pris: " + contr.calculateDiscountedPrice());

        System.out.println("\nDetta presenteras på skärmen (pengar tillbaka till kunden): " + contr.pay(400));
        System.out.println("\n\n\nStart a new sale!");

        // test in case a new sale gets paid.

        try {
            contr.startSale();
            contr.registerItem(1,2);
            Sale itemInfo2 = contr.registerItem(1, 3);
            System.out.println("Varukorg efter vara 2 \n" + itemInfo2);
        }
        catch (ItemMissingException exc){
            errorMessageHandler.showErrorMsg(exc.getMessage());
        }
        catch (OperationFailedEceptions exc){
            errorMessageHandler.showErrorMsg("Databes failed to work");
        }

        System.out.println("Belopp före rabatt: " + contr.giveMeTotal());

        System.out.println("Rabbaterat pris: " + contr.calculateDiscountedPrice());

        System.out.println("\nDetta presenteras på skärmen (pengar tillbaka till kunden): " + contr.pay(300));



    }

    private void handleException(String uiMsg, Exception exc) {
        errorMessageHandler.showErrorMsg(uiMsg);
        logger.logException(exc);
    }

}
