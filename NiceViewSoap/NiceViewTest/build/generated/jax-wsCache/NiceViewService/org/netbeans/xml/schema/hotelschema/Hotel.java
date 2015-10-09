
package org.netbeans.xml.schema.hotelschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Hotel complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad name.
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
     * Define el valor de la propiedad name.
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
     * Obtiene el valor de la propiedad booknumber.
     * 
     */
    public int getBooknumber() {
        return booknumber;
    }

    /**
     * Define el valor de la propiedad booknumber.
     * 
     */
    public void setBooknumber(int value) {
        this.booknumber = value;
    }

    /**
     * Obtiene el valor de la propiedad city.
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
     * Define el valor de la propiedad city.
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
     * Obtiene el valor de la propiedad reservationService.
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
     * Define el valor de la propiedad reservationService.
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
     * Obtiene el valor de la propiedad price.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Define el valor de la propiedad price.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Obtiene el valor de la propiedad guarantee.
     * 
     */
    public boolean isGuarantee() {
        return guarantee;
    }

    /**
     * Define el valor de la propiedad guarantee.
     * 
     */
    public void setGuarantee(boolean value) {
        this.guarantee = value;
    }

    /**
     * Obtiene el valor de la propiedad address.
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
     * Define el valor de la propiedad address.
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
     * Obtiene el valor de la propiedad startperiod.
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
     * Define el valor de la propiedad startperiod.
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
     * Obtiene el valor de la propiedad endperiod.
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
     * Define el valor de la propiedad endperiod.
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
