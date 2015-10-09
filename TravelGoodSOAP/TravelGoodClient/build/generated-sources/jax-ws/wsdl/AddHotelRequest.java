
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
 *         &lt;element name="HotelInfo" type="{http://xml.netbeans.org/schema/hotelschema}Hotel"/>
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
    "hotelInfo"
})
@XmlRootElement(name = "addHotelRequest")
public class AddHotelRequest {

    @XmlElement(required = true)
    protected String itineraryID;
    @XmlElement(name = "HotelInfo", required = true)
    protected Hotel hotelInfo;

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
     * Obtiene el valor de la propiedad hotelInfo.
     * 
     * @return
     *     possible object is
     *     {@link Hotel }
     *     
     */
    public Hotel getHotelInfo() {
        return hotelInfo;
    }

    /**
     * Define el valor de la propiedad hotelInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link Hotel }
     *     
     */
    public void setHotelInfo(Hotel value) {
        this.hotelInfo = value;
    }

}
