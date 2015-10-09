/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.unitary;

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
import wsdl.CancelItineraryFault;
import wsdl.CreateItineraryRequest;
import wsdl.CreateItineraryResponse;
import wsdl.FlightList;
import wsdl.GetFlightRequest;
import wsdl.GetFlightTravelGoodOperationFault;

/**
 *
 * @author Alina GHERMAN<alinagherman@hotmail.fr>
 */
public class Flight {
    
    public Flight() {
    }
    

    @Test
     public void getFlight() {
        try {
            CreateItineraryRequest request = new CreateItineraryRequest();
           request.setCustomerID("11");
           CreateItineraryResponse response = createItineraryTravelGoodOperation(request);
           assertNotNull(request);
           assertFalse(response.getItineraryID().isEmpty());
           System.out.println(response.getItineraryID());

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
        } catch (GetFlightTravelGoodOperationFault ex) {
            Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static FlightList getFlightTravelGoodOperation(wsdl.GetFlightRequest getFlightInput) throws GetFlightTravelGoodOperationFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getFlightTravelGoodOperation(getFlightInput);
    }


    private static CreateItineraryResponse createItineraryTravelGoodOperation(wsdl.CreateItineraryRequest createItineraryInput) {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.createItineraryTravelGoodOperation(createItineraryInput);
    }
}
