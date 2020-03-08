package by.epam.javatraining.xmlandwebparser.service;

public enum TouristVoucherEnum {
    TOURISTVOUCHERS("touristVouchers"),
    TOURISTVOUCHER("touristVoucher"),
    TYPE("type"),
    COUNTRY("country"),
    STARTDATE("startDate"),
    NUMBERDAYSNIGHTS("numberDaysNights"),
    TRANSPORT("transport"),
    STARS("stars"),
    MEALS("meals"),
    NUMBEROFROOMS("numberOfRooms"),
    AIRCONDITION("airCondition"),
    TV("tv"),
    WIFI("wifi"),
    PARKING("parking"),
    PRICE("price"),
    HOTELSPECIFICATION("hotelSpecification");

    private String value;

    private TouristVoucherEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
