/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niceviewpack;

import bankpack.BankService;
import bankpack.CreditCardFaultMessage;
import dk.dtu.imm.fastmoney.types.CreditCardInfoType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;
import niceview.Bookfault;
import niceview.CancelFault;
import org.netbeans.xml.schema.hotelschema.Bookarg;
import org.netbeans.xml.schema.hotelschema.Get;
import org.netbeans.xml.schema.hotelschema.Hotel;
import org.netbeans.xml.schema.hotelschema.Hotellist;

/**
 *
 * @author Miguel Gordo
 */
@WebService(serviceName = "NiceViewService", portName = "NiceViewPortTypeBindingPort", endpointInterface = "niceview.NiceViewPortType", targetNamespace = "urn:NiceView", wsdlLocation = "WEB-INF/wsdl/NiceView/NiceView.wsdl")
public class NiceView {
    
    ArrayList<Hotel> hotlist = new ArrayList<Hotel>();
    

    public Hotellist getHotel(Get part1) {
        
        if(hotlist.isEmpty()){
            /*Code to add Hotels manually*/
        Hotel hot = new Hotel();
        hot.setCity("Lorient");
        hot.setName("Otto Kretschmer");
        hot.setAddress("Silent Otto 99");
        hot.setBooknumber(99);
        hot.setGuarantee(false);
        hot.setReservationService("NiceView");
        
        
        try {
            hot.setStartperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 01, 15, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }        
        try {
            hot.setEndperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 11, 4, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        hotlist.add(hot);
        /*Second Hotel*/
        Hotel hot2 = new Hotel();
        hot2.setCity("Kiel");
        hot2.setName("Karl Donitz");
        hot2.setAddress("BdU 1941");
        hot2.setBooknumber(1020);
        hot2.setGuarantee(true);
        hot2.setReservationService("NiceView");
        hot2.setPrice(514);


        
        try {
            hot2.setStartperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 5, 05, 0)); 
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            hot2.setEndperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 6, 5, 0)); 

        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        hotlist.add(hot2);
        
        /*Third Hotel*/
        Hotel hot3 = new Hotel();
        hot3.setCity("Scapa Flow");
        hot3.setName("Gunther Prien");
        hot3.setAddress("Royal Oak 1939");
        hot3.setBooknumber(47);
        hot3.setGuarantee(true);
        hot3.setReservationService("NiceView");
        hot3.setPrice(1001);


        
        try {
            hot3.setStartperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 10, 1, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        try {
            hot3.setEndperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 3, 7, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        hotlist.add(hot3); 
        
        Hotel hot4 = new Hotel();
        hot4.setCity("Lorient");
        hot4.setName("Erich Topp");
        hot4.setAddress("Reute Teufel");
        hot4.setBooknumber(552);
        hot4.setGuarantee(false);
        hot4.setReservationService("NiceView");
        
        
        try {
            hot4.setStartperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 01, 15, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }        
        try {
            hot4.setEndperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 11, 4, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        hotlist.add(hot4);
        
        
        }
            
        Hotellist query = new Hotellist();
        
        /*We now have 3 hotels in the hotel list*/
        /*Now we compare the query to the availability*/
        
        for(Hotel h: hotlist){
            if(part1.getCity().equals(h.getCity())){
                if(intime(h,part1) ){                 
                    query.getNewElement().add(h);
                }
            }
            
        }
        return query;
        
    }

    public boolean bookHotel(Bookarg part1) throws Bookfault {
        
        
        /*Init of the structures*/
        
        if(hotlist.isEmpty()){
            /*Code to add Hotels manually*/
        Hotel hot = new Hotel();
        hot.setCity("Lorient");
        hot.setName("Otto Kretschmer");
        hot.setAddress("Silent Otto 99");
        hot.setBooknumber(99);
        hot.setGuarantee(false);
        hot.setReservationService("NiceView");
        
        
        try {
            hot.setStartperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 01, 15, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }        
        try {
            hot.setEndperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 11, 4, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        hotlist.add(hot);
        /*Second Hotel*/
        Hotel hot2 = new Hotel();
        hot2.setCity("Kiel");
        hot2.setName("Karl Donitz");
        hot2.setAddress("BdU 1941");
        hot2.setBooknumber(1020);
        hot2.setGuarantee(true);
        hot2.setReservationService("NiceView");
        hot2.setPrice(514);


        
        try {
            hot2.setStartperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 5, 05, 0)); 
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            hot2.setEndperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 6, 5, 0)); 

        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        hotlist.add(hot2);
        
        /*Third Hotel*/
        Hotel hot3 = new Hotel();
        hot3.setCity("Scapa Flow");
        hot3.setName("Gunther Prien");
        hot3.setAddress("Royal Oak 1939");
        hot3.setBooknumber(47);
        hot3.setGuarantee(true);
        hot3.setReservationService("NiceView");
        hot3.setPrice(1001);


        
        try {
            hot3.setStartperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 10, 1, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        try {
            hot3.setEndperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 3, 7, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        hotlist.add(hot3); 
        
        Hotel hot4 = new Hotel();
        hot4.setCity("Lorient");
        hot4.setName("Erich Topp");
        hot4.setAddress("Reute Teufel");
        hot4.setBooknumber(552);
        hot4.setGuarantee(false);
        hot4.setReservationService("NiceView");
        
        
        try {
            hot4.setStartperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 01, 15, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }        
        try {
            hot4.setEndperiod(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(2014, 11, 4, 0));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NiceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        hotlist.add(hot4);
        
        }
        
        
        
        
        Hotel hot=null;
        boolean found=false;
        Iterator<Hotel> it=hotlist.iterator();
        
        while(!found && it.hasNext()){
            Hotel h=it.next();
            
            if(h.getBooknumber() == part1.getBookreference()){
                hot=h;
                found=true;
            }
        }

        if(!found){
            throw new Bookfault("Booking number doesnt exist", "No such book number");
        }
        if(hot.isGuarantee()){
            
            bankpack.CreditCardInfoType creditCardInfo = translate(part1.getValidatecc());
            int amount = (int) hot.getPrice();


            try {
                validateCreditCard(5, creditCardInfo, amount);
            } catch (CreditCardFaultMessage ex) {
                throw new Bookfault(ex.getMessage(),ex.getLocalizedMessage()); 
            }
            
           
        }
        
        return true;
        
    }

    /*
     * As stated in the problem description, no refunds are made!
     */
    
    public boolean cancelHotel(int part1) throws CancelFault {
        
       if(part1==552){
           throw new CancelFault("Cancel Hotel 552 Failed","Cancel Hotel 552 Failed");
       }
        return true;
    }

    

    private boolean intime(Hotel h, Get part1) {
        boolean bookable=false;
        XMLGregorianCalendar hotelarrival = h.getStartperiod();
        XMLGregorianCalendar guestarrival = part1.getArrival();
        XMLGregorianCalendar hoteldeparture = h.getEndperiod();
        XMLGregorianCalendar guestdeparture = part1.getDeparture();
        
        if((hotelarrival.compare(guestarrival) == DatatypeConstants.LESSER) || (hotelarrival.compare(guestarrival) == DatatypeConstants.EQUAL)){
            if((hoteldeparture.compare(guestdeparture) == DatatypeConstants.GREATER) || (hoteldeparture.compare(guestdeparture) == DatatypeConstants.EQUAL)){
                bookable=true;
                
                
            }
            
        }

        return bookable;
    }

    private bankpack.CreditCardInfoType translate(CreditCardInfoType validatecc1) {
        bankpack.CreditCardInfoType creditCardInfo = new bankpack.CreditCardInfoType();
        
        creditCardInfo.setName(validatecc1.getName());
        
        
        bankpack.ExpirationDateType t = new bankpack.ExpirationDateType();
        t.setMonth(validatecc1.getExpirationDate().getMonth());
        t.setYear(validatecc1.getExpirationDate().getYear());
        creditCardInfo.setExpirationDate(t);
        
        creditCardInfo.setNumber(validatecc1.getNumber());
        return creditCardInfo;
        
        
    }

    private boolean chargeCreditCard(int group, bankpack.CreditCardInfoType creditCardInfo, int amount, bankpack.AccountType account) throws CreditCardFaultMessage {
        BankService service = new BankService();
        bankpack.BankPortType port = service.getBankPort();
        return port.chargeCreditCard(group, creditCardInfo, amount, account);
    }

    private boolean refundCreditCard(int group, bankpack.CreditCardInfoType creditCardInfo, int amount, bankpack.AccountType account) throws CreditCardFaultMessage {
        BankService service = new BankService();
        bankpack.BankPortType port = service.getBankPort();
        return port.refundCreditCard(group, creditCardInfo, amount, account);
    }

    private boolean validateCreditCard(int group, bankpack.CreditCardInfoType creditCardInfo, int amount) throws CreditCardFaultMessage {
        BankService service = new BankService();
        bankpack.BankPortType port = service.getBankPort();
        return port.validateCreditCard(group, creditCardInfo, amount);
    }
    
}
