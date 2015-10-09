/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@XmlRootElement(name = "bookedHotel")
public class BookedHotelEntity {
    
    String status;
    private HotelInfoEntity hotel;

    public BookedHotelEntity() {
    }

    public BookedHotelEntity(String status, HotelInfoEntity flight) {
        this.hotel = flight;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public HotelInfoEntity getHotelInfoEntity(){
        return this.hotel;
    }
    
    public void setHotelInfoEntity(HotelInfoEntity hotel){
        this.hotel = hotel;
    }
}
