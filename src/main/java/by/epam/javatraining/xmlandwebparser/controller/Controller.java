package by.epam.javatraining.xmlandwebparser.controller;

import by.epam.javatraining.xmlandwebparser.command.Command;
import by.epam.javatraining.xmlandwebparser.command.CommandType;
import by.epam.javatraining.xmlandwebparser.factory.TouristVoucherBuilderFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/mainServlet")
@MultipartConfig
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            handleRequest(request, response);

    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter(CommandType.COMMAND.getValue());
        Command command = TouristVoucherBuilderFactory.getInstance().chooseParseCommand(name);
        String forwardPage = command.execute(request, response);
        request.getRequestDispatcher(forwardPage).forward(request, response);
    }
}
