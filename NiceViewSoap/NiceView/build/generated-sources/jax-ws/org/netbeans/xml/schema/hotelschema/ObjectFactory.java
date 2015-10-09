
package org.netbeans.xml.schema.hotelschema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.netbeans.xml.schema.hotelschema package. 
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

    private final static QName _Cancelreq_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "cancelreq");
    private final static QName _Hotellistelement_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "hotellistelement");
    private final static QName _Bookreply_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "bookreply");
    private final static QName _Getelement_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "getelement");
    private final static QName _Stringfault_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "stringfault");
    private final static QName _Hotelelement_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "hotelelement");
    private final static QName _Bookargelement_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "bookargelement");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.netbeans.xml.schema.hotelschema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link Hotellist }
     * 
     */
    public Hotellist createHotellist() {
        return new Hotellist();
    }

    /**
     * Create an instance of {@link Bookarg }
     * 
     */
    public Bookarg createBookarg() {
        return new Bookarg();
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "cancelreq")
    public JAXBElement<Integer> createCancelreq(Integer value) {
        return new JAXBElement<Integer>(_Cancelreq_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hotellist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "hotellistelement")
    public JAXBElement<Hotellist> createHotellistelement(Hotellist value) {
        return new JAXBElement<Hotellist>(_Hotellistelement_QNAME, Hotellist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "bookreply")
    public JAXBElement<Boolean> createBookreply(Boolean value) {
        return new JAXBElement<Boolean>(_Bookreply_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Get }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "getelement")
    public JAXBElement<Get> createGetelement(Get value) {
        return new JAXBElement<Get>(_Getelement_QNAME, Get.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "stringfault")
    public JAXBElement<String> createStringfault(String value) {
        return new JAXBElement<String>(_Stringfault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "hotelelement")
    public JAXBElement<Hotel> createHotelelement(Hotel value) {
        return new JAXBElement<Hotel>(_Hotelelement_QNAME, Hotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bookarg }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "bookargelement")
    public JAXBElement<Bookarg> createBookargelement(Bookarg value) {
        return new JAXBElement<Bookarg>(_Bookargelement_QNAME, Bookarg.class, null, value);
    }

}
