package resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import entity.FlightEntity;
import entity.FlightInfoEntity;

/**
 *
 * @author veve
 */
@Path("AllFlights")
public class AllFlightsResource {

    @GET
    @Produces("application/json")
    public List<FlightInfoEntity> getAllFlights(){
         List<FlightInfoEntity> listFlights = new ArrayList<FlightInfoEntity>();
         FlightEntity f1 = new FlightEntity("Copenhaga", "Paris", new Date(), new Date(), "carrier");
         FlightEntity f2 = new FlightEntity("Paris", "Geneva", new Date(), new Date(), "carrier");
         FlightEntity f3 = new FlightEntity("Lyon", "Madrid", new Date(), new Date(), "carrier");
         FlightEntity f4 = new FlightEntity("Birkerod", "Villeurbanne", new Date(), new Date(), "carrier");
         FlightEntity f5 = new FlightEntity("Munich", "Grenoble", new Date(), new Date(), "carrier");
         FlightEntity f6 = new FlightEntity("Paris", "Targu-Mures", new Date(), new Date(), "carrier");
         
         listFlights.add(new FlightInfoEntity("1", "300", "WizzAir", f1));
         listFlights.add(new FlightInfoEntity("2", "301", "SAS", f2));
         listFlights.add(new FlightInfoEntity("3", "302", "EasyJet", f3));
         listFlights.add(new FlightInfoEntity("4", "303", "Lufthansa", f4));
         listFlights.add(new FlightInfoEntity("5", "304", "Tarom", f5));
         listFlights.add(new FlightInfoEntity("6", "305", "AirFrance", f6));
     
        return listFlights;
    }
    
    /*
    @PUT
    public void setFlightStatus(String bookNumber){
        flightState = "booked";
    }
    
    
    @Path("reset")
    @PUT
    public void resetFlightStatus(){
        flightState = "ok";
    }
    */
}
