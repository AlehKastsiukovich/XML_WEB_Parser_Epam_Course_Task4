package by.epam.javatraining.xmlandwebparser.parser;

import by.epam.javatraining.xmlandwebparser.entity.TouristVoucher;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Set;

public class TouristVoucherHandler extends DefaultHandler {
    private Set<TouristVoucher> touristVoucherSet;

    public Set<TouristVoucher> getTouristVoucherSet() {
        return touristVoucherSet;
    }
}
