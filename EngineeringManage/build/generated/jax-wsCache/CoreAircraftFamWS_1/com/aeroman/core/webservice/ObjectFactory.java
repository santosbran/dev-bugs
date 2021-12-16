
package com.aeroman.core.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.aeroman.core.webservice package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _CoreAll_QNAME = new QName("http://webservice.core.aeroman.com/", "coreAll");
    private final static QName _CoreAllResponse_QNAME = new QName("http://webservice.core.aeroman.com/", "coreAllResponse");
    private final static QName _CoreCreate_QNAME = new QName("http://webservice.core.aeroman.com/", "coreCreate");
    private final static QName _CoreCreateResponse_QNAME = new QName("http://webservice.core.aeroman.com/", "coreCreateResponse");
    private final static QName _CoreDelete_QNAME = new QName("http://webservice.core.aeroman.com/", "coreDelete");
    private final static QName _CoreDeleteResponse_QNAME = new QName("http://webservice.core.aeroman.com/", "coreDeleteResponse");
    private final static QName _CoreEdit_QNAME = new QName("http://webservice.core.aeroman.com/", "coreEdit");
    private final static QName _CoreEditResponse_QNAME = new QName("http://webservice.core.aeroman.com/", "coreEditResponse");
    private final static QName _CoreFind_QNAME = new QName("http://webservice.core.aeroman.com/", "coreFind");
    private final static QName _CoreFindResponse_QNAME = new QName("http://webservice.core.aeroman.com/", "coreFindResponse");
    private final static QName _CoreAircraftFamPJ_QNAME = new QName("http://webservice.core.aeroman.com/", "CoreAircraftFamPJ");
    private final static QName _CoreAircraftFam_QNAME = new QName("http://webservice.core.aeroman.com/", "coreAircraftFam");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aeroman.core.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CoreAll }
     * 
     */
    public CoreAll createCoreAll() {
        return new CoreAll();
    }

    /**
     * Create an instance of {@link CoreAllResponse }
     * 
     */
    public CoreAllResponse createCoreAllResponse() {
        return new CoreAllResponse();
    }

    /**
     * Create an instance of {@link CoreCreate }
     * 
     */
    public CoreCreate createCoreCreate() {
        return new CoreCreate();
    }

    /**
     * Create an instance of {@link CoreCreateResponse }
     * 
     */
    public CoreCreateResponse createCoreCreateResponse() {
        return new CoreCreateResponse();
    }

    /**
     * Create an instance of {@link CoreDelete }
     * 
     */
    public CoreDelete createCoreDelete() {
        return new CoreDelete();
    }

    /**
     * Create an instance of {@link CoreDeleteResponse }
     * 
     */
    public CoreDeleteResponse createCoreDeleteResponse() {
        return new CoreDeleteResponse();
    }

    /**
     * Create an instance of {@link CoreEdit }
     * 
     */
    public CoreEdit createCoreEdit() {
        return new CoreEdit();
    }

    /**
     * Create an instance of {@link CoreEditResponse }
     * 
     */
    public CoreEditResponse createCoreEditResponse() {
        return new CoreEditResponse();
    }

    /**
     * Create an instance of {@link CoreFind }
     * 
     */
    public CoreFind createCoreFind() {
        return new CoreFind();
    }

    /**
     * Create an instance of {@link CoreFindResponse }
     * 
     */
    public CoreFindResponse createCoreFindResponse() {
        return new CoreFindResponse();
    }

    /**
     * Create an instance of {@link CoreAircraftFamPJ }
     * 
     */
    public CoreAircraftFamPJ createCoreAircraftFamPJ() {
        return new CoreAircraftFamPJ();
    }

    /**
     * Create an instance of {@link CoreAircraftFam }
     * 
     */
    public CoreAircraftFam createCoreAircraftFam() {
        return new CoreAircraftFam();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreAll }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreAll }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "coreAll")
    public JAXBElement<CoreAll> createCoreAll(CoreAll value) {
        return new JAXBElement<CoreAll>(_CoreAll_QNAME, CoreAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreAllResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreAllResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "coreAllResponse")
    public JAXBElement<CoreAllResponse> createCoreAllResponse(CoreAllResponse value) {
        return new JAXBElement<CoreAllResponse>(_CoreAllResponse_QNAME, CoreAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreCreate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreCreate }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "coreCreate")
    public JAXBElement<CoreCreate> createCoreCreate(CoreCreate value) {
        return new JAXBElement<CoreCreate>(_CoreCreate_QNAME, CoreCreate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreCreateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreCreateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "coreCreateResponse")
    public JAXBElement<CoreCreateResponse> createCoreCreateResponse(CoreCreateResponse value) {
        return new JAXBElement<CoreCreateResponse>(_CoreCreateResponse_QNAME, CoreCreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreDelete }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreDelete }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "coreDelete")
    public JAXBElement<CoreDelete> createCoreDelete(CoreDelete value) {
        return new JAXBElement<CoreDelete>(_CoreDelete_QNAME, CoreDelete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreDeleteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreDeleteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "coreDeleteResponse")
    public JAXBElement<CoreDeleteResponse> createCoreDeleteResponse(CoreDeleteResponse value) {
        return new JAXBElement<CoreDeleteResponse>(_CoreDeleteResponse_QNAME, CoreDeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreEdit }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreEdit }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "coreEdit")
    public JAXBElement<CoreEdit> createCoreEdit(CoreEdit value) {
        return new JAXBElement<CoreEdit>(_CoreEdit_QNAME, CoreEdit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreEditResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreEditResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "coreEditResponse")
    public JAXBElement<CoreEditResponse> createCoreEditResponse(CoreEditResponse value) {
        return new JAXBElement<CoreEditResponse>(_CoreEditResponse_QNAME, CoreEditResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreFind }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreFind }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "coreFind")
    public JAXBElement<CoreFind> createCoreFind(CoreFind value) {
        return new JAXBElement<CoreFind>(_CoreFind_QNAME, CoreFind.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreFindResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreFindResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "coreFindResponse")
    public JAXBElement<CoreFindResponse> createCoreFindResponse(CoreFindResponse value) {
        return new JAXBElement<CoreFindResponse>(_CoreFindResponse_QNAME, CoreFindResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreAircraftFamPJ }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreAircraftFamPJ }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "CoreAircraftFamPJ")
    public JAXBElement<CoreAircraftFamPJ> createCoreAircraftFamPJ(CoreAircraftFamPJ value) {
        return new JAXBElement<CoreAircraftFamPJ>(_CoreAircraftFamPJ_QNAME, CoreAircraftFamPJ.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreAircraftFam }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreAircraftFam }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.core.aeroman.com/", name = "coreAircraftFam")
    public JAXBElement<CoreAircraftFam> createCoreAircraftFam(CoreAircraftFam value) {
        return new JAXBElement<CoreAircraftFam>(_CoreAircraftFam_QNAME, CoreAircraftFam.class, null, value);
    }

}
