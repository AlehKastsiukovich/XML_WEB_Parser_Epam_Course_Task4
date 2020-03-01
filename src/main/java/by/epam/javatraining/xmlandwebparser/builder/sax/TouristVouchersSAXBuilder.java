package by.epam.javatraining.xmlandwebparser.builder.sax;

import by.epam.javatraining.xmlandwebparser.builder.AbstractTouristVoucherBuilder;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;

public class TouristVouchersSAXBuilder extends AbstractTouristVoucherBuilder {
    private static final Logger logger = Logger.getLogger(TouristVouchersSAXBuilder.class);
    private TouristVoucherHandler touristVoucherHandler;
    private XMLReader reader;

    public TouristVouchersSAXBuilder() {
        touristVoucherHandler = new TouristVoucherHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(touristVoucherHandler);
        } catch (SAXException e) {
            logger.error(e);
        }
    }

    @Override
    public void buildSetTouristVouchers(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException | SAXException e) {
            logger.error(e);
        }

        touristVoucherSet = touristVoucherHandler.getTouristVoucherSet();
    }
}
