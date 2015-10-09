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
import wsdl.AddHotelRequest;
import wsdl.AddHotelResponse;
import wsdl.CreateItineraryRequest;
import wsdl.CreateItineraryResponse;
import wsdl.GetHotelRequest;
import wsdl.GetHotelTravelGoodOperationFault;
import wsdl.Hotellist;

/**
 *
 * @author Alina GHERMAN<alinagherman@hotmail.fr>
 */
public class Hotel {
    
    public Hotel() {
    }

    @Test
    public void getHotel() {
        try {
            //create itinerary
              CreateItineraryRequest request = new CreateItineraryRequest();
              request.setCustomerID("11");
              CreateItineraryResponse response = createItineraryTravelGoodOperation(request);
              assertNotNull(request);
              assertFalse(response.getItineraryID().isEmpty());
              System.out.println(response.getItineraryID());
        GetHotelRequest hotelRequest = new GetHotelRequest();
                  hotelRequest.setCity("Lorient");
                  hotelRequest.setArrivalDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 01, 15, 0));
                  hotelRequest.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 11, 4, 0));
                  hotelRequest.setItineraryID(response.getItineraryID());
                  Hotellist list = new Hotellist();
                  list = getHotelTravelGoodOperation(hotelRequest);
                  assertEquals(false, list.getNewElement().isEmpty());
        } catch (GetHotelTravelGoodOperationFault ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static CreateItineraryResponse createItineraryTravelGoodOperation(wsdl.CreateItineraryRequest createItineraryInput) {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.createItineraryTravelGoodOperation(createItineraryInput);
    }

    private static Hotellist getHotelTravelGoodOperation(wsdl.GetHotelRequest getHotelInput) throws GetHotelTravelGoodOperationFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getHotelTravelGoodOperation(getHotelInput);
    }
}
