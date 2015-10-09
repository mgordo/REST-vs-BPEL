/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niceviewtest;

import dk.dtu.imm.fastmoney.types.CreditCardInfoType;
import dk.dtu.imm.fastmoney.types.ExpirationDateType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import niceview.Bookfault;
import niceview.CancelFault;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.netbeans.xml.schema.hotelschema.Bookarg;
import org.netbeans.xml.schema.hotelschema.Get;
import org.netbeans.xml.schema.hotelschema.Hotel;
import org.netbeans.xml.schema.hotelschema.Hotellist;

/**
 *
 * @author Miguel Gordo
 */
public class NiceViewTest {
    
    public NiceViewTest() {
    }
    
    @Test
    public void testget(){
        
        Get send = new Get();
        send.setCity("Lorient");

        try {
            send.setArrival(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 1, 6, 0));
        } catch (DatatypeConfigurationException ex) {
            System.out.println("Bad calendar startup 1");
        }

        try {
            send.setDeparture(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014,1,10, 0));
            
        } catch (DatatypeConfigurationException ex) {
            System.out.println("Bad calendar startup 2");
        }
      
        Hotellist list = getHotel(send);
        assertEquals(true,list.getNewElement().isEmpty());

        try {
            
            send.setArrival(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 2, 16, 0));
        } catch (DatatypeConfigurationException ex) {
            System.out.println("Bad calendar startup 1");
        }

        try {

            send.setDeparture(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014,3,10, 0));
        } catch (DatatypeConfigurationException ex) {
            System.out.println("Bad calendar startup 2");
        }
           
        list = getHotel(send);
        assertEquals(false,list.getNewElement().isEmpty());
        Hotel temp = list.getNewElement().get(0);
        
        assertEquals(temp.getCity(),"Lorient");
        assertEquals(temp.isGuarantee(),false);
        assertEquals(temp.getBooknumber(),99);
        assertEquals(temp.getName(),"Otto Kretschmer");
        
        
    }
    
    @Test
    public void testbook(){
        
        Bookarg test1 = new Bookarg();
        test1.setBookreference(99);
        
        try {
            bookHotel(test1);
        } catch (Bookfault ex) {
            fail("Should have been booked!");
        }
        
        Bookarg test2 = new Bookarg();
        test2.setBookreference(1020);
        
        CreditCardInfoType credit2 = new CreditCardInfoType();
        ExpirationDateType expirat2 = new ExpirationDateType();
        expirat2.setMonth(6);
        expirat2.setYear(9);
        credit2.setExpirationDate(expirat2);
        credit2.setName("Donovan Jasper");
        credit2.setNumber("50408818");
        test2.setValidatecc(credit2);
        
        try {
            bookHotel(test2);
        } catch (Bookfault ex) {
            System.out.println("Failed because: "+ ex.getFaultInfo());
            fail("Should have been booked!");
        }
        
        Bookarg test3 = new Bookarg();
        test3.setBookreference(47);
        
        CreditCardInfoType credit3 = new CreditCardInfoType();
        ExpirationDateType expirat3 = new ExpirationDateType();
        expirat3.setMonth(9);
        expirat3.setYear(10);
        credit3.setExpirationDate(expirat3);
        credit3.setName("Tobiasen Inge");
        credit3.setNumber("50408823");
        test3.setValidatecc(credit3);
        
        try {
            bookHotel(test3);
            fail("Shouldn't have been booked!");
        } catch (Bookfault ex) {
            System.out.println("Exception cause: "+ ex.getFaultInfo());
            assertEquals(ex.getFaultInfo(),"The account has not enough money");
        }
        
        /*A validation error should happen!*/
        Bookarg test4 = new Bookarg();
        test4.setBookreference(47);
        
        CreditCardInfoType credit4 = new CreditCardInfoType();
        ExpirationDateType expirat4 = new ExpirationDateType();
        expirat4.setMonth(9);
        expirat4.setYear(5);
        credit4.setExpirationDate(expirat4);
        credit4.setName("Tobiasen Inge");
        credit4.setNumber("50408823");
        test4.setValidatecc(credit4);
        
        try {
            bookHotel(test4);
            fail("Shouldn't have been booked!");
        } catch (Bookfault ex) {
            System.out.println("Exception cause: "+ ex.getFaultInfo());
            assertEquals(ex.getFaultInfo(),"Credit card does not exist");
        }
        
        
        
        
        Bookarg test5 = new Bookarg();
        test5.setBookreference(1020);
        
        CreditCardInfoType credit5 = new CreditCardInfoType();
        ExpirationDateType expirat5 = new ExpirationDateType();
        expirat5.setMonth(9);
        expirat5.setYear(5);
        credit5.setExpirationDate(expirat5);
        credit5.setName("Mumble Remumble");
        credit5.setNumber("50408823");
        test5.setValidatecc(credit5);
        
        try {
            bookHotel(test5);
            fail("Shouldn't have been booked!");
        } catch (Bookfault ex) {
            System.out.println("Exception cause: "+ ex.getFaultInfo());
            assertEquals(ex.getFaultInfo(),"Credit card does not exist");
        }
        
        
        
    }
    
    @Test
    public void canceltest(){
        try {
            assertEquals(true,cancelHotel(99));
        } catch (CancelFault ex) {
            fail("Should be ok to cancel everythin!");
        }
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

    private static Hotellist getHotel(org.netbeans.xml.schema.hotelschema.Get part1) {
        niceview.NiceViewService service = new niceview.NiceViewService();
        niceview.NiceViewPortType port = service.getNiceViewPortTypeBindingPort();
        return port.getHotel(part1);
    }
    
    
    
    
    
    
}
