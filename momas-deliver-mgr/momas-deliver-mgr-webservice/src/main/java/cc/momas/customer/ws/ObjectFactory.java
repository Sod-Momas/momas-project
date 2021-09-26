
package cc.momas.customer.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cc.momas.customer.ws package. 
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

    private final static QName _QueryAllShopsByNotAssociate_QNAME = new QName("http://ws.customer.momas.cc/", "queryAllShopsByNotAssociate");
    private final static QName _QueryByPhoneResponse_QNAME = new QName("http://ws.customer.momas.cc/", "queryByPhoneResponse");
    private final static QName _QueryAllShopsByAssociate_QNAME = new QName("http://ws.customer.momas.cc/", "queryAllShopsByAssociate");
    private final static QName _UpdateShopsDecidezoneId_QNAME = new QName("http://ws.customer.momas.cc/", "updateShopsDecidezoneId");
    private final static QName _UpdateShopsDecidezoneIdResponse_QNAME = new QName("http://ws.customer.momas.cc/", "updateShopsDecidezoneIdResponse");
    private final static QName _QueryAllShopsByAssociateResponse_QNAME = new QName("http://ws.customer.momas.cc/", "queryAllShopsByAssociateResponse");
    private final static QName _QueryAllShopsByNotAssociateResponse_QNAME = new QName("http://ws.customer.momas.cc/", "queryAllShopsByNotAssociateResponse");
    private final static QName _QueryByPhone_QNAME = new QName("http://ws.customer.momas.cc/", "queryByPhone");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cc.momas.customer.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryByPhone }
     * 
     */
    public QueryByPhone createQueryByPhone() {
        return new QueryByPhone();
    }

    /**
     * Create an instance of {@link QueryAllShopsByNotAssociateResponse }
     * 
     */
    public QueryAllShopsByNotAssociateResponse createQueryAllShopsByNotAssociateResponse() {
        return new QueryAllShopsByNotAssociateResponse();
    }

    /**
     * Create an instance of {@link QueryAllShopsByAssociateResponse }
     * 
     */
    public QueryAllShopsByAssociateResponse createQueryAllShopsByAssociateResponse() {
        return new QueryAllShopsByAssociateResponse();
    }

    /**
     * Create an instance of {@link UpdateShopsDecidezoneIdResponse }
     * 
     */
    public UpdateShopsDecidezoneIdResponse createUpdateShopsDecidezoneIdResponse() {
        return new UpdateShopsDecidezoneIdResponse();
    }

    /**
     * Create an instance of {@link UpdateShopsDecidezoneId }
     * 
     */
    public UpdateShopsDecidezoneId createUpdateShopsDecidezoneId() {
        return new UpdateShopsDecidezoneId();
    }

    /**
     * Create an instance of {@link QueryAllShopsByAssociate }
     * 
     */
    public QueryAllShopsByAssociate createQueryAllShopsByAssociate() {
        return new QueryAllShopsByAssociate();
    }

    /**
     * Create an instance of {@link QueryAllShopsByNotAssociate }
     * 
     */
    public QueryAllShopsByNotAssociate createQueryAllShopsByNotAssociate() {
        return new QueryAllShopsByNotAssociate();
    }

    /**
     * Create an instance of {@link QueryByPhoneResponse }
     * 
     */
    public QueryByPhoneResponse createQueryByPhoneResponse() {
        return new QueryByPhoneResponse();
    }

    /**
     * Create an instance of {@link Shops }
     * 
     */
    public Shops createShops() {
        return new Shops();
    }

    /**
     * Create an instance of {@link Categories }
     * 
     */
    public Categories createCategories() {
        return new Categories();
    }

    /**
     * Create an instance of {@link Users }
     * 
     */
    public Users createUsers() {
        return new Users();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryAllShopsByNotAssociate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.customer.momas.cc/", name = "queryAllShopsByNotAssociate")
    public JAXBElement<QueryAllShopsByNotAssociate> createQueryAllShopsByNotAssociate(QueryAllShopsByNotAssociate value) {
        return new JAXBElement<QueryAllShopsByNotAssociate>(_QueryAllShopsByNotAssociate_QNAME, QueryAllShopsByNotAssociate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryByPhoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.customer.momas.cc/", name = "queryByPhoneResponse")
    public JAXBElement<QueryByPhoneResponse> createQueryByPhoneResponse(QueryByPhoneResponse value) {
        return new JAXBElement<QueryByPhoneResponse>(_QueryByPhoneResponse_QNAME, QueryByPhoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryAllShopsByAssociate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.customer.momas.cc/", name = "queryAllShopsByAssociate")
    public JAXBElement<QueryAllShopsByAssociate> createQueryAllShopsByAssociate(QueryAllShopsByAssociate value) {
        return new JAXBElement<QueryAllShopsByAssociate>(_QueryAllShopsByAssociate_QNAME, QueryAllShopsByAssociate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateShopsDecidezoneId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.customer.momas.cc/", name = "updateShopsDecidezoneId")
    public JAXBElement<UpdateShopsDecidezoneId> createUpdateShopsDecidezoneId(UpdateShopsDecidezoneId value) {
        return new JAXBElement<UpdateShopsDecidezoneId>(_UpdateShopsDecidezoneId_QNAME, UpdateShopsDecidezoneId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateShopsDecidezoneIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.customer.momas.cc/", name = "updateShopsDecidezoneIdResponse")
    public JAXBElement<UpdateShopsDecidezoneIdResponse> createUpdateShopsDecidezoneIdResponse(UpdateShopsDecidezoneIdResponse value) {
        return new JAXBElement<UpdateShopsDecidezoneIdResponse>(_UpdateShopsDecidezoneIdResponse_QNAME, UpdateShopsDecidezoneIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryAllShopsByAssociateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.customer.momas.cc/", name = "queryAllShopsByAssociateResponse")
    public JAXBElement<QueryAllShopsByAssociateResponse> createQueryAllShopsByAssociateResponse(QueryAllShopsByAssociateResponse value) {
        return new JAXBElement<QueryAllShopsByAssociateResponse>(_QueryAllShopsByAssociateResponse_QNAME, QueryAllShopsByAssociateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryAllShopsByNotAssociateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.customer.momas.cc/", name = "queryAllShopsByNotAssociateResponse")
    public JAXBElement<QueryAllShopsByNotAssociateResponse> createQueryAllShopsByNotAssociateResponse(QueryAllShopsByNotAssociateResponse value) {
        return new JAXBElement<QueryAllShopsByNotAssociateResponse>(_QueryAllShopsByNotAssociateResponse_QNAME, QueryAllShopsByNotAssociateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryByPhone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.customer.momas.cc/", name = "queryByPhone")
    public JAXBElement<QueryByPhone> createQueryByPhone(QueryByPhone value) {
        return new JAXBElement<QueryByPhone>(_QueryByPhone_QNAME, QueryByPhone.class, null, value);
    }

}
