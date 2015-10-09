/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datepack;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

/**
 *
 * @author Diego
 */
@WebService(serviceName = "DateCalculatorService", portName = "DateCalculatorPortTypeService", endpointInterface = "org.netbeans.j2ee.wsdl.datecalculator.java.datecalculator.DateCalculatorPortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/DateCalculator/java/DateCalculator", wsdlLocation = "WEB-INF/wsdl/DateCalculator/DateCalculator.wsdl")
public class DateCalculator {
    /**
     * 0 == Normal execution
     * other == the process will die in 10 secs
     */
    static int test=0;

    public javax.xml.datatype.Duration dateCalculatorOperation(javax.xml.datatype.XMLGregorianCalendar part1) {
        javax.xml.datatype.XMLGregorianCalendar ret=null;
        try {
            ret=DatatypeFactory.newInstance().newXMLGregorianCalendarDate(part1.getYear(), part1.getMonth(), part1.getDay()-1, 0);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(DateCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long lastdate = ret.toGregorianCalendar().getTimeInMillis();
        Date today = new Date();
        long actualdate = today.getTime();
        DatatypeFactory fact=null;
        Duration dur=null;
        try {
            fact=DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(DateCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        dur=fact.newDuration(lastdate-actualdate);
        
        if(test == 0){
            return dur;
        }else{
            return fact.newDuration(10000);
        }
    }

    public javax.xml.datatype.XMLGregorianCalendar dateCalculatorGetBigDateOperation(boolean foo) {
        //JOptionPane.showMessageDialog(new JFrame(), "Entre aqui");
        javax.xml.datatype.XMLGregorianCalendar ret=null;
        try {
            ret = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendarDate(2050, 8, 15,0);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(DateCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //JOptionPane.showMessageDialog(new JFrame(), "Estoy en Date. The year is: "+ret.getYear());
        return ret;
    }
    
}
