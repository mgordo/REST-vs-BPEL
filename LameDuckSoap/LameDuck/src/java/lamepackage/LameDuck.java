/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lamepackage;

import bankpackage.BankService;
import bankpackage.CreditCardFaultMessage;
import dk.dtu.imm.fastmoney.types.CreditCardInfoType;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import lameduck.BookFlightFault;
import lameduck.CancelFlightFaultMessage;
import org.netbeans.xml.schema.airlineschema.BookFlightFaultType;
import org.netbeans.xml.schema.airlineschema.Flight;
import org.netbeans.xml.schema.airlineschema.FlightList;
import org.netbeans.xml.schema.airlineschema.FlightList.FlightInformation;
import org.netbeans.xml.schema.airlineschema.ObjectFactory;
/**
 *
 * @author Diego Gonzalez
 */
@WebService(serviceName = "LameDuckService", portName = "LameDuckPortTypeBindingPort", endpointInterface = "lameduck.LameDuckPortType", targetNamespace = "urn:LameDuck", wsdlLocation = "WEB-INF/wsdl/LameDuck/LameDuck.wsdl")
public class LameDuck {

    FlightList list=null;
    
    public org.netbeans.xml.schema.airlineschema.FlightList getFlights(java.lang.String source, java.lang.String destination, javax.xml.datatype.XMLGregorianCalendar date) {
        if(list==null){
            try {
                initialize();
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(LameDuck.class.getName()).log(Level.SEVERE, null, ex);               
            }
        }
        ObjectFactory o = new ObjectFactory();
        FlightList matches = o.createFlightList();
        Iterator<FlightInformation> it = list.getFlightInformation().iterator();
        while(it.hasNext()){
            FlightInformation finfo = it.next();
            if(finfo!=null && finfo.getFlight().getDestinationAirport().equals(destination) &&
                    finfo.getFlight().getStartAirport().equals(source) &&
                    finfo.getFlight().getLiftOffDate().getYear() == date.getYear() &&
                    finfo.getFlight().getLiftOffDate().getMonth() == date.getMonth() && 
                    finfo.getFlight().getLiftOffDate().getDay() == date.getDay()){
                matches.getFlightInformation().add(finfo);
            }
        }
        return matches;

    }

    public boolean bookFlight(int bookingnumber, dk.dtu.imm.fastmoney.types.CreditCardInfoType creditcard) throws BookFlightFault {
        if(list==null){
            try {
                initialize();
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(LameDuck.class.getName()).log(Level.SEVERE, null, ex);          
                throw new UnsupportedOperationException("Not initialized");
            }
        }
        
        Iterator<FlightInformation> it = list.getFlightInformation().iterator();
        int fl=0;
        FlightInformation finfo=null;
      
        while(it.hasNext() && fl==0){
            finfo = it.next();
            
            if(finfo.getBookingNumber() == bookingnumber){
                fl=1;
            }
        }
        /*The booking number doesn't exist*/
        if(fl == 0){
            BookFlightFaultType faultInfo;
            ObjectFactory o = new ObjectFactory();
            faultInfo = o.createBookFlightFaultType();
            faultInfo.setDescription("No booking number");
            BookFlightFault bookfault = new BookFlightFault("No existing number", faultInfo);
            throw bookfault;
        }
        boolean validateCreditCard;
   
        try {
            validateCreditCard = validateCreditCard(5, translateCreditCard(creditcard), finfo.getPrice());
        } catch (CreditCardFaultMessage ex) {
            BookFlightFaultType faultInfo;
            ObjectFactory o = new ObjectFactory();
            faultInfo = o.createBookFlightFaultType();
            faultInfo.setDescription(ex.getMessage());
            BookFlightFault bookfault = new BookFlightFault(ex.getLocalizedMessage(), faultInfo);
            throw bookfault;
        }
        if(validateCreditCard == false){         
            BookFlightFaultType faultInfo;
            ObjectFactory o = new ObjectFactory();
            faultInfo = o.createBookFlightFaultType();
            faultInfo.setDescription("Not enough money");
            BookFlightFault bookfault = new BookFlightFault("Not enough money", faultInfo);
            throw bookfault;
        }
        
        /*We transfer the money to LameDuck*/
        bankpackage.ObjectFactory obj = new bankpackage.ObjectFactory();
        bankpackage.AccountType account = obj.createAccountType();
        account.setName("LameDuck");
        account.setNumber("50208812");
        try {
            chargeCreditCard(5, translateCreditCard(creditcard), finfo.getPrice(),account);
        } catch (CreditCardFaultMessage ex) {
            BookFlightFaultType faultInfo;
            ObjectFactory o = new ObjectFactory();
            faultInfo = o.createBookFlightFaultType();
            faultInfo.setDescription(ex.getMessage());
            BookFlightFault bookfault = new BookFlightFault(ex.getLocalizedMessage(), faultInfo);
            throw bookfault;
        }
        return true;

    }

    public boolean cancelFlight(int bookingnumber1, int price1, dk.dtu.imm.fastmoney.types.CreditCardInfoType credircardinfo1) throws CancelFlightFaultMessage {
        if(list== null){
            try {
                initialize();
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(LameDuck.class.getName()).log(Level.SEVERE, null, ex);            
                throw new UnsupportedOperationException("Not initialized");
            }
        }
        
        /*We transfer the money from LameDuck*/
        bankpackage.ObjectFactory obj = new bankpackage.ObjectFactory();
        bankpackage.AccountType account = obj.createAccountType();
        account.setName("LameDuck");
        account.setNumber("50208812");
        try {
            refundCreditCard(5, translateCreditCard(credircardinfo1), price1/2,account);
        } catch (CreditCardFaultMessage ex) {
            BookFlightFaultType faultInfo;
            ObjectFactory o = new ObjectFactory();
            faultInfo = o.createBookFlightFaultType();
            faultInfo.setDescription(ex.getMessage());
            throw new CancelFlightFaultMessage(ex.getMessage(),faultInfo);
        }
        
        return true;
    }
    
    private void initialize() throws DatatypeConfigurationException {
        
        ObjectFactory o = new ObjectFactory();
        
        list = o.createFlightList();
        
        Flight flight = o.createFlight();
        
        /*Fisrt flight*/
        flight.setDestinationAirport("MAD");
        flight.setStartAirport("CPH");
        DatatypeFactory xmlFactory = DatatypeFactory.newInstance();
        flight.setLandingDate(xmlFactory.newXMLGregorianCalendarDate(2013, 12, 20, 0));
        flight.setLandingTimetim(xmlFactory.newXMLGregorianCalendarTime(22,0, 0, 0));
        flight.setLiftOffDate(xmlFactory.newXMLGregorianCalendarDate(2013, 12, 19, 0));
        flight.setLiftOffTime(xmlFactory.newXMLGregorianCalendarTime(21,0, 0, 0));
        flight.setCarrier("SASCarrier");
        
        FlightInformation finfo = new FlightInformation();
        finfo.setAirline("SAS");
        finfo.setBookingNumber(1);
        finfo.setFlight(flight);
        finfo.setPrice(100);
        
        list.getFlightInformation().add(finfo);      
        
        /*Second flight*/
        flight = o.createFlight();
        finfo = new FlightInformation();
        flight.setDestinationAirport("ABC");
        flight.setStartAirport("DEF");
        flight.setLandingDate(xmlFactory.newXMLGregorianCalendarDate(2013, 12, 30, 0));
        flight.setLandingTimetim(xmlFactory.newXMLGregorianCalendarTime(12,0, 0, 0));
        flight.setLiftOffDate(xmlFactory.newXMLGregorianCalendarDate(2013, 12, 30, 0));
        flight.setLiftOffTime(xmlFactory.newXMLGregorianCalendarTime(10,0, 0, 0));
        flight.setCarrier("RyanairCarrier");
        
        finfo.setAirline("Ryanair");
        finfo.setBookingNumber(2);
        finfo.setFlight(flight);
        finfo.setPrice(200);
        
        list.getFlightInformation().add(finfo);
      

        
        /*Third flight*/
        flight = o.createFlight();
        finfo = new FlightInformation();
        flight.setDestinationAirport("ABC");
        flight.setStartAirport("DEF");
        flight.setLandingDate(xmlFactory.newXMLGregorianCalendarDate(2013, 12, 30, 0));
        flight.setLandingTimetim(xmlFactory.newXMLGregorianCalendarTime(15,0, 0, 0));
        flight.setLiftOffDate(xmlFactory.newXMLGregorianCalendarDate(2013, 12, 30, 0));
        flight.setLiftOffTime(xmlFactory.newXMLGregorianCalendarTime(13,0, 0, 0));
        flight.setCarrier("IberiaCarrier");
        
        finfo.setAirline("Iberia");
        finfo.setBookingNumber(3);
        finfo.setFlight(flight);
        finfo.setPrice(200);
        
        list.getFlightInformation().add(finfo);
       
        
        /*Fouth flight*/
        flight = o.createFlight();
        finfo = new FlightInformation();
        flight.setDestinationAirport("HHH");
        flight.setStartAirport("ZZZ");
        flight.setLandingDate(xmlFactory.newXMLGregorianCalendarDate(2015, 12, 30, 0));
        flight.setLandingTimetim(xmlFactory.newXMLGregorianCalendarTime(15,0, 0, 0));
        flight.setLiftOffDate(xmlFactory.newXMLGregorianCalendarDate(2015, 12, 30, 0));
        flight.setLiftOffTime(xmlFactory.newXMLGregorianCalendarTime(13,0, 0, 0));
        flight.setCarrier("EasyJetCarrier");
        
        finfo.setAirline("Easy Jet");
        finfo.setBookingNumber(4);
        finfo.setFlight(flight);
        finfo.setPrice(1200);
        
        list.getFlightInformation().add(finfo);

    }

    private bankpackage.CreditCardInfoType translateCreditCard(CreditCardInfoType card){
        bankpackage.ObjectFactory obj = new bankpackage.ObjectFactory();
        bankpackage.CreditCardInfoType cardNew = obj.createCreditCardInfoType();
        
        bankpackage.ExpirationDateType e = obj.createExpirationDateType();
        e.setYear(card.getExpirationDate().getYear());
        e.setMonth(card.getExpirationDate().getMonth());
        cardNew.setExpirationDate(e);
        cardNew.setName(card.getName());
        cardNew.setNumber(card.getNumber());
        return cardNew;
    }

    private boolean chargeCreditCard(int group, bankpackage.CreditCardInfoType creditCardInfo, int amount, bankpackage.AccountType account) throws CreditCardFaultMessage {
        BankService service = new BankService();
        bankpackage.BankPortType port = service.getBankPort();
        return port.chargeCreditCard(group, creditCardInfo, amount, account);
    }

    private boolean refundCreditCard(int group, bankpackage.CreditCardInfoType creditCardInfo, int amount, bankpackage.AccountType account) throws CreditCardFaultMessage {
        BankService service = new BankService();
        bankpackage.BankPortType port = service.getBankPort();
        return port.refundCreditCard(group, creditCardInfo, amount, account);
    }

    private boolean validateCreditCard(int group, bankpackage.CreditCardInfoType creditCardInfo, int amount) throws CreditCardFaultMessage {
        BankService service = new BankService();
        bankpackage.BankPortType port = service.getBankPort();
        return port.validateCreditCard(group, creditCardInfo, amount);
    }
    
    
}