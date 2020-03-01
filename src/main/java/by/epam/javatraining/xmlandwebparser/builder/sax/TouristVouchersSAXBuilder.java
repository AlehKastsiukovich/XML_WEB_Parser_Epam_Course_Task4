package by.epam.javatraining.xmlandwebparser.builder.sax;

import by.epam.javatraining.xmlandwebparser.entity.TouristVoucher;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;
import java.util.Set;

public class TouristVouchersSAXBuilder {
    private Set<TouristVoucher> touristVoucherSet;
    private TouristVoucherHandler touristVoucherHandler;
    private XMLReader reader;

    public TouristVouchersSAXBuilder() {
        touristVoucherHandler = new TouristVoucherHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(touristVoucherHandler);
        } catch (SAXException e) {

        }
    }

    public Set<TouristVoucher> getTouristVoucherSet() {
        return touristVoucherSet;
    }

    public void buildSetTouristVouchers(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        touristVoucherSet = touristVoucherHandler.getTouristVoucherSet();
    }
}
