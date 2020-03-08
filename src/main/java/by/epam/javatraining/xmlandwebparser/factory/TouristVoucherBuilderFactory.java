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

    public static TouristVoucherBuilderFactory getInstance() {
        return TouristVoucherBuilderFactoryHolder.INSTANCE;
    }

    private enum ParserType {
        DOM("DOM_PARSER"),
        SAX("SAX_PARSER"),
        STAX("STAX_PARSER");

        private String value;

        ParserType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public AbstractTouristVoucherBuilder createTouristVoucherBuilder(HttpServletRequest request) {

        if (request.getParameter(ParserType.DOM.getValue()) != null) {
            return new TouristVouchersDOMBuilder();
        }
        if (request.getParameter(ParserType.SAX.getValue()) != null) {
            return new TouristVouchersSAXBuilder();
        }
        if (request.getParameter(ParserType.STAX.getValue()) != null) {
            return new TouristVoucherSTAXBuilder();
        }

        return null;
    }
}

