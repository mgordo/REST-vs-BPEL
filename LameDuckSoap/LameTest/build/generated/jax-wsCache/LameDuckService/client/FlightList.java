
package client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FlightList complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FlightList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="flightInformation" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="airline" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Flight" type="{http://xml.netbeans.org/schema/AirlineSchema}flight"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlightList", namespace = "http://xml.netbeans.org/schema/AirlineSchema", propOrder = {
    "flightInformation"
})
public class FlightList {

    @XmlElement(namespace = "http://xml.netbeans.org/schema/AirlineSchema")
    protected List<FlightList.FlightInformation> flightInformation;

    /**
     * Gets the value of the flightInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flightInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlightInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FlightList.FlightInformation }
     * 
     * 
     */
    public List<FlightList.FlightInformation> getFlightInformation() {
        if (flightInformation == null) {
            flightInformation = new ArrayList<FlightList.FlightInformation>();
        }
        return this.flightInformation;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="airline" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Flight" type="{http://xml.netbeans.org/schema/AirlineSchema}flight"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bookingNumber",
        "price",
        "airline",
        "flight"
    })
    public static class FlightInformation {

        @XmlElement(namespace = "http://xml.netbeans.org/schema/AirlineSchema")
        protected int bookingNumber;
        @XmlElement(namespace = "http://xml.netbeans.org/schema/AirlineSchema")
        protected int price;
        @XmlElement(namespace = "http://xml.netbeans.org/schema/AirlineSchema", required = true)
        protected String airline;
        @XmlElement(name = "Flight", namespace = "http://xml.netbeans.org/schema/AirlineSchema", required = true)
        protected Flight flight;

        /**
         * Obtiene el valor de la propiedad bookingNumber.
         * 
         */
        public int getBookingNumber() {
            return bookingNumber;
        }

        /**
         * Define el valor de la propiedad bookingNumber.
         * 
         */
        public void setBookingNumber(int value) {
            this.bookingNumber = value;
        }

        /**
         * Obtiene el valor de la propiedad price.
         * 
         */
        public int getPrice() {
            return price;
        }

        /**
         * Define el valor de la propiedad price.
         * 
         */
        public void setPrice(int value) {
            this.price = value;
        }

        /**
         * Obtiene el valor de la propiedad airline.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAirline() {
            return airline;
        }

        /**
         * Define el valor de la propiedad airline.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAirline(String value) {
            this.airline = value;
        }

        /**
         * Obtiene el valor de la propiedad flight.
         * 
         * @return
         *     possible object is
         *     {@link Flight }
         *     
         */
        public Flight getFlight() {
            return flight;
        }

        /**
         * Define el valor de la propiedad flight.
         * 
         * @param value
         *     allowed object is
         *     {@link Flight }
         *     
         */
        public void setFlight(Flight value) {
            this.flight = value;
        }

    }

}
