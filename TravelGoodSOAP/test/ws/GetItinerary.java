/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ws;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.netbeans.xml.schema.airlineschema.Flight;
import wsdl.travelgood.AddFlightRequest;
import wsdl.travelgood.AddFlightResponse;
import wsdl.travelgood.AddFlightTravelGoodFault;
import wsdl.travelgood.CreateItineraryRequest;
import wsdl.travelgood.CreateItineraryResponse;
import wsdl.travelgood.GetItineraryRequest;
import wsdl.travelgood.GetItineraryResponse;

/**
 *
 * @author souki
 */
public class GetItinerary {
    
    public GetItinerary() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
 
    @Test
    public void getEmptyItinerary(){
         CreateItineraryRequest request = new CreateItineraryRequest();
         request.setCustomerID("1956156");
         CreateItineraryResponse response= createItineraryTravelGoodOperation(request);
         assertNotNull(request);
         assertFalse(response.getItineraryID().isEmpty());
         System.out.println(response.getItineraryID());       
         GetItineraryRequest requestItinerary = new GetItineraryRequest();
         requestItinerary.setItineraryID(response.getItineraryID());
        
         GetItineraryResponse responseItinerary = getItineraryOperation(requestItinerary);
         assertNotNull(responseItinerary);
 
    }
    
   @Test
     public void getItinerary() {
         //create itinerary
         CreateItineraryRequest request = new CreateItineraryRequest();
         request.setCustomerID("5696");
         CreateItineraryResponse response= createItineraryTravelGoodOperation(request);
         assertNotNull(request);
         assertFalse(response.getItineraryID().isEmpty());
         System.out.println(response.getItineraryID());
        
         
         
                DatatypeFactory dataFactory=null;
        try {
            dataFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            fail("It should have created a data Factory");
        }
         Flight f =new Flight();
         f.setStartAirport("Charles de gaulle etoile");        
         f.setDestinationAirport("Madrid airport");
         f.setCarrier(null);
         f.setLandingDate(dataFactory.newXMLGregorianCalendarDate(2012, 12, 19, 0));
         f.setLandingTimetim(dataFactory.newXMLGregorianCalendarTime(3, 20, 02, 0));
         f.setLiftOffDate(dataFactory.newXMLGregorianCalendarDate(2012, 12, 19, 0));
         f.setLiftOffTime(dataFactory.newXMLGregorianCalendarTime(3, 20, 02, 0));
        
         AddFlightRequest.FlightInfo flightInfo=new AddFlightRequest.FlightInfo();
         flightInfo.setBookingNumber(1);
         flightInfo.setFlight(f);
         flightInfo.setPrice(100);
         flightInfo.setAirline("easyjet");
         AddFlightRequest requestAddFlight = new AddFlightRequest();
         requestAddFlight.setItineraryID(response.getItineraryID()); 
         requestAddFlight.setFlightInfo(flightInfo);
         AddFlightResponse responseAddFlight;
        try {
            responseAddFlight = addFlightTravelGoodOperation(requestAddFlight);
            assertNotNull(responseAddFlight);
            assertTrue(responseAddFlight.isAddFlightConfirmation());
        } catch (AddFlightTravelGoodFault ex) {
            Logger.getLogger(AddFlightsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            responseAddFlight = addFlightTravelGoodOperation(requestAddFlight);
            assertNotNull(responseAddFlight);
            assertTrue(responseAddFlight.isAddFlightConfirmation());
            
            GetItineraryRequest requestItinerary = new GetItineraryRequest();
            requestItinerary.setItineraryID(response.getItineraryID());
        
            GetItineraryResponse responseItinerary = getItineraryOperation(requestItinerary);
            assertNotNull(responseItinerary);
            assertEquals(2,responseItinerary.getItinerary().getFlightList().size());
         
        } catch (AddFlightTravelGoodFault ex) {
            Logger.getLogger(AddFlightsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
          
       
     }

    private static AddFlightResponse addFlightTravelGoodOperation(wsdl.travelgood.AddFlightRequest addFlightInput) throws AddFlightTravelGoodFault {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addFlightTravelGoodOperation(addFlightInput);
    }

    private static GetItineraryResponse getItineraryOperation(wsdl.travelgood.GetItineraryRequest getItineraryInput) {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getItineraryOperation(getItineraryInput);
    }

    private static CreateItineraryResponse createItineraryTravelGoodOperation(wsdl.travelgood.CreateItineraryRequest createItineraryInput) {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.createItineraryTravelGoodOperation(createItineraryInput);
    }

}
