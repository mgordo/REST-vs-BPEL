/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.resource;

import dk.dtu.imm.fastmoney.types.CreditCardInfoType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import niceview.Bookfault;
import niceview.CancelFault;
import ws.dtu.client.BookFlightFault;
import ws.dtu.client.CancelFlightFaultMessage;
import ws.dtu.client.ExpirationDateType;
import ws.dtu.entity.BookedFlightEntity;
import ws.dtu.entity.BookedHotelEntity;
import ws.dtu.entity.FlightInfoEntity;
import ws.dtu.entity.HotelInfoEntity;
import ws.dtu.entity.ItineraryEntity;
import ws.dtu.representation.ItineraryRepresentation;
import ws.dtu.representation.Link;
import ws.dtu.representation.Representation;
import ws.dtu.representation.StatusRepresentation;
import ws.dtu.utils.Constants;


@Path("itineraries/{iid}")
public class ItineraryResource {

    /*
     * Attributes
     */
    static Map<String, ItineraryEntity> itineraries = new HashMap<String, ItineraryEntity>();
    
    /*
     * This operation is used to get informations about the flights
     * @return list of flights
     */
    static void reset() {
        itineraries = new HashMap<String, ItineraryEntity>();
    }
    
    /**
    *
    * @author miguel
    */
    @GET
    @Produces(Constants.MEDIATYPE_XML)
    public Response getItinerary(
            @PathParam("iid") String iid ) {
        
        
        ItineraryEntity itinerary = itineraries.get(iid);
        if(itinerary == null){
             return Response.
                    status(Response.Status.NOT_FOUND).
                    entity(Constants.MSG_ITINERARY_NOT_FOUND).
                    build();
        }
        
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH) , cal.get(Calendar.DAY_OF_MONTH)-1);
        
        if(itinerary.getFirstDate().compareTo(cal.getTime())<=0){
           itineraries.remove(iid);
           return Response.status(Response.Status.NOT_FOUND)
                    .entity("Itinerary already started!")
                    .build();
        }
        
        ItineraryRepresentation itineraryRep = new ItineraryRepresentation();
        itineraryRep.setItinerary(itineraries.get(iid));
        
        
        addSelfLink(iid, itineraryRep);
        ItineraryResource.addFlightAddLink(iid, itineraryRep);
        HotelResource.getHotelInfoLink(iid, itineraryRep);
        FlightResource.getFlightInfoLink(iid, itineraryRep);
        ItineraryResource.addHotelAddLink(iid, itineraryRep);
        bookItineraryLink(iid, itineraryRep);
        
        
        
        return Response.ok(itineraryRep).build();
    }

    /**
     *
    * @author diego
    */
    @Path("/flightadd")
    @PUT
    @Consumes(Constants.MEDIATYPE_XML)
    @Produces(Constants.MEDIATYPE_XML)
    public Response addFlight(
            @PathParam("iid") String iid,
            FlightInfoEntity flight){
        
        ItineraryEntity itinerary = itineraries.get(iid);
        if(itinerary == null){
             return Response.
                    status(Response.Status.NOT_FOUND).
                    entity(Constants.MSG_ITINERARY_NOT_FOUND).
                    build();
        }
        
        
        itinerary.getFlightsList().add(new BookedFlightEntity(Constants.STATUS_UNCONFIRMED, flight));

        StatusRepresentation statusrep = new StatusRepresentation();

        statusrep.setStatus("OK");
        
        addSelfLink(iid, statusrep);
        ItineraryResource.addFlightAddLink(iid, statusrep);
        HotelResource.getHotelInfoLink(iid, statusrep);
        FlightResource.getFlightInfoLink(iid, statusrep);
        ItineraryResource.addHotelAddLink(iid, statusrep);
        bookItineraryLink(iid, statusrep);
        
        if(itinerary.getFirstDate() == null){/*First booking in the itinerary*/
            itinerary.setFirstDate(flight.getFlight().getDateLiftOf());
        }else{
            if(flight.getFlight().getDateLiftOf().compareTo(itinerary.getFirstDate())<0)
                itinerary.setFirstDate(flight.getFlight().getDateLiftOf());
        }
 
        return Response.ok(statusrep).build();
        
    }
    
    /**
    *
    * @author miguel
    */
    @Path("/hoteladd")
    @PUT
    @Consumes(Constants.MEDIATYPE_XML)
    @Produces(Constants.MEDIATYPE_XML)
    public Response addHotel( 
            @PathParam("iid") String iid, 
            HotelInfoEntity hotel){
        
        ItineraryEntity itinerary = itineraries.get(iid);
        if(itinerary == null){
             return Response.
                    status(Response.Status.NOT_FOUND).
                    entity(Constants.MSG_ITINERARY_NOT_FOUND).
                    build();
        }
        
        
        
        itinerary.getHotelList().add(new BookedHotelEntity(Constants.STATUS_UNCONFIRMED, hotel));
        ItineraryRepresentation itineraryRep = new ItineraryRepresentation();
        itineraryRep.setItinerary(itinerary);
        
        StatusRepresentation statusrep = new StatusRepresentation();
        statusrep.setStatus("OK");
        
        addSelfLink(iid, statusrep);
        ItineraryResource.addFlightAddLink(iid, statusrep);
        HotelResource.getHotelInfoLink(iid, statusrep);
        FlightResource.getFlightInfoLink(iid, statusrep);
        addHotelAddLink(iid, statusrep);
        bookItineraryLink(iid, statusrep);

        if(itinerary.getFirstDate() == null){/*First booking in the itinerary*/
            itinerary.setFirstDate(hotel.getArrivalDate());
        }else{
            if(hotel.getArrivalDate().compareTo(itinerary.getFirstDate())<0)
                itinerary.setFirstDate(hotel.getArrivalDate());
        }

        return Response.ok(statusrep).build();
    }
    
    /**
    *
    * @author miguel
    */
    @Path("/book")
    @PUT
    @Consumes(Constants.MEDIATYPE_XML)
    @Produces(Constants.MEDIATYPE_XML)
    public Response bookItinerary( @PathParam("iid") String iid, 
            CreditCardInfoType credit){
        
        
        ItineraryEntity itinerary = itineraries.get(iid);
        if(itinerary == null){
             return Response.
                    status(Response.Status.NOT_FOUND).
                    entity(Constants.MSG_ITINERARY_NOT_FOUND).
                    build();
        }
        ArrayList<BookedHotelEntity> bookedHotels = new ArrayList<BookedHotelEntity>();
        for(BookedHotelEntity hot:itinerary.getHotelList()){
            org.netbeans.xml.schema.hotelschema.Bookarg part1 = new org.netbeans.xml.schema.hotelschema.Bookarg();
            part1.setValidatecc(credit);
            part1.setBookreference(hot.getHotelInfoEntity().getBookingNumber());
            try {
                bookHotel(part1);
                hot.setStatus(Constants.STATUS_CONFIRMED);
                bookedHotels.add(hot);
            } catch (Bookfault ex) {
                /*Fault handling*/
                BookedHotelEntity hotcancel=new BookedHotelEntity();
                for(int i=0; i< bookedHotels.size();i++){
                    try {
                        hotcancel= bookedHotels.get(i);
                        cancelHotel(hotcancel.getHotelInfoEntity().getBookingNumber());
                        hotcancel.setStatus(Constants.STATUS_CANCELLED);
                    } catch (CancelFault ex1) {
                        /*WHAT TO DO IN THIS CASE!*/
                        return Response.
                            status(Response.Status.INTERNAL_SERVER_ERROR).
                            entity("Exception while cancelling hotels! Cause: "+ ex1.getFaultInfo()).
                            build();
                    }
                }
                
                return Response.
                       status(Response.Status.INTERNAL_SERVER_ERROR).
                       entity("Error booking Hotels! Cause: "+ex.getFaultInfo()).
                       build();
            }
        }
        ArrayList<BookedFlightEntity> bookedFlights = new ArrayList<BookedFlightEntity>();
        BookedFlightEntity fli=new BookedFlightEntity();
          for(int i=0; i< itinerary.getFlightsList().size();i++){
            ws.dtu.client.CreditCardInfoType creditcard = translate(credit);
          
            try {
                fli=itinerary.getFlightsList().get(i);
                bookFlight(fli.getFlightInformation().getBookingNumber(),creditcard);
                fli.setStatus(Constants.STATUS_CONFIRMED);
                bookedFlights.add(fli);
            } catch (BookFlightFault ex) {
                /*Cancel previously booked flights*/
                for(BookedFlightEntity flicancel:bookedFlights){
                    try {
                        cancelFlight(flicancel.getFlightInformation().getBookingNumber()
                                , flicancel.getFlightInformation().getPrice()
                                , creditcard);
                        flicancel.setStatus(Constants.STATUS_CANCELLED);
                    } catch (CancelFlightFaultMessage ex1) {
                        return Response.
                            status(Response.Status.INTERNAL_SERVER_ERROR).
                            entity("Exception while cancelling flights! Cause: "+ ex1.getFaultInfo()).
                            build();
                    }
                }
                
                /*Now cancel the previously booked hotels!*/
                for(BookedHotelEntity hotcancel:bookedHotels){
                    try {
                        cancelHotel(hotcancel.getHotelInfoEntity().getBookingNumber());
                        hotcancel.setStatus(Constants.STATUS_CANCELLED);
                    } catch (CancelFault ex1) {
                        /*WHAT TO DO IN THIS CASE!*/
                        return Response.
                            status(Response.Status.INTERNAL_SERVER_ERROR).
                            entity("Exception while cancelling hotels! Cause: "+ ex1.getFaultInfo()).
                            build();
                    }
                }
                
                return Response.
                       status(Response.Status.INTERNAL_SERVER_ERROR).
                       entity("Error booking Flights! Cause: "+ex.getFaultInfo()).
                       build();
                
            }
        }
        
        itinerary.setItineraryStatus(Constants.STATUS_CONFIRMED);
        StatusRepresentation statusrep = new StatusRepresentation();
        statusrep.setStatus("Booked succesfully!");
        
        addSelfLink(iid, statusrep);
        addCancelLink(iid,statusrep);
        
        
        return Response.ok(statusrep).build();
    
    
    }
    /**
     *
     * @author diego
    */
    @Path("/cancel")
    @PUT
    @Consumes(Constants.MEDIATYPE_XML)
    @Produces(Constants.MEDIATYPE_XML)
    public Response cancelItinerary(@PathParam("iid") String iid, 
        CreditCardInfoType credit){
        
        ItineraryEntity it = ItineraryResource.itineraries.get(iid);
        if(it == null){/*The itinerary does not exists*/
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Non existing itinerary")
                    .build();
        }
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH) , cal.get(Calendar.DAY_OF_MONTH)-1);
        
        if(it.getFirstDate().compareTo(cal.getTime())<=0){
           itineraries.remove(iid);
           return Response.status(Response.Status.NOT_FOUND)
                    .entity("Itinerary already started!")
                    .build();
        }
        
        /*If itinerary is not booked fault*/
        if(!it.getItineraryStatus().equals(Constants.STATUS_CONFIRMED)){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Itinerary: "+it.getItineraryStatus()+ " unable to cancel it")
                    .build();
        }
        
        /*If there's some problem, we need to continue canceling and at the end,
         we should return a fault*/
        boolean error=false;
        
        Iterator<BookedFlightEntity> iterator = it.getFlightsList().iterator();
        while(iterator.hasNext()){
            
            BookedFlightEntity flight = iterator.next();
            if(flight.getStatus().equals(Constants.STATUS_CONFIRMED)){
                try {
                    /*We only try to cancel if it's already booked*/
                    cancelFlight(flight.getFlightInformation().getBookingNumber(), flight.getFlightInformation().getPrice(), translate(credit));
                    flight.setStatus(Constants.STATUS_CANCELLED);
                } catch (CancelFlightFaultMessage ex) {
                    error = true;
                }
            }
        }
        
        Iterator<BookedHotelEntity> iterator2 = it.getHotelList().iterator();
        while(iterator2.hasNext()){
            
            BookedHotelEntity hotel = iterator2.next();
            if(hotel.getStatus().equals(Constants.STATUS_CONFIRMED)){
                try {
                    /*We only try to cancel if it's already booked*/
                    cancelHotel(hotel.getHotelInfoEntity().getBookingNumber());
                    hotel.setStatus(Constants.STATUS_CANCELLED);
                } catch (CancelFault ex) {
                    error = true;
                }
            }
        }
        
        /**
         * If there's been an error, we should inform the client,
         * that there are some parts of the itinerary which are still
         * booked
         */
        StatusRepresentation stat=new StatusRepresentation();
        if(error == true){
            /*The itinerary status DOESN'T change, the user could want to try to cancel it later*/
            stat.setStatus("There's been a problem with some reservations, please check your itinerary");
            addSelfLink(iid,stat);
            addCancelLink(iid,stat);
            return Response.status(Response.Status.NOT_MODIFIED)
                    .entity(stat)
                    .build();
        }
        
        it.setItineraryStatus(Constants.STATUS_CANCELLED);
        stat.setStatus("Itinerary canceled");
        addSelfLink(iid,stat);
        
        return Response.status(Response.Status.OK)
                    .entity(stat)
                    .build();
    }
     
    /***********************************************************************
     * Helpers for links
     * @param cid
     * @param oid
     * @param response 
     ************************************************************************/
    
      static void addSelfLink(String iid, Representation response) {
        Link link = new Link();
        link.setUri(String.format("%s/%s", Constants.BASE_ITINERARIES_URI, iid));
        link.setRel(Constants.ITINERARY_RELATION);
        response.getLinks().add(link);
    }
      static void addFlightAddLink(String iid, Representation response){
         Link link = new Link();
        link.setUri(String.format("%s/%s/flightadd", Constants.BASE_ITINERARIES_URI, iid));
        link.setRel(Constants.FLIGHTADD_RELATION);
        response.getLinks().add(link);
     } 
      static void addHotelAddLink(String iid, Representation response){
         Link link = new Link();
        link.setUri(String.format("%s/%s/hoteladd", Constants.BASE_ITINERARIES_URI, iid));
        link.setRel(Constants.HOTELADD_RELATION);
        response.getLinks().add(link);
     } 
      static void bookItineraryLink(String iid, Representation response){
         Link link = new Link();
        link.setUri(String.format("%s/%s/book", Constants.BASE_ITINERARIES_URI, iid));
        link.setRel(Constants.BOOKITINERARY_RELATION);
        response.getLinks().add(link);
     }
     static void addCancelLink(String iid, Representation response) {
        Link link = new Link();
        link.setUri(String.format("%s/%s/cancel", Constants.BASE_ITINERARIES_URI, iid));
        link.setRel(Constants.CANCEL_RELATION);
        response.getLinks().add(link);
    }
    private static boolean bookFlight(int bookingnumber, ws.dtu.client.CreditCardInfoType creditcard) throws BookFlightFault {
        ws.dtu.client.LameDuckService service = new ws.dtu.client.LameDuckService();
        ws.dtu.client.LameDuckPortType port = service.getLameDuckPortTypeBindingPort();
        return port.bookFlight(bookingnumber, creditcard);
    }
    private static boolean cancelFlight(int bookingnumber1, int price1, ws.dtu.client.CreditCardInfoType credircardinfo1) throws CancelFlightFaultMessage {
        ws.dtu.client.LameDuckService service = new ws.dtu.client.LameDuckService();
        ws.dtu.client.LameDuckPortType port = service.getLameDuckPortTypeBindingPort();
        return port.cancelFlight(bookingnumber1, price1, credircardinfo1);
    }
    private static boolean bookHotel(org.netbeans.xml.schema.hotelschema.Bookarg part1) throws Bookfault {
        niceview.NiceViewService service = new niceview.NiceViewService();
        niceview.NiceViewPortType port = service.getNiceViewPortTypeBindingPort();
        return port.bookHotel(part1);
    }
    private static boolean cancelHotel(int part1) throws CancelFault {
        niceview.NiceViewService service = new niceview.NiceViewService();
        niceview.NiceViewPortType port = service.getNiceViewPortTypeBindingPort();
        return port.cancelHotel(part1);
    }
    /**
     * This method translates a dk.dtu.imm.fastmoney.types.ExpirationDateType credit into
     * a ws.dtu.client.CreditCardInfoType
     * @param credit is the dk.dtu.imm.fastmoney.types.ExpirationDateType to be converted
     * @return ws.dtu.client.CreditCardInfoType object
     */
    private ws.dtu.client.CreditCardInfoType translate(CreditCardInfoType credit) {
        
        ws.dtu.client.CreditCardInfoType resp = new ws.dtu.client.CreditCardInfoType();
        ExpirationDateType t = new ExpirationDateType();
        dk.dtu.imm.fastmoney.types.ExpirationDateType ss = credit.getExpirationDate();
        t.setMonth(credit.getExpirationDate().getMonth());
        t.setYear(credit.getExpirationDate().getYear());
        resp.setExpirationDate(t);
        resp.setName(credit.getName());
        resp.setNumber(credit.getNumber());
        return resp;
        
    }
       
}
