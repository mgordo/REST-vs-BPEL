/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author souki
 */
@XmlRootElement()
public class CreditCardInfoType {
    ExpirationDateType expirationDate;
    String name;
    String number;
    
    
    public void setExpirationDate(ExpirationDateType expirationDate)
    {
        this.expirationDate = expirationDate;
    }
    public ExpirationDateType getExpirationDate()
    {
        return expirationDate;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setNumber(String number)
    {
        this.number = number;
    }
    public String getName()
    {
        return name;
    }
    public String getNumber()
    {
        return number;
    }
    
    
}