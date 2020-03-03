package by.epam.javatraining.xmlandwebparser.service;

import by.epam.javatraining.xmlandwebparser.entity.TouristVoucher;
import org.apache.log4j.Logger;
import java.text.ParseException;
import java.util.Set;

public class XMLParser {
    private final static Logger logger = Logger.getLogger(XMLParser.class);

    private XMLParser() {
    }

    private static class XMLParserHolder {
        private static final XMLParser INSTANCE = new XMLParser();
    }

    public static XMLParser getInstance() {
        return XMLParserHolder.INSTANCE;
    }

    public Set<TouristVoucher> parseXMLFile(String path, AbstractTouristVoucherBuilder builder) {
        Set<TouristVoucher> touristVouchers = null;

        try {
            builder.buildSetTouristVouchers(path);
            touristVouchers = builder.getTouristVoucherSet();
        } catch (ParseException e) {
            logger.error(e);
        }

        return touristVouchers;
    }
}
