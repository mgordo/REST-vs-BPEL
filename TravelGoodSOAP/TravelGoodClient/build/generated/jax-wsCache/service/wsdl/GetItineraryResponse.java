
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
 *         &lt;element name="itinerary" type="{http://travelGood.wsdl}itineraryComplexType"/>
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
    "itinerary"
})
@XmlRootElement(name = "getItineraryResponse")
public class GetItineraryResponse {

    @XmlElement(required = true)
    protected ItineraryComplexType itinerary;

    /**
     * Obtiene el valor de la propiedad itinerary.
     * 
     * @return
     *     possible object is
     *     {@link ItineraryComplexType }
     *     
     */
    public ItineraryComplexType getItinerary() {
        return itinerary;
    }

    /**
     * Define el valor de la propiedad itinerary.
     * 
     * @param value
     *     allowed object is
     *     {@link ItineraryComplexType }
     *     
     */
    public void setItinerary(ItineraryComplexType value) {
        this.itinerary = value;
    }

}
