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
import wsdl.AddHotelRequest;
import wsdl.AddHotelResponse;
import wsdl.AddHotelTravelGoodFault;
import wsdl.BookItineraryRequest;
import wsdl.BookItineraryResponse;
import wsdl.BookItineraryTravelGoodFault;
import wsdl.CancelItineraryFault;
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
 * @author Diego
 */
public class SmallTest {


   
 @Test
    public void testSmall() throws Exception{
        //create itinerary
        CreateItineraryRequest request = new CreateItineraryRequest();
        request.setCustomerID("11");
        CreateItineraryResponse response = createItineraryTravelGoodOperation(request);
        assertNotNull(request);
        assertFalse(response.getItineraryID().isEmpty());
        BookItineraryRequest brequest = new BookItineraryRequest();
        brequest.setItineraryID(response.getItineraryID());
        
        bookItineraryTravelGoodOperation(brequest);
        GetItineraryRequest irequest = new GetItineraryRequest();
        
        irequest.setItineraryID(response.getItineraryID());
        getItineraryOperation(irequest);
                
 
 }
 
    private static AddFlightResponse addFlightTravelGoodOperation(wsdl.AddFlightRequest addFlightInput) throws AddFlightTravelGoodFault, InterruptedException {
        System.out.println("Sleeping..."+addFlightInput.getItineraryID());
        //Thread.sleep(2000);
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addFlightTravelGoodOperation(addFlightInput);
    }

    private static AddHotelResponse addHotelTravelGoodlOperation(wsdl.AddHotelRequest addHotelInput) throws AddHotelTravelGoodFault, InterruptedException {
        System.out.println("Sleeping..."+addHotelInput.getItineraryID());
        //Thread.sleep(2000);
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addHotelTravelGoodlOperation(addHotelInput);
    }

    private static BookItineraryResponse bookItineraryTravelGoodOperation(wsdl.BookItineraryRequest bookItineraryInput) throws BookItineraryTravelGoodFault, InterruptedException {
        System.out.println("Sleeping..."+bookItineraryInput.getItineraryID());
        //Thread.sleep(2000);
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.bookItineraryTravelGoodOperation(bookItineraryInput);
    }


    private static CreateItineraryResponse createItineraryTravelGoodOperation(wsdl.CreateItineraryRequest createItineraryInput) throws InterruptedException {
        
        System.out.println("Sleeping..."+createItineraryInput.getCustomerID());
        //Thread.sleep(2000);
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.createItineraryTravelGoodOperation(createItineraryInput);
    }

    private static FlightList getFlightTravelGoodOperation(wsdl.GetFlightRequest getFlightInput) throws GetFlightTravelGoodOperationFault, InterruptedException {
        System.out.println("Sleeping..."+getFlightInput.getItineraryID());
        //Thread.sleep(2000);
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getFlightTravelGoodOperation(getFlightInput);
    }

    private static Hotellist getHotelTravelGoodOperation(wsdl.GetHotelRequest getHotelInput) throws GetHotelTravelGoodOperationFault, InterruptedException {
        System.out.println("Sleeping..."+getHotelInput.getItineraryID());
        //Thread.sleep(2000);
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getHotelTravelGoodOperation(getHotelInput);
    }

    private static GetItineraryResponse getItineraryOperation(wsdl.GetItineraryRequest getItineraryInput) throws InterruptedException {
        System.out.println("Sleeping..."+getItineraryInput.getItineraryID());
        //Thread.sleep(2000);
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getItineraryOperation(getItineraryInput);
    }


}
