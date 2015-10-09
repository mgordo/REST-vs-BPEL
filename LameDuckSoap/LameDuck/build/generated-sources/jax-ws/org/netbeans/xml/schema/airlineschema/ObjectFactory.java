
package org.netbeans.xml.schema.airlineschema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.netbeans.xml.schema.airlineschema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BookFlightFaultElement_QNAME = new QName("http://xml.netbeans.org/schema/AirlineSchema", "bookFlightFaultElement");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.netbeans.xml.schema.airlineschema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FlightList }
     * 
     */
    public FlightList createFlightList() {
        return new FlightList();
    }

    /**
     * Create an instance of {@link BookFlightFaultType }
     * 
     */
    public BookFlightFaultType createBookFlightFaultType() {
        return new BookFlightFaultType();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link FlightList.FlightInformation }
     * 
     */
    public FlightList.FlightInformation createFlightListFlightInformation() {
        return new FlightList.FlightInformation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookFlightFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/AirlineSchema", name = "bookFlightFaultElement")
    public JAXBElement<BookFlightFaultType> createBookFlightFaultElement(BookFlightFaultType value) {
        return new JAXBElement<BookFlightFaultType>(_BookFlightFaultElement_QNAME, BookFlightFaultType.class, null, value);
    }

}
