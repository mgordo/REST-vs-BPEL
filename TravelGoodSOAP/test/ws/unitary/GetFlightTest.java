/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ws.unitary;

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
import wsdl.travelgood.GetFlightRequest;
import wsdl.travelgood.GetFlightTravelGoodOperationFault;

/**
 *
 * @author Alina GHERMAN<alinagherman@hotmail.fr>
 */
public class GetFlightTest {
    
    public GetFlightTest() {
    }
    /*
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
    public void getNoFlight() {
            DatatypeFactory dataFactory=null;
        try {
            dataFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            fail("It should have created a data Factory");
        }
        GetFlightRequest getFlightInput = new GetFlightRequest();
        getFlightInput.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2012, 12, 19, 0));
        getFlightInput.setFlightDestinationPoint("MAD");
        getFlightInput.setFlightStartPoint("CPH");
        getFlightInput.setCustomerID("1");
        getFlightInput.setItineraryID("1");
        FlightList result;
        try {
            result = getFlightTravelGoodOperation(getFlightInput);
        } catch (GetFlightTravelGoodOperationFault ex) {
            Logger.getLogger(GetFlightTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    @Test
    public void getOneFlight() {
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
        getFlightInput.setCustomerID("1");
        getFlightInput.setItineraryID("1");
        FlightList result;
        try {
            result = getFlightTravelGoodOperation(getFlightInput);
        } catch (GetFlightTravelGoodOperationFault ex) {
            Logger.getLogger(GetFlightTest.class.getName()).log(Level.SEVERE, null, ex);
            assertEquals("No available flights",ex.getFaultInfo().getMessage());
        }
    }
    @Test
    public void getMultipleFlights() {
            DatatypeFactory dataFactory=null;
        try {
            dataFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            fail("It should have created a data Factory");
        }
        GetFlightRequest getFlightInput = new GetFlightRequest();
        getFlightInput.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2012, 12, 30, 0));
        getFlightInput.setFlightDestinationPoint("ABC");
        getFlightInput.setFlightStartPoint("DEF");
        getFlightInput.setCustomerID("1");
        getFlightInput.setItineraryID("1");
        FlightList result;
        try {        
            result = getFlightTravelGoodOperation(getFlightInput);

           
            assertEquals(result.getFlightInformation().size(), 2);
            assertEquals(result.getFlightInformation().get(0).getAirline(),"Ryanair");
            assertEquals(result.getFlightInformation().get(0).getBookingNumber(),2);
            assertEquals(result.getFlightInformation().get(0).getPrice(),200);
            assertEquals(result.getFlightInformation().get(0).getFlight().getDestinationAirport(),"ABC");
            assertEquals(result.getFlightInformation().get(0).getFlight().getStartAirport(),"DEF");
        
            assertEquals(result.getFlightInformation().get(1).getAirline(),"Iberia");
            assertEquals(result.getFlightInformation().get(1).getBookingNumber(),3);
            assertEquals(result.getFlightInformation().get(1).getPrice(),200);
            assertEquals(result.getFlightInformation().get(1).getFlight().getDestinationAirport(),"ABC");
            assertEquals(result.getFlightInformation().get(1).getFlight().getStartAirport(),"DEF");
               } catch (GetFlightTravelGoodOperationFault ex) {
            Logger.getLogger(GetFlightTest.class.getName()).log(Level.SEVERE, null, ex);
        }         
        
    }

    private static FlightList getFlightTravelGoodOperation(wsdl.travelgood.GetFlightRequest getFlightInput) throws GetFlightTravelGoodOperationFault {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getFlightTravelGoodOperation(getFlightInput);
    }*/

}
