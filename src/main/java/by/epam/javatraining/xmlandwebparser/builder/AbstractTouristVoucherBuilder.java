package by.epam.javatraining.xmlandwebparser.builder;

import by.epam.javatraining.xmlandwebparser.entity.HotelSpecification;
import by.epam.javatraining.xmlandwebparser.entity.TouristVoucher;
import by.epam.javatraining.xmlandwebparser.entity.TransportType;
import by.epam.javatraining.xmlandwebparser.entity.VoucherType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AbstractTouristVoucherBuilder {
    protected Set<TouristVoucher> touristVoucherSet;
    private String id;
    private VoucherType voucherType;
    private String country;
    private Date date;
    private int numberDays;
    private TransportType transportType;
    private HotelSpecification hotelSpecification;
    private BigDecimal price;

    public AbstractTouristVoucherBuilder() {
        touristVoucherSet = new HashSet<>();
    }

    public AbstractTouristVoucherBuilder(Set<TouristVoucher> touristVoucherSet) {
        this.touristVoucherSet = touristVoucherSet;
    }

    public Set<TouristVoucher> getTouristVoucherSet() {
        return touristVoucherSet;
    }

    public AbstractTouristVoucherBuilder buildDate(Date date) {
        this.date = date;
        return this;
    }

    public AbstractTouristVoucherBuilder buildDaysNumber(int numberDays) {
        this.numberDays = numberDays;
        return this;
    }

    public AbstractTouristVoucherBuilder buildCountry(String country) {
        this.country = country;
        return this;
    }

    public AbstractTouristVoucherBuilder buildTransportType(TransportType transportType) {
        this.transportType = transportType;
        return this;
    }

    public AbstractTouristVoucherBuilder buildPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public AbstractTouristVoucherBuilder buildId(String id) {
        this.id = id;
        return this;
    }

    public AbstractTouristVoucherBuilder buildVoucherType(VoucherType voucherType) {
        this.voucherType = voucherType;
        return this;
    }

    public String getId() {
        return id;
    }

    public VoucherType getVoucherType() {
        return voucherType;
    }

    public String getCountry() {
        return country;
    }

    public Date getDate() {
        return date;
    }

    public int getNumberDays() {
        return numberDays;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public HotelSpecification getHotelSpecification() {
        return hotelSpecification;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
