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
import org.netbeans.xml.schema.airlineschema.Flight;
import wsdl.travelgood.AddFlightRequest;
import wsdl.travelgood.AddFlightResponse;
import wsdl.travelgood.AddFlightTravelGoodFault;
import wsdl.travelgood.BookItineraryRequest;
import wsdl.travelgood.BookItineraryResponse;
import wsdl.travelgood.BookItineraryTravelGoodFault;
import wsdl.travelgood.CreateItineraryRequest;
import wsdl.travelgood.CreateItineraryResponse;
import wsdl.travelgood.GetItineraryRequest;
import wsdl.travelgood.GetItineraryResponse;
import wsdl.travelgood.ObjectFactory;

/**
 *
 * @author souki
 */
public class BookFlightTest {
    
    public BookFlightTest() {
    }

     @Test
     public void bookEmptyItinerary() {
         CreateItineraryRequest request = new CreateItineraryRequest();
         request.setCustomerID("1127");
         CreateItineraryResponse response= createItineraryTravelGoodOperation(request);
         assertNotNull(request);
         assertFalse(response.getItineraryID().isEmpty());
         System.out.println(response.getItineraryID());
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
            assertEquals(false, responseBook.isBookingConfirmation());
        } catch (BookItineraryTravelGoodFault ex) {
            Logger.getLogger(BookFlightTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     }
    
     @Test
     public void bookItinerary() {
         //create itinerary
         CreateItineraryRequest request = new CreateItineraryRequest();
         request.setCustomerID("1117");
         CreateItineraryResponse response= createItineraryTravelGoodOperation(request);
         assertNotNull(request);
         assertFalse(response.getItineraryID().isEmpty());
         System.out.println(response.getItineraryID());
        
          //addFlight
              DatatypeFactory dataFactory=null;
        try {
            dataFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            fail("It should have created a data Factory");
        }
         Flight f =new Flight();
         f.setStartAirport("CPH");        
         f.setDestinationAirport("MAD");
         f.setCarrier("carrier");
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
            assertTrue(responseAddFlight.isAddFlightConfirmation());
            responseAddFlight = addFlightTravelGoodOperation(requestAddFlight);       
            assertTrue(responseAddFlight.isAddFlightConfirmation());
        } catch (AddFlightTravelGoodFault ex) {
            Logger.getLogger(AddFlightsTest.class.getName()).log(Level.SEVERE, null, ex);
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
            assertEquals(true, responseBook.isBookingConfirmation());
        } catch (BookItineraryTravelGoodFault ex) {
            Logger.getLogger(BookFlightTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

      @Test
     public void bookItinerary2() {
          
         //create itinerary
         CreateItineraryRequest request = new CreateItineraryRequest();
         request.setCustomerID("102027");
         CreateItineraryResponse response= createItineraryTravelGoodOperation(request);
         assertNotNull(request);
         assertFalse(response.getItineraryID().isEmpty());
         System.out.println(response.getItineraryID());
         
         
         //addFlight
              DatatypeFactory dataFactory=null;
        try {
            dataFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            fail("It should have created a data Factory");
        }
         Flight f =new Flight();
         f.setStartAirport("CPH");        
         f.setDestinationAirport("MAD");
         f.setCarrier("carrier");
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
            assertTrue(responseAddFlight.isAddFlightConfirmation());
            responseAddFlight = addFlightTravelGoodOperation(requestAddFlight);       
            assertTrue(responseAddFlight.isAddFlightConfirmation());
        } catch (AddFlightTravelGoodFault ex) {
            Logger.getLogger(AddFlightsTest.class.getName()).log(Level.SEVERE, null, ex);
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
            assertEquals(true, responseBook.isBookingConfirmation());
        } catch (BookItineraryTravelGoodFault ex) {
            Logger.getLogger(BookFlightTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
  
    
     
    private static AddFlightResponse addFlightTravelGoodOperation(wsdl.travelgood.AddFlightRequest addFlightInput) throws AddFlightTravelGoodFault {
        wsdl.travelgood.TravelGoodWsdlService service = new wsdl.travelgood.TravelGoodWsdlService();
        wsdl.travelgood.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addFlightTravelGoodOperation(addFlightInput);
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
