/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.asked;

import org.junit.Test;
import static org.junit.Assert.*;
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
public class UnitaryTest {
   
 @Test
    public void testP1() throws Exception {
        //create itinerary
        CreateItineraryRequest request = new CreateItineraryRequest();
        request.setCustomerID("11");
        CreateItineraryResponse response = createItineraryTravelGoodOperation(request);
        assertNotNull(request);
        assertFalse(response.getItineraryID().isEmpty());

        //get a list of flights**********************************************
        DatatypeFactory dataFactory = null;
        try {
            dataFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            fail("It should have created a data Factory");
        }
        GetFlightRequest getFlightInput = new GetFlightRequest();
        getFlightInput.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2013, 12, 19, 0));
        getFlightInput.setFlightDestinationPoint("MAD");
        getFlightInput.setFlightStartPoint("CPH");
        getFlightInput.setItineraryID(response.getItineraryID());

        FlightList result = new FlightList();
            result = getFlightTravelGoodOperation(getFlightInput);
            //*****************************FLIGHT 1**************************************
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
            //*****************************HOTEL 1**************************************
            //****************************************************************************            
            //get hotel*******************************************************
            GetHotelRequest hotelRequest = new GetHotelRequest();
            hotelRequest.setCity("Lorient");
            hotelRequest.setArrivalDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 01, 15, 0));
            hotelRequest.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 11, 4, 0));
            hotelRequest.setItineraryID(response.getItineraryID());
            Hotellist list = new Hotellist();
            list = getHotelTravelGoodOperation(hotelRequest);
            assertEquals(false, list.getNewElement().isEmpty());
            //add hotel**************************************
            Hotel h = new Hotel();
            h.setAddress(list.getNewElement().get(0).getAddress());
            h.setBooknumber(list.getNewElement().get(0).getBooknumber());
            h.setCity(list.getNewElement().get(0).getCity());
            h.setEndperiod(list.getNewElement().get(0).getEndperiod());
            h.setGuarantee(list.getNewElement().get(0).isGuarantee());
            h.setName(list.getNewElement().get(0).getName());
            h.setPrice(list.getNewElement().get(0).getPrice());
            h.setReservationService(list.getNewElement().get(0).getReservationService());
            h.setStartperiod(list.getNewElement().get(0).getStartperiod());
            AddHotelRequest requestAddHotels = new AddHotelRequest();
            requestAddHotels.setItineraryID(response.getItineraryID());
            requestAddHotels.setHotelInfo(h);
            AddHotelResponse responseAddHotel1;
            responseAddHotel1 = addHotelTravelGoodlOperation(requestAddHotels);           
            assertNotNull(responseAddHotel1);
            assertTrue(responseAddHotel1.isAddHotelConfirmation()); 
            //*****************************FLIGHT 2**************************************
            //****************************************************************************            
            //get flight****************************************************
            GetFlightRequest getFlightInput1 = new GetFlightRequest();
            getFlightInput1.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2013, 12, 30, 0));
            getFlightInput1.setFlightDestinationPoint("ABC");
            getFlightInput1.setFlightStartPoint("DEF");
            getFlightInput1.setItineraryID(response.getItineraryID());
            FlightList result1 = new FlightList();
            result1 = getFlightTravelGoodOperation(getFlightInput1);
            assertEquals(result1.getFlightInformation().size(), 2);
            assertEquals(result1.getFlightInformation().get(0).getAirline(), "Ryanair");
            assertEquals(result1.getFlightInformation().get(0).getBookingNumber(), 2);
            assertEquals(result1.getFlightInformation().get(0).getPrice(), 200);
            assertEquals(result1.getFlightInformation().get(0).getFlight().getDestinationAirport(), "ABC");
            assertEquals(result1.getFlightInformation().get(0).getFlight().getStartAirport(), "DEF");
            //create and add the flight*************************************
            Flight f1 = new Flight();
            f1.setStartAirport(result1.getFlightInformation().get(0).getFlight().getStartAirport());
            f1.setDestinationAirport(result1.getFlightInformation().get(0).getFlight().getDestinationAirport());
            f1.setCarrier(result1.getFlightInformation().get(0).getFlight().getCarrier());
            f1.setLandingTimetim(result1.getFlightInformation().get(0).getFlight().getLandingTimetim());
            f1.setLiftOffDate(result1.getFlightInformation().get(0).getFlight().getLiftOffDate());
            f1.setLiftOffTime(result1.getFlightInformation().get(0).getFlight().getLiftOffTime());
            AddFlightRequest.FlightInfo flightInfo1 = new AddFlightRequest.FlightInfo();
            flightInfo1.setBookingNumber(result1.getFlightInformation().get(0).getBookingNumber());
            flightInfo1.setFlight(f1);
            flightInfo1.setPrice(result1.getFlightInformation().get(0).getPrice());
            flightInfo1.setAirline(result1.getFlightInformation().get(0).getAirline());
            AddFlightRequest requestAddFlight1 = new AddFlightRequest();
            requestAddFlight1.setItineraryID(response.getItineraryID());
            requestAddFlight1.setFlightInfo(flightInfo1);
            AddFlightResponse responseAddFlight1;
            responseAddFlight1 = addFlightTravelGoodOperation(requestAddFlight1);
            assertNotNull(responseAddFlight1);
            assertEquals(true, responseAddFlight1.isAddFlightConfirmation());
            //create and add the flight*************************************
            Flight f2 = new Flight();
            f2.setStartAirport(result1.getFlightInformation().get(1).getFlight().getStartAirport());
            f2.setDestinationAirport(result1.getFlightInformation().get(1).getFlight().getDestinationAirport());
            f2.setCarrier(result1.getFlightInformation().get(1).getFlight().getCarrier());
            f2.setLandingTimetim(result1.getFlightInformation().get(1).getFlight().getLandingTimetim());
            f2.setLiftOffDate(result1.getFlightInformation().get(1).getFlight().getLiftOffDate());
            f2.setLiftOffTime(result1.getFlightInformation().get(1).getFlight().getLiftOffTime());
            AddFlightRequest.FlightInfo flightInfo2 = new AddFlightRequest.FlightInfo();
            flightInfo2.setBookingNumber(result1.getFlightInformation().get(0).getBookingNumber());
            flightInfo2.setFlight(f2);
            flightInfo2.setPrice(result1.getFlightInformation().get(1).getPrice());
            flightInfo2.setAirline(result1.getFlightInformation().get(1).getAirline());
            AddFlightRequest requestAddFlight2 = new AddFlightRequest();
            requestAddFlight2.setItineraryID(response.getItineraryID());
            requestAddFlight2.setFlightInfo(flightInfo2);
            AddFlightResponse responseAddFlight2;
            responseAddFlight2 = addFlightTravelGoodOperation(requestAddFlight2);
            assertNotNull(responseAddFlight2);  
             //get hotel*******************************************************
            GetHotelRequest hotelRequest1 = new GetHotelRequest();
            hotelRequest.setCity("Kiel");
            hotelRequest.setArrivalDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 5, 05, 0));
            hotelRequest.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 6, 5, 0));
            hotelRequest.setItineraryID(response.getItineraryID());
            Hotellist list1 = new Hotellist();
            list1 = getHotelTravelGoodOperation(hotelRequest);
            assertEquals(false, list1.getNewElement().isEmpty());
            //add hotel**************************************
            Hotel h1 = new Hotel();
            h1.setAddress(list1.getNewElement().get(0).getAddress());
            h1.setBooknumber(list1.getNewElement().get(0).getBooknumber());
            h1.setCity(list1.getNewElement().get(0).getCity());
            h1.setEndperiod(list1.getNewElement().get(0).getEndperiod());
            h1.setGuarantee(list1.getNewElement().get(0).isGuarantee());
            h1.setName(list1.getNewElement().get(0).getName());
            h1.setPrice(list1.getNewElement().get(0).getPrice());
            h1.setReservationService(list1.getNewElement().get(0).getReservationService());
            h1.setStartperiod(list1.getNewElement().get(0).getStartperiod());
            AddHotelRequest requestAddHotels1 = new AddHotelRequest();
            requestAddHotels1.setItineraryID(response.getItineraryID());
            requestAddHotels1.setHotelInfo(h1);
            AddHotelResponse responseAddHotel2;
            responseAddHotel2 = addHotelTravelGoodlOperation(requestAddHotels1);           
            assertNotNull(responseAddHotel2);
            assertTrue(responseAddHotel2.isAddHotelConfirmation()); 
             //*****************************GET ITINERARY**************************************
            //**************************************************************************** 
            //ask for itinerary*****************************************
            GetItineraryRequest requestItinerary = new GetItineraryRequest();
            requestItinerary.setItineraryID(response.getItineraryID());     
            GetItineraryResponse responseItinerary = getItineraryOperation(requestItinerary);
            assertNotNull(responseItinerary);
            assertEquals("unconfirmed", responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(0).getFlightStatus());
            assertEquals("unconfirmed", responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(1).getFlightStatus());
            assertEquals("unconfirmed", responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(2).getFlightStatus());
            assertEquals("unconfirmed", responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(0).getHotelStatus());
            assertEquals("unconfirmed", responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(1).getHotelStatus());
            assertEquals(2, responseItinerary.getItinerary().getHotelListRoot().getHotelList().size());
            assertEquals(3, responseItinerary.getItinerary().getFlightListRoot().getFlightList().size());
            assertEquals(100,responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(0).getPrice()); 
            assertEquals(200,responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(1).getPrice()); 
            assertEquals(200,responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(2).getPrice()); 
            assertEquals("SAS",responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(0).getAirline()); 
            assertEquals("Ryanair",responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(1).getAirline()); 
            assertEquals("Iberia",responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(2).getAirline()); 
            assertEquals("Lorient",responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(0).getCity()); 
            assertEquals(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 5, 05, 0),
                    responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(1).getStartperiod()); 
            assertEquals(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 6, 5, 0),
                    responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(1).getEndperiod()); 
            assertEquals("Kiel",responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(1).getCity()); 
            assertEquals(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 01, 15, 0),
                    responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(0).getStartperiod()); 
            assertEquals(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 11, 4, 0),
                    responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(0).getEndperiod()); 
             //*****************************BOOK ITINERARY**************************************
            //**************************************************************************** 
           
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
             responseBook = bookItineraryTravelGoodOperation(requestBook);
             assertEquals(true, responseBook.isBookingConfirmation());
            //*****************************GET ITINERARY**************************************
            //**************************************************************************** 
            GetItineraryResponse responseItinerary1 = getItineraryOperation(requestItinerary);
            assertNotNull(responseItinerary1);
            assertEquals("confirmed", responseItinerary1.getItinerary().getItineraryStatus());
            assertEquals("confirmed", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getFlightStatus());
            assertEquals("confirmed", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getFlightStatus());
            assertEquals("confirmed", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(2).getFlightStatus());
            assertEquals("confirmed", responseItinerary1.getItinerary().getHotelListRoot().getHotelList().get(0).getHotelStatus());
            assertEquals("confirmed", responseItinerary1.getItinerary().getHotelListRoot().getHotelList().get(1).getHotelStatus());
            assertEquals(2, responseItinerary1.getItinerary().getHotelListRoot().getHotelList().size());
            assertEquals(3, responseItinerary1.getItinerary().getFlightListRoot().getFlightList().size());
            assertEquals(100,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getPrice()); 
            assertEquals(200,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getPrice()); 
            assertEquals(200,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(2).getPrice()); 
            assertEquals("SAS",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getAirline()); 
            assertEquals("Ryanair",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getAirline()); 
            assertEquals("Iberia",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(2).getAirline()); 
            assertEquals("Lorient",responseItinerary1.getItinerary().getHotelListRoot().getHotelList().get(0).getCity()); 
       
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
        try {
            dataFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            fail("It should have created a data Factory");
        }
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
            cancel.setItineraryID(response.getItineraryID());
            /*
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
 
 @Test
    public void testB() throws Exception{
        //create itinerary
        CreateItineraryRequest request = new CreateItineraryRequest();
        request.setCustomerID("13");
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
            //*****************************FLIGHT 1**************************************
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
            //*****************************HOTEL 1**************************************
            //****************************************************************************            
            //get hotel*******************************************************
           
            //add hotel**************************************
            Hotel h = new Hotel();
            h.setAddress("Lorient booking should fail");
            h.setBooknumber(45612);
            h.setCity("Wrong Lorient");
            h.setEndperiod(dataFactory.newXMLGregorianCalendarDate(2013, 12, 19, 0));
            h.setGuarantee(false);
            h.setName("This is a name");
            h.setPrice(100);
            h.setReservationService("This is a reservation service");
            h.setStartperiod(dataFactory.newXMLGregorianCalendarDate(2013, 12, 19, 0));
            AddHotelRequest requestAddHotels = new AddHotelRequest();
            requestAddHotels.setItineraryID(response.getItineraryID());
            requestAddHotels.setHotelInfo(h);
            AddHotelResponse responseAddHotel1;
            responseAddHotel1 = addHotelTravelGoodlOperation(requestAddHotels);           
            assertNotNull(responseAddHotel1);
            assertTrue(responseAddHotel1.isAddHotelConfirmation()); 
            //*****************************FLIGHT 2**************************************
            //****************************************************************************            
            //get flight****************************************************
            GetFlightRequest getFlightInput1 = new GetFlightRequest();
            getFlightInput1.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2013, 12, 30, 0));
            getFlightInput1.setFlightDestinationPoint("ABC");
            getFlightInput1.setFlightStartPoint("DEF");
            getFlightInput1.setItineraryID(response.getItineraryID());
            FlightList result1 = new FlightList();
            result1 = getFlightTravelGoodOperation(getFlightInput1);
            assertEquals(result1.getFlightInformation().size(), 2);
            assertEquals(result1.getFlightInformation().get(0).getAirline(), "Ryanair");
            assertEquals(result1.getFlightInformation().get(0).getBookingNumber(), 2);
            assertEquals(result1.getFlightInformation().get(0).getPrice(), 200);
            assertEquals(result1.getFlightInformation().get(0).getFlight().getDestinationAirport(), "ABC");
            assertEquals(result1.getFlightInformation().get(0).getFlight().getStartAirport(), "DEF");
            //create and add the flight*************************************
            Flight f1 = new Flight();
            f1.setStartAirport(result1.getFlightInformation().get(0).getFlight().getStartAirport());
            f1.setDestinationAirport(result1.getFlightInformation().get(0).getFlight().getDestinationAirport());
            f1.setCarrier(result1.getFlightInformation().get(0).getFlight().getCarrier());
            f1.setLandingTimetim(result1.getFlightInformation().get(0).getFlight().getLandingTimetim());
            f1.setLiftOffDate(result1.getFlightInformation().get(0).getFlight().getLiftOffDate());
            f1.setLiftOffTime(result1.getFlightInformation().get(0).getFlight().getLiftOffTime());
            AddFlightRequest.FlightInfo flightInfo1 = new AddFlightRequest.FlightInfo();
            flightInfo1.setBookingNumber(result1.getFlightInformation().get(0).getBookingNumber());
            flightInfo1.setFlight(f1);
            flightInfo1.setPrice(result1.getFlightInformation().get(0).getPrice());
            flightInfo1.setAirline(result1.getFlightInformation().get(0).getAirline());
            AddFlightRequest requestAddFlight1 = new AddFlightRequest();
            requestAddFlight1.setItineraryID(response.getItineraryID());
            requestAddFlight1.setFlightInfo(flightInfo1);
            AddFlightResponse responseAddFlight1;
            responseAddFlight1 = addFlightTravelGoodOperation(requestAddFlight1);
            assertNotNull(responseAddFlight1);
            assertEquals(true, responseAddFlight1.isAddFlightConfirmation());

            //*****************************GET ITINERARY**************************************
            //**************************************************************************** 
            //ask for itinerary*****************************************
            GetItineraryRequest requestItinerary = new GetItineraryRequest();
            requestItinerary.setItineraryID(response.getItineraryID());     
            GetItineraryResponse responseItinerary = getItineraryOperation(requestItinerary);
            assertNotNull(responseItinerary);
            assertEquals("unconfirmed", responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(0).getFlightStatus());
            assertEquals("unconfirmed", responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(1).getFlightStatus());
            assertEquals("unconfirmed", responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(0).getHotelStatus());
            assertEquals(1, responseItinerary.getItinerary().getHotelListRoot().getHotelList().size());
            assertEquals(2, responseItinerary.getItinerary().getFlightListRoot().getFlightList().size());
            assertEquals(100,responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(0).getPrice()); 
            assertEquals(200,responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(1).getPrice()); 
            assertEquals("SAS",responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(0).getAirline()); 
            assertEquals("Ryanair",responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(1).getAirline()); 
            assertEquals("Wrong Lorient",responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(0).getCity()); 

          
             //*****************************BOOK ITINERARY should fail**************************************
            //*****************************************Second booking= hotel**************************** 
            BookItineraryRequest requestBook = new BookItineraryRequest();
            requestBook.setItineraryID(response.getItineraryID());
            CreditCardInfoType card =  new CreditCardInfoType();

             card.setName("Anne Strandberg");
             card.setNumber("50408816");
             ExpirationDateType edate = new ExpirationDateType();
             edate.setMonth(5);
             edate.setYear(9);
             card.setExpirationDate(edate);
             requestBook.setCreditCardInformation(card);
             BookItineraryResponse responseBook;
             responseBook =null;
             try{
                responseBook = bookItineraryTravelGoodOperation(requestBook);
                fail("It should have failed");
             }catch(BookItineraryTravelGoodFault e){
                 
             }
             
             //*****************************GET ITINERARY**************************************
            //**************************************************************************** 

            GetItineraryResponse responseItinerary1 = getItineraryOperation(requestItinerary);
            assertNotNull(responseItinerary1);
            assertEquals("unconfirmed", responseItinerary1.getItinerary().getItineraryStatus());
            assertEquals("cancelled", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getFlightStatus());
            assertEquals("cancelled", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getFlightStatus()); 
            assertEquals("unconfirmed", responseItinerary1.getItinerary().getHotelListRoot().getHotelList().get(0).getHotelStatus());
            assertEquals(1, responseItinerary1.getItinerary().getHotelListRoot().getHotelList().size());
            assertEquals(2, responseItinerary1.getItinerary().getFlightListRoot().getFlightList().size());
            assertEquals(100,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getPrice()); 
            assertEquals(200,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getPrice()); 
            assertEquals("SAS",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getAirline()); 
            assertEquals("Ryanair",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getAirline()); 
            assertEquals("Wrong Lorient",responseItinerary1.getItinerary().getHotelListRoot().getHotelList().get(0).getCity()); 
            
          
    }
  
 @Test
    public void testC1() throws Exception{
        //create itinerary
        CreateItineraryRequest request = new CreateItineraryRequest();
        request.setCustomerID("11");
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
            //*****************************FLIGHT 1************************************** 
            //****************************************************************************
            //test recived flight**************************************
            assertEquals(result.getFlightInformation().size(), 1);
            assertEquals(result.getFlightInformation().get(0).getAirline(), "SAS");
            assertEquals(result.getFlightInformation().get(0).getBookingNumber(), 1);
            assertEquals(result.getFlightInformation().get(0).getPrice(), 100);
            assertEquals(result.getFlightInformation().get(0).getFlight().getDestinationAirport(), "MAD");
            assertEquals(result.getFlightInformation().get(0).getFlight().getStartAirport(), "CPH");
            //add the flight**************************************
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
            //*****************************HOTEL 1**************************************
            //****************************************************************************            
            //get hotel*******************************************************
            GetHotelRequest hotelRequest = new GetHotelRequest();
            hotelRequest.setCity("Lorient");
            hotelRequest.setArrivalDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 01, 15, 0));
            hotelRequest.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 11, 4, 0));
            hotelRequest.setItineraryID(response.getItineraryID());
            Hotellist list = new Hotellist();
            list = getHotelTravelGoodOperation(hotelRequest);
            assertEquals(false, list.getNewElement().isEmpty());
            //add hotel**************************************
            Hotel h = new Hotel();
            h.setAddress(list.getNewElement().get(0).getAddress());
            h.setBooknumber(list.getNewElement().get(0).getBooknumber());
            h.setCity(list.getNewElement().get(0).getCity());
            h.setEndperiod(list.getNewElement().get(0).getEndperiod());
            h.setGuarantee(list.getNewElement().get(0).isGuarantee());
            h.setName(list.getNewElement().get(0).getName());
            h.setPrice(list.getNewElement().get(0).getPrice());
            h.setReservationService(list.getNewElement().get(0).getReservationService());
            h.setStartperiod(list.getNewElement().get(0).getStartperiod());
            AddHotelRequest requestAddHotels = new AddHotelRequest();
            requestAddHotels.setItineraryID(response.getItineraryID());
            requestAddHotels.setHotelInfo(h);
            AddHotelResponse responseAddHotel1;
            responseAddHotel1 = addHotelTravelGoodlOperation(requestAddHotels);           
            assertNotNull(responseAddHotel1);
            assertTrue(responseAddHotel1.isAddHotelConfirmation()); 
            //*****************************FLIGHT 2**************************************
            //****************************************************************************            
            //get flight****************************************************
            GetFlightRequest getFlightInput1 = new GetFlightRequest();
            getFlightInput1.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2013, 12, 30, 0));
            getFlightInput1.setFlightDestinationPoint("ABC");
            getFlightInput1.setFlightStartPoint("DEF");
            getFlightInput1.setItineraryID(response.getItineraryID());
            FlightList result1 = new FlightList();
            result1 = getFlightTravelGoodOperation(getFlightInput1);
            assertEquals(result1.getFlightInformation().size(), 2);
            assertEquals(result1.getFlightInformation().get(0).getAirline(), "Ryanair");
            assertEquals(result1.getFlightInformation().get(0).getBookingNumber(), 2);
            assertEquals(result1.getFlightInformation().get(0).getPrice(), 200);
            assertEquals(result1.getFlightInformation().get(0).getFlight().getDestinationAirport(), "ABC");
            assertEquals(result1.getFlightInformation().get(0).getFlight().getStartAirport(), "DEF");
            //add the flight*************************************
            Flight f1 = new Flight();
            f1.setStartAirport(result1.getFlightInformation().get(0).getFlight().getStartAirport());
            f1.setDestinationAirport(result1.getFlightInformation().get(0).getFlight().getDestinationAirport());
            f1.setCarrier(result1.getFlightInformation().get(0).getFlight().getCarrier());
            f1.setLandingTimetim(result1.getFlightInformation().get(0).getFlight().getLandingTimetim());
            f1.setLiftOffDate(result1.getFlightInformation().get(0).getFlight().getLiftOffDate());
            f1.setLiftOffTime(result1.getFlightInformation().get(0).getFlight().getLiftOffTime());
            AddFlightRequest.FlightInfo flightInfo1 = new AddFlightRequest.FlightInfo();
            flightInfo1.setBookingNumber(result1.getFlightInformation().get(0).getBookingNumber());
            flightInfo1.setFlight(f1);
            flightInfo1.setPrice(result1.getFlightInformation().get(0).getPrice());
            flightInfo1.setAirline(result1.getFlightInformation().get(0).getAirline());
            AddFlightRequest requestAddFlight1 = new AddFlightRequest();
            requestAddFlight1.setItineraryID(response.getItineraryID());
            requestAddFlight1.setFlightInfo(flightInfo1);
            AddFlightResponse responseAddFlight1;
            responseAddFlight1 = addFlightTravelGoodOperation(requestAddFlight1);
            assertNotNull(responseAddFlight1);
            assertEquals(true, responseAddFlight1.isAddFlightConfirmation());
             //*****************************BOOK ITINERARY**************************************
            //**************************************************************************** 
           
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
             responseBook = bookItineraryTravelGoodOperation(requestBook);
             assertEquals(true, responseBook.isBookingConfirmation());
            //*****************************GET ITINERARY**************************************
            //**************************************************************************** 
            GetItineraryRequest requestItinerary = new GetItineraryRequest();
            requestItinerary.setItineraryID(response.getItineraryID());    
            GetItineraryResponse responseItinerary1 = getItineraryOperation(requestItinerary);
            assertNotNull(responseItinerary1);
            assertEquals("confirmed", responseItinerary1.getItinerary().getItineraryStatus());
            assertEquals("confirmed", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getFlightStatus());
            assertEquals("confirmed", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getFlightStatus());
            assertEquals("confirmed", responseItinerary1.getItinerary().getHotelListRoot().getHotelList().get(0).getHotelStatus());
            assertEquals(1, responseItinerary1.getItinerary().getHotelListRoot().getHotelList().size());
            assertEquals(2, responseItinerary1.getItinerary().getFlightListRoot().getFlightList().size());
            assertEquals(100,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getPrice()); 
            assertEquals(200,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getPrice()); 
            assertEquals("SAS",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getAirline()); 
            assertEquals("Ryanair",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getAirline()); 
            assertEquals("Lorient",responseItinerary1.getItinerary().getHotelListRoot().getHotelList().get(0).getCity()); 
            //cancel itinerary
            CancelItineraryRequest cancel = new CancelItineraryRequest();
            cancel.setCreditcard(card);
            cancel.setItineraryID(response.getItineraryID());           
            boolean ok = cancelItineraryOperation(cancel);
            assertTrue(ok);
            //get itinerary**********************************************************
            GetItineraryResponse responseItinerary2 = getItineraryOperation(requestItinerary);
            assertEquals("cancelled", responseItinerary2.getItinerary().getItineraryStatus());
            assertEquals("cancelled", responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(0).getFlightStatus());
            assertEquals("cancelled", responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(1).getFlightStatus());
            assertEquals("cancelled", responseItinerary2.getItinerary().getHotelListRoot().getHotelList().get(0).getHotelStatus());
            assertEquals(1, responseItinerary2.getItinerary().getHotelListRoot().getHotelList().size());
            assertEquals(2, responseItinerary2.getItinerary().getFlightListRoot().getFlightList().size());
            assertEquals(100,responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(0).getPrice()); 
            assertEquals(200,responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(1).getPrice()); 
            assertEquals("SAS",responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(0).getAirline()); 
            assertEquals("Ryanair",responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(1).getAirline()); 
            assertEquals("Lorient",responseItinerary2.getItinerary().getHotelListRoot().getHotelList().get(0).getCity()); 
            
       
    }

    @Test
    public void testC2() throws Exception{
        //create itinerary
        CreateItineraryRequest request = new CreateItineraryRequest();
        request.setCustomerID("11");
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
            //*****************************FLIGHT 1************************************** 
            //****************************************************************************
            //test recived flight**************************************
            assertEquals(result.getFlightInformation().size(), 1);
            assertEquals(result.getFlightInformation().get(0).getAirline(), "SAS");
            assertEquals(result.getFlightInformation().get(0).getBookingNumber(), 1);
            assertEquals(result.getFlightInformation().get(0).getPrice(), 100);
            assertEquals(result.getFlightInformation().get(0).getFlight().getDestinationAirport(), "MAD");
            assertEquals(result.getFlightInformation().get(0).getFlight().getStartAirport(), "CPH");
            //add the flight**************************************
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
            //*****************************HOTEL 1**************************************
            //****************************************************************************            
            //get hotel*******************************************************
            GetHotelRequest hotelRequest = new GetHotelRequest();
            hotelRequest.setCity("Lorient");
            hotelRequest.setArrivalDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 01, 15, 0));
            hotelRequest.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 11, 4, 0));
            hotelRequest.setItineraryID(response.getItineraryID());
            Hotellist list = new Hotellist();
            list = getHotelTravelGoodOperation(hotelRequest);
            assertEquals(false, list.getNewElement().isEmpty());
            //add hotel**************************************
            /**
             * This hotel fails when cancelling
             */
            Hotel h = new Hotel();
            h.setAddress(list.getNewElement().get(1).getAddress());
            h.setBooknumber(list.getNewElement().get(1).getBooknumber());
            h.setCity(list.getNewElement().get(1).getCity());
            h.setEndperiod(list.getNewElement().get(1).getEndperiod());
            h.setGuarantee(list.getNewElement().get(1).isGuarantee());
            h.setName(list.getNewElement().get(1).getName());
            h.setPrice(list.getNewElement().get(1).getPrice());
            h.setReservationService(list.getNewElement().get(1).getReservationService());
            h.setStartperiod(list.getNewElement().get(1).getStartperiod());
            AddHotelRequest requestAddHotels = new AddHotelRequest();
            requestAddHotels.setItineraryID(response.getItineraryID());
            requestAddHotels.setHotelInfo(h);
            AddHotelResponse responseAddHotel1;
            responseAddHotel1 = addHotelTravelGoodlOperation(requestAddHotels);           
            assertNotNull(responseAddHotel1);
            assertTrue(responseAddHotel1.isAddHotelConfirmation()); 
            //*****************************FLIGHT 2**************************************
            //****************************************************************************            
            //get flight****************************************************
            GetFlightRequest getFlightInput1 = new GetFlightRequest();
            getFlightInput1.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2013, 12, 30, 0));
            getFlightInput1.setFlightDestinationPoint("ABC");
            getFlightInput1.setFlightStartPoint("DEF");
            getFlightInput1.setItineraryID(response.getItineraryID());
            FlightList result1 = new FlightList();
            result1 = getFlightTravelGoodOperation(getFlightInput1);
            assertEquals(result1.getFlightInformation().size(), 2);
            assertEquals(result1.getFlightInformation().get(0).getAirline(), "Ryanair");
            assertEquals(result1.getFlightInformation().get(0).getBookingNumber(), 2);
            assertEquals(result1.getFlightInformation().get(0).getPrice(), 200);
            assertEquals(result1.getFlightInformation().get(0).getFlight().getDestinationAirport(), "ABC");
            assertEquals(result1.getFlightInformation().get(0).getFlight().getStartAirport(), "DEF");
            //add the flight*************************************
            Flight f1 = new Flight();
            f1.setStartAirport(result1.getFlightInformation().get(0).getFlight().getStartAirport());
            f1.setDestinationAirport(result1.getFlightInformation().get(0).getFlight().getDestinationAirport());
            f1.setCarrier(result1.getFlightInformation().get(0).getFlight().getCarrier());
            f1.setLandingTimetim(result1.getFlightInformation().get(0).getFlight().getLandingTimetim());
            f1.setLiftOffDate(result1.getFlightInformation().get(0).getFlight().getLiftOffDate());
            f1.setLiftOffTime(result1.getFlightInformation().get(0).getFlight().getLiftOffTime());
            AddFlightRequest.FlightInfo flightInfo1 = new AddFlightRequest.FlightInfo();
            flightInfo1.setBookingNumber(result1.getFlightInformation().get(0).getBookingNumber());
            flightInfo1.setFlight(f1);
            flightInfo1.setPrice(result1.getFlightInformation().get(0).getPrice());
            flightInfo1.setAirline(result1.getFlightInformation().get(0).getAirline());
            AddFlightRequest requestAddFlight1 = new AddFlightRequest();
            requestAddFlight1.setItineraryID(response.getItineraryID());
            requestAddFlight1.setFlightInfo(flightInfo1);
            AddFlightResponse responseAddFlight1;
            responseAddFlight1 = addFlightTravelGoodOperation(requestAddFlight1);
            assertNotNull(responseAddFlight1);
            assertEquals(true, responseAddFlight1.isAddFlightConfirmation());
             //*****************************BOOK ITINERARY**************************************
            //**************************************************************************** 
           
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
             responseBook = bookItineraryTravelGoodOperation(requestBook);
             assertEquals(true, responseBook.isBookingConfirmation());
            //*****************************GET ITINERARY**************************************
            //**************************************************************************** 
            GetItineraryRequest requestItinerary = new GetItineraryRequest();
            requestItinerary.setItineraryID(response.getItineraryID());    
            GetItineraryResponse responseItinerary1 = getItineraryOperation(requestItinerary);          
            assertNotNull(responseItinerary1);
            assertEquals("confirmed", responseItinerary1.getItinerary().getItineraryStatus());
            assertEquals("confirmed", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getFlightStatus());
            assertEquals("confirmed", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getFlightStatus());
            assertEquals("confirmed", responseItinerary1.getItinerary().getHotelListRoot().getHotelList().get(0).getHotelStatus());
            assertEquals(1, responseItinerary1.getItinerary().getHotelListRoot().getHotelList().size());
            assertEquals(2, responseItinerary1.getItinerary().getFlightListRoot().getFlightList().size());
            assertEquals(100,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getPrice()); 
            assertEquals(200,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getPrice()); 
            assertEquals("SAS",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getAirline()); 
            assertEquals("Ryanair",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getAirline()); 
            assertEquals("Lorient",responseItinerary1.getItinerary().getHotelListRoot().getHotelList().get(0).getCity()); 
            //cancel itinerary
            CancelItineraryRequest cancel = new CancelItineraryRequest();
            cancel.setCreditcard(card);
            cancel.setItineraryID(response.getItineraryID()); 
            
            try{
                cancelItineraryOperation(cancel);
                fail("it should have thrown a fault");
            }catch(CancelItineraryFault e){
                assertEquals("error cancelling, please check your itinerary",e.getFaultInfo());
            }
            
            
            //get itinerary**********************************************************
            
            GetItineraryResponse responseItinerary2 = getItineraryOperation(requestItinerary);
            assertEquals("confirmed", responseItinerary2.getItinerary().getItineraryStatus());
            assertEquals("cancelled", responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(0).getFlightStatus());
            assertEquals("cancelled", responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(1).getFlightStatus());
            assertEquals("confirmed", responseItinerary2.getItinerary().getHotelListRoot().getHotelList().get(0).getHotelStatus());
            assertEquals(1, responseItinerary2.getItinerary().getHotelListRoot().getHotelList().size());
            assertEquals(2, responseItinerary2.getItinerary().getFlightListRoot().getFlightList().size());
            assertEquals(100,responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(0).getPrice()); 
            assertEquals(200,responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(1).getPrice()); 
            assertEquals("SAS",responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(0).getAirline()); 
            assertEquals("Ryanair",responseItinerary2.getItinerary().getFlightListRoot().getFlightList().get(1).getAirline()); 
            assertEquals("Lorient",responseItinerary2.getItinerary().getHotelListRoot().getHotelList().get(0).getCity()); 
        
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
    private static boolean cancelItineraryOperation(wsdl.CancelItineraryRequest cancelInput) throws CancelItineraryFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.cancelItineraryOperation(cancelInput);
    }


}
