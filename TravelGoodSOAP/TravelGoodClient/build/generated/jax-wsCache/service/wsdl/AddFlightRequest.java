
package wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="itineraryID" type="{http://travelGood.wsdl}itineraryID"/>
 *         &lt;element name="FlightInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Flight" type="{http://xml.netbeans.org/schema/AirlineSchema}flight"/>
 *                   &lt;element name="airline" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "", propOrder = {
    "itineraryID",
    "flightInfo"
})
@XmlRootElement(name = "addFlightRequest")
public class AddFlightRequest {

    @XmlElement(required = true)
    protected String itineraryID;
    @XmlElement(name = "FlightInfo", required = true)
    protected AddFlightRequest.FlightInfo flightInfo;

    /**
     * Obtiene el valor de la propiedad itineraryID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItineraryID() {
        return itineraryID;
    }

    /**
     * Define el valor de la propiedad itineraryID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItineraryID(String value) {
        this.itineraryID = value;
    }

    /**
     * Obtiene el valor de la propiedad flightInfo.
     * 
     * @return
     *     possible object is
     *     {@link AddFlightRequest.FlightInfo }
     *     
     */
    public AddFlightRequest.FlightInfo getFlightInfo() {
        return flightInfo;
    }

    /**
     * Define el valor de la propiedad flightInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link AddFlightRequest.FlightInfo }
     *     
     */
    public void setFlightInfo(AddFlightRequest.FlightInfo value) {
        this.flightInfo = value;
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
     *         &lt;element name="Flight" type="{http://xml.netbeans.org/schema/AirlineSchema}flight"/>
     *         &lt;element name="airline" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        "flight",
        "airline",
        "price",
        "bookingNumber"
    })
    public static class FlightInfo {

        @XmlElement(name = "Flight", required = true)
        protected Flight flight;
        @XmlElement(required = true)
        protected String airline;
        protected int price;
        protected int bookingNumber;

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

    }

}
