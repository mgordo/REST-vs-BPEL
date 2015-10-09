
package wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BookFlightFaultElement_QNAME = new QName("http://xml.netbeans.org/schema/AirlineSchema", "bookFlightFaultElement");
    private final static QName _Cancelreq_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "cancelreq");
    private final static QName _CancelItineraryFault_QNAME = new QName("http://travelGood.wsdl", "cancelItineraryFault");
    private final static QName _ChargeCreditCardResponse_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "chargeCreditCardResponse");
    private final static QName _CreditCardFault_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "CreditCardFault");
    private final static QName _GetHotelResponse_QNAME = new QName("http://travelGood.wsdl", "getHotelResponse");
    private final static QName _Hotellistelement_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "hotellistelement");
    private final static QName _CancelItineraryResponse_QNAME = new QName("http://travelGood.wsdl", "cancelItineraryResponse");
    private final static QName _GetFlightResponse_QNAME = new QName("http://travelGood.wsdl", "getFlightResponse");
    private final static QName _Bookreply_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "bookreply");
    private final static QName _Getelement_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "getelement");
    private final static QName _ValidateCreditCardResponse_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "validateCreditCardResponse");
    private final static QName _RefundCreditCard_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "refundCreditCard");
    private final static QName _RefundCreditCardResponse_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "refundCreditCardResponse");
    private final static QName _Stringfault_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "stringfault");
    private final static QName _ValidateCreditCard_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "validateCreditCard");
    private final static QName _Hotelelement_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "hotelelement");
    private final static QName _Bookargelement_QNAME = new QName("http://xml.netbeans.org/schema/hotelschema", "bookargelement");
    private final static QName _ChargeCreditCard_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "chargeCreditCard");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddFlightRequest }
     * 
     */
    public AddFlightRequest createAddFlightRequest() {
        return new AddFlightRequest();
    }

    /**
     * Create an instance of {@link ItineraryComplexType }
     * 
     */
    public ItineraryComplexType createItineraryComplexType() {
        return new ItineraryComplexType();
    }

    /**
     * Create an instance of {@link ItineraryComplexType.HotelListRoot }
     * 
     */
    public ItineraryComplexType.HotelListRoot createItineraryComplexTypeHotelListRoot() {
        return new ItineraryComplexType.HotelListRoot();
    }

    /**
     * Create an instance of {@link ItineraryComplexType.FlightListRoot }
     * 
     */
    public ItineraryComplexType.FlightListRoot createItineraryComplexTypeFlightListRoot() {
        return new ItineraryComplexType.FlightListRoot();
    }

    /**
     * Create an instance of {@link wsdl.FlightList }
     * 
     */
    public wsdl.FlightList createFlightList() {
        return new wsdl.FlightList();
    }

    /**
     * Create an instance of {@link CancelItineraryRequest }
     * 
     */
    public CancelItineraryRequest createCancelItineraryRequest() {
        return new CancelItineraryRequest();
    }

    /**
     * Create an instance of {@link CreditCardInfoType }
     * 
     */
    public CreditCardInfoType createCreditCardInfoType() {
        return new CreditCardInfoType();
    }

    /**
     * Create an instance of {@link AddHotelRequest }
     * 
     */
    public AddHotelRequest createAddHotelRequest() {
        return new AddHotelRequest();
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link GetItineraryRequest }
     * 
     */
    public GetItineraryRequest createGetItineraryRequest() {
        return new GetItineraryRequest();
    }

    /**
     * Create an instance of {@link GetFlightFault }
     * 
     */
    public GetFlightFault createGetFlightFault() {
        return new GetFlightFault();
    }

    /**
     * Create an instance of {@link GetHotelFault }
     * 
     */
    public GetHotelFault createGetHotelFault() {
        return new GetHotelFault();
    }

    /**
     * Create an instance of {@link AddFlightResponse }
     * 
     */
    public AddFlightResponse createAddFlightResponse() {
        return new AddFlightResponse();
    }

    /**
     * Create an instance of {@link GetFlightRequest }
     * 
     */
    public GetFlightRequest createGetFlightRequest() {
        return new GetFlightRequest();
    }

    /**
     * Create an instance of {@link BookItineraryFault }
     * 
     */
    public BookItineraryFault createBookItineraryFault() {
        return new BookItineraryFault();
    }

    /**
     * Create an instance of {@link AddFlightFault }
     * 
     */
    public AddFlightFault createAddFlightFault() {
        return new AddFlightFault();
    }

    /**
     * Create an instance of {@link AddHotelResponse }
     * 
     */
    public AddHotelResponse createAddHotelResponse() {
        return new AddHotelResponse();
    }

    /**
     * Create an instance of {@link CreateItineraryRequest }
     * 
     */
    public CreateItineraryRequest createCreateItineraryRequest() {
        return new CreateItineraryRequest();
    }

    /**
     * Create an instance of {@link BookItineraryResponse }
     * 
     */
    public BookItineraryResponse createBookItineraryResponse() {
        return new BookItineraryResponse();
    }

    /**
     * Create an instance of {@link BookItineraryRequest }
     * 
     */
    public BookItineraryRequest createBookItineraryRequest() {
        return new BookItineraryRequest();
    }

    /**
     * Create an instance of {@link AddFlightRequest.FlightInfo }
     * 
     */
    public AddFlightRequest.FlightInfo createAddFlightRequestFlightInfo() {
        return new AddFlightRequest.FlightInfo();
    }

    /**
     * Create an instance of {@link Hotellist }
     * 
     */
    public Hotellist createHotellist() {
        return new Hotellist();
    }

    /**
     * Create an instance of {@link GetItineraryResponse }
     * 
     */
    public GetItineraryResponse createGetItineraryResponse() {
        return new GetItineraryResponse();
    }

    /**
     * Create an instance of {@link AddHotelFault }
     * 
     */
    public AddHotelFault createAddHotelFault() {
        return new AddHotelFault();
    }

    /**
     * Create an instance of {@link CreateItineraryResponse }
     * 
     */
    public CreateItineraryResponse createCreateItineraryResponse() {
        return new CreateItineraryResponse();
    }

    /**
     * Create an instance of {@link GetHotelRequest }
     * 
     */
    public GetHotelRequest createGetHotelRequest() {
        return new GetHotelRequest();
    }

    /**
     * Create an instance of {@link wsdl.FlightInfo }
     * 
     */
    public wsdl.FlightInfo createFlightInfo() {
        return new wsdl.FlightInfo();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link Bookarg }
     * 
     */
    public Bookarg createBookarg() {
        return new Bookarg();
    }

    /**
     * Create an instance of {@link ValidateCreditCardResponse }
     * 
     */
    public ValidateCreditCardResponse createValidateCreditCardResponse() {
        return new ValidateCreditCardResponse();
    }

    /**
     * Create an instance of {@link RefundCreditCardResponse }
     * 
     */
    public RefundCreditCardResponse createRefundCreditCardResponse() {
        return new RefundCreditCardResponse();
    }

    /**
     * Create an instance of {@link RefundCreditCard }
     * 
     */
    public RefundCreditCard createRefundCreditCard() {
        return new RefundCreditCard();
    }

    /**
     * Create an instance of {@link ChargeCreditCardResponse }
     * 
     */
    public ChargeCreditCardResponse createChargeCreditCardResponse() {
        return new ChargeCreditCardResponse();
    }

    /**
     * Create an instance of {@link ValidateCreditCard }
     * 
     */
    public ValidateCreditCard createValidateCreditCard() {
        return new ValidateCreditCard();
    }

    /**
     * Create an instance of {@link CreditCardFaultType }
     * 
     */
    public CreditCardFaultType createCreditCardFaultType() {
        return new CreditCardFaultType();
    }

    /**
     * Create an instance of {@link ChargeCreditCard }
     * 
     */
    public ChargeCreditCard createChargeCreditCard() {
        return new ChargeCreditCard();
    }

    /**
     * Create an instance of {@link ExpirationDateType }
     * 
     */
    public ExpirationDateType createExpirationDateType() {
        return new ExpirationDateType();
    }

    /**
     * Create an instance of {@link AccountType }
     * 
     */
    public AccountType createAccountType() {
        return new AccountType();
    }

    /**
     * Create an instance of {@link BookFlightFaultType }
     * 
     */
    public BookFlightFaultType createBookFlightFaultType() {
        return new BookFlightFaultType();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link ItineraryComplexType.HotelListRoot.HotelList }
     * 
     */
    public ItineraryComplexType.HotelListRoot.HotelList createItineraryComplexTypeHotelListRootHotelList() {
        return new ItineraryComplexType.HotelListRoot.HotelList();
    }

    /**
     * Create an instance of {@link ItineraryComplexType.FlightListRoot.FlightList }
     * 
     */
    public ItineraryComplexType.FlightListRoot.FlightList createItineraryComplexTypeFlightListRootFlightList() {
        return new ItineraryComplexType.FlightListRoot.FlightList();
    }

    /**
     * Create an instance of {@link wsdl.FlightList.FlightInformation }
     * 
     */
    public wsdl.FlightList.FlightInformation createFlightListFlightInformation() {
        return new wsdl.FlightList.FlightInformation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookFlightFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/AirlineSchema", name = "bookFlightFaultElement")
    public JAXBElement<BookFlightFaultType> createBookFlightFaultElement(BookFlightFaultType value) {
        return new JAXBElement<BookFlightFaultType>(_BookFlightFaultElement_QNAME, BookFlightFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "cancelreq")
    public JAXBElement<Integer> createCancelreq(Integer value) {
        return new JAXBElement<Integer>(_Cancelreq_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelGood.wsdl", name = "cancelItineraryFault")
    public JAXBElement<String> createCancelItineraryFault(String value) {
        return new JAXBElement<String>(_CancelItineraryFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeCreditCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.fastmoney.imm.dtu.dk", name = "chargeCreditCardResponse")
    public JAXBElement<ChargeCreditCardResponse> createChargeCreditCardResponse(ChargeCreditCardResponse value) {
        return new JAXBElement<ChargeCreditCardResponse>(_ChargeCreditCardResponse_QNAME, ChargeCreditCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditCardFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.fastmoney.imm.dtu.dk", name = "CreditCardFault")
    public JAXBElement<CreditCardFaultType> createCreditCardFault(CreditCardFaultType value) {
        return new JAXBElement<CreditCardFaultType>(_CreditCardFault_QNAME, CreditCardFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hotellist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelGood.wsdl", name = "getHotelResponse")
    public JAXBElement<Hotellist> createGetHotelResponse(Hotellist value) {
        return new JAXBElement<Hotellist>(_GetHotelResponse_QNAME, Hotellist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hotellist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "hotellistelement")
    public JAXBElement<Hotellist> createHotellistelement(Hotellist value) {
        return new JAXBElement<Hotellist>(_Hotellistelement_QNAME, Hotellist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelGood.wsdl", name = "cancelItineraryResponse")
    public JAXBElement<Boolean> createCancelItineraryResponse(Boolean value) {
        return new JAXBElement<Boolean>(_CancelItineraryResponse_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link wsdl.FlightList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelGood.wsdl", name = "getFlightResponse")
    public JAXBElement<wsdl.FlightList> createGetFlightResponse(wsdl.FlightList value) {
        return new JAXBElement<wsdl.FlightList>(_GetFlightResponse_QNAME, wsdl.FlightList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "bookreply")
    public JAXBElement<Boolean> createBookreply(Boolean value) {
        return new JAXBElement<Boolean>(_Bookreply_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Get }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "getelement")
    public JAXBElement<Get> createGetelement(Get value) {
        return new JAXBElement<Get>(_Getelement_QNAME, Get.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCreditCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.fastmoney.imm.dtu.dk", name = "validateCreditCardResponse")
    public JAXBElement<ValidateCreditCardResponse> createValidateCreditCardResponse(ValidateCreditCardResponse value) {
        return new JAXBElement<ValidateCreditCardResponse>(_ValidateCreditCardResponse_QNAME, ValidateCreditCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundCreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.fastmoney.imm.dtu.dk", name = "refundCreditCard")
    public JAXBElement<RefundCreditCard> createRefundCreditCard(RefundCreditCard value) {
        return new JAXBElement<RefundCreditCard>(_RefundCreditCard_QNAME, RefundCreditCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundCreditCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.fastmoney.imm.dtu.dk", name = "refundCreditCardResponse")
    public JAXBElement<RefundCreditCardResponse> createRefundCreditCardResponse(RefundCreditCardResponse value) {
        return new JAXBElement<RefundCreditCardResponse>(_RefundCreditCardResponse_QNAME, RefundCreditCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "stringfault")
    public JAXBElement<String> createStringfault(String value) {
        return new JAXBElement<String>(_Stringfault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.fastmoney.imm.dtu.dk", name = "validateCreditCard")
    public JAXBElement<ValidateCreditCard> createValidateCreditCard(ValidateCreditCard value) {
        return new JAXBElement<ValidateCreditCard>(_ValidateCreditCard_QNAME, ValidateCreditCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "hotelelement")
    public JAXBElement<Hotel> createHotelelement(Hotel value) {
        return new JAXBElement<Hotel>(_Hotelelement_QNAME, Hotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bookarg }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/hotelschema", name = "bookargelement")
    public JAXBElement<Bookarg> createBookargelement(Bookarg value) {
        return new JAXBElement<Bookarg>(_Bookargelement_QNAME, Bookarg.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeCreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.fastmoney.imm.dtu.dk", name = "chargeCreditCard")
    public JAXBElement<ChargeCreditCard> createChargeCreditCard(ChargeCreditCard value) {
        return new JAXBElement<ChargeCreditCard>(_ChargeCreditCard_QNAME, ChargeCreditCard.class, null, value);
    }

}
