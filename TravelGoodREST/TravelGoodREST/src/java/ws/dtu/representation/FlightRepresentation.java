/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.representation;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import ws.dtu.entity.FlightInfoEntity;

/**
 *
 * @author diego
 */
@XmlRootElement()
public class FlightRepresentation extends Representation  {
    private List<FlightInfoEntity> flights = new ArrayList<FlightInfoEntity>();

    public List<FlightInfoEntity> getFlight() {
        return flights;
    }

    public void setFlight(List<FlightInfoEntity> flights) {
        this.flights=flights;
    }
       
}
