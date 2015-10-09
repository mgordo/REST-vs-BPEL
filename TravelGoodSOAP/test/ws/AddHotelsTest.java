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
import org.netbeans.xml.schema.hotelschema.Hotel;
import wsdl.travelgood.AddFlightRequest;
import wsdl.travelgood.AddHotelRequest;
import wsdl.travelgood.AddHotelResponse;
import wsdl.travelgood.AddHotelTravelGoodFault;
import wsdl.travelgood.CreateItineraryRequest;
import wsdl.travelgood.CreateItineraryResponse;

/**
 *
 * @author souki
 */
public class AddHotelsTest {
    
    public AddHotelsTest() {
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
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
   public void addHotels() {
         CreateItineraryRequest request = new CreateItineraryRequest();
         request.setCustomerID("121230");
         CreateItineraryResponse response= createItineraryTravelGoodOperation(request); 
          DatatypeFactory dataFactory=null;
        try {
            dataFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            fail("It should have created a data Factory");
        }
         Hotel h = new Hotel();
         h.setAddress("somewhere over the rainbow");
         h.setBooknumber(1);
         h.setCity("CPH");
         h.setEndperiod(dataFactory.newXMLGregorianCalendarDate(2012, 12, 19, 0));
         h.setGuarantee(true);
         h.setName("four seasons");
         h.setPrice(200);
         h.setReservationService("best one");
         h.setStartperiod(dataFactory.newXMLGregorianCalendarDate(2012, 12, 19, 0));
         
         
         AddHotelRequest requestAddHotels = new AddHotelRequest();
         requestAddHotels.setItineraryID(response.getItineraryID());
         requestAddHotels.setHotelInfo(h);
         AddHotelResponse responseAddHotel;
        try {
            responseAddHotel=addHotelTravelGoodlOperation(requestAddHotels);
            assertNotNull(responseAddHotel);
            assertTrue(responseAddHotel.isAddHotelConfirmation());
        } catch (AddHotelTravelGoodFault ex) {
            Logger.getLogger(AddHotelsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
}
        @Test
    public void addTwoHotels() {
         CreateItineraryRequest request = new CreateItineraryRequest();
         request.setCustomerID("145555230");
         CreateItineraryResponse response= createItineraryTravelGoodOperation(request);  
                   DatatypeFactory dataFactory=null;
        try {
            dataFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            fail("It should have created a data Factory");
        }
         Hotel h = new Hotel();
         h.setAddress("somewhere over the rainbow");
         h.setBooknumber(1);
         h.setCity("CPH");
         h.setEndperiod(dataFactory.newXMLGregorianCalendarDate(2012, 12, 19, 0));
         h.setGuarantee(true);
         h.setName("four seasons");
         h.setPrice(200);
         h.setReservationService("best one");
         h.setStartperiod(dataFactory.newXMLGregorianCalendarDate(2012, 12, 19, 0));     

         AddHotelRequest requestAddHotels = new AddHotelRequest();
         requestAddHotels.setItineraryID(response.getItineraryID());
         requestAddHotels.setHotelInfo(h);
         AddHotelResponse responseAddHotel;

        try {
            responseAddHotel=addHotelTravelGoodlOperation(requestAddHotels);
            assertNotNull(responseAddHotel);
            assertTrue(responseAddHotel.isAddHotelConfirmation());
            responseAddHotel=addHotelTravelGoodlOperation(requestAddHotels);
            assertNotNull(responseAddHotel);
            assertTrue(responseAddHotel.isAddHotelConfirmation());

       } catch (AddHotelTravelGoodFault ex) {
            Logger.getLogger(AddHotelsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    private static CreateItineraryResponse createItineraryTravelGoodOperation(wsdl.travelgood.CreateItineraryRequest createItineraryInput) {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.createItineraryTravelGoodOperation(createItineraryInput);
    }

    private static AddHotelResponse addHotelTravelGoodlOperation(wsdl.travelgood.AddHotelRequest addHotelInput) throws AddHotelTravelGoodFault {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addHotelTravelGoodlOperation(addHotelInput);
    }


}
