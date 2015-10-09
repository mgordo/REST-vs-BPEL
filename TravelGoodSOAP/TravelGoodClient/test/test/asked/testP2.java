/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.asked;

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
import wsdl.AddFlightRequest;
import wsdl.AddFlightResponse;
import wsdl.AddFlightTravelGoodFault;
import wsdl.AddHotelRequest;
import wsdl.AddHotelResponse;
import wsdl.AddHotelTravelGoodFault;
import wsdl.BookItineraryRequest;
import wsdl.BookItineraryResponse;
import wsdl.BookItineraryTravelGoodFault;
import wsdl.CancelItineraryFault;
import wsdl.CancelItineraryRequest;
import wsdl.CreateItineraryRequest;
import wsdl.CreateItineraryResponse;
import wsdl.CreditCardInfoType;
import wsdl.ExpirationDateType;
import wsdl.Flight;
import wsdl.FlightList;
import wsdl.GetFlightRequest;
import wsdl.GetFlightTravelGoodOperationFault;
import wsdl.GetHotelRequest;
import wsdl.GetHotelTravelGoodOperationFault;
import wsdl.GetItineraryRequest;
import wsdl.GetItineraryResponse;
import wsdl.Hotel;
import wsdl.Hotellist;


/**
 *
 * @author Alina GHERMAN<alinagherman@hotmail.fr>
 */
public class TestP2 {
    


    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
   
@Test
    public void testP2() throws Exception{
        //create itinerary
        CreateItineraryRequest request = new CreateItineraryRequest();
        request.setCustomerID("12");
        CreateItineraryResponse response = createItineraryTravelGoodOperation(request);
        assertNotNull(request);
        assertFalse(response.getItineraryID().isEmpty());
       

        //get a list of flights**********************************************
        DatatypeFactory dataFactory = null;
        
            dataFactory = DatatypeFactory.newInstance();
        
        GetFlightRequest getFlightInput = new GetFlightRequest();
        getFlightInput.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2013, 12, 19, 0));
        getFlightInput.setFlightDestinationPoint("MAD");
        getFlightInput.setFlightStartPoint("CPH");
        getFlightInput.setItineraryID(response.getItineraryID());
        
        FlightList result = new FlightList();
            result = getFlightTravelGoodOperation(getFlightInput);

            //*****************************Add flight**************************************
            //****************************************************************************
            //test recived flight**************************************
            assertEquals(result.getFlightInformation().size(), 1);
            assertEquals(result.getFlightInformation().get(0).getAirline(), "SAS");
            assertEquals(result.getFlightInformation().get(0).getBookingNumber(), 1);
            assertEquals(result.getFlightInformation().get(0).getPrice(), 100);
            assertEquals(result.getFlightInformation().get(0).getFlight().getDestinationAirport(), "MAD");
            assertEquals(result.getFlightInformation().get(0).getFlight().getStartAirport(), "CPH");
            //create and add the flight**************************************
            Flight f = new Flight();
            f.setStartAirport(result.getFlightInformation().get(0).getFlight().getStartAirport());
            f.setDestinationAirport(result.getFlightInformation().get(0).getFlight().getDestinationAirport());
            f.setCarrier(result.getFlightInformation().get(0).getFlight().getCarrier());
            f.setLandingTimetim(result.getFlightInformation().get(0).getFlight().getLandingTimetim());
            f.setLiftOffDate(result.getFlightInformation().get(0).getFlight().getLiftOffDate());
            f.setLiftOffTime(result.getFlightInformation().get(0).getFlight().getLiftOffTime());
            AddFlightRequest.FlightInfo flightInfo = new AddFlightRequest.FlightInfo();
            flightInfo.setBookingNumber(result.getFlightInformation().get(0).getBookingNumber());
            flightInfo.setFlight(f);
            flightInfo.setPrice(result.getFlightInformation().get(0).getPrice());
            flightInfo.setAirline(result.getFlightInformation().get(0).getAirline());
            AddFlightRequest requestAddFlight = new AddFlightRequest();
            requestAddFlight.setItineraryID(response.getItineraryID());
            requestAddFlight.setFlightInfo(flightInfo);
            AddFlightResponse responseAddFlight;            
            
            responseAddFlight = addFlightTravelGoodOperation(requestAddFlight);
            
            assertNotNull(responseAddFlight);
            assertTrue(responseAddFlight.isAddFlightConfirmation());
            //Cancel********************************************************
            CreditCardInfoType card = new CreditCardInfoType();           
            card.setName("Tick Joachim");
            card.setNumber("50408824");
            ExpirationDateType edate = new ExpirationDateType();
            edate.setMonth(2);
            edate.setYear(11);
            card.setExpirationDate(edate);
            CancelItineraryRequest cancel = new CancelItineraryRequest();
            cancel.setCreditcard(card);
            cancel.setItineraryID(response.getItineraryID());   /*        
            boolean ok = cancelItineraryOperation(cancel);
            assertTrue(ok);*/
            //get itinerary**********************************************************
            GetItineraryRequest requestItinerary = new GetItineraryRequest();
            requestItinerary.setItineraryID(response.getItineraryID()); 
            GetItineraryResponse responseItinerary1 = getItineraryOperation(requestItinerary);
            
            assertNotNull(responseItinerary1);
            assertEquals("unconfirmed", responseItinerary1.getItinerary().getItineraryStatus());
            assertEquals("unconfirmed", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getFlightStatus());
            assertNull(responseItinerary1.getItinerary().getHotelListRoot());
            assertEquals(1, responseItinerary1.getItinerary().getFlightListRoot().getFlightList().size());
            assertEquals(100,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getPrice()); 
            assertEquals("SAS",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getAirline()); 
            
        
    }
 
    private static AddFlightResponse addFlightTravelGoodOperation(wsdl.AddFlightRequest addFlightInput) throws AddFlightTravelGoodFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addFlightTravelGoodOperation(addFlightInput);
    }

    private static AddHotelResponse addHotelTravelGoodlOperation(wsdl.AddHotelRequest addHotelInput) throws AddHotelTravelGoodFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addHotelTravelGoodlOperation(addHotelInput);
    }

    private static BookItineraryResponse bookItineraryTravelGoodOperation(wsdl.BookItineraryRequest bookItineraryInput) throws BookItineraryTravelGoodFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.bookItineraryTravelGoodOperation(bookItineraryInput);
    }

    private static boolean cancelItineraryOperation(wsdl.CancelItineraryRequest cancelInput) throws CancelItineraryFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.cancelItineraryOperation(cancelInput);
    }

    private static CreateItineraryResponse createItineraryTravelGoodOperation(wsdl.CreateItineraryRequest createItineraryInput) {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.createItineraryTravelGoodOperation(createItineraryInput);
    }

    private static FlightList getFlightTravelGoodOperation(wsdl.GetFlightRequest getFlightInput) throws GetFlightTravelGoodOperationFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getFlightTravelGoodOperation(getFlightInput);
    }

    private static Hotellist getHotelTravelGoodOperation(wsdl.GetHotelRequest getHotelInput) throws GetHotelTravelGoodOperationFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getHotelTravelGoodOperation(getHotelInput);
    }

    private static GetItineraryResponse getItineraryOperation(wsdl.GetItineraryRequest getItineraryInput) {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getItineraryOperation(getItineraryInput);
    }

}
