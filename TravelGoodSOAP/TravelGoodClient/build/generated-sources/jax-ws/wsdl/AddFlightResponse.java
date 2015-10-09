
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
 *         &lt;element name="addFlightConfirmation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "addFlightConfirmation"
})
@XmlRootElement(name = "addFlightResponse")
public class AddFlightResponse {

    protected boolean addFlightConfirmation;

    /**
     * Obtiene el valor de la propiedad addFlightConfirmation.
     * 
     */
    public boolean isAddFlightConfirmation() {
        return addFlightConfirmation;
    }

    /**
     * Define el valor de la propiedad addFlightConfirmation.
     * 
     */
    public void setAddFlightConfirmation(boolean value) {
        this.addFlightConfirmation = value;
    }

}
