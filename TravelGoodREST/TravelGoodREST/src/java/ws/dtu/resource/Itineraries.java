/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.resource;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Diego
 */
@Path("itineraries/reset")
public class Itineraries {
   

    @PUT
    public Response reset(){
        ItineraryResource.reset();
        return Response.ok().build();
    }
}
