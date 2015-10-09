/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@XmlRootElement(name = "bookedFlight")
public class BookedFlightEntity {
    
    String status;
    FlightInfoEntity flight;

    public BookedFlightEntity() {
    }

    public BookedFlightEntity(String status, FlightInfoEntity flight) {
        this.flight = flight;
        this.status = status;
    }

    public FlightInfoEntity getFlightInformation() {
        return flight;
    }

    public void setFlightInformation(FlightInfoEntity flight) {
        this.flight = flight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
