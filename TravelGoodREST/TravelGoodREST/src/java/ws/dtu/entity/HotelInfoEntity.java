/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pierre-Emmanuel
 */


@XmlRootElement(name = "hotel_info")
public class HotelInfoEntity {
    private String hotelName;
    private String hotelAddress;
    private int bookingNumber;
    private double price;
    private boolean creditCardGuarantee;
    private String resServiceName;
    private String hotelLocation;
    private Date arrivalDate;
    private Date departureDate;

    public HotelInfoEntity(){
    }

    public HotelInfoEntity(String hotelName, 
            String hotelAddress, 
            int bookingNumber, 
            double price, 
            boolean creditCardGuarantee, 
            String resServiceName, 
            String hotelLocation,
            Date arrivalDate,
            Date departureDate) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.bookingNumber = bookingNumber;
        this.price = price;
        this.creditCardGuarantee = creditCardGuarantee;
        this.resServiceName = resServiceName;
        this.hotelLocation = hotelLocation;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCreditCardGuarantee() {
        return creditCardGuarantee;
    }

    public void setCreditCardGuarantee(boolean creditCardGuarantee) {
        this.creditCardGuarantee = creditCardGuarantee;
    }

    public String getResServiceName() {
        return resServiceName;
    }

    public void setResServiceName(String resServiceName) {
        this.resServiceName = resServiceName;
    }
    
    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }
    
    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }


}
