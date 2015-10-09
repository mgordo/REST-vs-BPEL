package entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author veve
 */
@XmlRootElement(name = "flightInfo")
public class FlightInfoEntity {
    private String bookingNumber;
    private String price;
    private String airline;
    private FlightEntity flight;

    public FlightInfoEntity() {   
        
    }

    public FlightInfoEntity(String bookingNumber,
            String price,
            String airline,
            FlightEntity flight) {
        this.bookingNumber = bookingNumber;
        this.price = price;
        this.airline = airline;
        this.flight = flight;
        
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }
    
}
