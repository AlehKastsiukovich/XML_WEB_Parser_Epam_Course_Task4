package by.epam.javatraining.xmlandwebparser.service;

import by.epam.javatraining.xmlandwebparser.command.CommandType;
import by.epam.javatraining.xmlandwebparser.entity.TouristVoucher;
import by.epam.javatraining.xmlandwebparser.validator.XSDValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Set;

public class ParserXML {

    private static class ParserXMLHolder {
        private static final ParserXML INSTANCE = new ParserXML();
    }

    public static ParserXML getInstance() {
        return ParserXMLHolder.INSTANCE;
    }

    public Set<TouristVoucher> parseXML(HttpServletRequest request, AbstractTouristVoucherBuilder builder) throws IOException, ServletException, ParseException {
        XSDValidator xsdValidator = XSDValidator.getInstance();
        xsdValidator.validateXMLSchema(request);
        Part filePart = request.getPart(CommandType.FILE.getValue());
        InputStream fileContent = filePart.getInputStream();
        builder.buildSetTouristVouchers(fileContent);

        return builder.getTouristVoucherSet();
    }
}
