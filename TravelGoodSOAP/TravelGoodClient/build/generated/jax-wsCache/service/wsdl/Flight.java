
package wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para flight complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="flight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StartAirport" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DestinationAirport" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="liftOffDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="liftOffTime" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         &lt;element name="landingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="landingTimetim" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         &lt;element name="carrier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flight", namespace = "http://xml.netbeans.org/schema/AirlineSchema", propOrder = {
    "startAirport",
    "destinationAirport",
    "liftOffDate",
    "liftOffTime",
    "landingDate",
    "landingTimetim",
    "carrier"
})
public class Flight {

    @XmlElement(name = "StartAirport", namespace = "http://xml.netbeans.org/schema/AirlineSchema", required = true)
    protected String startAirport;
    @XmlElement(name = "DestinationAirport", namespace = "http://xml.netbeans.org/schema/AirlineSchema", required = true)
    protected String destinationAirport;
    @XmlElement(namespace = "http://xml.netbeans.org/schema/AirlineSchema", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar liftOffDate;
    @XmlElement(namespace = "http://xml.netbeans.org/schema/AirlineSchema", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar liftOffTime;
    @XmlElement(namespace = "http://xml.netbeans.org/schema/AirlineSchema", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar landingDate;
    @XmlElement(namespace = "http://xml.netbeans.org/schema/AirlineSchema", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar landingTimetim;
    @XmlElement(namespace = "http://xml.netbeans.org/schema/AirlineSchema", required = true)
    protected String carrier;

    /**
     * Obtiene el valor de la propiedad startAirport.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartAirport() {
        return startAirport;
    }

    /**
     * Define el valor de la propiedad startAirport.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartAirport(String value) {
        this.startAirport = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationAirport.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationAirport() {
        return destinationAirport;
    }

    /**
     * Define el valor de la propiedad destinationAirport.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationAirport(String value) {
        this.destinationAirport = value;
    }

    /**
     * Obtiene el valor de la propiedad liftOffDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLiftOffDate() {
        return liftOffDate;
    }

    /**
     * Define el valor de la propiedad liftOffDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLiftOffDate(XMLGregorianCalendar value) {
        this.liftOffDate = value;
    }

    /**
     * Obtiene el valor de la propiedad liftOffTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLiftOffTime() {
        return liftOffTime;
    }

    /**
     * Define el valor de la propiedad liftOffTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLiftOffTime(XMLGregorianCalendar value) {
        this.liftOffTime = value;
    }

    /**
     * Obtiene el valor de la propiedad landingDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLandingDate() {
        return landingDate;
    }

    /**
     * Define el valor de la propiedad landingDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLandingDate(XMLGregorianCalendar value) {
        this.landingDate = value;
    }

    /**
     * Obtiene el valor de la propiedad landingTimetim.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLandingTimetim() {
        return landingTimetim;
    }

    /**
     * Define el valor de la propiedad landingTimetim.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLandingTimetim(XMLGregorianCalendar value) {
        this.landingTimetim = value;
    }

    /**
     * Obtiene el valor de la propiedad carrier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * Define el valor de la propiedad carrier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrier(String value) {
        this.carrier = value;
    }

}
