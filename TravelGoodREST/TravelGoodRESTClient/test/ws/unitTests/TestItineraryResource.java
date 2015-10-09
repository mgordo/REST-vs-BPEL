package ws.unitTests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ws.dtu.representation.FlightRepresentation;
import ws.dtu.representation.ItineraryRepresentation;
import ws.dtu.representation.Link;
import ws.dtu.representation.StatusRepresentation;
import static ws.dtu.utils.Constants.*;
/**
 *
 * @author diego
 */
public class TestItineraryResource {
    
    public static Client client;
    public static WebResource itineraries;
    public static WebResource login;
    
    @BeforeClass
    public static void setUp(){
        client = Client.create();
        itineraries = client.resource(BASE_ITINERARIES_URI);
        login = client.resource(BASE_LOGIN_URI);
    }
    
    @Before
    public void reset(){
         client.resource(BASE_ITINERARIES_URI + "/reset").put();
    }

    /*
     * @author diego
     */
    @Test
    public void addFlight(){
        
        StatusRepresentation iid = login.path("/pepe").put(StatusRepresentation.class);
        Link getFlight = iid.getLinkByRelation(GETFLIGHT_RELATION);
        
        String link = String.format("%s?start=%s&destination=%s&date=%s", getFlight.getUri().toString(),"CPH","MAD","19/12/2013");
        FlightRepresentation list =client.resource(link).accept(MEDIATYPE_XML)
                .get(FlightRepresentation.class);
        assertEquals(1,list.getFlight().size());
        
        Link addFlight = list.getLinkByRelation(FLIGHTADD_RELATION);
        
        StatusRepresentation responseadd = client.resource(addFlight.getUri())
                .accept(MEDIATYPE_XML)
                .type(MEDIATYPE_XML)
                .put(StatusRepresentation.class,list.getFlight().get(0));
        
        Link getIti = responseadd.getLinkByRelation(ITINERARY_RELATION);
        ItineraryRepresentation iti = client.resource(getIti.getUri())
                .get(ItineraryRepresentation.class);
        
        assertEquals(1,iti.getItinerary().getFlightsList().size());
        
        
    }
}
