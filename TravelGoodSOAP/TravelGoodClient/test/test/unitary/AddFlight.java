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
import wsdl.AddFlightRequest;
import wsdl.AddFlightResponse;
import wsdl.AddFlightTravelGoodFault;
import wsdl.CreateItineraryRequest;
import wsdl.CreateItineraryResponse;
import wsdl.Flight;
import wsdl.FlightList;
import wsdl.GetFlightRequest;
import wsdl.GetFlightTravelGoodOperationFault;

/**
 *
 * @author Alina GHERMAN<alinagherman@hotmail.fr>
 */
public class AddFlight {
    
    public AddFlight() {
    }
    
    
    @Test
     public void addFlight() {
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
               assertEquals(result.getFlightInformation().size(), 1);
               assertEquals(result.getFlightInformation().get(0).getAirline(), "SAS");
               assertEquals(result.getFlightInformation().get(0).getBookingNumber(), 1);
               assertEquals(result.getFlightInformation().get(0).getPrice(), 100);
               assertEquals(result.getFlightInformation().get(0).getFlight().getDestinationAirport(), "MAD");
               assertEquals(result.getFlightInformation().get(0).getFlight().getStartAirport(), "CPH");
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
        } catch (AddFlightTravelGoodFault ex) {
            Logger.getLogger(AddFlight.class.getName()).log(Level.SEVERE, null, ex);
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

    private static AddFlightResponse addFlightTravelGoodOperation(wsdl.AddFlightRequest addFlightInput) throws AddFlightTravelGoodFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addFlightTravelGoodOperation(addFlightInput);
    }
}
