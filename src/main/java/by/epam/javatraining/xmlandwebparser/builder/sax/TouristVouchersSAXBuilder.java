package by.epam.javatraining.xmlandwebparser.builder.sax;

import by.epam.javatraining.xmlandwebparser.builder.AbstractTouristVoucherBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;

public class TouristVouchersSAXBuilder extends AbstractTouristVoucherBuilder {
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

    @Override
    public void buildSetTouristVouchers(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }

        touristVoucherSet = touristVoucherHandler.getTouristVoucherSet();
    }
}
