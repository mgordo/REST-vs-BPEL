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
import org.netbeans.xml.schema.hotelschema.Get;
import org.netbeans.xml.schema.hotelschema.Hotellist;
import wsdl.travelgood.GetHotelFault;
import wsdl.travelgood.GetHotelTravelGoodOperationFault;
import wsdl.travelgood.GetHotelRequest;
/**
 *
 * @author souki
 */
public class GetHotelTest {
    
    public GetHotelTest() {
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
    public void getHotelWithHotel() {
        GetHotelRequest hotelRequest = new GetHotelRequest();
        try {
            hotelRequest.setCity("Lorient");
            hotelRequest.setArrivalDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2013, 2, 16, 0));
            hotelRequest.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2013,3,10, 0));
            hotelRequest.setCustomerID("1");
            hotelRequest.setItineraryID("1");
            Hotellist list = getHotelTravelGoodOperation(hotelRequest);
            assertEquals(false,list.getNewElement().isEmpty());
            
        }catch (DatatypeConfigurationException ex) {
            Logger.getLogger(GetHotelTest.class.getName()).log(Level.SEVERE, null, ex);
        }catch (GetHotelTravelGoodOperationFault ex) {
            Logger.getLogger(GetHotelTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void getHotelWithoutHotel() {
        GetHotelRequest hotelRequest = new GetHotelRequest();
        
        try {
            hotelRequest.setCity("Lorient");
            hotelRequest.setArrivalDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2013, 1, 6, 0));
            hotelRequest.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2013,1,10, 0));
            hotelRequest.setCustomerID("1");
            hotelRequest.setItineraryID("1");           
            Hotellist list = getHotelTravelGoodOperation(hotelRequest); 
            assertEquals(true,list.getNewElement().isEmpty());
        }catch (DatatypeConfigurationException ex) {
            Logger.getLogger(GetHotelTest.class.getName()).log(Level.SEVERE, null, ex);
        }catch (GetHotelTravelGoodOperationFault ex) {
            Logger.getLogger(GetHotelTest.class.getName()).log(Level.SEVERE, null, ex);
            assertEquals("No Available Hotels",ex.getFaultInfo().getMessage());
        }
    }

    private static Hotellist getHotelTravelGoodOperation(GetHotelRequest getHotelInput) throws GetHotelTravelGoodOperationFault {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getHotelTravelGoodOperation(getHotelInput);
    }*/
}
