/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.testAsked;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ws.dtu.entity.CreditCardInfoType;
import ws.dtu.entity.ItineraryEntity;
import ws.dtu.representation.FlightRepresentation;
import ws.dtu.representation.HotelRepresentation;
import ws.dtu.representation.ItineraryRepresentation;
import ws.dtu.representation.Link;
import ws.dtu.representation.StatusRepresentation;
import static ws.dtu.utils.Constants.*;

/**
 *
 * @author souki
 */
public class TestP2 {
    
    public static Client client;
    public static WebResource itineraries;
    public static WebResource login;
    
    CreditCardInfoType creditcard;
    ws.dtu.entity.ExpirationDateType expdate;  
    XMLGregorianCalendar date;

    
    
    @BeforeClass
    public static void setUp(){
        client = Client.create();
        itineraries = client.resource(BASE_ITINERARIES_URI);
        login = client.resource(BASE_LOGIN_URI);
    }
          @Before
    public void create()
    {
     expdate = new ws.dtu.entity.ExpirationDateType();
       expdate.setMonth(5);
       expdate.setYear(9);
       creditcard = new CreditCardInfoType();
       creditcard.setName("Anne Strandberg");
       creditcard.setNumber("50408816");
       creditcard.setExpirationDate(expdate);
       
       DatatypeFactory data;
       try {
            data = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException expdate) {
            return;
        }
        date = data.newXMLGregorianCalendar("2013-12-19");
 
    }
    
    @Before
    public void reset(){
         client.resource(BASE_ITINERARIES_URI + "/reset").put();
    }

    @Test
    public void testP2() {    
   //1- get first flight  
        
        StatusRepresentation iid = login.path("/pepe").put(StatusRepresentation.class);
        Link getFlight1 = iid.getLinkByRelation(GETFLIGHT_RELATION);
        String link1 = String.format("%s?start=%s&destination=%s&date=%s", getFlight1.getUri().toString(),"CPH","MAD","19/12/2013");
        FlightRepresentation listFlight =client.resource(link1).accept(MEDIATYPE_XML).get(FlightRepresentation.class);      
        assertEquals(1,listFlight.getFlight().size());
                     
    //2- add first flight    
        
         Link addFlight1 = listFlight.getLinkByRelation(FLIGHTADD_RELATION);      
        StatusRepresentation responseadd = client.resource(addFlight1.getUri())
                .accept(MEDIATYPE_XML)
                .type(MEDIATYPE_XML)
                .put(StatusRepresentation.class,listFlight.getFlight().get(0));       
        Link getIti = responseadd.getLinkByRelation(ITINERARY_RELATION);
        ItineraryRepresentation iti = client.resource(getIti.getUri()).get(ItineraryRepresentation.class);
                // check if the flight was added to the itinerary
        assertEquals(1,iti.getItinerary().getFlightsList().size());
        assertEquals("unconfirmed",iti.getItinerary().getFlightsList().get(0).getStatus());
                  
  /*      
    //3- cancel the itinerary
   
        Cannot cancel an unbooked itinerary
        
        */
      
}
}