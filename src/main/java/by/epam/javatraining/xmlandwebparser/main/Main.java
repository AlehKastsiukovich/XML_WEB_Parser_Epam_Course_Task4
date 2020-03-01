package by.epam.javatraining.xmlandwebparser.main;

import by.epam.javatraining.xmlandwebparser.builder.dom.TouristVouchersDOMBuilder;
import by.epam.javatraining.xmlandwebparser.entity.TouristVoucher;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        TouristVouchersDOMBuilder domBuilder = new TouristVouchersDOMBuilder();
        String path = "D:\\JavaProjects\\XmlAndWebParser\\src\\main\\resources\\touristVouchers.xml";

        try {
            domBuilder.buildSetTouristVouchers(path);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(domBuilder.getTouristVoucherSet());
//        TouristVouchersSAXBuilder touristVouchersSAXBuilder = new TouristVouchersSAXBuilder();
//        touristVouchersSAXBuilder.buildSetTouristVouchers(path);
//
//        System.out.println(touristVouchersSAXBuilder.getTouristVoucherSet());

//        TouristVoucherSTAXBuilder touristVoucherSTAXBuilder = new TouristVoucherSTAXBuilder();
//        touristVoucherSTAXBuilder.buildSetTouristVouchers(path);
//        System.out.println(touristVoucherSTAXBuilder.getTouristVouchers());

    }
}
