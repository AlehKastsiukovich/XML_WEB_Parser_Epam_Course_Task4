package by.epam.javatraining.xmlandwebparser.controller;

import by.epam.javatraining.xmlandwebparser.command.CommandType;
import by.epam.javatraining.xmlandwebparser.command.PageType;
import by.epam.javatraining.xmlandwebparser.entity.TouristVoucher;
import by.epam.javatraining.xmlandwebparser.factory.TouristVoucherBuilderFactory;
import by.epam.javatraining.xmlandwebparser.service.AbstractTouristVoucherBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.text.ParseException;
import java.util.Set;

@WebServlet("/mainServlet")
@MultipartConfig
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ParseException {
        Part filePart = request.getPart(FILE);
        InputStream fileContent = filePart.getInputStream();
        String name = request.getParameter(CommandType.COMMAND.getValue());


        TouristVoucherBuilderFactory factory = TouristVoucherBuilderFactory.getInstance();
        AbstractTouristVoucherBuilder builder = factory.createTouristVoucherBuilder(request);
        builder.buildSetTouristVouchers(fileContent);
        Set<TouristVoucher> voucherSet = builder.getTouristVoucherSet();
        request.setAttribute("resultSet", voucherSet);
        request.getRequestDispatcher(PageType.PARSE_RESULT_PAGE.getValue()).forward(request, response);
    }
}
