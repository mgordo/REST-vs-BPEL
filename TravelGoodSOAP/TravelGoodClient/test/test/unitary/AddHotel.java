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
import wsdl.Hotel;
import wsdl.Hotellist;

/**
 *
 * @author Alina GHERMAN<alinagherman@hotmail.fr>
 */
public class AddHotel {

    public AddHotel() {
    }

    @Test
    public void addHotelWithoutGet() {
        try {
            CreateItineraryRequest request = new CreateItineraryRequest();
           request.setCustomerID("121230");
           CreateItineraryResponse response= createItineraryTravelGoodOperation(request);
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
       
              responseAddHotel=addHotelTravelGoodlOperation(requestAddHotels);
              assertNotNull(responseAddHotel);
              assertTrue(responseAddHotel.isAddHotelConfirmation());
        } catch (AddHotelTravelGoodFault ex) {
            Logger.getLogger(AddHotel.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }

   // @Test
    public void addHotelWithGet() {
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
        } catch (AddHotelTravelGoodFault ex) {
            Logger.getLogger(AddHotel.class.getName()).log(Level.SEVERE, null, ex);
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

    private static AddHotelResponse addHotelTravelGoodlOperation(wsdl.AddHotelRequest addHotelInput) throws AddHotelTravelGoodFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addHotelTravelGoodlOperation(addHotelInput);
    }
}
