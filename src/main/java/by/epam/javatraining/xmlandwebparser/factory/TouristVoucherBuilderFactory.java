package by.epam.javatraining.xmlandwebparser.factory;

import by.epam.javatraining.xmlandwebparser.command.Command;
import by.epam.javatraining.xmlandwebparser.command.parsecommand.DomParseCommand;
import by.epam.javatraining.xmlandwebparser.command.parsecommand.ErrorMessageCommand;
import by.epam.javatraining.xmlandwebparser.command.parsecommand.SaxParseCommand;
import by.epam.javatraining.xmlandwebparser.command.parsecommand.StaxParseCommand;

public class TouristVoucherBuilderFactory {

    private static class TouristVoucherBuilderFactoryHolder {
        private static final TouristVoucherBuilderFactory INSTANCE = new TouristVoucherBuilderFactory();
    }

    public static TouristVoucherBuilderFactory getInstance() {
        return TouristVoucherBuilderFactoryHolder.INSTANCE;
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

