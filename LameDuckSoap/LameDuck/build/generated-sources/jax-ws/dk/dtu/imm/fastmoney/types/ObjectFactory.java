
package dk.dtu.imm.fastmoney.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dk.dtu.imm.fastmoney.types package. 
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

    private final static QName _ValidateCreditCardResponse_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "validateCreditCardResponse");
    private final static QName _RefundCreditCard_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "refundCreditCard");
    private final static QName _RefundCreditCardResponse_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "refundCreditCardResponse");
    private final static QName _ChargeCreditCardResponse_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "chargeCreditCardResponse");
    private final static QName _CreditCardFault_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "CreditCardFault");
    private final static QName _ValidateCreditCard_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "validateCreditCard");
    private final static QName _ChargeCreditCard_QNAME = new QName("urn://types.fastmoney.imm.dtu.dk", "chargeCreditCard");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dk.dtu.imm.fastmoney.types
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link CreditCardInfoType }
     * 
     */
    public CreditCardInfoType createCreditCardInfoType() {
        return new CreditCardInfoType();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.fastmoney.imm.dtu.dk", name = "validateCreditCard")
    public JAXBElement<ValidateCreditCard> createValidateCreditCard(ValidateCreditCard value) {
        return new JAXBElement<ValidateCreditCard>(_ValidateCreditCard_QNAME, ValidateCreditCard.class, null, value);
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
