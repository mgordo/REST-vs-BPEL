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
import wsdl.AddHotelTravelGoodFault;
import wsdl.CreateItineraryRequest;
import wsdl.CreateItineraryResponse;
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
public class Itinerary {
    
    public Itinerary() {
    }
    
     @Test
    public void itineraryEmpty() throws InterruptedException {
        //create itinerary
        CreateItineraryRequest request = new CreateItineraryRequest();
        request.setCustomerID("11");
        CreateItineraryResponse response = createItineraryTravelGoodOperation(request);
        assertNotNull(request);
        assertFalse(response.getItineraryID().isEmpty());
        System.out.println(response.getItineraryID());
     }
     
      @Test
        public void getitineraryEmpty() throws InterruptedException {
        //create itinerary
        CreateItineraryRequest request = new CreateItineraryRequest();
        request.setCustomerID("11");
        CreateItineraryResponse response = createItineraryTravelGoodOperation(request);
        assertNotNull(request);
        assertFalse(response.getItineraryID().isEmpty());
        System.out.println(response.getItineraryID());
        GetItineraryRequest requestItinerary = new GetItineraryRequest();
        requestItinerary.setItineraryID(response.getItineraryID());     
        GetItineraryResponse responseItinerary = getItineraryOperation(requestItinerary);
        assertNotNull(responseItinerary);
        
        
        
     }
           @Test
        public void get2itineraryEmpty() throws InterruptedException {
        try {
            //create itinerary
            System.out.println("Entre en get2");
            CreateItineraryRequest request = new CreateItineraryRequest();
            request.setCustomerID("11");
            CreateItineraryResponse response = createItineraryTravelGoodOperation(request);
            assertNotNull(request);
            assertFalse(response.getItineraryID().isEmpty());
            System.out.println(response.getItineraryID());
            GetItineraryRequest requestItinerary = new GetItineraryRequest();
            requestItinerary.setItineraryID(response.getItineraryID()); 
                
            GetItineraryResponse responseItinerary = getItineraryOperation(requestItinerary);
            assertNotNull(responseItinerary);
                         GetHotelRequest hotelRequest = new GetHotelRequest();
                hotelRequest.setCity("Lorient");
                hotelRequest.setArrivalDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 01, 15, 0));
                hotelRequest.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 11, 4, 0));
                hotelRequest.setItineraryID(response.getItineraryID());
                Hotellist list = new Hotellist();
                list = getHotelTravelGoodOperation(hotelRequest);
                assertEquals(false, list.getNewElement().isEmpty());
                Hotel h1 = new Hotel();
                h1.setAddress(list.getNewElement().get(0).getAddress());
                h1.setBooknumber(list.getNewElement().get(0).getBooknumber());
                h1.setCity(list.getNewElement().get(0).getCity());
                h1.setEndperiod(list.getNewElement().get(0).getEndperiod());
                h1.setGuarantee(list.getNewElement().get(0).isGuarantee());
                h1.setName(list.getNewElement().get(0).getName());
                h1.setPrice(list.getNewElement().get(0).getPrice());
                h1.setReservationService(list.getNewElement().get(0).getReservationService());
                h1.setStartperiod(list.getNewElement().get(0).getStartperiod());
                AddHotelRequest requestAddHotels1 = new AddHotelRequest();
                requestAddHotels1.setItineraryID(response.getItineraryID());
                requestAddHotels1.setHotelInfo(h1);
                AddHotelResponse responseAddHotel2;
                responseAddHotel2 = addHotelTravelGoodlOperation(requestAddHotels1);
                assertNotNull(responseAddHotel2);
                assertTrue(responseAddHotel2.isAddHotelConfirmation());
                 GetItineraryResponse responseItinerary1 = getItineraryOperation(requestItinerary);
                assertNotNull(responseItinerary1);
        } catch (GetHotelTravelGoodOperationFault ex) {
            Logger.getLogger(Itinerary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AddHotelTravelGoodFault ex) {
            Logger.getLogger(Itinerary.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        } 
           }
    private static AddHotelResponse addHotelTravelGoodlOperation(wsdl.AddHotelRequest addHotelInput) throws AddHotelTravelGoodFault, InterruptedException {
        //Thread.sleep(2000);
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addHotelTravelGoodlOperation(addHotelInput);
    }
       
       private static CreateItineraryResponse createItineraryTravelGoodOperation(wsdl.CreateItineraryRequest createItineraryInput) throws InterruptedException {
        //Thread.sleep(2000);
           wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.createItineraryTravelGoodOperation(createItineraryInput);
    }  
        
          private static GetItineraryResponse getItineraryOperation(wsdl.GetItineraryRequest getItineraryInput) throws InterruptedException {
        //Thread.sleep(2000);
              wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getItineraryOperation(getItineraryInput);
    }

    private static Hotellist getHotelTravelGoodOperation(wsdl.GetHotelRequest getHotelInput) throws GetHotelTravelGoodOperationFault, InterruptedException {
        
        //Thread.sleep(2000);
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getHotelTravelGoodOperation(getHotelInput);
    }
}