/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.resource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.netbeans.xml.schema.hotelschema.Get;
import org.netbeans.xml.schema.hotelschema.Hotel;
import org.netbeans.xml.schema.hotelschema.Hotellist;
import ws.dtu.entity.HotelInfoEntity;
import ws.dtu.representation.HotelRepresentation;
import ws.dtu.representation.Link;
import ws.dtu.representation.Representation;
import ws.dtu.utils.Constants;

/**
 *
 * @author Pierre-Emmanuel
 */

@Path("hotels/{iid}")
public class HotelResource {
    
    @GET
    @Produces(Constants.MEDIATYPE_XML)
    public Response getHotels(
            @PathParam("iid") String iid,
            @QueryParam("arrival") String arrivalDate,
            @QueryParam("departure") String departureDate,
            @QueryParam("city") String hotelLocation) {

        //get the dates in the good format for NiceView
          
        Date ad;
        Date dd;
        DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
        XMLGregorianCalendar xmlDateArr = null;
        XMLGregorianCalendar xmlDateDep = null;
        try {
            ad = df.parse(arrivalDate);
            dd = df.parse(departureDate);
            GregorianCalendar cal1 = new GregorianCalendar();
            GregorianCalendar cal2 = new GregorianCalendar();
            cal1.setTime(ad);
            cal2.setTime(dd);
            xmlDateArr = DatatypeFactory
                    .newInstance()
                    .newXMLGregorianCalendarDate(cal1.get(Calendar.YEAR),
                    cal1.get(Calendar.MONTH) + 1,
                    cal1.get(Calendar.DAY_OF_MONTH),
                    0);
            xmlDateDep = DatatypeFactory
                    .newInstance()
                    .newXMLGregorianCalendarDate(cal2.get(Calendar.YEAR),
                    cal2.get(Calendar.MONTH) + 1,
                    cal2.get(Calendar.DAY_OF_MONTH),
                    0);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(HotelResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        } catch (ParseException ex) {
            Logger.getLogger(HotelResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
       
        List<HotelInfoEntity> listHotels = new ArrayList<HotelInfoEntity>();
        Get get = new Get();
        get.setArrival(xmlDateArr);
        get.setDeparture(xmlDateDep);
        get.setCity(hotelLocation);
        //call niceview      
        Hotellist hotelListView = getHotel(get);
      for (Hotel hView : hotelListView.getNewElement()) {
            

                    
            HotelInfoEntity infoHotel = new HotelInfoEntity(hView.getName(),
            hView.getAddress(), 
            hView.getBooknumber(),
            hView.getPrice(),
            hView.isGuarantee(), 
            hView.getReservationService(),
            hView.getCity(),
                    hView.getStartperiod().toGregorianCalendar().getTime(),
                    hView.getEndperiod().toGregorianCalendar().getTime());
            listHotels.add(infoHotel);
        }
        
        if (listHotels == null || listHotels.size() == 0) {
            return Response.
                    status(Response.Status.NOT_FOUND).
                    entity(Constants.MSG_NO_HOTEL_FOUND).
                    build();
        }

        HotelRepresentation hotelRep = new HotelRepresentation();
        hotelRep.setHotel(listHotels);
        /*6 Links*/
        ItineraryResource.addSelfLink(iid, hotelRep);
        ItineraryResource.addFlightAddLink(iid, hotelRep);
        getHotelInfoLink(iid, hotelRep);
        FlightResource.getFlightInfoLink(iid, hotelRep);
        ItineraryResource.addHotelAddLink(iid, hotelRep);
        ItineraryResource.bookItineraryLink(iid, hotelRep);
        

        return Response.ok(hotelRep).build();
    }

    static void getHotelInfoLink(String iid, Representation response) {
        Link link = new Link();
        link.setUri(String.format("%s/%s", Constants.BASE_HOTEL_URI, iid));
        link.setRel(Constants.GETHOTEL_RELATION);
        response.getLinks().add(link);
    }

    private static Hotellist getHotel(org.netbeans.xml.schema.hotelschema.Get part1) {
        niceview.NiceViewService service = new niceview.NiceViewService();
        niceview.NiceViewPortType port = service.getNiceViewPortTypeBindingPort();
        return port.getHotel(part1);
    }
}
