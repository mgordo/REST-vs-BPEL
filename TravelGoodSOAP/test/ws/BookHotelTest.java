/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ws;

import dk.dtu.imm.fastmoney.types.CreditCardInfoType;
import dk.dtu.imm.fastmoney.types.ExpirationDateType;
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
import wsdl.travelgood.AddHotelRequest;
import wsdl.travelgood.AddHotelResponse;
import wsdl.travelgood.AddHotelTravelGoodFault;
import wsdl.travelgood.BookItineraryRequest;
import wsdl.travelgood.BookItineraryResponse;
import wsdl.travelgood.BookItineraryTravelGoodFault;
import wsdl.travelgood.CreateItineraryRequest;
import wsdl.travelgood.CreateItineraryResponse;
import wsdl.travelgood.GetItineraryResponse;

/**
 *
 * @author souki
 */
public class BookHotelTest {
    
    public BookHotelTest() {
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
     public void bookItinerary() {
         //create itinerary
         CreateItineraryRequest request = new CreateItineraryRequest();
         request.setCustomerID("1257");
         CreateItineraryResponse response= createItineraryTravelGoodOperation(request);
         assertNotNull(request);
         assertFalse(response.getItineraryID().isEmpty());
         System.out.println(response.getItineraryID());
        
         //addHotel
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
          
         //create book element
         BookItineraryRequest requestBook = new BookItineraryRequest();
         requestBook.setItineraryID(response.getItineraryID());
         CreditCardInfoType card =  new CreditCardInfoType();        
         
          card.setName("Tick Joachim");
          card.setNumber("50408824");
          ExpirationDateType edate = new ExpirationDateType();
          edate.setMonth(2);
          edate.setYear(11);
          card.setExpirationDate(edate);
          requestBook.setCreditCardInformation(card);
          BookItineraryResponse responseBook;
        try {
            responseBook = bookItineraryTravelGoodOperation(requestBook);
        } catch (BookItineraryTravelGoodFault ex) {
            Logger.getLogger(BookHotelTest.class.getName()).log(Level.SEVERE, null, ex);
            assertEquals("itinerary could not be booked", ex.getFaultInfo().getMessage());
        }
     }

    private static AddHotelResponse addHotelTravelGoodlOperation(wsdl.travelgood.AddHotelRequest addHotelInput) throws AddHotelTravelGoodFault {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addHotelTravelGoodlOperation(addHotelInput);
    }

    private static BookItineraryResponse bookItineraryTravelGoodOperation(wsdl.travelgood.BookItineraryRequest bookItineraryInput) throws BookItineraryTravelGoodFault {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.bookItineraryTravelGoodOperation(bookItineraryInput);
    }

    private static CreateItineraryResponse createItineraryTravelGoodOperation(wsdl.travelgood.CreateItineraryRequest createItineraryInput) {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.createItineraryTravelGoodOperation(createItineraryInput);
    }

    private static GetItineraryResponse getItineraryOperation(wsdl.travelgood.GetItineraryRequest getItineraryInput) {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getItineraryOperation(getItineraryInput);
    }
}
