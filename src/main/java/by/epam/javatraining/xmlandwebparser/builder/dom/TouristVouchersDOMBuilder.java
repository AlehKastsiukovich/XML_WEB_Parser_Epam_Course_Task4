package by.epam.javatraining.xmlandwebparser.builder.dom;

import by.epam.javatraining.xmlandwebparser.builder.AbstractTouristVoucherBuilder;
import by.epam.javatraining.xmlandwebparser.entity.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TouristVouchersDOMBuilder extends AbstractTouristVoucherBuilder {
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

    public void buildTouristVoucherList(String fileName) throws ParseException {
        Document document = null;

        try {
            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList touristVoucher = root.getElementsByTagName("touristVoucher");

            for (int i = 0; i < touristVoucher.getLength(); i++) {
                Element touristVoucherElement = (Element) touristVoucher.item(i);
                TouristVoucher example = buildTouristVoucher(touristVoucherElement);
                travelVoucherList.add(example);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TouristVoucher buildTouristVoucher(Element element) throws ParseException {
        TouristVoucher touristVoucher = new TouristVoucher();
        touristVoucher.setId(element.getAttribute("id"));
        touristVoucher.setVoucherType(VoucherType.valueOf(getElementTextContent(element, "type")));
        touristVoucher.setCountry(getElementTextContent(element, "country"));
        touristVoucher.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(getElementTextContent(element, "startDate")));
        touristVoucher.setNumberDays(Integer.parseInt(getElementTextContent(element, "numberDaysNights")));
        touristVoucher.setTransportType(TransportType.valueOf(getElementTextContent(element, "transport")));
        HotelSpecification hotelSpecification = new HotelSpecification();
        hotelSpecification.setStarsNumber(Integer.parseInt(getElementTextContent(element, "stars")));
        hotelSpecification.setMealType(MealType.valueOf(getElementTextContent(element, "meals")));
        hotelSpecification.setNumberOfRooms(Integer.parseInt(getElementTextContent(element, "numberOfRooms")));
        hotelSpecification.setAirCondition(Boolean.parseBoolean(getElementTextContent(element, "airCondition")));
        hotelSpecification.setTv(Boolean.parseBoolean(getElementTextContent(element, "tv")));
        hotelSpecification.setWifi(Boolean.parseBoolean(getElementTextContent(element, "wifi")));
        hotelSpecification.setParking(Boolean.parseBoolean(getElementTextContent(element, "parking")));
        touristVoucher.setHotelSpecification(hotelSpecification);
        touristVoucher.setPrice(new BigDecimal(getElementTextContent(element, "price")));

        return touristVoucher;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
