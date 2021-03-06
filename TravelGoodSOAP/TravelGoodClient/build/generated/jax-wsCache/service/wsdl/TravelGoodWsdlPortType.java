
package wsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "travelGoodWsdlPortType", targetNamespace = "http://travelGood.wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TravelGoodWsdlPortType {


    /**
     * 
     * @param getFlightInput
     * @return
     *     returns wsdl.FlightList
     * @throws GetFlightTravelGoodOperationFault
     */
    @WebMethod
    @WebResult(name = "getFlightResponse", targetNamespace = "http://travelGood.wsdl", partName = "getFlightOutput")
    public FlightList getFlightTravelGoodOperation(
        @WebParam(name = "getFlightRequest", targetNamespace = "http://travelGood.wsdl", partName = "getFlightInput")
        GetFlightRequest getFlightInput)
        throws GetFlightTravelGoodOperationFault
    ;

    /**
     * 
     * @param getHotelInput
     * @return
     *     returns wsdl.Hotellist
     * @throws GetHotelTravelGoodOperationFault
     */
    @WebMethod
    @WebResult(name = "getHotelResponse", targetNamespace = "http://travelGood.wsdl", partName = "getHotelOutput")
    public Hotellist getHotelTravelGoodOperation(
        @WebParam(name = "getHotelRequest", targetNamespace = "http://travelGood.wsdl", partName = "getHotelInput")
        GetHotelRequest getHotelInput)
        throws GetHotelTravelGoodOperationFault
    ;

    /**
     * 
     * @param createItineraryInput
     * @return
     *     returns wsdl.CreateItineraryResponse
     */
    @WebMethod
    @WebResult(name = "createItineraryResponse", targetNamespace = "http://travelGood.wsdl", partName = "createItineraryOutput")
    public CreateItineraryResponse createItineraryTravelGoodOperation(
        @WebParam(name = "createItineraryRequest", targetNamespace = "http://travelGood.wsdl", partName = "createItineraryInput")
        CreateItineraryRequest createItineraryInput);

    /**
     * 
     * @param addFlightInput
     * @return
     *     returns wsdl.AddFlightResponse
     * @throws AddFlightTravelGoodFault
     */
    @WebMethod
    @WebResult(name = "addFlightResponse", targetNamespace = "http://travelGood.wsdl", partName = "addFlightOutput")
    public AddFlightResponse addFlightTravelGoodOperation(
        @WebParam(name = "addFlightRequest", targetNamespace = "http://travelGood.wsdl", partName = "addFlightInput")
        AddFlightRequest addFlightInput)
        throws AddFlightTravelGoodFault
    ;

    /**
     * 
     * @param bookItineraryInput
     * @return
     *     returns wsdl.BookItineraryResponse
     * @throws BookItineraryTravelGoodFault
     */
    @WebMethod
    @WebResult(name = "bookItineraryResponse", targetNamespace = "http://travelGood.wsdl", partName = "bookItineraryOutput")
    public BookItineraryResponse bookItineraryTravelGoodOperation(
        @WebParam(name = "bookItineraryRequest", targetNamespace = "http://travelGood.wsdl", partName = "bookItineraryInput")
        BookItineraryRequest bookItineraryInput)
        throws BookItineraryTravelGoodFault
    ;

    /**
     * 
     * @param getItineraryInput
     * @return
     *     returns wsdl.GetItineraryResponse
     */
    @WebMethod
    @WebResult(name = "getItineraryResponse", targetNamespace = "http://travelGood.wsdl", partName = "getItineraryOutput")
    public GetItineraryResponse getItineraryOperation(
        @WebParam(name = "getItineraryRequest", targetNamespace = "http://travelGood.wsdl", partName = "getItineraryInput")
        GetItineraryRequest getItineraryInput);

    /**
     * 
     * @param addHotelInput
     * @return
     *     returns wsdl.AddHotelResponse
     * @throws AddHotelTravelGoodFault
     */
    @WebMethod
    @WebResult(name = "addHotelResponse", targetNamespace = "http://travelGood.wsdl", partName = "addHotelOutput")
    public AddHotelResponse addHotelTravelGoodlOperation(
        @WebParam(name = "addHotelRequest", targetNamespace = "http://travelGood.wsdl", partName = "addHotelInput")
        AddHotelRequest addHotelInput)
        throws AddHotelTravelGoodFault
    ;

    /**
     * 
     * @param cancelInput
     * @return
     *     returns boolean
     * @throws CancelItineraryFault
     */
    @WebMethod
    @WebResult(name = "cancelItineraryResponse", targetNamespace = "http://travelGood.wsdl", partName = "cancelOutput")
    public boolean cancelItineraryOperation(
        @WebParam(name = "cancelItineraryRequest", targetNamespace = "http://travelGood.wsdl", partName = "cancelInput")
        CancelItineraryRequest cancelInput)
        throws CancelItineraryFault
    ;

}
