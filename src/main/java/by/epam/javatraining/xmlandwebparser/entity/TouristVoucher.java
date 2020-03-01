package by.epam.javatraining.xmlandwebparser.entity;

import by.epam.javatraining.xmlandwebparser.builder.AbstractTouristVoucherBuilder;
import java.math.BigDecimal;
import java.util.Date;

public class TouristVoucher {
    private String id;
    private VoucherType voucherType;
    private String country;
    private Date date;
    private int numberDays;
    private TransportType transportType;
    private HotelSpecification hotelSpecification;
    private BigDecimal price;

    public TouristVoucher(AbstractTouristVoucherBuilder builder) {
        this.id = builder.getId();
        this.voucherType = builder.getVoucherType();
        this.country = builder.getCountry();
        this.date = builder.getDate();
        this.numberDays = builder.getNumberDays();
        this.transportType = builder.getTransportType();
        this.hotelSpecification = builder.getHotelSpecification();
        this.price = builder.getPrice();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VoucherType getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(VoucherType voucherType) {
        this.voucherType = voucherType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberDays() {
        return numberDays;
    }

    public void setNumberDays(int numberDays) {
        this.numberDays = numberDays;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public HotelSpecification getHotelSpecification() {
        return hotelSpecification;
    }

    public void setHotelSpecification(HotelSpecification hotelSpecification) {
        this.hotelSpecification = hotelSpecification;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TouristVoucher{" +
                "id=" + id +
                ", voucherType=" + voucherType +
                ", country='" + country + '\'' +
                ", date=" + date +
                ", numberDays=" + numberDays +
                ", transportType=" + transportType +
                ", hotelSpecification=" + hotelSpecification +
                ", price=" + price +
                '}';
    }
}
