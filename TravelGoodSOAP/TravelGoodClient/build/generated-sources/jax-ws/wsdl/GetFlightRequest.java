
package wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="flightStartPoint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flightDestinationPoint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flightDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="itineraryID" type="{http://travelGood.wsdl}itineraryID"/>
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
    "flightStartPoint",
    "flightDestinationPoint",
    "flightDate",
    "itineraryID"
})
@XmlRootElement(name = "getFlightRequest")
public class GetFlightRequest {

    @XmlElement(required = true)
    protected String flightStartPoint;
    @XmlElement(required = true)
    protected String flightDestinationPoint;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar flightDate;
    @XmlElement(required = true)
    protected String itineraryID;

    /**
     * Obtiene el valor de la propiedad flightStartPoint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightStartPoint() {
        return flightStartPoint;
    }

    /**
     * Define el valor de la propiedad flightStartPoint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightStartPoint(String value) {
        this.flightStartPoint = value;
    }

    /**
     * Obtiene el valor de la propiedad flightDestinationPoint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightDestinationPoint() {
        return flightDestinationPoint;
    }

    /**
     * Define el valor de la propiedad flightDestinationPoint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightDestinationPoint(String value) {
        this.flightDestinationPoint = value;
    }

    /**
     * Obtiene el valor de la propiedad flightDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFlightDate() {
        return flightDate;
    }

    /**
     * Define el valor de la propiedad flightDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFlightDate(XMLGregorianCalendar value) {
        this.flightDate = value;
    }

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

}
