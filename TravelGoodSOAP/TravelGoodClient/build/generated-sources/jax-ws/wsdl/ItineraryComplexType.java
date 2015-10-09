
package wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para itineraryComplexType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="itineraryComplexType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itineraryStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flightListRoot">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="flightList" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://travelGood.wsdl}FlightInfo">
 *                           &lt;sequence>
 *                             &lt;element name="flightStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="hotelListRoot">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="hotelList" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://xml.netbeans.org/schema/hotelschema}Hotel">
 *                           &lt;sequence>
 *                             &lt;element name="hotelStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "itineraryComplexType", propOrder = {
    "itineraryStatus",
    "flightListRoot",
    "hotelListRoot"
})
public class ItineraryComplexType {

    @XmlElement(required = true)
    protected String itineraryStatus;
    @XmlElement(required = true)
    protected ItineraryComplexType.FlightListRoot flightListRoot;
    @XmlElement(required = true)
    protected ItineraryComplexType.HotelListRoot hotelListRoot;

    /**
     * Obtiene el valor de la propiedad itineraryStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItineraryStatus() {
        return itineraryStatus;
    }

    /**
     * Define el valor de la propiedad itineraryStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItineraryStatus(String value) {
        this.itineraryStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad flightListRoot.
     * 
     * @return
     *     possible object is
     *     {@link ItineraryComplexType.FlightListRoot }
     *     
     */
    public ItineraryComplexType.FlightListRoot getFlightListRoot() {
        return flightListRoot;
    }

    /**
     * Define el valor de la propiedad flightListRoot.
     * 
     * @param value
     *     allowed object is
     *     {@link ItineraryComplexType.FlightListRoot }
     *     
     */
    public void setFlightListRoot(ItineraryComplexType.FlightListRoot value) {
        this.flightListRoot = value;
    }

    /**
     * Obtiene el valor de la propiedad hotelListRoot.
     * 
     * @return
     *     possible object is
     *     {@link ItineraryComplexType.HotelListRoot }
     *     
     */
    public ItineraryComplexType.HotelListRoot getHotelListRoot() {
        return hotelListRoot;
    }

    /**
     * Define el valor de la propiedad hotelListRoot.
     * 
     * @param value
     *     allowed object is
     *     {@link ItineraryComplexType.HotelListRoot }
     *     
     */
    public void setHotelListRoot(ItineraryComplexType.HotelListRoot value) {
        this.hotelListRoot = value;
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
     *         &lt;element name="flightList" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://travelGood.wsdl}FlightInfo">
     *                 &lt;sequence>
     *                   &lt;element name="flightStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
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
        "flightList"
    })
    public static class FlightListRoot {

        protected List<ItineraryComplexType.FlightListRoot.FlightList> flightList;

        /**
         * Gets the value of the flightList property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the flightList property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFlightList().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ItineraryComplexType.FlightListRoot.FlightList }
         * 
         * 
         */
        public List<ItineraryComplexType.FlightListRoot.FlightList> getFlightList() {
            if (flightList == null) {
                flightList = new ArrayList<ItineraryComplexType.FlightListRoot.FlightList>();
            }
            return this.flightList;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://travelGood.wsdl}FlightInfo">
         *       &lt;sequence>
         *         &lt;element name="flightStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "flightStatus"
        })
        public static class FlightList
            extends FlightInfo
        {

            @XmlElement(required = true)
            protected String flightStatus;

            /**
             * Obtiene el valor de la propiedad flightStatus.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFlightStatus() {
                return flightStatus;
            }

            /**
             * Define el valor de la propiedad flightStatus.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFlightStatus(String value) {
                this.flightStatus = value;
            }

        }

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
     *         &lt;element name="hotelList" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://xml.netbeans.org/schema/hotelschema}Hotel">
     *                 &lt;sequence>
     *                   &lt;element name="hotelStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
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
        "hotelList"
    })
    public static class HotelListRoot {

        protected List<ItineraryComplexType.HotelListRoot.HotelList> hotelList;

        /**
         * Gets the value of the hotelList property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the hotelList property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHotelList().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ItineraryComplexType.HotelListRoot.HotelList }
         * 
         * 
         */
        public List<ItineraryComplexType.HotelListRoot.HotelList> getHotelList() {
            if (hotelList == null) {
                hotelList = new ArrayList<ItineraryComplexType.HotelListRoot.HotelList>();
            }
            return this.hotelList;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://xml.netbeans.org/schema/hotelschema}Hotel">
         *       &lt;sequence>
         *         &lt;element name="hotelStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "hotelStatus"
        })
        public static class HotelList
            extends Hotel
        {

            @XmlElement(required = true)
            protected String hotelStatus;

            /**
             * Obtiene el valor de la propiedad hotelStatus.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHotelStatus() {
                return hotelStatus;
            }

            /**
             * Define el valor de la propiedad hotelStatus.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHotelStatus(String value) {
                this.hotelStatus = value;
            }

        }

    }

}
