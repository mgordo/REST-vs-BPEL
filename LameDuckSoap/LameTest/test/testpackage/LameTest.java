/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import client.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Diego Gonzalez
 */
public class LameTest {
    
    public LameTest() {
    }

    
    @Test
    public void getTest(){
        DatatypeFactory dataFactory=null;
        try {
            dataFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            fail("It should have created a data Factory");
        }
        /*Only one flight*/
        FlightList flights = getFlights("CPH","MAD" , dataFactory.newXMLGregorianCalendarDate(2013, 12, 19, 0));
        assertEquals(flights.getFlightInformation().size(), 1);
        assertEquals(flights.getFlightInformation().get(0).getAirline(),"SAS");
        assertEquals(flights.getFlightInformation().get(0).getBookingNumber(),1);
        assertEquals(flights.getFlightInformation().get(0).getPrice(),100);
        assertEquals(flights.getFlightInformation().get(0).getFlight().getDestinationAirport(),"MAD");
        assertEquals(flights.getFlightInformation().get(0).getFlight().getStartAirport(),"CPH");
        
        /*NO flights*/
        flights = getFlights("BAR","MAD" , dataFactory.newXMLGregorianCalendarDate(2013, 12, 19, 0));
        assertEquals(flights.getFlightInformation().size(), 0);
        
        /*Two flights*/
        flights = getFlights("DEF","ABC" , dataFactory.newXMLGregorianCalendarDate(2013, 12, 30, 0));
        assertEquals(flights.getFlightInformation().size(), 2);
        assertEquals(flights.getFlightInformation().get(0).getAirline(),"Ryanair");
        assertEquals(flights.getFlightInformation().get(0).getBookingNumber(),2);
        assertEquals(flights.getFlightInformation().get(0).getPrice(),200);
        assertEquals(flights.getFlightInformation().get(0).getFlight().getDestinationAirport(),"ABC");
        assertEquals(flights.getFlightInformation().get(0).getFlight().getStartAirport(),"DEF");
        
        assertEquals(flights.getFlightInformation().get(1).getAirline(),"Iberia");
        assertEquals(flights.getFlightInformation().get(1).getBookingNumber(),3);
        assertEquals(flights.getFlightInformation().get(1).getPrice(),200);
        assertEquals(flights.getFlightInformation().get(1).getFlight().getDestinationAirport(),"ABC");
        assertEquals(flights.getFlightInformation().get(1).getFlight().getStartAirport(),"DEF");
    }
    
    @Test
    public void bookTest(){
        ObjectFactory obj = new ObjectFactory();
        client.CreditCardInfoType card = obj.createCreditCardInfoType();
        
        /*Normal booking*/
        card.setName("Tick Joachim");
        card.setNumber("50408824");
        ExpirationDateType edate = obj.createExpirationDateType();
        edate.setMonth(2);
        edate.setYear(11);
        card.setExpirationDate(edate);
        try {
            assertEquals(bookFlight(1,card),true);
        } catch (BookFlightFault ex) {
            fail("Reason: "+ex.getLocalizedMessage()+"\n"+ex.getMessage());
        }
        
        /*Non existing credit card*/
        card.setName("Tick Joachim1");
        card.setNumber("50408824");
        edate.setMonth(2);
        edate.setYear(11);
        card.setExpirationDate(edate);
        try {
            bookFlight(1,card);
            fail("Should have failed");
        } catch (BookFlightFault ex) {
            assertEquals(ex.getMessage(),"Credit card does not exist");
        }
        
        /*Not enough money*/
        card.setName("Bech Camilla");
        card.setNumber("50408822");
        edate.setMonth(7);
        edate.setYear(9);
        card.setExpirationDate(edate);
        try {
            bookFlight(4,card);
            fail("Should have failed");
        } catch (BookFlightFault ex) {
            assertEquals(ex.getLocalizedMessage(),"The account has not enough money");
            
        }
    }
    
    @Test
    public void cancelTest(){
        
        ObjectFactory obj = new ObjectFactory();
        client.CreditCardInfoType card = obj.createCreditCardInfoType();
        
        /*Normal cancel*/
        card.setName("Tick Joachim");
        card.setNumber("50408824");
        ExpirationDateType edate = obj.createExpirationDateType();
        edate.setMonth(2);
        edate.setYear(11);
        card.setExpirationDate(edate);
        try {
            assertEquals(cancelFlight(1, 100, card),true);
        } catch (CancelFlightFaultMessage ex) {
            fail("Should not have failed");
        }
        
        /*No existing credit card*/
        card.setName("Tick Joachim1");
        card.setNumber("50408824");
        edate.setMonth(2);
        edate.setYear(11);
        card.setExpirationDate(edate);
        try {
            cancelFlight(1, 100, card);
            fail("Should have failed");
        } catch (CancelFlightFaultMessage ex) {
            assertEquals(ex.getMessage(),"Credit card does not exist");
        }
        
    }

    private static boolean bookFlight(int bookingnumber, client.CreditCardInfoType creditcard) throws BookFlightFault {
        client.LameDuckService service = new client.LameDuckService();
        client.LameDuckPortType port = service.getLameDuckPortTypeBindingPort();
        return port.bookFlight(bookingnumber, creditcard);
    }

    private static boolean cancelFlight(int bookingnumber1, int price1, client.CreditCardInfoType credircardinfo1) throws CancelFlightFaultMessage {
        client.LameDuckService service = new client.LameDuckService();
        client.LameDuckPortType port = service.getLameDuckPortTypeBindingPort();
        return port.cancelFlight(bookingnumber1, price1, credircardinfo1);
    }

    private static FlightList getFlights(java.lang.String source, java.lang.String destination, javax.xml.datatype.XMLGregorianCalendar date) {
        client.LameDuckService service = new client.LameDuckService();
        client.LameDuckPortType port = service.getLameDuckPortTypeBindingPort();
        return port.getFlights(source, destination, date);
    }
    
    
}
