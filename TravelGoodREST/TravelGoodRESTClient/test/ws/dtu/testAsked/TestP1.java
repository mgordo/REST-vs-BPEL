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
import ws.dtu.entity.ExpirationDateType;
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
public class TestP1 {

   public static Client client;
    public static WebResource itineraries;
    public static WebResource login;
    
    CreditCardInfoType creditcard;
    ExpirationDateType expdate; 
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
       expdate = new ExpirationDateType();
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
        date = data.newXMLGregorianCalendarDate(2014, 1, 6, 0);
 
    }
    
    @Before
    public void reset(){
         client.resource(BASE_ITINERARIES_URI + "/reset").put();
    }

    @Test
    public void testP1() {    
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
              
    //3- get first hotel     

             
        Link getHotel1 = iid.getLinkByRelation(GETHOTEL_RELATION);
        String link2 = String.format("%s?arrival=%s&departure=%s&city=%s", getHotel1.getUri().toString(),"15/01/2014","4/11/2014","Lorient");
        HotelRepresentation listHotel =client.resource(link2).accept(MEDIATYPE_XML).get(HotelRepresentation.class);            
        assertEquals(2,listHotel.getHotel().size());
     
     //4- add first hotel    
         
        Link addHotel1 = listHotel.getLinkByRelation(HOTELADD_RELATION);
        responseadd = client.resource(addHotel1.getUri())
                .accept(MEDIATYPE_XML)
                .type(MEDIATYPE_XML)
                .put(StatusRepresentation.class,listHotel.getHotel().get(0));
        
         getIti = responseadd.getLinkByRelation(ITINERARY_RELATION);
         iti = client.resource(getIti.getUri())
                .get(ItineraryRepresentation.class);
            // we check if the flight was added to the itinerary
        assertEquals(1,iti.getItinerary().getHotelList().size());
        assertEquals("unconfirmed",iti.getItinerary().getHotelList().get(0).getStatus());              
      
        // 5- get a second flight
      
        Link getFlight2 = iti.getLinkByRelation(GETFLIGHT_RELATION);       
        String link3 = String.format("%s?start=%s&destination=%s&date=%s", getFlight2.getUri().toString(),"CPH","MAD","19/12/2013");
        listFlight =client.resource(link3).accept(MEDIATYPE_XML).get(FlightRepresentation.class);      
        assertEquals(1,listFlight.getFlight().size());
        
        
         //6- add second flight 
        
         Link addFlight2 = iti.getLinkByRelation(FLIGHTADD_RELATION); 
         
        responseadd = client.resource(addFlight2.getUri())
                .accept(MEDIATYPE_XML)
                .type(MEDIATYPE_XML)
                .put(StatusRepresentation.class,listFlight.getFlight().get(0));       
        getIti = responseadd.getLinkByRelation(ITINERARY_RELATION);
        
        
        iti = client.resource(getIti.getUri()).get(ItineraryRepresentation.class);
                // check if the flight was added to the itinerary
        assertEquals(2,iti.getItinerary().getFlightsList().size()); 
        assertEquals("unconfirmed",iti.getItinerary().getFlightsList().get(1).getStatus());
        
        
     
        // 7- get a third flight
        
        Link getFlight3 = iid.getLinkByRelation(GETFLIGHT_RELATION);       
        String link4 = String.format("%s?start=%s&destination=%s&date=%s", getFlight3.getUri().toString(),"CPH","MAD","19/12/2013");
        FlightRepresentation listFlight3 =client.resource(link4).accept(MEDIATYPE_XML).get(FlightRepresentation.class);      
        assertEquals(1,listFlight3.getFlight().size());
        assertEquals("unconfirmed",iti.getItinerary().getItineraryStatus());
        
        
        
         //8- add a third flight               
        Link addFlight3 = listFlight.getLinkByRelation(FLIGHTADD_RELATION);      
        responseadd = client.resource(addFlight3.getUri())
                .accept(MEDIATYPE_XML)
                .type(MEDIATYPE_XML)
                .put(StatusRepresentation.class,listFlight.getFlight().get(0));       
        getIti = responseadd.getLinkByRelation(ITINERARY_RELATION);
        iti = client.resource(getIti.getUri()).get(ItineraryRepresentation.class);
                // check if the flight was added to the itinerary
        assertEquals(3,iti.getItinerary().getFlightsList().size()); 
        assertEquals("unconfirmed",iti.getItinerary().getFlightsList().get(2).getStatus());
       
               
    //9- get second hotel     

        Link getHotel2 = iid.getLinkByRelation(GETHOTEL_RELATION);
        String link5 = String.format("%s?arrival=%s&departure=%s&city=%s", getHotel2.getUri().toString(),"15/01/2014","4/11/2014","Lorient");
        HotelRepresentation listHotel2 =client.resource(link5).accept(MEDIATYPE_XML).get(HotelRepresentation.class);
       assertEquals(2,listHotel2.getHotel().size());
       
   
     
     //10- add second hotel    
        
        Link addHotel2 = listHotel2.getLinkByRelation(HOTELADD_RELATION);
        responseadd = client.resource(addHotel2.getUri())
                .accept(MEDIATYPE_XML)
                .type(MEDIATYPE_XML)
                .put(StatusRepresentation.class,listHotel2.getHotel().get(0));
        
         getIti = responseadd.getLinkByRelation(ITINERARY_RELATION);
         iti = client.resource(getIti.getUri())
                .get(ItineraryRepresentation.class);
            // we check if the flight was added to the itinerary
        assertEquals(2,iti.getItinerary().getHotelList().size());
        assertEquals("unconfirmed",iti.getItinerary().getHotelList().get(1).getStatus());              
     
        
      //11- book itinerary 
     
       Link bookItinerarylink = iti.getLinkByRelation(BOOKITINERARY_RELATION); 
       StatusRepresentation responseBook = client.resource(bookItinerarylink.getUri())
                .accept(MEDIATYPE_XML)
                .type(MEDIATYPE_XML).
                put(StatusRepresentation.class,creditcard);
         
        
        assertEquals("Booked succesfully!",responseBook.getStatus());
         
                    // verifying that the status changed
        getIti = responseBook.getLinkByRelation(ITINERARY_RELATION);
        iti = client.resource(getIti.getUri()).get(ItineraryRepresentation.class); 
        
        assertEquals(3,iti.getItinerary().getFlightsList().size());
        assertEquals(2,iti.getItinerary().getHotelList().size());
        assertEquals("confirmed",iti.getItinerary().getItineraryStatus());
      
   
        
    }

  }
