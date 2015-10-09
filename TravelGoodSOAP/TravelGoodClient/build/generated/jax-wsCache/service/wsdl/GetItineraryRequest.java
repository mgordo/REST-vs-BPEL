
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
    "itineraryID"
})
@XmlRootElement(name = "getItineraryRequest")
public class GetItineraryRequest {

    @XmlElement(required = true)
    protected String itineraryID;

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
