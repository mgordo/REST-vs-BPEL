
package org.netbeans.xml.schema.airlineschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for flight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
@XmlType(name = "flight", propOrder = {
    "startAirport",
    "destinationAirport",
    "liftOffDate",
    "liftOffTime",
    "landingDate",
    "landingTimetim",
    "carrier"
})
public class Flight {

    @XmlElement(name = "StartAirport", required = true)
    protected String startAirport;
    @XmlElement(name = "DestinationAirport", required = true)
    protected String destinationAirport;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar liftOffDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar liftOffTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar landingDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar landingTimetim;
    @XmlElement(required = true)
    protected String carrier;

    /**
     * Gets the value of the startAirport property.
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
     * Sets the value of the startAirport property.
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
     * Gets the value of the destinationAirport property.
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
     * Sets the value of the destinationAirport property.
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
     * Gets the value of the liftOffDate property.
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
     * Sets the value of the liftOffDate property.
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
     * Gets the value of the liftOffTime property.
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
     * Sets the value of the liftOffTime property.
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
     * Gets the value of the landingDate property.
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
     * Sets the value of the landingDate property.
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
     * Gets the value of the landingTimetim property.
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
     * Sets the value of the landingTimetim property.
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
     * Gets the value of the carrier property.
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
     * Sets the value of the carrier property.
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
