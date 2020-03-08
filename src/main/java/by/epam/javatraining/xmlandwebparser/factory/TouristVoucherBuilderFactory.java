package by.epam.javatraining.xmlandwebparser.factory;

import by.epam.javatraining.xmlandwebparser.service.AbstractTouristVoucherBuilder;
import by.epam.javatraining.xmlandwebparser.service.dom.TouristVouchersDOMBuilder;
import by.epam.javatraining.xmlandwebparser.service.sax.TouristVouchersSAXBuilder;
import by.epam.javatraining.xmlandwebparser.service.stax.TouristVoucherSTAXBuilder;

import javax.servlet.http.HttpServletRequest;

public class TouristVoucherBuilderFactory {

    private static class TouristVoucherBuilderFactoryHolder {
        private static final TouristVoucherBuilderFactory INSTANCE = new TouristVoucherBuilderFactory();
    }

    public AbstractTouristVoucherBuilder chooseParseCommand(String builderName) {
        switch (builderName) {
            case "DOM_PARSER":
                return new TouristVouchersDOMBuilder();
            case "SAX_PARSER":
                return new TouristVouchersSAXBuilder();
            case "STAX_PARSER":
                return new TouristVoucherSTAXBuilder();

        }
    }
}

