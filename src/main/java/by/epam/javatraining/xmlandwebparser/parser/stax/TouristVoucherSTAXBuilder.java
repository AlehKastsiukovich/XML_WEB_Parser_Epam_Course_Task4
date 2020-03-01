package by.epam.javatraining.xmlandwebparser.parser.stax;

import by.epam.javatraining.xmlandwebparser.entity.*;
import by.epam.javatraining.xmlandwebparser.parser.TouristVoucherEnum;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class TouristVoucherSTAXBuilder {
    private Set<TouristVoucher> touristVouchers = new HashSet<>();
    private XMLInputFactory inputFactory;

    public TouristVoucherSTAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public Set<TouristVoucher> getTouristVouchers() {
        return touristVouchers;
    }

    public void buildSetTouristVouchers(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;

        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (TouristVoucherEnum.valueOf(name.toUpperCase()) == TouristVoucherEnum.TOURISTVOUCHER) {
                        TouristVoucher touristVoucher = buildTouristVoucher(reader);
                        touristVouchers.add(touristVoucher);
                    }
                }
            }
        } catch (FileNotFoundException | ParseException | XMLStreamException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {

            }
        }
    }

    private TouristVoucher buildTouristVoucher(XMLStreamReader reader) throws XMLStreamException, ParseException {
        TouristVoucher touristVoucher = new TouristVoucher();
        touristVoucher.setId(reader.getAttributeValue(null, TouristVoucherEnum.TOURISTVOUCHER.getValue()));

        String name;
        while (reader.hasNext()) {
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TouristVoucherEnum.valueOf(name.toUpperCase())) {
                        case TYPE:
                            touristVoucher.setVoucherType(VoucherType.valueOf(getXMLText(reader)));
                            break;
                        case COUNTRY:
                            touristVoucher.setCountry(getXMLText(reader));
                            break;
                        case STARTDATE:
                            touristVoucher.setDate((new SimpleDateFormat("yyyy-MM-dd").parse(getXMLText(reader))));
                            break;
                        case NUMBERDAYSNIGHTS:
                            touristVoucher.setNumberDays(Integer.parseInt(getXMLText(reader)));
                            break;
                        case TRANSPORT:
                            touristVoucher.setTransportType(TransportType.valueOf(getXMLText(reader)));
                            break;
                        case HOTELSPECIFICATION:
                            touristVoucher.setHotelSpecification(getXMLHotelSpecification(reader));
                            break;
                        case PRICE:
                            touristVoucher.setPrice(new BigDecimal(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TouristVoucherEnum.valueOf(name.toUpperCase()) == TouristVoucherEnum.TOURISTVOUCHER) {
                        return touristVoucher;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag touristVoucher");

    }

    private HotelSpecification getXMLHotelSpecification(XMLStreamReader reader) throws XMLStreamException {
        HotelSpecification hotelSpecification = new HotelSpecification();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TouristVoucherEnum.valueOf(name.toUpperCase())) {
                        case STARS:
                            hotelSpecification.setStarsNumber(Integer.parseInt(getXMLText(reader)));
                            break;
                        case MEALS:
                            hotelSpecification.setMealType(MealType.valueOf(getXMLText(reader)));
                            break;
                        case NUMBEROFROOMS:
                            hotelSpecification.setNumberOfRooms(Integer.parseInt(getXMLText(reader)));
                            break;
                        case AIRCONDITION:
                            hotelSpecification.setAirCondition(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case TV:
                            hotelSpecification.setTv(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case WIFI:
                            hotelSpecification.setWifi(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case PARKING:
                            hotelSpecification.setParking(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TouristVoucherEnum.valueOf(name.toUpperCase()) == TouristVoucherEnum.HOTELSPECIFICATION) {
                        return hotelSpecification;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag HotelSpecification");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }

        return text;
    }
}
