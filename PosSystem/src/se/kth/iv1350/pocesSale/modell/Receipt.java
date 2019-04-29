package se.kth.iv1350.pocesSale.modell;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Receipt extends Sale {

    private Sale sale;
    private LocalDateTime endSaleTime;
    private DateTimeFormatter formatDateAndTime = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
    private String formattedDateAndTime;


    public Receipt(Sale endSale){
        sale = endSale;
        formattedDateAndTime = endSale.saleTime.format(formatDateAndTime);
        endSaleTime = LocalDateTime.now();
    }

    public double giveMeChange(){
        return Math.round(sale.changeAmount);
    }




    @Override
    public String toString(){
        StringBuilder recieptPresentation = new StringBuilder();
        recieptPresentation.append("--- START OF RECEIPT---\n");
        recieptPresentation.append("" + sale.storeName+ " " + sale.storeAdress+ "\n");
        recieptPresentation.append(formattedDateAndTime+"\n\n");
        recieptPresentation.append(sale.toString());
        recieptPresentation.append("\n--- END OF RECEIPT---");


        return recieptPresentation.toString();

    }
}
