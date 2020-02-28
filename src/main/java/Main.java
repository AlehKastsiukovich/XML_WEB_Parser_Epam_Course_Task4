import by.epam.javatraining.xmlandwebparser.entity.TouristVoucher;
import by.epam.javatraining.xmlandwebparser.parser.TouristVouchersDOMBuilder;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        TouristVouchersDOMBuilder domBuilder = new TouristVouchersDOMBuilder();
        String path = "D:\\JavaProjects\\XmlAndWebParser\\src\\main\\resources\\touristVouchers.xml";
        try {
            domBuilder.buildTouristVoucherList(path);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (TouristVoucher voucher: domBuilder.getTravelVoucherList()) {
            System.out.println(voucher);
        }
    }
}
