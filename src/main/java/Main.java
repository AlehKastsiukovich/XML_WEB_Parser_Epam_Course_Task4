import by.epam.javatraining.xmlandwebparser.parser.dom.TouristVouchersDOMBuilder;
import by.epam.javatraining.xmlandwebparser.parser.sax.TouristVouchersSAXBuilder;
import by.epam.javatraining.xmlandwebparser.parser.stax.TouristVoucherSTAXBuilder;

public class Main {

    public static void main(String[] args) {
        TouristVouchersDOMBuilder domBuilder = new TouristVouchersDOMBuilder();
        String path = "D:\\JavaProjects\\XmlAndWebParser\\src\\main\\resources\\touristVouchers.xml";
//        try {
//            domBuilder.buildTouristVoucherList(path);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        for (TouristVoucher voucher: domBuilder.getTravelVoucherList()) {
//            System.out.println(voucher);
//        }

//        TouristVouchersSAXBuilder touristVouchersSAXBuilder = new TouristVouchersSAXBuilder();
//        touristVouchersSAXBuilder.buildSetTouristVouchers(path);
//
//        System.out.println(touristVouchersSAXBuilder.getTouristVoucherSet());

        TouristVoucherSTAXBuilder touristVoucherSTAXBuilder = new TouristVoucherSTAXBuilder();
        touristVoucherSTAXBuilder.buildSetTouristVouchers(path);
        System.out.println(touristVoucherSTAXBuilder.getTouristVouchers());

    }
}
