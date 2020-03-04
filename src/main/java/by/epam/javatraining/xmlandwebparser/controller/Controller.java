package by.epam.javatraining.xmlandwebparser.controller;

import by.epam.javatraining.xmlandwebparser.service.dom.TouristVouchersDOMBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/mainservlet")
@MultipartConfig
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        TouristVouchersDOMBuilder touristVouchersDOMBuilder = new TouristVouchersDOMBuilder();

    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) {

    }
}
