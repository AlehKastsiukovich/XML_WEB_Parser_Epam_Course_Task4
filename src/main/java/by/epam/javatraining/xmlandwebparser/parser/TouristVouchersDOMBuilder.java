package by.epam.javatraining.xmlandwebparser.parser;

import by.epam.javatraining.xmlandwebparser.entity.TouristVoucher;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TouristVouchersDOMBuilder {
    private List<TouristVoucher> travelVoucherList;
    private DocumentBuilder documentBuilder;

    public TouristVouchersDOMBuilder() {
        travelVoucherList = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public List<TouristVoucher> getTravelVoucherList() {
        return travelVoucherList;
    }

    public List<TouristVoucher> buildTouristVoucherList(String fileName) {
        Document document = null;

        try {
            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList touristVoucher = root.getElementsByTagName("touristVoucher");

            for (int i = 0; i< touristVoucher.getLength(); i++) {
                Element touristVoucherElement = (Element)touristVoucher.item(i);
                TouristVoucher example = buildTouristVoucher(touristVoucherElement);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TouristVoucher buildTouristVoucher(Element element) {
        TouristVoucher touristVoucher = new TouristVoucher();
        
    }
}
