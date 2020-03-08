package by.epam.javatraining.xmlandwebparser.factory;

import by.epam.javatraining.xmlandwebparser.command.Command;
import by.epam.javatraining.xmlandwebparser.command.parsecommand.DomParseCommand;
import by.epam.javatraining.xmlandwebparser.command.parsecommand.ErrorMessageCommand;
import by.epam.javatraining.xmlandwebparser.command.parsecommand.SaxParseCommand;
import by.epam.javatraining.xmlandwebparser.command.parsecommand.StaxParseCommand;
import by.epam.javatraining.xmlandwebparser.service.AbstractTouristVoucherBuilder;
import by.epam.javatraining.xmlandwebparser.service.dom.TouristVouchersDOMBuilder;
import by.epam.javatraining.xmlandwebparser.service.sax.TouristVouchersSAXBuilder;
import by.epam.javatraining.xmlandwebparser.service.stax.TouristVoucherSTAXBuilder;

import javax.servlet.http.HttpServletRequest;

public class TouristVoucherBuilderFactory {

    private static class TouristVoucherBuilderFactoryHolder {
        private static final TouristVoucherBuilderFactory INSTANCE = new TouristVoucherBuilderFactory();
    }

    public Command chooseParseCommand(String builderName) {
        switch (builderName) {
            case "DOM_PARSER":
                return new DomParseCommand();
            case "SAX_PARSER":
                return new SaxParseCommand();
            case "STAX_PARSER":
                return new StaxParseCommand();
            default:
                return new ErrorMessageCommand();
        }
    }
}

