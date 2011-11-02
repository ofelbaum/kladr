
package com.emal.kladr.webservice.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emal.kladr.webservice.xml package. 
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

    private final static QName _RegionsRequest_QNAME = new QName("http://emal.com/kladr/schemas", "RegionsRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emal.kladr.webservice.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StreetResponse }
     * 
     */
    public StreetResponse createStreetResponse() {
        return new StreetResponse();
    }

    /**
     * Create an instance of {@link StreetRequest }
     * 
     */
    public StreetRequest createStreetRequest() {
        return new StreetRequest();
    }

    /**
     * Create an instance of {@link DistrictsRequest }
     * 
     */
    public DistrictsRequest createDistrictsRequest() {
        return new DistrictsRequest();
    }

    /**
     * Create an instance of {@link BuildingRequest }
     * 
     */
    public BuildingRequest createBuildingRequest() {
        return new BuildingRequest();
    }

    /**
     * Create an instance of {@link LocalitiesRequest }
     * 
     */
    public LocalitiesRequest createLocalitiesRequest() {
        return new LocalitiesRequest();
    }

    /**
     * Create an instance of {@link BuildingResponse }
     * 
     */
    public BuildingResponse createBuildingResponse() {
        return new BuildingResponse();
    }

    /**
     * Create an instance of {@link KladrResponse }
     * 
     */
    public KladrResponse createKladrResponse() {
        return new KladrResponse();
    }

    /**
     * Create an instance of {@link Building }
     * 
     */
    public Building createBuilding() {
        return new Building();
    }

    /**
     * Create an instance of {@link Street }
     * 
     */
    public Street createStreet() {
        return new Street();
    }

    /**
     * Create an instance of {@link Kladr }
     * 
     */
    public Kladr createKladr() {
        return new Kladr();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://emal.com/kladr/schemas", name = "RegionsRequest")
    public JAXBElement<Object> createRegionsRequest(Object value) {
        return new JAXBElement<Object>(_RegionsRequest_QNAME, Object.class, null, value);
    }

}
