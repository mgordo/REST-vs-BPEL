/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import ws.dtu.utils.Constants;

/**
 *
 * @author miguel
 */
@XmlRootElement(name = "itinerary")
public class ItineraryEntity {
    
    private List<BookedFlightEntity> flightsList;
    private List<BookedHotelEntity> hotelList;
    private String itinerarystatus;
    private Date firstDate;

    public ItineraryEntity(){
        flightsList = new ArrayList<BookedFlightEntity>();
        hotelList = new ArrayList<BookedHotelEntity>();
        itinerarystatus = Constants.STATUS_UNCONFIRMED;
        firstDate = null;
    }

    public List<BookedFlightEntity> getFlightsList() {
        return flightsList;
    }

    public void setFlightsList(List<BookedFlightEntity> flightsList) {
        this.flightsList = flightsList;
    }

    public String getItineraryStatus() {
        return itinerarystatus;
    }

    public void setItineraryStatus(String status) {
        this.itinerarystatus = status;
    }
    
    public List<BookedHotelEntity> getHotelList() {
        return this.hotelList;
    }

    public void setHotelList(List<BookedHotelEntity> hotelList) {
        this.hotelList = hotelList;
    }
    
     public Date getFirstDate() {
        return this.firstDate;
    }

    public void setFirstDate(Date date) {
        this.firstDate = date;
    }
}
