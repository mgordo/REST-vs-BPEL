/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.representation;

import javax.xml.bind.annotation.XmlRootElement;
import ws.dtu.entity.ItineraryEntity;

/**
 *
 * @author veve
 */
@XmlRootElement()
public class ItineraryRepresentation extends Representation  {

    private ItineraryEntity itinerary;

    public ItineraryEntity getItinerary() {
        return itinerary;
    }

    public void setItinerary(ItineraryEntity itinerary) {
        this.itinerary = itinerary;
    }
    
}
