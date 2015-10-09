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
import ws.dtu.client.FlightList;
import ws.dtu.entity.FlightEntity;
import ws.dtu.entity.FlightInfoEntity;
import ws.dtu.representation.FlightRepresentation;
import ws.dtu.representation.Link;
import ws.dtu.representation.Representation;
import ws.dtu.utils.Constants;


/**
 *
 * @author veve
 */
@Path("flights/{iid}")
public class FlightResource {

    
    
    
    @GET
    @Produces(Constants.MEDIATYPE_XML)
    public Response getFlights(
            @PathParam("iid") String iid,
            @QueryParam("start") String startPoint,
            @QueryParam("destination") String destinationPoint,
            @QueryParam("date") String dateString) {

        //get the date in the good format for lameDuck
        
        
        
        
        Date dob;
        DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
        XMLGregorianCalendar xmlDate = null;
        try {
            dob = df.parse(dateString);
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(dob);
            xmlDate = DatatypeFactory
                    .newInstance()
                    .newXMLGregorianCalendarDate(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH) + 1,
                    cal.get(Calendar.DAY_OF_MONTH),
                    DatatypeConstants.FIELD_UNDEFINED);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(FlightResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        } catch (ParseException ex) {
            Logger.getLogger(FlightResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        //call LameDuck for getting the flights and put the in the TravelGood Entity
        List<FlightInfoEntity> listFlights = new ArrayList<FlightInfoEntity>();
        FlightList flightListDuck = getFlights(startPoint,destinationPoint,xmlDate);
        for (FlightList.FlightInformation fDuck : flightListDuck.getFlightInformation()) {
            FlightEntity f1 = new FlightEntity(
                    fDuck.getFlight().getStartAirport(),
                    fDuck.getFlight().getDestinationAirport(),
                    fDuck.getFlight().getLiftOffDate().toGregorianCalendar().getTime(),
                    fDuck.getFlight().getLandingDate().toGregorianCalendar().getTime(),
                    fDuck.getFlight().getCarrier());
            listFlights.add(new FlightInfoEntity(fDuck.getBookingNumber(),
                    fDuck.getPrice(),
                    fDuck.getAirline(),
                    f1));
        }
        
        if (listFlights == null) {
            return Response.
                    status(Response.Status.NOT_FOUND).
                    entity(Constants.MSG_NO_FLIGHT_FOUND).
                    build();
        }

        FlightRepresentation flightRep = new FlightRepresentation();
        flightRep.setFlight(listFlights);
        /*6 Links*/
        getFlightInfoLink(iid, flightRep);
        ItineraryResource.addSelfLink(iid, flightRep);
        ItineraryResource.addFlightAddLink(iid, flightRep);
        HotelResource.getHotelInfoLink(iid,flightRep);
        ItineraryResource.addHotelAddLink(iid, flightRep);
        ItineraryResource.bookItineraryLink(iid, flightRep);


        return Response.ok(flightRep).build();
    }

    static void getFlightInfoLink(String iid,Representation response){
         Link link = new Link();
        link.setUri(String.format("%s/%s", Constants.BASE_FLIGHT_URI, iid));
        link.setRel(Constants.GETFLIGHT_RELATION);
        response.getLinks().add(link);
     }
    
    
    
    private static FlightList getFlights(java.lang.String source, java.lang.String destination, javax.xml.datatype.XMLGregorianCalendar date) {
        ws.dtu.client.LameDuckService service = new ws.dtu.client.LameDuckService();
        ws.dtu.client.LameDuckPortType port = service.getLameDuckPortTypeBindingPort();
        return port.getFlights(source, destination, date);
    }

}
