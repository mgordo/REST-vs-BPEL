/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.representation;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author Miguel Gordo
 */
@XmlRootElement()
public class StatusRepresentation extends Representation {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}