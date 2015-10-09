/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.resource;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ws.dtu.entity.ItineraryEntity;
import ws.dtu.representation.StatusRepresentation;
import ws.dtu.utils.Constants;

/**
 *
 * @author diego
 */

@Path("login/{cid}")
public class LoginResource {
    
    static int actualit=0;
    
    @PUT
    @Produces(Constants.MEDIATYPE_XML)
    public Response login(@PathParam("cid") String user){
        
        if(user == null){
             return Response.
                    status(Response.Status.NOT_FOUND).
                    entity(Constants.MSG_ITINERARY_NOT_FOUND).
                    build();
        }
        
        actualit++;
        ItineraryResource.itineraries.put(String.valueOf(actualit), new ItineraryEntity());
        StatusRepresentation statusrep = new StatusRepresentation();
        statusrep.setStatus(String.valueOf(actualit));
        /*6 Links*/
        ItineraryResource.addSelfLink(String.valueOf(actualit), statusrep);
        FlightResource.getFlightInfoLink(String.valueOf(actualit), statusrep);
        ItineraryResource.addFlightAddLink(String.valueOf(actualit), statusrep);
        HotelResource.getHotelInfoLink(String.valueOf(actualit), statusrep);
        ItineraryResource.addHotelAddLink(String.valueOf(actualit), statusrep);
        
        
        ItineraryResource.addFlightAddLink(String.valueOf(actualit),statusrep);
        return Response.ok(statusrep).build();
        
        
    }
    
    
    
    
    
    
}
