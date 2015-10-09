/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ws;

import test.ws.unitary.GetFlightTest;
import test.ws.unitary.GetHotelTest;
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
import org.netbeans.xml.schema.airlineschema.FlightList;
import org.netbeans.xml.schema.hotelschema.Hotellist;
import wsdl.travelgood.CreateItineraryRequest;
import wsdl.travelgood.CreateItineraryResponse;
import wsdl.travelgood.GetFlightRequest;
import wsdl.travelgood.GetFlightTravelGoodOperationFault;
import wsdl.travelgood.GetHotelRequest;
import wsdl.travelgood.GetHotelTravelGoodOperationFault;

/**
 *
 * @author souki
 */
public class CreateItineraryTest {
    
    public CreateItineraryTest() {
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
     public void createItinerary() {
         CreateItineraryRequest request = new CreateItineraryRequest();
         request.setCustomerID("11");
         CreateItineraryResponse response= createItineraryTravelGoodOperation(request);
         assertNotNull(request);
         assertFalse(response.getItineraryID().isEmpty());
         System.out.println(response.getItineraryID());
     
     }
    
    @Test
     public void createItineraryHotels() {
         CreateItineraryRequest request = new CreateItineraryRequest();
         request.setCustomerID("2");
         CreateItineraryResponse response= createItineraryTravelGoodOperation(request);
         assertNotNull(request);
         assertFalse(response.getItineraryID().isEmpty());
         System.out.println(response.getItineraryID());
         GetHotelRequest hotelRequest = new GetHotelRequest();
        try {
            hotelRequest.setCity("Lorient");
            hotelRequest.setArrivalDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2013, 2, 16, 0));
            hotelRequest.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2013,3,10, 0));
            hotelRequest.setItineraryID(response.getItineraryID());
            Hotellist list = getHotelTravelGoodOperation(hotelRequest);
            assertEquals(false,list.getNewElement().isEmpty());
            
        }catch (DatatypeConfigurationException ex) {
            Logger.getLogger(GetHotelTest.class.getName()).log(Level.SEVERE, null, ex);
        }catch (GetHotelTravelGoodOperationFault ex) {
            Logger.getLogger(GetHotelTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     }
    
     @Test
     public void createItineraryFlight() {
         CreateItineraryRequest request = new CreateItineraryRequest();
         request.setCustomerID("3");
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
        GetFlightRequest getFlightInput = new GetFlightRequest();
        getFlightInput.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2012, 12, 19, 0));
        getFlightInput.setFlightDestinationPoint("MAAD");
        getFlightInput.setFlightStartPoint("CPAH");
        getFlightInput.setItineraryID(response.getItineraryID());
        FlightList result;
        try {
            result = getFlightTravelGoodOperation(getFlightInput);
        } catch (GetFlightTravelGoodOperationFault ex) {
            Logger.getLogger(GetFlightTest.class.getName()).log(Level.SEVERE, null, ex);
            assertEquals("No available flights",ex.getFaultInfo().getMessage());
        }
     
     }
     
     @Test
     public void createItineraryFlightAndHotel() {
         
       //create itinerary
       CreateItineraryRequest request = new CreateItineraryRequest();
       request.setCustomerID("3");
       CreateItineraryResponse response= createItineraryTravelGoodOperation(request);
       assertNotNull(request);
       assertFalse(response.getItineraryID().isEmpty());
       System.out.println(response.getItineraryID());
         
         //get flight
        DatatypeFactory dataFactory=null;
        try {
            dataFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            fail("It should have created a data Factory");
        }
        GetFlightRequest getFlightInput = new GetFlightRequest();
        getFlightInput.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2012, 12, 19, 0));
        getFlightInput.setFlightDestinationPoint("MAAD");
        getFlightInput.setFlightStartPoint("CPAH");
        getFlightInput.setItineraryID(response.getItineraryID());
        FlightList result;
        try {
            result = getFlightTravelGoodOperation(getFlightInput);
        } catch (GetFlightTravelGoodOperationFault ex) {
            Logger.getLogger(GetFlightTest.class.getName()).log(Level.SEVERE, null, ex);
            assertEquals("No available flights",ex.getFaultInfo().getMessage());
        }
                 
        
        
        //get hotel
        GetHotelRequest hotelRequest = new GetHotelRequest();
        try {
            hotelRequest.setCity("Lorient");
            hotelRequest.setArrivalDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2013, 2, 16, 0));
            hotelRequest.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2013,3,10, 0));          
            hotelRequest.setItineraryID(response.getItineraryID());
            Hotellist list = getHotelTravelGoodOperation(hotelRequest);
            assertEquals(false,list.getNewElement().isEmpty());
            
        }catch (DatatypeConfigurationException ex) {
            Logger.getLogger(GetHotelTest.class.getName()).log(Level.SEVERE, null, ex);
        }catch (GetHotelTravelGoodOperationFault ex) {
            Logger.getLogger(GetHotelTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     }
    private static CreateItineraryResponse createItineraryTravelGoodOperation(wsdl.travelgood.CreateItineraryRequest input3) {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.createItineraryTravelGoodOperation(input3);
    }
       private static Hotellist getHotelTravelGoodOperation(GetHotelRequest getHotelInput) throws GetHotelTravelGoodOperationFault {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getHotelTravelGoodOperation(getHotelInput);
    }
       
     private static FlightList getFlightTravelGoodOperation(wsdl.travelgood.GetFlightRequest getFlightInput) throws GetFlightTravelGoodOperationFault {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getFlightTravelGoodOperation(getFlightInput);
    }
}
