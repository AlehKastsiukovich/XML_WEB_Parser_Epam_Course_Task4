package by.epam.javatraining.xmlandwebparser.command.parsecommand;

import by.epam.javatraining.xmlandwebparser.command.Command;
import by.epam.javatraining.xmlandwebparser.command.PageType;
import by.epam.javatraining.xmlandwebparser.entity.TouristVoucher;
import by.epam.javatraining.xmlandwebparser.builder.AbstractTouristVoucherBuilder;
import by.epam.javatraining.xmlandwebparser.exception.ServiceException;
import by.epam.javatraining.xmlandwebparser.service.ParserXML;
import by.epam.javatraining.xmlandwebparser.builder.dom.TouristVouchersDOMBuilder;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class DomParseCommand implements Command {
    private static final Logger logger = Logger.getLogger(DomParseCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            AbstractTouristVoucherBuilder builder = new TouristVouchersDOMBuilder();
            Set<TouristVoucher> voucherSet = ParserXML.getInstance().parseXML(request, builder);
            request.setAttribute("resultSet", voucherSet);
            return PageType.PARSE_RESULT_PAGE.getValue();
        } catch (ServiceException e) {
            logger.error(e);
            return PageType.ERROR_PAGE.getValue();
        }
    }
}
