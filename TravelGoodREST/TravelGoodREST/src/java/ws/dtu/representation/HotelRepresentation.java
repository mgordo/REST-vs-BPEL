/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.representation;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import ws.dtu.entity.HotelInfoEntity;

/**
 *
 * @author Pierre-Emmanuel
 */
@XmlRootElement()
public class HotelRepresentation extends Representation  {
    private List<HotelInfoEntity> hotels = new ArrayList<HotelInfoEntity>();

    public List<HotelInfoEntity> getHotel() {
        return hotels;
    }

    public void setHotel(List<HotelInfoEntity> hotels) {
        this.hotels=hotels;
    }
}
       