package by.epam.javatraining.xmlandwebparser.command.parsecommand;

import by.epam.javatraining.xmlandwebparser.command.Command;
import by.epam.javatraining.xmlandwebparser.command.CommandType;
import by.epam.javatraining.xmlandwebparser.command.PageType;
import by.epam.javatraining.xmlandwebparser.entity.TouristVoucher;
import by.epam.javatraining.xmlandwebparser.service.AbstractTouristVoucherBuilder;
import by.epam.javatraining.xmlandwebparser.service.dom.TouristVouchersDOMBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Set;

public class DomParseCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Part filePart;
        InputStream fileContent;

        try {
            filePart = request.getPart(CommandType.FILE.getValue());
            fileContent = filePart.getInputStream();
            AbstractTouristVoucherBuilder builder = new TouristVouchersDOMBuilder();
            builder.buildSetTouristVouchers(fileContent);
            Set<TouristVoucher> voucherSet = builder.getTouristVoucherSet();
            request.setAttribute("resultSet", voucherSet);
            return PageType.PARSE_RESULT_PAGE.getValue();

        } catch (IOException | ServletException | ParseException e) {
            return PageType.ERROR_PAGE.getValue();
        }
    }
}
