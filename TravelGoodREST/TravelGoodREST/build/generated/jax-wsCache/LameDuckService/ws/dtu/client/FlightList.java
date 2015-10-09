
package ws.dtu.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FlightList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
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
         * Gets the value of the bookingNumber property.
         * 
         */
        public int getBookingNumber() {
            return bookingNumber;
        }

        /**
         * Sets the value of the bookingNumber property.
         * 
         */
        public void setBookingNumber(int value) {
            this.bookingNumber = value;
        }

        /**
         * Gets the value of the price property.
         * 
         */
        public int getPrice() {
            return price;
        }

        /**
         * Sets the value of the price property.
         * 
         */
        public void setPrice(int value) {
            this.price = value;
        }

        /**
         * Gets the value of the airline property.
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
         * Sets the value of the airline property.
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
         * Gets the value of the flight property.
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
         * Sets the value of the flight property.
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
