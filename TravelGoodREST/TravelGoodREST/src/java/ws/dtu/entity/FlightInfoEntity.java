package ws.dtu.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author veve
 */
@XmlRootElement(name = "flight_info")
public class FlightInfoEntity {
    private int bookingNumber;
    private int price;
    private String airline;
    private FlightEntity flight;
    
    public FlightInfoEntity() {   
        
    }

    public FlightInfoEntity(int bookingNumber,
            int price,
            String airline,
            FlightEntity flight) {
        this.bookingNumber = bookingNumber;
        this.price = price;
        this.airline = airline;
        this.flight = flight;
    }


    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
