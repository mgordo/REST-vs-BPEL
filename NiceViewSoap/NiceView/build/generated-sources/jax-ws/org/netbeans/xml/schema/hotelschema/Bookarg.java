
package org.netbeans.xml.schema.hotelschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import dk.dtu.imm.fastmoney.types.CreditCardInfoType;


/**
 * <p>Java class for bookarg complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bookarg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookreference" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="validatecc" type="{urn://types.fastmoney.imm.dtu.dk}creditCardInfoType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookarg", propOrder = {
    "bookreference",
    "validatecc"
})
public class Bookarg {

    protected int bookreference;
    @XmlElement(required = true)
    protected CreditCardInfoType validatecc;

    /**
     * Gets the value of the bookreference property.
     * 
     */
    public int getBookreference() {
        return bookreference;
    }

    /**
     * Sets the value of the bookreference property.
     * 
     */
    public void setBookreference(int value) {
        this.bookreference = value;
    }

    /**
     * Gets the value of the validatecc property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardInfoType }
     *     
     */
    public CreditCardInfoType getValidatecc() {
        return validatecc;
    }

    /**
     * Sets the value of the validatecc property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardInfoType }
     *     
     */
    public void setValidatecc(CreditCardInfoType value) {
        this.validatecc = value;
    }

}
