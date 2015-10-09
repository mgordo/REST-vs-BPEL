package entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author veve
 */
@XmlRootElement(name = "flight")
public class FlightEntity {
    private String startAirport;
    private String destinationAirport;
    private Date dateLiftOf;
    private Date dateLanding;
    private String carrier;
    
    public FlightEntity() {
    }

    public FlightEntity(String startAirport,
            String destinationAirport,
            Date dateLiftOf,
            Date dateLanding,
            String carrier) {
        this.startAirport = startAirport;
        this.destinationAirport = destinationAirport;
        this.dateLiftOf = dateLiftOf;
        this.dateLanding = dateLanding;
        this.carrier = carrier;
    }

    public String getStartAirport() {
        return startAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public Date getDateLiftOf() {
        return dateLiftOf;
    }

    public Date getDateLanding() {
        return dateLanding;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public void setDateLiftOf(Date dateLiftOf) {
        this.dateLiftOf = dateLiftOf;
    }

    public void setDateLanding(Date dateLanding) {
        this.dateLanding = dateLanding;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    
}
