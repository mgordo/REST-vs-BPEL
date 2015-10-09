/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.unitTests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.swing.JOptionPane;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ws.dtu.entity.CreditCardInfoType;
import ws.dtu.entity.ExpirationDateType;
import ws.dtu.representation.HotelRepresentation;
import ws.dtu.representation.Link;
import ws.dtu.representation.StatusRepresentation;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ws.dtu.entity.CreditCardInfoType;
import ws.dtu.entity.ExpirationDateType;
import ws.dtu.entity.ItineraryEntity;
import ws.dtu.representation.FlightRepresentation;
import ws.dtu.representation.HotelRepresentation;
import ws.dtu.representation.ItineraryRepresentation;
import ws.dtu.representation.Link;
import ws.dtu.representation.StatusRepresentation;
import static ws.dtu.utils.Constants.*;
/**
 *
 * @author souki
 */
public class Hotel {
    
    public Hotel() {
    }
    
     public static Client client;
    public static WebResource itineraries;
    public static WebResource login;
    
    CreditCardInfoType creditcard;
    ExpirationDateType expdate; 
    XMLGregorianCalendar date;
    
    @BeforeClass
    public static void setUp(){
        client = Client.create();
        itineraries = client.resource(BASE_ITINERARIES_URI);
        login = client.resource(BASE_LOGIN_URI);
    }
        @Before
    public void create()
    {
       expdate = new ExpirationDateType();
       expdate.setMonth(5);
       expdate.setYear(9);
       creditcard = new CreditCardInfoType();
       creditcard.setName("Anne Strandberg");
       creditcard.setNumber("50408816");
       creditcard.setExpirationDate(expdate);
       
       DatatypeFactory data;
       try {
            data = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException expdate) {
            return;
        }
        date = data.newXMLGregorianCalendarDate(2014, 1, 6, 0);
 
    }
    
    @Before
    public void reset(){
         client.resource(BASE_ITINERARIES_URI + "/reset").put();
    }

    @Test
    public void getHotel() {    
      
        StatusRepresentation iid = login.path("/pepe").put(StatusRepresentation.class);
        Link getHotel1 = iid.getLinkByRelation(GETHOTEL_RELATION);
        String link2 = String.format("%s?arrival=%s&departure=%s&city=%s", getHotel1.getUri().toString(),"15/01/2014","4/11/2014","Lorient");
        HotelRepresentation listHotel =client.resource(link2).accept(MEDIATYPE_XML).get(HotelRepresentation.class);        
        assertEquals(2,listHotel.getHotel().size());
    }
}
