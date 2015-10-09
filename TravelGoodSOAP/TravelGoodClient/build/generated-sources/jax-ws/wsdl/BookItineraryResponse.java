
package wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="bookingConfirmation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "bookingConfirmation"
})
@XmlRootElement(name = "bookItineraryResponse")
public class BookItineraryResponse {

    protected boolean bookingConfirmation;

    /**
     * Obtiene el valor de la propiedad bookingConfirmation.
     * 
     */
    public boolean isBookingConfirmation() {
        return bookingConfirmation;
    }

    /**
     * Define el valor de la propiedad bookingConfirmation.
     * 
     */
    public void setBookingConfirmation(boolean value) {
        this.bookingConfirmation = value;
    }

}
