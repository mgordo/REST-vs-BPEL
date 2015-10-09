
package org.netbeans.xml.schema.hotelschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Hotel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Hotel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="booknumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReservationService" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="guarantee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="startperiod" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="endperiod" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hotel", propOrder = {
    "name",
    "booknumber",
    "city",
    "reservationService",
    "price",
    "guarantee",
    "address",
    "startperiod",
    "endperiod"
})
public class Hotel {

    @XmlElement(required = true)
    protected String name;
    protected int booknumber;
    @XmlElement(required = true)
    protected String city;
    @XmlElement(name = "ReservationService", required = true)
    protected String reservationService;
    protected double price;
    protected boolean guarantee;
    @XmlElement(required = true)
    protected String address;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startperiod;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endperiod;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the booknumber property.
     * 
     */
    public int getBooknumber() {
        return booknumber;
    }

    /**
     * Sets the value of the booknumber property.
     * 
     */
    public void setBooknumber(int value) {
        this.booknumber = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the reservationService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservationService() {
        return reservationService;
    }

    /**
     * Sets the value of the reservationService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservationService(String value) {
        this.reservationService = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the guarantee property.
     * 
     */
    public boolean isGuarantee() {
        return guarantee;
    }

    /**
     * Sets the value of the guarantee property.
     * 
     */
    public void setGuarantee(boolean value) {
        this.guarantee = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the startperiod property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartperiod() {
        return startperiod;
    }

    /**
     * Sets the value of the startperiod property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartperiod(XMLGregorianCalendar value) {
        this.startperiod = value;
    }

    /**
     * Gets the value of the endperiod property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndperiod() {
        return endperiod;
    }

    /**
     * Sets the value of the endperiod property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndperiod(XMLGregorianCalendar value) {
        this.endperiod = value;
    }

}
