/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flightTests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author veve
 */
public class TestFlightResource {
    
    Client client = Client.create();
    WebResource r = client.resource("http://localhost:8080/LameDuckREST/webresources/Flight/getFlights");

    
    
    @Test
    public void getFlights() {
        String result = r.get(String.class);
        assertEquals("DTU", result);
    }
   
    /*
    @Before
    public void resetFlightStatus(){
        r.path("reset").put();
    }   
    
    @Test
    public void setFlight() {
        String expected = "ok";
        r.put(expected);
        assertEquals(expected, r.get(String.class));
    }
*/
}
