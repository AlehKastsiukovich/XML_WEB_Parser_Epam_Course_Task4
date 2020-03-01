package by.epam.javatraining.xmlandwebparser.factory;

import by.epam.javatraining.xmlandwebparser.builder.AbstractTouristVoucherBuilder;
import by.epam.javatraining.xmlandwebparser.builder.dom.TouristVouchersDOMBuilder;
import by.epam.javatraining.xmlandwebparser.builder.sax.TouristVouchersSAXBuilder;
import by.epam.javatraining.xmlandwebparser.builder.stax.TouristVoucherSTAXBuilder;

public class TouristVoucherBuilderFactory {

    private enum ParserType {
        DOM,
        SAX,
        STAX
    }

    public AbstractTouristVoucherBuilder createTouristVoucherBuilder(String type) {
        ParserType parserType = ParserType.valueOf(type);

        switch (parserType) {
            case DOM:
                return new TouristVouchersDOMBuilder();
            case SAX:
                return new TouristVouchersSAXBuilder();
            case STAX:
                return new TouristVoucherSTAXBuilder();
            default:
                throw new EnumConstantNotPresentException(parserType.getDeclaringClass(), parserType.name());
        }
    }
}
